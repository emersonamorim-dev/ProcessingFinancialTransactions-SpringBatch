CREATE TABLE IF NOT EXISTS financial_transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(255) NOT NULL,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    description VARCHAR(255),
    amount DECIMAL(19, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    source_account VARCHAR(255) NOT NULL,
    destination_account VARCHAR(255) NOT NULL
);
