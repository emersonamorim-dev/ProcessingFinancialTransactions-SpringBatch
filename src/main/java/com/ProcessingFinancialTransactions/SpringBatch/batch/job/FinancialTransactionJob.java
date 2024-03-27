package com.ProcessingFinancialTransactions.SpringBatch.batch.job;

import com.ProcessingFinancialTransactions.SpringBatch.batch.listener.JobCompletionNotificationListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("removal")
@Configuration
@EnableBatchProcessing
public class FinancialTransactionJob {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    @SuppressWarnings("rawtypes")
    private final JobCompletionNotificationListener listener;

    @Autowired
    public FinancialTransactionJob(JobBuilderFactory jobBuilderFactory,
                                   StepBuilderFactory stepBuilderFactory,
                                   @SuppressWarnings("rawtypes") JobCompletionNotificationListener listener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.listener = listener;
    }

    // Definir o Step como um Bean
    @SuppressWarnings({ "deprecation" })
    @Bean
    public Step financialTransactionStep() {
        return stepBuilderFactory.get("financialTransactionStep")
                .tasklet((contribution, chunkContext) -> null) 
                .build();
    }

    @SuppressWarnings({ "deprecation", "null" })
    @Bean
    public Job processFinancialTransactionsJob(Step financialTransactionStep) {
        return jobBuilderFactory.get("processFinancialTransactionsJob")
                .listener(listener)
                .start(financialTransactionStep) 
                .build();
    }
}
