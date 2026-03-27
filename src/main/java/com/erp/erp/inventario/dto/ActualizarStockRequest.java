package com.erp.erp.inventario.dto;

public record ActualizarStockRequest(
        String nombreProducto,
        Integer cantidadVendida) {
}