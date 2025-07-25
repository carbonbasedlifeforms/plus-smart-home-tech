create schema if not exists warehouse;
set schema 'warehouse';

create table if not exists warehouse_items (
    id uuid default gen_random_uuid() primary key,
    quantity bigint default 0,
    fragile boolean not null,
    weight decimal not null,
    width decimal not null,
    height decimal not null,
    depth decimal not null
);

create table if not exists order_booking (
    order_id uuid primary key,
    delivery_id uuid
);

create table if not exists order_booking_products (
    order_booking_id uuid references order_booking(order_id),
    product_id uuid not null,
    quantity bigint not null default 0
);