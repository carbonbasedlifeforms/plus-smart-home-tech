create schema if not exists shopping_store;
set schema 'shopping_store';

create table if not exists products (
    id uuid default gen_random_uuid() primary key,
    product_name varchar(255),
    description text,
    image_src varchar(255),
    quantity_state varchar(64),
    product_state varchar(64),
    product_category varchar(64),
    price decimal
);