insert into Currency(description)values('EUR');
insert into Currency(description)values('USD');
insert into Currency(description)values('GBP');
insert into Currency(description)values('AUD');
insert into Currency(description)values('CAD');




insert into Brand (id,name, description) values(1,'ZARA','Cadena de moda');
insert into Brand (name, description) values('Pull&Bear','Cadena de moda');
insert into Brand (name, description) values('Bershka','Cadena de tiendas de ropa');



insert into Category (name) values('Men');
insert into Category (name) values('Women');
insert into Category (name) values('Kids');


 
insert into Product(id,name, description,category_id) values(35455,'RedMax','Red T-Shirt', 1);
insert into Product(name, description,category_id) values('PinkGlass','Pink T-Shirt', 2);

 

insert into Prices(id,start_date,end_date,priority,price,brand_id,product_id, currency_id)values(1,'2020-06-14 00.00.00','2020-12-31 23.59.59',0,35.50,1,35455,1);
insert into Prices(id,start_date,end_date,priority,price,brand_id,product_id, currency_id)values(2,'2020-06-14 15.00.00','2020-06-14 18.30.00',1,25.45,1,35455,1);
insert into Prices(id,start_date,end_date,priority,price,brand_id,product_id, currency_id)values(3,'2020-06-15 00.00.00','2020-06-15 11.00.00',1,30.50,1,35455,1);
insert into Prices(id,start_date,end_date,priority,price,brand_id,product_id, currency_id)values(4,'2020-06-15 16.00.00','2020-12-31 23.59.59',1,38.95,1,35455,1);

 