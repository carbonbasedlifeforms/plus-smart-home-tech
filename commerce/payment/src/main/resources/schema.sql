create schema if not exists payment_gateway;
set schema 'payment_gateway';

create table if not exists payments (
    id uuid default gen_random_uuid() primary key,
    order_id uuid not null,
    products_total decimal,
    delivery_total decimal,
    total_payment  decimal,
    fee_total decimal,
    payment_state varchar(50)
);