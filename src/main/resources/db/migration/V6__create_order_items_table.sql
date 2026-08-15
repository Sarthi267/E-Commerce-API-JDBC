

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
