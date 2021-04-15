CREATE TABLE Currency(id INT PRIMARY KEY AUTO_INCREMENT, description varchar(5));

CREATE TABLE Brand(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), description VARCHAR(30));

CREATE TABLE Category(id INT PRIMARY KEY AUTO_INCREMENT , name varchar(20));

CREATE TABLE Product(id BIGINT PRIMARY KEY AUTO_INCREMENT ,name VARCHAR(20) , description VARCHAR(30),category_id int,
                    FOREIGN KEY (category_id) REFERENCES category(id));


                    
                  
CREATE TABLE Prices(id BIGINT PRIMARY KEY AUTO_INCREMENT , start_date datetime , end_date dateTime , priority int , price float,
                     brand_id int, FOREIGN KEY (brand_id) REFERENCES Brand(id),
							product_id BIGINT,FOREIGN KEY (product_id) REFERENCES Product(id),
							currency_id int, FOREIGN KEY (currency_id) REFERENCES Currency(id));
							
							
 
CREATE VIEW Prices_View as select Prices.brand_id,Prices.start_date,Prices.end_date,Prices.id as price_list,Prices.product_id,Prices.priority,Prices.price,Currency.description as curr from Prices inner join Currency on Prices.currency_id= Currency.id;
