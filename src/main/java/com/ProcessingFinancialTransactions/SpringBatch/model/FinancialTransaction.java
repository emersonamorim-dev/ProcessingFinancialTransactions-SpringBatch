package com.ProcessingFinancialTransactions.SpringBatch.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinancialTransaction {
    private Long id;
    private String transactionId;
    private LocalDateTime timestamp;
    private String description;
    private BigDecimal amount;
    private String currency;
    private String sourceAccount;
    private String destinationAccount;

    public FinancialTransaction() {
        // Construtor padrão necessário para frameworks como Spring Boot e JPA
    }

    // Construtor principal com todos os campos obrigatórios
    public FinancialTransaction(String transactionId, LocalDateTime timestamp, String description,
                                BigDecimal amount, String currency, String sourceAccount, String destinationAccount) {
        this.transactionId = transactionId;
        this.timestamp = timestamp;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    // Getters e Setters para todos os campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    // Sobrescrever o método toString() para facilitar a depuração
    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "id=" + id +
                ", transactionId='" + transactionId + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                '}';
    }
}