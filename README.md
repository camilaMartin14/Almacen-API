# ALMACÉN🧃

### Almacén is a Java REST API designed to manage daily sales, product inventory, and store customers👨‍👩‍👧‍👦

## Table of Contents
1. [Features](#features)
2. [Endpoints](#endpoints)

## Features

- CRUD operations for sales, clients and products.
- Retrieve the highest sale for any given date.
- Get the number of sales for a specific day.
- Identify the products running low on stock.

## Endpoints
### Customers
- GET /clientes: Retrieve all customers in the store
- POST /clientes/crear: register a new customer.
- DELETE /clientes/eliminar/{id_cliente}: delete a customer by their ID.
- PUT /clientes/ editar/{id_cliente}: Update all details of a customer, including their ID.
- PUT /clientes/editar: Update customer details without changing the ID.
### Products
- GET /productos/sin-stock: List all products where stock is less than 5 units.
### Sales
- GET /ventas/productos/{codigo_venta}: View all products included in a specific sale.
- GET /ventas/total/{fecha_venta}: Get the total sales amount for a specific day. 
### 👉Note: To perform CRUD operations for sales or products, simply replace "clientes" in the endpoints with "ventas" or "productos" respectively.
