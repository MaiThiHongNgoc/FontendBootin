package org.example.doanki2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgProductList {
    private int img_id;

    private String img_name;

    private String img_url;

    private Products product;

}
