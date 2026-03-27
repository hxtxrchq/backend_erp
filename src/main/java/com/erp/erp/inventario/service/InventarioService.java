package com.erp.erp.inventario.service;

import com.erp.erp.inventario.entity.MovimientoStock;
import com.erp.erp.inventario.entity.Producto;
import com.erp.erp.inventario.repository.MovimientoStockRepository;
import com.erp.erp.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InventarioService {

    private final ProductoRepository productoRepository;
    private final MovimientoStockRepository movimientoStockRepository;

    // Spring Boot inyecta automáticamente los repositorios
    public InventarioService(ProductoRepository productoRepository,
            MovimientoStockRepository movimientoStockRepository) {
        this.productoRepository = productoRepository;
        this.movimientoStockRepository = movimientoStockRepository;
    }

    @Transactional
    public String procesarVentaYDescontarStock(String nombreProducto, int cantidadVendida) {
        // 1. Buscamos el producto en la base de datos
        Optional<Producto> productoOpt = productoRepository.findByNombreContainingIgnoreCase(nombreProducto);

        if (productoOpt.isEmpty()) {
            return "Error: No se encontró el producto '" + nombreProducto + "' en el inventario.";
        }

        Producto producto = productoOpt.get();

        // 2. Validamos que haya suficiente stock
        if (producto.getStock() < cantidadVendida) {
            return "Alerta: Stock insuficiente para '" + nombreProducto + "'. Stock actual: " + producto.getStock();
        }

        // 3. Descontamos el stock y actualizamos la tabla Productos
        producto.setStock(producto.getStock() - cantidadVendida);
        productoRepository.save(producto);

        // 4. Registramos el evento en la tabla MovimientosStock (como "Salida")
        MovimientoStock movimiento = new MovimientoStock(producto, "Salida", cantidadVendida);
        movimientoStockRepository.save(movimiento);

        // 5. Devolvemos este texto para que la Inteligencia Artificial sepa qué
        // responderle al usuario
        return "Éxito: Se descontaron " + cantidadVendida + " unidades de '" + nombreProducto
                + "' y se registró la salida en el historial. Nuevo stock: " + producto.getStock();
    }
}