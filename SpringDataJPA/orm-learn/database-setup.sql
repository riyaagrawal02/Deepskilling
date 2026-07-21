-- Database Setup Script for Spring Data JPA Assessment
-- This script creates the database and table for the Country management system

CREATE DATABASE IF NOT EXISTS ormlearn;

USE ormlearn;

DROP TABLE IF EXISTS country;

CREATE TABLE country (
    co_code VARCHAR(10) PRIMARY KEY COMMENT 'Country Code (Mapped to Country.code)',
    co_name VARCHAR(100) NOT NULL COMMENT 'Country Name (Mapped to Country.name)'
);


CREATE INDEX idx_country_name ON country (co_name);

INSERT INTO
    country (co_code, co_name)
VALUES ('IN', 'India'),
    ('US', 'United States'),
    ('UK', 'United Kingdom'),
    ('CA', 'Canada'),
    ('AU', 'Australia'),
    ('FR', 'France'),
    ('DE', 'Germany'),
    ('JP', 'Japan'),
    ('CN', 'China'),
    ('BR', 'Brazil');


SELECT * FROM country;

SELECT * FROM country WHERE co_code = 'IN';

SELECT * FROM country WHERE co_name LIKE '%United%';

SELECT * FROM country WHERE co_name LIKE '%India%';

SELECT * FROM country ORDER BY co_name ASC;

SELECT * FROM country WHERE co_name LIKE 'U%';

SELECT COUNT(*) as total_countries FROM country;

DESCRIBE country;

SELECT
    COLUMN_NAME,
    COLUMN_TYPE,
    IS_NULLABLE,
    COLUMN_KEY,
    COLUMN_COMMENT
FROM INFORMATION_SCHEMA.COLUMNS
WHERE
    TABLE_NAME = 'country'
    AND TABLE_SCHEMA = 'ormlearn';