package com.ProcessingFinancialTransactions.SpringBatch.batch.config;

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
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({ "null", "deprecation" })
    @Bean
    public Job processFinancialTransactionsJob(Step processFinancialTransactionsStep) {
        return jobBuilderFactory.get("processFinancialTransactionsJob")
                .flow(processFinancialTransactionsStep)
                .end()
                .build();
    }

    @SuppressWarnings({ "deprecation" })
    @Bean
    public Step processFinancialTransactionsStep() {
        return stepBuilderFactory.get("processFinancialTransactionsStep")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Executing step to process financial transactions...");
                    // Aqui você irá implementar a lógica do processamento das transações financeiras
                    return null;
                })
                .build();
    }
}
