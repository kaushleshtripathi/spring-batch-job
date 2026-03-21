package com.springbatch.test.processor;

import com.springbatch.test.dto.ProductDTO;
import com.springbatch.test.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ProductProcessor  implements ItemProcessor<Product, ProductDTO> {

	@Override
	public ProductDTO process(Product product) throws Exception {
		// basic mapping + optional transformation
		return ProductDTO.builder().name(product.getName()).
				description(product.getDescription()).
				price(product.getPrice()).build();
	}
}
