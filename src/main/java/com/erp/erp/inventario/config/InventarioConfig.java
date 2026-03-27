package com.erp.erp.inventario.config;

import com.erp.erp.inventario.dto.ActualizarStockRequest;
import com.erp.erp.inventario.service.InventarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class InventarioConfig {

    @Bean
    @Description("Útil para descontar el stock de un producto en la base de datos y registrar su historial de salida inmediatamente después de realizar una venta.")
    public Function<ActualizarStockRequest, String> agenteLogistico(InventarioService inventarioService) {

        return request -> inventarioService.procesarVentaYDescontarStock(
                request.nombreProducto(),
                request.cantidadVendida());
    }
}