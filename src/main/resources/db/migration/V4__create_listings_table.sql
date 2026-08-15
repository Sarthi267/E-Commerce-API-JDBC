
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