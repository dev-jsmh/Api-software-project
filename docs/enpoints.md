 
This file will contain all the urls for each endpoint create for the api project 


 * Providers

GET | http://localhost:8080/api/v1/providers
GET | http://localhost:8080/api/v1/providers/{ id }
POST| http://localhost:8080/api/v1/providers
PUT | http://localhost:8080/api/v1/providers/{ id }
DELETE | http://localhost:8080/api/v1/providers/{ id }

* Product Categories 

GET | http://localhost:8080/api/v1/products/categories
GET | http://localhost:8080/api/v1/products/categories/{ id }
POST| http://localhost:8080/api/v1/products/categories
PUT | http://localhost:8080/api/v1/products/categories/{ id }
DELETE | http://localhost:8080/api/v1/products/categories/{ id }

* Products 

GET | http://localhost:8080/api/v1/products
GET | http://localhost:8080/api/v1/products/{ id }
POST| http://localhost:8080/api/v1/products
PUT | http://localhost:8080/api/v1/products/{ id }
DELETE | http://localhost:8080/api/v1/products/{ id }

assing a category to specified product
PUT | http://localhost:8080/api/v1/products/{product_code}/assing-category/{category_id}


* product orders
GET | http://localhost:8080/api/v1/product-orders
POST| http://localhost:8080/api/v1/product-orders
