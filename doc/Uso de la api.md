# Uso de la api


## Cliente
### Crear un cliente
- URL: `/api/v1/client`
- Método: `POST`
- Cuerpo de la solicitud:
```json
{
 "name": "Nombre del cliente",
 "lastname": "Apellido del cliente",
 "docnumber": 123456789
}
```

### Obtener un cliente por ID
- URL: `/api/v1/client/{id}`
- Método: `GET`

### Actualizar un cliente existente
- URL: `/api/v1/client/{id}`
- Método: `PUT`
- Cuerpo de la solicitud:
```json
{
  "name": "Nuevo nombre del cliente",
  "lastname": "Nuevo apellido del cliente",
  "docnumber": 987654321
}
```
### Eliminar un cliente por ID
- URL: `/api/v1/client/{id}`
- Método: `DELETE`


## Producto
### Crear un producto
- URL: `/api/v1/product`
- Método: `POST`
- Cuerpo de la solicitud:
```json
{
 "tittle": "Nuevo nombre del producto",
  "description": "Nueva descripción del producto",
  "code": "200",
  "price": 14.99,
  "stock": 3
}
```
### Obtener un producto  por ID
- URL: `/api/v1/product/{id}`
- Método: `GET`

### Actualizar un producto existente
- URL: `/api/v1/product/{id}`
- Método: `PUT`
- Cuerpo de la solicitud:
```json
 {
  "tittle": "Nuevo nombre del producto",
  "description": "Nueva descripción del producto",
  "code": "200",
  "price": 14.99,
  "stock": 3
}
```

### Eliminar un producto por ID
- URL: `/api/v1/product/{id}`
- Método: `DELETE`


## Comprobantes
### Crear un comprobante
- URL: `/api/v1/invoice`
- Método: `POST`
- Cuerpo de la solicitud:
```json
{
    "client_id": 1,
    "product_list": [
        {
            "productId": 1,
            "quantity": 1
        },
         {
            "productId": 2,
            "quantity": 2
        }
        
    ]
}
```
### Obtener un comprobante  por ID
- URL: `/api/v1/invoice/{id}`
- Método: `GET`

### Obtener comprobantes por cliente ID
- URL: `/api/v1/invoice/getInvoicesByClientId/{id}`
- Método: `GET`

