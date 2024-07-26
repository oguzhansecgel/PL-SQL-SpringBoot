package com.sqldeveloper.sqldeveloper.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@ToString
public class Product {
    @Id
    @Column(name = "ID")
    private Long id;
    private String name;
    private double price;
}
