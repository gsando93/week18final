DROP TABLE IF EXISTS seed_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS seed;

CREATE TABLE seed (
	seed_id int NOT NULL AUTO_INCREMENT,
	seed_name varchar(256) NOT NULL,
	seed_text text NOT NULL,
	PRIMARY KEY (seed_id)
);

CREATE TABLE role (
	role_id int NOT NULL AUTO_INCREMENT,
	seed_id int NOT NULL,
	role_name varchar(256) NOT NULL,
	primary_trait varchar(128),
	PRIMARY KEY (role_id),
	FOREIGN KEY (seed_id) REFERENCES seed (seed_id) ON DELETE CASCADE
);

CREATE TABLE genre (
	genre_id int NOT NULL AUTO_INCREMENT,
	genre_name varchar(128) NOT NULL,
	PRIMARY KEY (genre_id)
);

CREATE TABLE seed_genre (
	seed_id int NOT NULL,
	genre_id int NOT NULL,
	FOREIGN KEY (seed_id) REFERENCES seed (seed_id) ON DELETE CASCADE,
	FOREIGN KEY (genre_id) REFERENCES genre (genre_id) ON DELETE CASCADE
);