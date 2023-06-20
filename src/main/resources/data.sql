DROP TABLE IF EXISTS public.prices;

CREATE TABLE public.prices (
    id int not null,
	brand_id int NULL,
	start_date datetime NULL,
	end_date datetime NULL,
	price_list int NULL,
	product_id int NULL,
	priority int NULL,
	price float4 NULL,
	curr varchar(5) NULL
);

INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1,1,'2023-06-14 00.00.00','2023-12-31 23.59.59',1,35455,0,35.50,'EUR'),
       (2,1,'2023-06-14 15.00.00','2023-06-14 18.30.00',1,35455,1,20.45,'EUR'),
       (3,1,'2023-06-15 00.00.00','2023-06-15 11.00.00',1,35455,1,30.50,'EUR'),
       (4,1,'2023-06-15 16.00.00','2023-12-31 23.59.59',1,35455,1,38.95,'EUR');