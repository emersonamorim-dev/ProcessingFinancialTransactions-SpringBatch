package com.ProcessingFinancialTransactions.SpringBatch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class EventHandler extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(@SuppressWarnings("null") JobExecution jobExecution) {
        System.out.println("Iniciando o processamento de transações financeiras...");
    }

    @Override
    public void afterJob(@SuppressWarnings("null") JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("Processamento de transações financeiras concluído com sucesso!");
            // Adicione aqui a lógica para notificar usuários, gerar relatórios, etc.
        } else if(jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("Falha ao processar transações financeiras. Status: " + jobExecution.getStatus());
            // Adicione aqui a lógica para tratamento de erros, envio de alertas, etc.
        }
    }
}
