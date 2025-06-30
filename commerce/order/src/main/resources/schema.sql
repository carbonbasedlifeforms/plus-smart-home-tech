create schema if not exists "order";
set schema 'order';

create table if not exists address (
    id uuid default gen_random_uuid() primary key,
    country varchar(255),
    city varchar(255),
    street varchar(255),
    house varchar(10),
    flat varchar(10)
);

create table if not exists orders (
    id uuid default gen_random_uuid() primary key,
    user_name varchar(255),
    order_state varchar(50),
    shopping_cart_id uuid,
    delivery_id uuid,
    delivery_address_id uuid references address(id),
    payment_id uuid,
    delivery_volume decimal,
    delivery_weight decimal,
    fragile boolean,
    total_price decimal,
    product_price decimal,
    delivery_price decimal
);

create table if not exists order_products (
    product_id uuid,
    order_id uuid references orders(id),
    quantity bigint,
    primary key (product_id, order_id)
);
