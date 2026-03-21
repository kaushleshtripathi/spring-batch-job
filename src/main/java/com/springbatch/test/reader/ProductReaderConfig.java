package com.springbatch.test.reader;

import com.springbatch.test.model.Product;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class ProductReaderConfig extends JpaPagingItemReader<Product> {

	public ProductReaderConfig(EntityManagerFactory entityManagerFactory) {
		setName("productItemReader");
		setEntityManagerFactory(entityManagerFactory);
		setQueryString("SELECT p FROM Product p WHERE p.price > 0");
		setPageSize(100);  // tune as needed
	}
}
