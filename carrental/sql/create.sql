CREATE TABLE Clients(
login VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) NOT NULL
);

CREATE TABLE Cars(
id_car IDENTITY PRIMARY KEY,
plate_number VARCHAR(8),
mark VARCHAR(20),
model VARCHAR(20),
description VARCHAR(255),
price_hour INTEGER);

CREATE TABLE Rentals(
id_rentals INTEGER IDENTITY  PRIMARY KEY ,
login VARCHAR(32) REFERENCES Clients(login),
plate_number INTEGER REFERENCES Cars(id_car),
rental_date DATE,
return_date DATE);