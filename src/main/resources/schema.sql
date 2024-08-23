CREATE TABLE tb_representatives (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE tb_states (
    abbreviation CHAR(2) PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE tb_clients (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255) NOT NULL UNIQUE,
    representative_id UUID,
    state_id CHAR(2),  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_representative
        FOREIGN KEY (representative_id) 
        REFERENCES tb_representatives(id),
    CONSTRAINT fk_state
        FOREIGN KEY (state_id) 
        REFERENCES tb_states(abbreviation)  
);
