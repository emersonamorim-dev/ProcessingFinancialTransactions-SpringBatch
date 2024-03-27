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

            // Simulação de geração de relatório e notificação de usuários
            generateReport(jobExecution);
            notifyUsers();
        } else if(jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("Falha ao processar transações financeiras. Status: " + jobExecution.getStatus());

            // Simulação de tratamento de erros e envio de alertas
            handleError(jobExecution);
            sendAlerts();
        }
    }

    private void generateReport(JobExecution jobExecution) {
        // Lógica para gerar relatórios
        System.out.println("Gerando relatório para a execução do job ID: " + jobExecution.getJobId());
        // reportService.generateReport(jobExecution);
    }

    private void notifyUsers() {
        // Lógica para notificar usuários
        System.out.println("Notificando usuários sobre a conclusão do processamento.");
        // notificationService.notifyUsers();
    }

    private void handleError(JobExecution jobExecution) {
        // Lógica para tratamento de erros
        System.out.println("Tratando erros para a execução do job ID: " + jobExecution.getJobId());
        // alertService.handleError(jobExecution);
    }

    private void sendAlerts() {
        // Lógica para envio de alertas
        System.out.println("Enviando alertas sobre falhas no processamento.");
        // alertService.sendAlert();
    }
}
