CREATE TABLE klienci(
login VARCHAR(20) PRIMARY KEY,
haslo VARCHAR(20) NOT NULL
);

CREATE TABLE samochody(
nr_rejestracyjny VARCHAR(20) PRIMARY KEY,
marka VARCHAR(20),
model VARCHAR(20),
kolor VARCHAR(20),
cenaZaH INTEGER);

CREATE TABLE rezerwacje(
id_rezerwacji INTEGER  PRIMARY KEY,
login VARCHAR(20) REFERENCES klienci(login),
nr_rejestracyjny VARCHAR(20) REFERENCES samochody(nr_rejestracyjny),
dataOd DATE,
dataDo DATE);