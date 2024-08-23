package com.ms.clients.ms_customer_manager.domain.pagination;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class Pagination {

    private static Integer DEFAULT_SIZE = 100;
    private static Integer MAX_SIZE = 100;
    private static Integer DEFAULT_PAGE = 0;
    private static OrderType DEFAULT_ORDER = OrderType.ASC;

    @RequiredArgsConstructor
    @Getter
    public static enum OrderType {
        ASC("asc"),
        DESC("desc");

        private final String value;
    }
    
    private Integer size;
    private Integer page;
    private String order;


    public Pagination(Map<String, String> params) {
        size = params.containsKey("size") ? Integer.parseInt(params.get("size")) : DEFAULT_SIZE;
        page = params.containsKey("page") ? Integer.parseInt(params.get("page")) : DEFAULT_PAGE;
        order = params.containsKey("order") ? params.get("order") : DEFAULT_ORDER.getValue();
    }

    public int getSize() {
        System.out.println(size);
        if (size == null || size < 1) {
            return DEFAULT_SIZE;
        }
        return Math.min(size, MAX_SIZE);
    }

    public int getPage() {
        if (page == null) {
            return DEFAULT_PAGE;
        }
        return Math.min(DEFAULT_PAGE, page);
    }

    public String getOrder() {
        if (!OrderType.ASC.getValue().equals(this.order)) {
            return OrderType.DESC.getValue();
        }

        return DEFAULT_ORDER.getValue();
    }
}
