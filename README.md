# PruebaBpt-Backend

_Prueba técnica. Este proyecto hace consultas sencillas a dos tablas relacionadas._
_Proveedores y Productos_

### Pre-requisitos
_La base de datos es: bd_proveedor_<br>
_Para la base de datos, importar las tablas SQL que están en la carpeta SQL_

### Decisiones de Diseño
_Para el Backend se usó SpringBoot con Maven_<br>
_Se mapearon los datos con ModelMapper_

## Consumir el API
_Para consumir el API se tienen las siguintes URLs_<br>
http://localhost:4200/api


_Para proveedores_<br>
_Busca todos: /proveedor_<br>
_Busca por Nit del proveedor: /proveedor/123_<br>
_Busca proveedor por Codigo del producto: /proveedor/getnameproveedorporcod/123_


_Para productos_<br>
_Busca todos: /producto_<br>
_Busca por codigo del producto: /producto/123_<br>
_Busca productos por Nit del proveedor: /producto/getproductos/123_<br>
_Busca productos mayores que un valor dado: /producto/getproductosmayorque/40000_<br>
_Busca los nombres de productos por Nit del proveedor: /producto/getnameproductospornit/123_<br>
_Busca los nombres de productos por Nit del proveedor: /producto/getnameproductospornit/123_<br>
_Busca  productos que su precio esté entre dos valores: /producto/getproductosentre/200/300_<br>
