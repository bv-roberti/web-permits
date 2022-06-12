
INSERT INTO tb_user (name, email, password, active) VALUES ('Admin', 'bv_roberti@outlook.com', '$2a$12$EaCHyT5wF/zQUlUUXycid.Ei/iohnmZFkrNNhxbNhBJmnttLAIJPC', true);

INSERT INTO tb_uf (name, short_Name) VALUES ('Acre', 'AC');
INSERT INTO tb_uf (name, short_Name) VALUES ('Alagoas', 'AL');
INSERT INTO tb_uf (name, short_Name) VALUES ('Amazonas', 'AM');
INSERT INTO tb_uf (name, short_Name) VALUES ('Amapá', 'AP');
INSERT INTO tb_uf (name, short_Name) VALUES ('Bahia', 'BA');
INSERT INTO tb_uf (name, short_Name) VALUES ('Ceará', 'CE');
INSERT INTO tb_uf (name, short_Name) VALUES ('Distrito Federal', 'DF');
INSERT INTO tb_uf (name, short_Name) VALUES ('Espírito Santo', 'ES');
INSERT INTO tb_uf (name, short_Name) VALUES ('Goiás', 'GO');
INSERT INTO tb_uf (name, short_Name) VALUES ('Maranhão', 'MA');
INSERT INTO tb_uf (name, short_Name) VALUES ('Minas Gerais', 'MG');
INSERT INTO tb_uf (name, short_Name) VALUES ('Mato Grosso do Sul', 'MS');
INSERT INTO tb_uf (name, short_Name) VALUES ('Mato Grosso', 'MT');
INSERT INTO tb_uf (name, short_Name) VALUES ('Pará', 'PA');
INSERT INTO tb_uf (name, short_Name) VALUES ('Paraíba', 'PB');
INSERT INTO tb_uf (name, short_Name) VALUES ('Pernambuco', 'PE');
INSERT INTO tb_uf (name, short_Name) VALUES ('Piauí', 'PI');
INSERT INTO tb_uf (name, short_Name) VALUES ('Paraná', 'PR');
INSERT INTO tb_uf (name, short_Name) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO tb_uf (name, short_Name) VALUES ('Rio Grande do Norte', 'RN');
INSERT INTO tb_uf (name, short_Name) VALUES ('Rondônia', 'RO');
INSERT INTO tb_uf (name, short_Name) VALUES ('Roraima', 'RR');
INSERT INTO tb_uf (name, short_Name) VALUES ('Rio Grande do Sul', 'RS');
INSERT INTO tb_uf (name, short_Name) VALUES ('Santa Catarina', 'SC');
INSERT INTO tb_uf (name, short_Name) VALUES ('Sergipe', 'SE');
INSERT INTO tb_uf (name, short_Name) VALUES ('São Paulo', 'SP');
INSERT INTO tb_uf (name, short_Name) VALUES ('Tocantins', 'TO');

INSERT INTO tb_company (name, cnpj, active, created_At, UF_ID) VALUES ('Vale', '13.333.335/0001-02', true, NOW(), 10);

INSERT INTO tb_permit_type (name) VALUES ('Habite-se (Termo de Conclusão de Obra)');
INSERT INTO tb_permit_type (name) VALUES ('AVCB - Auto de Vistoria do Corpo de Bombeiros');
INSERT INTO tb_permit_type (name) VALUES ('AVCB - Responsável Técnico');
INSERT INTO tb_permit_type (name) VALUES ('Alvará de Funcionamento (Prefeitura)');
INSERT INTO tb_permit_type (name) VALUES ('LO - Licença de Operação Ambiental (Estadual)');
INSERT INTO tb_permit_type (name) VALUES ('LO - Licença de Operação Ambiental (Federal)');
INSERT INTO tb_permit_type (name) VALUES ('LO - Licença de Operação Ambiental (Municipal)');
INSERT INTO tb_permit_type (name) VALUES ('Alvará Sanitário de Estabelecimento');
INSERT INTO tb_permit_type (name) VALUES ('Alvará Sanitário de Veículos');
INSERT INTO tb_permit_type (name) VALUES ('Outorga de Perfuração');
INSERT INTO tb_permit_type (name) VALUES ('CREA - Conselho Regional de Engenharia e Agronomia');
INSERT INTO tb_permit_type (name) VALUES ('CREA - Responsável Técnico');
INSERT INTO tb_permit_type (name) VALUES ('CRQ - Conselho Regional de Químicos');
INSERT INTO tb_permit_type (name) VALUES ('CRQ - Responsável Técnico');
INSERT INTO tb_permit_type (name) VALUES ('Exército - Certificado de Produtos Controlados');
INSERT INTO tb_permit_type (name) VALUES ('CRM - Conselho Regional de Medicina');
INSERT INTO tb_permit_type (name) VALUES ('LI - Licença de Instalação Ambiental');
INSERT INTO tb_permit_type (name) VALUES ('Polícia Federal - Certificado de Produtos Controlados');
INSERT INTO tb_permit_type (name) VALUES ('LP - Licença Prévia Ambiental');
INSERT INTO tb_permit_type (name) VALUES ('CA - Certificado de Autorização do Corpo de Bombeiros');
INSERT INTO tb_permit_type (name) VALUES ('CADRI - Certificado de Movimentação de Resíduos Ambientais');
INSERT INTO tb_permit_type (name) VALUES ('CLI - Certificado de Licenciamento Integrado');
INSERT INTO tb_permit_type (name) VALUES ('COREN - Conselho Regional de Enfermagem');
INSERT INTO tb_permit_type (name) VALUES ('IBAMA - Cadastro Técnico Federal (CTF)');
INSERT INTO tb_permit_type (name) VALUES ('Polícia Civil - Certificado de Produtos Controlados');

INSERT INTO tb_permit_status (name) VALUES ('Regular');
INSERT INTO tb_permit_status (name) VALUES ('Renovar');
INSERT INTO tb_permit_status (name) VALUES ('Vencida');
INSERT INTO tb_permit_status (name) VALUES ('Dispensada');
INSERT INTO tb_permit_status (name) VALUES ('Em Renovacao');
INSERT INTO tb_permit_status (name) VALUES ('COVID');

INSERT INTO tb_permit (created_at, company_id, permit_status_id, permit_type_id, expiration_date, issue_date, deadline_date, number, active, HAS_EXPIRATION)
    VALUES ( NOW(), 1, 1, 1, NOW(), NOW(), NOW(), '123', true, false);