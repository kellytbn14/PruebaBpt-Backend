package com.empresa.sboot.pruebabpt.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    @Id
    private String nit;

    @Column(name = "nomproveedor")
    private String nomProveedor;

    @Column(name = "telproveedor")
    private String telProveedor;

    @Column(name = "emailproveedor")
    private String emailProveedor;

   //un proveedor muchos productos
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<Producto> productoList;

    private static final long serialVersionUID = 1L;

    public Proveedor() {
        this.productoList = new ArrayList<Producto>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getTelProveedor() {
        return telProveedor;
    }

    public void setTelProveedor(String telProveedor) {
        this.telProveedor = telProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public void addProductos(Producto producto){
        addProductos(producto);
    }

}
