CREATE TABLE conta_produto (
  conta_id BIGINT NOT NULL,
  produto_id BIGINT NOT NULL,
  PRIMARY KEY (conta_id, produto_id)
)
