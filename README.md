
//  Categories    ********************************************

GET     :   http://localhost:8080/api/categories/all

     -: Get All Categories with product


GET     :  http://localhost:8080/api/categories/1
		Get  Categories and product by categoriesid 

GET  :  http://localhost:8080/api/categories/page

	default pagination size is 10 element and page is 1

GET  : http://localhost:8080/api/categories/page?page=1&size=5

	Get all pagination details with all information size is 5 and page no is 1

GET  : http://localhost:8080/api/categories?page=1&size=5

	Get all pagination nly data size is 5 and page no is 1

POST  :   http://localhost:8080/api/categories

	Add Categories
 	{
        "id": 1,
        "name": "Politicals"
       
    }




PUT   : http://localhost:8080/api/categories/26

{
        "id": 1,
        "name": "Electronics",
        "products": [           
        ]
}
    


Update specific category 

DELETE  : http://localhost:8080/api/categories/2

Delete by id Category as well as products



 GET     :     http://localhost:8080/api/products

	default pagination size is 10 element and page is 1

 GET     :     http://localhost:8080/api/products?page=1&size=5


	default pagination size is 5 element and page is 1



Products /***************************************/


GET   :    http://localhost:8080/api/products/1
		Get   product and Categories  by categoriesid 



GET   : http://localhost:8080/api/products/all
		Get All  product and Categories  by categoriesid 


POST  :  http://localhost:8080/api/products

Add data
 {
"id": 10,
"name": "WASHING MACHINE",
"price": 99,
"category": {
    	     
	"id": 17   //important to add relationship
    
	}
}


PUT : http://localhost:8080/api/products/24

{
"id": 10,
"name": ".....................",
"price": 99,
"category": {
    "id": 16
    
}
}

DELETE : http://localhost:8080/api/products/3

DELETE BY ID


