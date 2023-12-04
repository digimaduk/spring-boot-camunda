package org.digimad.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private List<Product> products;
    private Customer customer;
    private LocalDateTime orderDate;
    private double totalAmount;
    private boolean isCompleted;
}
