package org.example.doanki2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_Detail_List {


    private int order_detail_id;


    private int orders;

   private Products products;

   private int quantity;

}
