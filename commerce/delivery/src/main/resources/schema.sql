create schema if not exists delivery;
set schema 'delivery';

create table if not exists address (
    id uuid default gen_random_uuid() primary key,
    country varchar(255),
    city varchar(255),
    street varchar(255),
    house varchar(10),
    flat varchar(10)
);

create table if not exists order_delivery (
    id uuid default gen_random_uuid() primary key,
    total_volume bigint,
    total_weight bigint,
    fragile boolean,
    from_address_id uuid references address(id) not null,
    to_address_id uuid references address(id) not null,
    order_id uuid not null,
    delivery_state varchar(50)
);

