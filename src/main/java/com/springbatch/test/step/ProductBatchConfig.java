package com.springbatch.test.step;

import com.springbatch.test.dto.ProductDTO;
import com.springbatch.test.model.Product;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@EnableBatchProcessing
public class ProductBatchConfig {

    @Bean
    public Step myStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<Product> productReader,
            ItemProcessor<Product, ProductDTO> productProcessor,
            ItemWriter<ProductDTO> productWriter
    ) {
        return new StepBuilder("myStep", jobRepository)
                .<Product, ProductDTO>chunk(100, transactionManager)
                .reader(productReader)
                .processor(productProcessor)
                .writer(productWriter)
                .build();
    }
}
