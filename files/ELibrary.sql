-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS ELibrary;
CREATE DATABASE ELibrary;
USE ELibrary;

-- ------------------------------------------------------------------------------
-- - Construction de la tables des livres                                     ---
-- ------------------------------------------------------------------------------
CREATE TABLE T_Books (
	IdBook			int(4)			PRIMARY KEY AUTO_INCREMENT,
	Title			varchar(30)		NOT NULL,
	Author			varchar(30)		NOT NULL,
	UnitaryPrice	float(8)		NOT NULL DEFAULT 0,
	Quantity		int(4)			NOT NULL DEFAULT 1
) ENGINE = InnoDB;
-- ------------------------------------------------------------------------------
-- - Construction de la tables des themes                                     ---
-- ------------------------------------------------------------------------------
CREATE TABLE T_Themes (
	IdTheme 			INT(4) 		PRIMARY KEY AUTO_INCREMENT,
	ThemeName 			VARCHAR(20) NOT NULL
	)ENGINE = InnoDB;
	
-- ------------------------------------------------------------------------------
-- - Construction de la tables des utilisateurs                               ---
-- ------------------------------------------------------------------------------
CREATE TABLE T_Customers (
	IdCustomer 		int(4) PRIMARY KEY AUTO_INCREMENT,
	Password 		varchar(20) NOT NULL,
	LastName 		varchar(30) NOT NULL,
	FirstName	 	varchar(30) NOT NULL,
	Email 			varchar(40) NOT NULL UNIQUE,
	Address 		varchar(50) NOT NULL ,
	Phone 			varchar(20) NOT NULL 
	
) ENGINE = InnoDB;
-- ------------------------------------------------------------------------------
-- - Construction de la tables de correspondance entre les themes et les livres--
-- ------------------------------------------------------------------------------

CREATE TABLE `t_themeitems` (
  `IdBook` int(4) NOT NULL,
  `IdTheme` int(4) NOT NULL,
  PRIMARY KEY (`IdBook`,`IdTheme`),
  KEY `FK__t_themes` (`IdTheme`),
  CONSTRAINT `FK__t_books` FOREIGN KEY (`IdBook`) REFERENCES `t_books` (`IdBook`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__t_themes` FOREIGN KEY (`IdTheme`) REFERENCES `t_themes` (`IdTheme`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
-- ------------------------------------------------------------------------------
-- - Construction de la tables des commandes                                   --
-- ------------------------------------------------------------------------------
CREATE TABLE T_Orders (
	IdOrder 			INT(4) 		PRIMARY KEY AUTO_INCREMENT,
	IdCustomer 			INT(4) NOT NULL,
	Amount				float(8),
	Date				date    NOT NULL  DEFAULT current_timestamp
	)ENGINE = InnoDB;

CREATE TABLE T_OrderItems (
	IdOrder		INT(4) NOT NULL,
	IdBook 		INT(4) NOT NULL,
	Quantity 	int(4) not null DEFAULT 0, 
	PRIMARY KEY (IdOrder,IdBook ),
	CONSTRAINT FK2__t_books FOREIGN KEY (IdBook) REFERENCES t_books (IdBook) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK__t_idorders FOREIGN KEY (IdOrder) REFERENCES t_orders (IdOrder) ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE = InnoDB;	

-- ------------------------------------------------------------------------------
-- -                          Les Données testées                              --
-- ------------------------------------------------------------------------------

INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'L Etranger'  ,'Albert Camus', 12 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le petit Prince'  ,'Antoine de Saint-Exupery', 18 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le Pere Goriot'  ,'Honore de Balzac', 14 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( '2666'  ,'Roberto Bolano', 25 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le prophete'  ,'Gibran Khalil Gibran', 22 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'La Nuit des temps'  ,'Rene Barjavel', 10 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Oui oui et les pirates'  ,'Toto', 16 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Vendredi ou la vie sauvage'  ,'Michel Tournier', 8 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le premier chien'  ,'Jean-Luc Dejean', 9 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'L ame du mal'  ,'Maxime Chattam', 22 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'In Tenebris'  ,'Maxime Chattam', 24 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Malefices'  ,'Maxime Chattam', 26 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Ballade des pendus'  ,'Francois Villon', 30 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'La soupe aux choux'  ,'Mere Grand', 20 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Veggie toi'  ,'Lami des Betes', 5 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Martin Eden'  ,'Jack London', 20 );
INSERT INTO T_Customers ( LastName, FirstName,Email, Address,Phone,Password) VALUES ( 'Robert'  , 'Refort', 'rob.red@fee.tcr','4 avenue du Lac, Puteaux','45109766','123');
INSERT INTO T_Customers ( LastName, FirstName,Email, Address,Phone,Password) VALUES ( 'Nasser'  , 'Artmen', 'nes.art@bleu.rtc','75 route de la gloire, Nice','4569875','456' );
INSERT INTO T_Customers ( LastName, FirstName,Email, Address,Phone,Password) VALUES ( 'Florence'  , 'Little', 'flo.lite@coldmail.frr','1 avenue de la mer Roubaix','46574659','789' );
INSERT INTO T_Customers ( LastName, FirstName,Email, Address,Phone,Password) VALUES ( 'Christophe'  , 'Laotsi', 'chris.admin@fms.it','42 rue de la paix Lozzi','9698659','000' );
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Occasion');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Voyage');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Jeunesse');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Cuisine');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Poesie');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Science-fiction');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Polar');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Roman');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Petit-prix');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Meilleurs ventes');
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (1,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (1,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (1,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (1,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (2,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (2,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (3,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (3,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (4,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (4,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (5,5);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (5,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (6,6);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (6,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (6,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (7,3);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (8,3);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (8,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (9,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (9,3);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (9,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (10,7);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (10,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (11,7);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (11,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (12,7);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (12,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (13,5);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (13,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (14,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (14,4);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (14,6);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (14,10);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (15,1);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (15,4);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (15,9);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (16,2);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (16,8);
INSERT INTO T_Themeitems (IdBook,IdTheme) VALUES (16,10);

