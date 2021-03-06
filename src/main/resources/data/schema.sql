CREATE SEQUENCE weather_entity_id_sequence INCREMENT 1 MINVALUE 0 MAXVALUE 99999999999999999 START 0;
CREATE TABLE weather (id INT PRIMARY KEY,
                      city VARCHAR(255) NOT NULL,
                      country VARCHAR(255) NOT NULL,
                      temperature NUMERIC(5, 2),
                      created timestamp NOT NULL,
                      last_modified timestamp NOT NULL,
                      created_by VARCHAR(255) NOT NULL,
                      last_modified_by VARCHAR(255) NOT NULL);
