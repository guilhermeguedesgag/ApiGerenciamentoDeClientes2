INSERT INTO tb_states (abbreviation, name) VALUES 
('AC', 'Acre'),
('AL', 'Alagoas'),
('AP', 'Amapá'),
('AM', 'Amazonas'),
('BA', 'Bahia'),
('CE', 'Ceará'),
('DF', 'Distrito Federal'),
('ES', 'Espírito Santo'),
('GO', 'Goiás'),
('MA', 'Maranhão'),
('MT', 'Mato Grosso'),
('MS', 'Mato Grosso do Sul'),
('MG', 'Minas Gerais'),
('PA', 'Pará'),
('PB', 'Paraíba'),
('PR', 'Paraná'),
('PE', 'Pernambuco'),
('PI', 'Piauí'),
('RJ', 'Rio de Janeiro'),
('RN', 'Rio Grande do Norte'),
('RS', 'Rio Grande do Sul'),
('RO', 'Rondônia'),
('RR', 'Roraima'),
('SC', 'Santa Catarina'),
('SP', 'São Paulo'),
('SE', 'Sergipe'),
('TO', 'Tocantins');

INSERT INTO tb_representatives (id, name, phone, email) VALUES 
('f1a8e1d2-8d4c-4b3a-9d23-5c8f2e3f6a4b', 'Carlos Silva', '555-1010', 'carlos.silva@example.com'),
('b2c9e4f6-7d5a-4f4b-8d3b-9e2f6a3d8b7c', 'Mariana Oliveira', '555-2020', 'mariana.oliveira@example.com'),
('d3f7e8a1-4b5c-4c4d-8a2c-1e3f7b4c6d5e', 'Pedro Souza', '555-3030', 'pedro.souza@example.com'),
('a4b8f9e2-5c6d-4d3e-9f4b-7c8d1a3e2f9b', 'Ana Pereira', '555-4040', 'ana.pereira@example.com'),
('c5d9f1b3-6d7e-4f5a-8b2d-3e4f8c7d1a2e', 'João Costa', '555-5050', 'joao.costa@example.com');

INSERT INTO tb_clients (id, name, phone, email, representative_id, state_id, created_at, updated_at) VALUES 
('a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890', 'Lucas Lima', '555-1234', 'lucas.lima@example.com', 'f1a8e1d2-8d4c-4b3a-9d23-5c8f2e3f6a4b', 'SP', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('b2c3d4e5-f678-90a1-b2c3-d4e5f67890a1', 'Fernanda Santos', '555-5678', 'fernanda.santos@example.com', 'b2c9e4f6-7d5a-4f4b-8d3b-9e2f6a3d8b7c', 'RJ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('c3d4e5f6-7890-a1b2-c3d4-e5f67890a1b2', 'Thiago Oliveira', '555-9101', 'thiago.oliveira@example.com', 'd3f7e8a1-4b5c-4c4d-8a2c-1e3f7b4c6d5e', 'MG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('d4e5f678-90a1-b2c3-d4e5-f67890a1b2c3', 'Beatriz Costa', '555-1213', 'beatriz.costa@example.com', 'a4b8f9e2-5c6d-4d3e-9f4b-7c8d1a3e2f9b', 'BA', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('e5f67890-a1b2-c3d4-e5f6-7890a1b2c3d4', 'Gabriel Souza', '555-1415', 'gabriel.souza@example.com', 'c5d9f1b3-6d7e-4f5a-8b2d-3e4f8c7d1a2e', 'RS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
