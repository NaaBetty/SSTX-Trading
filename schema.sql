CREATE TABLE client (
  id SERIAL PRIMARY KEY,
  amount DOUBLE PRECISION NOT NULL,
  currency VARCHAR(3) NOT NULL,
  status VARCHAR(20) NOT NULL,
  provider_id INTEGER,
  bank_account_id INTEGER
);

CREATE TABLE provider_offer (
  id SERIAL PRIMARY KEY,
  rate DOUBLE PRECISION NOT NULL,
  currency VARCHAR(3) NOT NULL,
  provider_id INTEGER NOT NULL
);

CREATE TABLE bank_account (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  account_number VARCHAR(50) NOT NULL,
  bank_name VARCHAR(100) NOT NULL
);

CREATE TABLE forex (
    id SERIAL PRIMARY KEY,
    currency_from VARCHAR(255) NOT NULL,
    currency_to VARCHAR(255) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    exchange_rate NUMERIC(19, 4) NOT NULL,
    date DATE NOT NULL,
    client_id BIGINT NOT NULL,
    total_amount NUMERIC(19, 2) DEFAULT 0.0
);

CREATE TABLE provider (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  url VARCHAR(255) NOT NULL
);

--CREATE TABLE client (
--  id SERIAL PRIMARY KEY,
--  name VARCHAR(255) NOT NULL,
--  email VARCHAR(255) UNIQUE NOT NULL,
--  password VARCHAR(255) NOT NULL,
--  bank_account INTEGER,
--  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
--  updated_at TIMESTAMP NOT NULL DEFAULT NOW()
--);