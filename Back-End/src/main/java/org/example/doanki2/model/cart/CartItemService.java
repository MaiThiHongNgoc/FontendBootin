package org.example.doanki2.model.cart;

import org.example.doanki2.entity.Cart_items;
import org.example.doanki2.entity.Carts;
import org.example.doanki2.entity.Products;
import org.example.doanki2.model.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Repository
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;


    public ResponseEntity<Cart_items> postCart(Cart_items cartItems){
        Cart_items save = cartItemRepository.save(cartItems);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(save.getCart().getCart_id()).toUri();

        return ResponseEntity.created(location).body(save);
    }
    public ResponseEntity<Cart_items> deleteCart(int id){
        Optional<Cart_items> cartItems = cartItemRepository.findById(id);
        if (!cartItems.isPresent()){
            throw new IllegalArgumentException("id cart not found");
        }
        cartItemRepository.deleteById(cartItems.get().getCart_items_id());
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Cart_items> putCart(int id, Cart_items cartItems){
        Optional<Cart_items> cartItemsOptional = cartItemRepository.findById(id);
        if (!cartItemsOptional.isPresent()){
            throw new IllegalArgumentException("id cart items not found");
        }
        Optional<Carts> cartsOptional = cartRepository.findById(cartItems.getCart().getCart_id());
        if (!cartsOptional.isPresent()){
            throw new IllegalArgumentException("id cart not found");
        }
        Optional<Products> productsOptional = productRepository.findById(cartItems.getProduct().getProduct_id());
        if (!productsOptional.isPresent()){
            throw new IllegalArgumentException("id product not found");
        }
        cartItems.setCart_items_id(cartItemsOptional.get().getCart_items_id());
        cartItems.setCart(cartsOptional.get());
        cartItems.setProduct(productsOptional.get());
        cartItemRepository.save(cartItems);
        return ResponseEntity.ok().build();
    }
}
