/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Anderson
 * Created: 27/02/2022
 */
INSERT INTO CONFIG_FATURAMENTO(despesas_totais, pc_margem_lucro, created_at, updated_at) 
VALUES(400.00, 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ITENS(custo_compra, descricao, imagem, nome, preco_venda_produto, created_at, updated_at) 
VALUES(2000.00, 'COMPUTADOR1', NULL, 'COMPUTADOR1', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ITENS(custo_compra, descricao, imagem, nome, preco_venda_produto, created_at, updated_at) 
VALUES(2000.00, 'COMPUTADOR2', NULL, 'COMPUTADOR2', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ITENS(custo_compra, descricao, imagem, nome, preco_venda_produto, created_at, updated_at) 
VALUES(2000.00, 'COMPUTADOR3', NULL, 'COMPUTADOR3', 5000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

/*INSERT INTO VENDAS(CREATED_AT, UPDATED_AT)
VALUES(CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO ITENS_VENDA(QUANTIDADE, VL_PRECO_VENDA, VL_TOTAL_VENDA, ID_ITEM)
VALUES(2, 2500, 5000, 1, 1);

INSERT INTO ITENS_VENDA(QUANTIDADE, VL_PRECO_VENDA, VL_TOTAL_VENDA, ID_ITEM)
VALUES(2, 2500, 5000, 2, 1);*/
