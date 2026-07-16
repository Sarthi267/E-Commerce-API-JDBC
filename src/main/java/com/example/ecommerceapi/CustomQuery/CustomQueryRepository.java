package com.example.ecommerceapi.CustomQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomQueryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ORDER_DETAILS_QUERY = """
            select\s
                o.user_id,
                o.shipping_address,
                o.total_amount,
                oi.quantity,
                oi.price_at_purchase,
                oi.subtotal,
                p.name,
                p.description,
                p.category
            from orders o\s
            left join order_items oi on o.id = oi.order_id
            left join listings l on oi.listing_id = l.id
            left join products p on l.product_id = p.id
            
            """;
    public List<CustomJoinDTO> getOrderDetails() {
        return jdbcTemplate.query(ORDER_DETAILS_QUERY, (rs, rowNum) ->
                new CustomJoinDTO(
                        rs.getLong("user_id"),
                        rs.getString("shipping_address"),
                        rs.getDouble("total_amount"),
                        rs.getInt("quantity"),
                        rs.getDouble("price_at_purchase"),
                        rs.getDouble("subtotal"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("category")
                )
        );
    }

}
