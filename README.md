
Prices Solution  
============ 
Tech Stack    
============
| Techs |
| ----------- |
| Java 15 |
| H2 |
| Maven |
| Spring boot |    

To develop this simple solution, I have created a little database    
------------

E-R Diagram:    
============
![Alt text](/mdResources/MER.png?raw=true "E-R Diagram")    

Although we can work with all the entities in our code, I decided to create a view to make the development process a little bit quicker.   
------------

You can check the DB Schema in https://github.com/jreyesr1/IndiTest/blob/48cec7003704393638d8e3c53f61546406d62543/src/main/resources/schema.sql    

Prices_View:    
============
![Alt text](/mdResources/View.png?raw=true "Prices_View")    


Endpoints: 
============   
We just have one endpoint to get our data.    
http://[hostname]:[port]/api/v1/prices   
The endpoint works with query params, all the params are required.   
| Key         | Value |
| ----------- | ----------- |
| date      | date in format [yyyy-MM-dd'-'HH.mm.ss] |
| product   | product Id        |
| brand   | brand Id        |    

URL Example:    
============

| Key         | Value |
| ----------- | ----------- |
| date      | 2020-06-16-21.00.00 |
| product   | 35455        |
| brand   | 1       |   

http://localhost:8181/api/v1/prices?date=2020-06-16-21.00.00&product=35455&brand=1    

As a successful response you will get a json body like that:   
------------
```json
{
    "priceList": 4,
    "brandId": 1,
    "startDate": "2020-06-15 16:00:00",
    "endDate": "2020-12-31 23:59:59",
    "productId": 35455,
    "price": 38.95,
    "currency": "EUR"
}
```
And as an error you can get:    
Code 404 when a Price is not found.    
Code 400 when you send a bad request.   

Note: You can find some tests to the endpoint in different cases, in the Test Class Package. 
------------ 







