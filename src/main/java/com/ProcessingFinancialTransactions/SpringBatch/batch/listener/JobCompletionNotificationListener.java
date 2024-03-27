package com.ProcessingFinancialTransactions.SpringBatch.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Component
public class JobCompletionNotificationListener<JavaMailSender> extends JobExecutionListenerSupport {

    private final JavaMailSender mailSender;

    @Autowired
    public JobCompletionNotificationListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void afterJob(@SuppressWarnings("null") JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("O job de processamento de transações financeiras foi concluído com sucesso!");
            // Notificar usuários via e-mail
            sendCompletionEmail(true, "");
            // Geração de relatório
        } else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            System.out.println("O job de processamento de transações financeiras falhou. Status: " + jobExecution.getStatus());
            // Tratamento de erros
            sendCompletionEmail(false, jobExecution.getAllFailureExceptions().toString());
        }
    }

    private void sendCompletionEmail(boolean isSuccess, String errorMessage) {
        SimpleMailMessage message = new SimpleMailMessageItemWriter();
        message.setFrom("noreply@yourdomain.com");
        message.setTo("user@yourdomain.com");
        if (isSuccess) {
            message.setSubject("Job de Processamento de Transações Concluído");
            message.setText("O job de processamento de transações financeiras foi concluído com sucesso.");
        } else {
            message.setSubject("Falha no Job de Processamento de Transações");
            message.setText("O job de processamento de transações financeiras falhou. Erro: " + errorMessage);
        }
        mailSender.send(message);
    }
}
