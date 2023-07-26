package com.example.crud.dtos;

import com.example.crud.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProductDTO(
        Long id,
        @NotBlank
        String name,
        @NotNull
        Integer price_in_cents
) {
        public RequestProductDTO(Product product) {
                this(product.getId(), product.getName(), product.getPrice_in_cents());
        }
}
