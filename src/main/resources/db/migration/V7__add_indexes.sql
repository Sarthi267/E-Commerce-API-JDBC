

create index idx_user_username on users(username);
create index idx_user_email on users(email);
create index idx_listings_seller_id on listings(seller_id);
create index idx_listings_product_id on listings(product_id);
create index idx_orders_user_id on orders(user_id);
create index idx_order_items_order_id on order_items(order_id);
create index idx_order_items_listing_id on order_items(listing_id);

create index idx_listings_status on listings(status);
create index idx_orders_status on orders(status);
create index idx_orders_payment_status on orders(payment_status);
