-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS ELibrary;
CREATE DATABASE ELibrary CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ELibrary;

-- ------------------------------------------------------------------------------
-- - Construction de la tables des livres en vente                            ---
-- ------------------------------------------------------------------------------
CREATE TABLE T_Books (
	IdBook			int(4)			PRIMARY KEY AUTO_INCREMENT,
	Title			varchar(30)		NOT NULL,
	Author			varchar(30)		NOT NULL,
	UnitaryPrice	float(8)		NOT NULL DEFAULT 0
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
	LastName 		varchar(30) NOT NULL,
	FirstNameName 	varchar(30) NOT NULL,
	Email 			varchar(40) NOT NULL UNIQUE,
	Address 		varchar(50) NOT NULL ,
	Phone 			varchar(20) NOT NULL ,
	Password 		varchar(20) NOT NULL
) ENGINE = InnoDB;
-- ------------------------------------------------------------------------------
-- - Construction de la tables de correspondance entre les themes et les livres--
-- ------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS `t_themeitem` (
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
	IdUser 				INT(4) NOT NULL,
	Amount				float(8),
	Date				date
	)ENGINE = InnoDB;

CREATE TABLE T_OrderItem (
	IdOrder INT(4) NOT NULL,
	IdBook INT(4) NOT NULL,
	Quantity int(4) not null DEFAULT 0, 
	PRIMARY KEY (IdOrder,IdBook ),
	CONSTRAINT FK2__t_books FOREIGN KEY (IdBook) REFERENCES t_books (IdBook) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK__t_idorders FOREIGN KEY (IdOrder) REFERENCES t_orders (IdOrder) ON UPDATE NO ACTION ON DELETE NO ACTION
) ENGINE = InnoDB;	

INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'L Etranger'  ,'Albert Camus', 12 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le petit Prince'  ,'Antoine de Saint-Exupéry', 18 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le Père Goriot'  ,'Honoré de Balzac', 14 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( '2666'  ,'Roberto Bolaño', 25 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le prophète'  ,'Gibran Khalil Gibran', 22 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'La Nuit des temps'  ,'René Barjavel', 10 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Oui oui et les pirates'  ,'Toto', 16 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Vendredi ou la vie sauvage'  ,'Michel Tournier', 8 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Le premier chien'  ,'Jean-Luc Déjean', 9 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'L âme du mal'  ,'Maxime Chattam', 22 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'L âme du mal'  ,'Maxime Chattam', 22 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'In Tenebris'  ,'Maxime Chattam', 24 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Maléfices'  ,'Maxime Chattam', 26 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Ballade des pendus'  ,'Francois Villon', 30 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'La soupe aux choux'  ,'Mère Grand', 20 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Veggie toi'  ,'Lami des Bêtes', 5 );
INSERT INTO T_Books ( Title, Author, UnitaryPrice ) VALUES ( 'Martin Eden'  ,'Jack London', 20 );
INSERT INTO T_Customers ( LastName, FirstNameName,Email, Address,Phone,Password) VALUES ( 'Robert'  , 'Refort', 'rob.red@fee.tcr','4 avenue du Lac, Puteaux',45109766,123 );
INSERT INTO T_Customers ( LastName, FirstNameName,Email, Address,Phone,Password) VALUES ( 'Nasser'  , 'Artmen', 'nes.art@bleu.rtc','75 route de la gloire, Nice',14569875,456 );
INSERT INTO T_Customers ( LastName, FirstNameName,Email, Address,Phone,Password) VALUES ( 'Florence'  , 'Little', 'flo.lite@coldmail.frr','1 avenue de la mer Roubaix',46574659,789 );
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Voyage');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Jeunesse');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Cuisine');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Poesie');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Science-fiction');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Polar');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Roman');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Petit-prix');
INSERT INTO T_Themes ( ThemeName ) VALUES ( 'Meilleurs ventes');



SELECT * FROM T_Customers;
