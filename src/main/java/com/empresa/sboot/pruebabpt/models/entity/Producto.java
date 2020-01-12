package com.empresa.sboot.pruebabpt.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codproducto;

    @NotEmpty
    @Column(name = "precioproducto")
    private int precioProducto;

    @NotEmpty
    @Column(name = "nomproducto")
    private String nomProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nitproveedor")
    @JsonIgnore
    private Proveedor proveedor;

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getCodProducto() {
        return codproducto;
    }

    public void setCodProducto(String codProducto) {
        this.codproducto = codProducto;
    }


    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

}
