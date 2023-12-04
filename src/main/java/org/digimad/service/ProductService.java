package org.digimad.service;

import org.digimad.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProducts() {
        productList.add(Product.builder()
            .productId(1L)
            .productName("Margherita Pizza")
            .description("A classic Italian pizza with tomato, fresh mozzarella cheese, basil, and olive oil.")
            .price(09.99)
            .quantityAvailable(10)
            .build());
        productList.add(Product.builder()
            .productId(2L)
            .productName("Vegetarian Pizza:")
            .description("Loaded with various vegetables such as bell peppers, onions, olives, tomatoes, mushrooms, and more.")
            .price(11.99)
            .quantityAvailable(10)
            .build());
        return productList;
    }
}
