package com.ProcessingFinancialTransactions.SpringBatch.batch.reader;

import com.ProcessingFinancialTransactions.SpringBatch.model.FinancialTransaction;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class FinancialTransactionReader implements ItemReader<FinancialTransaction> {

    private final Iterator<FinancialTransaction> transactionIterator;

    public FinancialTransactionReader(List<FinancialTransaction> transactions) {
        this.transactionIterator = transactions.iterator();
    }

    @Override
    public FinancialTransaction read() throws Exception {
        if (transactionIterator.hasNext()) {
            return transactionIterator.next();
        } else {
            // Retorna null para indicar que todos os itens foram lidos
            return null; 
        }
    }
}
