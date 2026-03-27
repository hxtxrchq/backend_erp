package com.erp.erp.compras.dto;

import java.math.BigDecimal;

public record ProductoDTO(
        Integer id,
        String nombre,
        Integer stock,
        BigDecimal precio
) {
}
