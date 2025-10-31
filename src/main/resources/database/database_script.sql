-- ===========================================
-- ADD INDEXES!!!!!!!!!!!!!
-- ===========================================

CREATE DATABASE IF NOT EXISTS meisterbank_dev;

\c meisterbank_dev;

-- ===========================================
-- drop schema public
-- ===========================================

 DROP SCHEMA IF EXISTS public;

-- ===========================================
-- create schema mb01
-- ===========================================

CREATE SCHEMA IF NOT EXISTS mb01; 

-- ===========================================
-- create account_type
-- ===========================================

CREATE TABLE mb01.account_type (
id 					SERIAL PRIMARY KEY NOT NULL,
account_type_name 	VARCHAR(255) NOT NULL,
interest_rate		DECIMAL(4,2) NOT NULL
);

-- ===========================================
-- create app_user
-- ===========================================

CREATE TABLE mb01.app_user (
id 	        		SERIAL NOT NULL PRIMARY KEY,
username    		VARCHAR(50) NOT NULL UNIQUE,
password_hash 		VARCHAR(255) NOT NULL,
email 				VARCHAR(255) NOT NULL UNIQUE,
first_name			VARCHAR(255) NOT NULL,
last_name			VARCHAR(255) NOT NULL,
ssn					VARCHAR(9) NOT NULL UNIQUE,
created_dtm 		TIMESTAMP WITH TIME ZONE
);

-- ===========================================
-- create account
-- ===========================================

CREATE TABLE mb01.account (
id 					SERIAL NOT NULL PRIMARY KEY,
app_user_id 		BIGINT NOT NULL REFERENCES mb01.app_user(id),
account_type_id 	BIGINT NOT NULL REFERENCES mb01.account_type(id),
account_nickname 	VARCHAR(100)
);

-- ===========================================
-- create app_user_2_account (joint)
-- ===========================================

CREATE TABLE mb01.app_user_2_account (
id 					SERIAL NOT NULL PRIMARY KEY,
app_user_id			BIGINT NOT NULL REFERENCES mb01.app_user(id),
account_id			BIGINT NOT NULL REFERENCES mb01.account(id)
);

-- ===========================================
-- create transaction_type
-- ===========================================

CREATE TABLE mb01.transaction_type (
id 						SERIAL PRIMARY KEY NOT NULL,
transaction_type_name 	VARCHAR(255) NOT NULL
);

-- ===========================================
-- create transfer / does from/to inherent from account id?
-- ===========================================

CREATE TABLE mb01.transfer (
id 					SERIAL PRIMARY KEY NOT NULL,
from_account_id		BIGINT NOT NULL REFERENCES mb01.account(id),
to_account_id 		BIGINT NOT NULL REFERENCES mb01.account_id(id),
amount 				DECIMAL(10,2) NOT NULL CHECK (amount > 0)
);

-- ===========================================
-- create transaction
-- ===========================================

CREATE TABLE mb01.transaction(
id 					SERIAL PRIMARY KEY NOT NULL,
account_id 			BIGINT NOT NULL REFERENCES mb01.account(id),
transaction_type_id BIGINT NOT NULL REFERENCES mb01.transaction_type(id),
amount 				DECIMAL(10,2) NOT NULL CHECK (amount > 0),
prev_balance		DECIMAL(10,2) NOT NULL,
curr_balance 		DECIMAL(10,2) NOT NULL,
description 		VARCHAR(255) NOT NULL,
transfer_id			BIGINT REFERENCES mb01.transfer(id),
created_dtm 		TIMESTAMP WITH TIME ZONE
);
