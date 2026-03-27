package com.erp.erp.inventario.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MovimientosStock")
public class MovimientoStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    // Relación directa con la tabla Productos
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductoId", nullable = false)
    private Producto producto;

    @Column(name = "ProveedorId")
    private Integer proveedorId;

    @Column(name = "TipoMovimiento", length = 20)
    private String tipoMovimiento; // "Entrada" o "Salida"

    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "Fecha", insertable = false, updatable = false)
    private LocalDateTime fecha;

    // Constructor vacío (JPA)
    public MovimientoStock() {
    }

    // Constructor práctico para registrar ventas rápidamente
    public MovimientoStock(Producto producto, String tipoMovimiento, Integer cantidad) {
        this.producto = producto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}