package com.springbatch.test.writer;

import com.springbatch.test.dto.ProductDTO;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductWriterConfig implements ItemWriter<ProductDTO> {

	@Override
	public void write(Chunk<? extends ProductDTO> items) throws Exception {
		items.forEach(dto -> {
			System.out.printf("Writing DTO: %s (%s, %.2f)%n",
					dto.getName(), dto.getDescription(), dto.getPrice());
			// e.g. save to DB via some service or JPA repo
		});
	}
}