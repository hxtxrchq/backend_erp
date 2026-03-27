package com.erp.erp.compras.repositorio;

import com.erp.erp.compras.entidad.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoStockRepositorio extends JpaRepository<MovimientoStock, Integer> {
}
