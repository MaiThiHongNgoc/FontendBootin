package org.example.doanki2.model.cart;

import org.example.doanki2.entity.Cart_items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<Cart_items, Integer> {
}
