CREATE schema if not exists bank;

create table bank.wallet
(
    id     serial PRIMARY KEY,
    amount decimal
);