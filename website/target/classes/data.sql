INSERT INTO DEALER(name) VALUES('Dealer 1');
INSERT INTO DEALER(name) VALUES('Dealer 2');

INSERT INTO LISTING(upload_date, dealer_id) VALUES('2019-12-04 21:00:00', 1);
INSERT INTO LISTING(upload_date, dealer_id) VALUES('2019-12-05 17:00:00', 2);

INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(1,'Mercedes','A 180',123,2014,'black',15950, 1);
INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(2,'Audi','A3',111,2016,'white',17210, 1);
INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(3,'Volkswagen','Golf',86,2018,'green',14980, 1);
INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(4,'Skoda','Octavia',86,2018,'black',16990, 1);
INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(1,'Volkswagen','Golf R3',86,2018,'green',14980, 2);
INSERT INTO CAR(code, make, model, power, year, color, price, listing_id) VALUES(2,'Skoda','Octavia Z',86,2018,'black',16990, 2);
