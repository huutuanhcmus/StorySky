CREATE database StorySky;

use StorySky;

create table category(
	idcategory bigint NOT NULL PRIMARY KEY auto_increment,
    namecategory VARCHAR(255) NOT NULL,
	codecategory VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL
);

create table story(
	idcategory bigint NOT NULL,
	idstory bigint NOT NULL PRIMARY KEY auto_increment,
    namestory NVARCHAR(255) NOT NULL,
	introducestory TEXT NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL,
    FOREIGN KEY (idcategory) REFERENCES category(idcategory)
);

create table collectionstory(
	idstory bigint NOT NULL,
    idcollectionstory bigint NOT NULL auto_increment PRIMARY KEY  ,
    namecollectionstory NVARCHAR(255) NOT NULL,
    contentcollectionstory  TEXT NOT NULL,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL,
    FOREIGN KEY (idstory) REFERENCES story(idstory)
);

ALTER TABLE collectionstory DROP PRIMARY KEY;
ALTER TABLE collectionstory ADD PRIMARY KEY (idstory,idcollectionstory);

CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

CREATE TABLE user (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  statuserus int NOT NULL,
  roleid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);
