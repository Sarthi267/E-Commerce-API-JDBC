create table if not exists users(
    id serial primary key,
    username varchar(30) not null unique,
    password varchar(255) not null unique,
    email varchar(50) not null unique,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone_number varchar(20) not null,
    address varchar(30) not null unique,
    city varchar(30) not null unique,
    "state" char(2) not null unique,
    country varchar(60) not null unique,
    postal_code varchar(15) not null unique
);;

create table if not exists sellers(
    id serial primary key,
    username varchar(30) not null unique,
    password varchar(255) not null unique,
    email varchar(50) not null unique,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone_number varchar(20) not null,
    address varchar(30) not null,
    city varchar(30) not null,
    "state" char(2) not null,
    country varchar(60) not null,
    postal_code varchar(15) not null unique
    );;

create table if not exists products(
    id serial primary key,
    "name" varchar (255) not null,
    description text,
    image varchar (255),
    category varchar (50)
);;

create table if not exists listings(
    id serial primary key,
    seller_id bigint references sellers(id),
    product_id bigint references products(id),
    price decimal (10,2),
    status varchar(20) not null,
    sku varchar(50) not null unique,
    stock integer not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);;

create table if not exists orders(
    id serial primary key,
    user_id bigint references users(id),
    status varchar(20) not null,
    total_amount decimal (10, 2) not null,
    shipping_address varchar(40) not null,
    payment_status varchar(20) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);;

create table if not exists "order_items"(
    id serial primary key,
    order_id bigint references orders(id),
    listing_id bigint references listings(id),
    quantity integer not null,
    price_at_purchase decimal (10, 2) not null,
    subtotal decimal (10, 2) not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);;

create or replace function fn_update_updated_at()
       returns trigger as $$
       begin
            NEW.updated_at = current_timestamp;
            return new;
       end;
       $$ language plpgsql;;

create or replace trigger listings_updated_at
before update on listings
for each row
execute function fn_update_updated_at();;

create or replace trigger orders_updated_at
before update on orders
for each row
execute function fn_update_updated_at();;

create or replace trigger order_items_updated_at
before update on order_items
for each row
execute function fn_update_updated_at();;





