ALTER TABLE
  pagamentos
ADD
  CONSTRAINT FK_PAGAMENTO_CONTA_ID FOREIGN KEY (conta_id) REFERENCES contas
