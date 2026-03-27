package com.erp.erp.compras.repositorio;

import com.erp.erp.compras.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
