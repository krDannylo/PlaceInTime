-- Dados de teste (Repeatable Migration - Seed)
-- Repeatable migrations (R__) são executadas APÓS todas as versioned migrations (V__)
-- São reexecutadas automaticamente sempre que o conteúdo do arquivo mudar
-- Remove os dados de seed existentes antes de inserir novamente

DELETE FROM test WHERE name IN ('Teste 1', 'Teste 2', 'Teste 3');

INSERT INTO test (name, description, created_at)
VALUES 
    ('Teste 1', 'Primeiro registro de teste', CURRENT_TIMESTAMP),
    ('Teste 2', 'Segundo registro de teste' , CURRENT_TIMESTAMP),
    ('Teste 3', 'Terceiro registro de teste', CURRENT_TIMESTAMP);