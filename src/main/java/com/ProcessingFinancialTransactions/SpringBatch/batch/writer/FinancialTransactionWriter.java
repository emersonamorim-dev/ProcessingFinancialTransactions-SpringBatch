package com.ProcessingFinancialTransactions.SpringBatch.batch.writer;

import com.ProcessingFinancialTransactions.SpringBatch.model.FinancialTransaction;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

@SuppressWarnings("unused")
@Component
public class FinancialTransactionWriter implements ItemWriter<FinancialTransaction> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FinancialTransactionWriter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void write(List<? extends FinancialTransaction> financialTransactions) throws Exception {
        for (FinancialTransaction transaction : financialTransactions) {
            // Verifique se os campos correspondem aos da sua tabela e adapte se necessário
            String sql = "INSERT INTO financial_transactions (transaction_id, timestamp, description, amount, currency, source_account, destination_account) VALUES (?, ?, ?, ?, ?, ?, ?)";

            jdbcTemplate.update(sql,
                transaction.getTransactionId(),
                transaction.getTimestamp(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getCurrency(),
                transaction.getSourceAccount(),
                transaction.getDestinationAccount());
        }
    }

    @Override
    public void write(@SuppressWarnings("null") Chunk<? extends FinancialTransaction> chunk) throws Exception {
        // Asumindo que Chunk é uma abstração iterável de FinancialTransactions
        for (FinancialTransaction transaction : chunk.getItems()) {
            String sql = "INSERT INTO financial_transactions (transaction_id, timestamp, description, amount, currency, source_account, destination_account) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            jdbcTemplate.update(sql, 
                                transaction.getTransactionId(), 
                                transaction.getTimestamp(), 
                                transaction.getDescription(), 
                                transaction.getAmount(), 
                                transaction.getCurrency(), 
                                transaction.getSourceAccount(), 
                                transaction.getDestinationAccount());
        }
    }
}