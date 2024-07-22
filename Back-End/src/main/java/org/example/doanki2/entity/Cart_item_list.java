package org.example.doanki2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart_item_list {

    private int cart_item_id;

    private int cart;

    private Products product;

    private int quantity;
}
