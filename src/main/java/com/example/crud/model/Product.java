package com.example.crud.model;

import com.example.crud.dtos.RequestProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price_in_cents;

    public Product(RequestProductDTO requestProductDTO) {
        this.name = requestProductDTO.name();
        this.price_in_cents = requestProductDTO.price_in_cents();
    }
}
