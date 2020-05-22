drop database ProyectoHibernate;
create database ProyectoHibernate;
use ProyectoHibernate;
create table Directores(
ID INT(10) AUTO_INCREMENT,
Nombre VARCHAR(30) NOT NULL,
Compania VARCHAR(30), 
PRIMARY KEY (ID)
); 
create table Peliculas(
Id INT(10) AUTO_INCREMENT,
Nombre VARCHAR(30) NOT NULL,
Director int,
PRIMARY KEY (Id),
FOREIGN KEY (Director) REFERENCES Directores(ID) ON DELETE NO ACTION ON UPDATE CASCADE);

