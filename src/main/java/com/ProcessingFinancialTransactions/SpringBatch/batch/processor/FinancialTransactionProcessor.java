package com.ProcessingFinancialTransactions.SpringBatch.batch.processor;

import com.ProcessingFinancialTransactions.SpringBatch.model.FinancialTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class FinancialTransactionProcessor implements ItemProcessor<FinancialTransaction, FinancialTransaction> {

    @Override
    public FinancialTransaction process(@SuppressWarnings("null") FinancialTransaction financialTransaction) throws Exception {
        // Validação: certifique-se de que a transação é válida
        if (!isValid(financialTransaction)) {
            // Aqui você pode logar, lançar uma exceção ou até mesmo retornar null para filtrar esta transação
            return null; 
        }
        // calcular taxas, atualizar valores
        financialTransaction = applyBusinessLogic(financialTransaction);
        
        // adiciona informações adicionais à transação, se necessário
        financialTransaction = enrichTransaction(financialTransaction);
        
        return financialTransaction;
    }

    private boolean isValid(FinancialTransaction transaction) {
        // verifica se o montante da transação é positivo
        return transaction.getAmount() != null && transaction.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }

    private FinancialTransaction applyBusinessLogic(FinancialTransaction transaction) {
        // aplica uma taxa fixa a todas as transações
        BigDecimal fee = new BigDecimal("0.99"); 
        transaction.setAmount(transaction.getAmount().subtract(fee));
        return transaction;
    }

    private FinancialTransaction enrichTransaction(FinancialTransaction transaction) {
        // adiciona uma descrição, se estiver faltando
        if (transaction.getDescription() == null || transaction.getDescription().isEmpty()) {
            transaction.setDescription("Transação sem descrição");
        }
        return transaction;
    }
}
