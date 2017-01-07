
CREATE TABLE Users(
	username VARCHAR(255),
	id SERIAL,
	adr VARCHAR(255),
	phoneNum VARCHAR(255),
	userRole INT,
--  0 = Admin,
--  1 = ContentManager,
--  2 = Vendor,
--  3 = Registered Customer
--  4 = Customer
	UNIQUE(username),
	PRIMARY KEY (id)
);



CREATE TABLE Shops(
	shopname VARCHAR(255),
	id SERIAL,
	adr VARCHAR(255),
	phoneNum VARCHAR(255),
	description VARCHAR(1023),
	PRIMARY KEY (id)	
);



CREATE TABLE Items(
	title VARCHAR(255),
	id SERIAL,
	description VARCHAR(1023),
	PRIMARY KEY (id)
);



CREATE TABLE Tags(
	categories VARCHAR(255),
	itemId INT,
	FOREIGN KEY (itemId) REFERENCES Items (id) 
);

CREATE TABLE isSelling(
	count INT,
	shopId INT,
	itemId INT,
	FOREIGN KEY (shopId) REFERENCES Shops (id),
	FOREIGN KEY (itemId) REFERENCES Items (id)
);
CREATE TABLE ShoppedAt(
	review VARCHAR(1023),
	shopId INT,
	userId INT,
	FOREIGN KEY (shopId) REFERENCES Shops (id),
	FOREIGN KEY (userId) REFERENCES Users (id)
);

CREATE TABLE Bought(
	review VARCHAR(1023),
	itemId INT,
	userId INT,
	FOREIGN KEY (itemId) REFERENCES Items (id),
	FOREIGN KEY (userId) REFERENCES Users (id)
);

CREATE TABLE Liked(
	itemId INT,
	userId INT,
	FOREIGN KEY (itemId) REFERENCES Items (id),
	FOREIGN KEY (userId) REFERENCES Users (id)
);

CREATE TABLE Owns(
	vendorId INT,
	shopId INT,
	FOREIGN KEY (shopId) REFERENCES Shops (id),
	FOREIGN KEY (vendorId) REFERENCES Users (id)
 
);

CREATE TABLE UsersTrash(
	tusername VARCHAR(255),
	tid INT,
	tadr VARCHAR(255),
	tphoneNum VARCHAR(255),
	tuserRole INT
--  0 = Admin,
--  1 = ContentManager,
--  2 = Vendor,
--  3 = Registered Customer
--  4 = Customer
);



CREATE TABLE ShopsTrash(
	tshopname VARCHAR(255),
	tid INT,
	tadr VARCHAR(255),
	tphoneNum VARCHAR(255),
	tdescription VARCHAR(1023)

);



CREATE TABLE ItemsTrash(
	ttitle VARCHAR(255),
	tid INT,
	tdescription VARCHAR(1023)
);
