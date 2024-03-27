CREATE TABLE financial_transactions (
    id SERIAL PRIMARY KEY,
    transaction_id VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    description TEXT,
    amount NUMERIC(19, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    source_account VARCHAR(255) NOT NULL,
    destination_account VARCHAR(255) NOT NULL
);
