CREATE KEYSPACE delivery_ks	
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

USE delivery_ks;

CREATE TABLE products (
id UUID,
name text,	
shop_name text,		
address text,	
price float,
weight int,
description text,
PRIMARY KEY (id)
);				
	
CREATE INDEX IF NOT EXISTS ON products (name);
CREATE INDEX IF NOT EXISTS ON products (shop_name);

Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Хлеб', 'Achan', 'ZHELEZNODOROZHNY', 100.00, 300, 'Самый вкусный хлеб');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Квас', 'Achan', 'ZHELEZNODOROZHNY', 200.00, 300, 'Самый вкусный квас');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Молоко', 'Achan', 'ZHELEZNODOROZHNY', 150.00, 100, 'Самое вкусное молоко');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Тапки', 'Achan', 'ZHELEZNODOROZHNY', 300.00, 100, 'Самые крепкие тапки');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Яблоко', 'Achan', 'ZHELEZNODOROZHNY', 120.00, 1000, 'Самые вкусное яблоки');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Пельмени', 'Шестёрочка', 'OKTYABRSKY', 140.00, 800, 'Вот он, настоящий пельмень!');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Фикус', 'Leroit Merlin', 'TSENTRALNY', 325.00, 1200, 'Благоухающий фикус');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Iphone 14', 'Re:store', 'SOVETSKY', 65000.00, 500, 'Удар по вашему кошельку');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Конфеты', 'Алёнка', 'ZAELTSOVSKY', 129.00, 600, 'Вкус детства');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Йод', 'СберАптека', 'KIROVSKY', 20.00, 50, 'Дёшево и сердито');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Цинк', 'Solgar', 'TSENTRALNY', 500.00, 300, 'Дорого и благосклонно');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Уха', 'Волковские продукты', 'ZHELEZNODOROZHNY', 300, 250, 'Сделана из фермерских продуктов');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Ель искуственная', 'Лента', 'PERVOMAISKY', 800.00, 1000, 'Готовь сани летом'); 
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Носки белорусские', 'Белорусские продукты', 'PERVOMAISKY', 250.00, 100, 'Мёртвого согреют');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Гуляж классический', 'Achan', 'ZAELTSOVSKY', 300.00, 150, 'Гуляй, гуляж');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Шестерёнки', 'Leroit Merlin', 'OKTYABRSKY', 2000.00, 1000, 'Смазаны на заводе');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Щи', 'Волковские продукты', 'ZHELEZNODOROZHNY', 100.00, 100, 'Прибавляют мощи');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Зубная щётка', 'Oral-B', 'KIROVSKY', 400.00, 225, 'Лучшая в своей сфере');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Вода', 'Ярче', 'OKTYABRSKY', 50.00, 500, 'С горных вершин Новосибирской области');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Ананас', 'Лента', 'TSENTRALNY', 400.00, 800, 'Свидание спас!');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Ракетка теннисная', 'Гигант', 'ZHELEZNODOROZHNY', 250.00, 100, 'Подойдёт как профессионалам, так и начинающим');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Окорок свиной', 'Лента', 'PERVOMAISKY', 600.00, 1500, 'В самый раз для гриля');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Лента от мух', 'Лента', 'TSENTRALNY', 300.00, 50, 'Лента для мух');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Диски для автомобиля', 'НСК Авто 54', 'OKTYABRSKY', 4000.00, 2500, 'Слепят на солнце');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Жаркое', 'Волковские продукты', 'SOVETSKY', 340.00, 300, 'Доставим не прохладным');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Эскимо', 'Инмарко', 'TSENTRALNY', 80.00, 130, 'Классическое мороженое');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Яйца С0', 'Лента', 'SOVETSKY', 80.00, 300, '10 штук'); 
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Чеснок', 'Бахетле', 'LENINSKY', 25.00, 50, 'Прямо с грядки');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Соль морская', 'Лента', 'DZERZHYNSKY', 100.00, 800, 'Идеально для салатов');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Игровая мышь', 'DNS', 'LENINSKY', 2500.00, 200, 'С подсветкой!');
Insert into delivery_ks.products(id, name, shop_name, address, price, weight, description) values (uuid(), 'Банный комплект', 'Achan', 'DZERZHYNSKY', 300.00, 100, 'С надписями');

CREATE TABLE purchases (
order_id uuid,
destination text,	
condition text,
weight int,	
shop_name text,
user_id text,		
product_id text,
product_name text,
address text,
quantity int,
price float,
description text,
PRIMARY KEY (order_id, product_id)
);

CREATE INDEX IF NOT EXISTS ON purchases (product_id);
CREATE INDEX IF NOT EXISTS ON purchases (destination);
CREATE INDEX IF NOT EXISTS ON purchases (condition);
CREATE INDEX IF NOT EXISTS ON purchases (weight);
CREATE INDEX IF NOT EXISTS ON purchases (address);
CREATE INDEX IF NOT EXISTS ON purchases (user_id);	

CREATE TABLE users (
username text,
password text,
full_name text,
phone_number text,
personal_score float,
promo_codes list<text>,
roles set<text>,
PRIMARY KEY (username)
);


CREATE TABLE couriers (
login text,
password text,
full_name text,
phone_number text,
district text,
PRIMARY KEY (login)
);				

CREATE INDEX IF NOT EXISTS ON couriers (district);



CREATE TABLE drivers (
login text,
password text,
full_name text,
phone_number text,
district text,		
is_available boolean,
PRIMARY KEY (login)
);

CREATE INDEX IF NOT EXISTS ON couriers (district);
CREATE INDEX IF NOT EXISTS ON couriers (is_available);
