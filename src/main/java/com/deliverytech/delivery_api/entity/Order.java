package com.deliverytech.delivery_api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate; 
    private String deliveryAddress; 
    private BigDecimal subtotal; 
    private BigDecimal deliveryFee; 
    private BigDecimal totalAmount; 

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; 

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)                                                              
    private List<OrderItem> items;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;
}
