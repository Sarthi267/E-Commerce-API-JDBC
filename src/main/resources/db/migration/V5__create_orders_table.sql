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
