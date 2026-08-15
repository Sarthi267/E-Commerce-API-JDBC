create index idx_listings_sku on listings(sku);

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
