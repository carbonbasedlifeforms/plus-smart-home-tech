create schema if not exists shopping_cart;
set schema 'shopping_cart';

create table if not exists shopping_carts (
    id uuid default gen_random_uuid() primary key,
    user_name varchar(255),
    is_active boolean
);

create table if not exists shopping_cart_products (
    product_id uuid primary key,
    shopping_cart_id uuid references shopping_carts(id),
    quantity bigint not null
);