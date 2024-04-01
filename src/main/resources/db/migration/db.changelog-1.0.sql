CREATE schema if not exists bank;

create table bank.wallet
(
    id      serial PRIMARY KEY,
    amount  decimal
);

INSERT INTO wallet(id, amount) VALUES (1,0);

UPDATE wallet SET amount=1000 WHERE id=1;