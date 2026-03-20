package com.springbatch.test.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.springbatch.promotionalemailgenerator.model.Product;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.springbatch.promotionalemailgenerator.model.Client;
import com.springbatch.promotionalemailgenerator.model.ClientProductInterest;

@Configuration
public class SpringBatchReaderConfig {
	@Bean
	public JdbcCursorItemReader<Product> readInterestProductClientReader(
			@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<Product>()
				.name("readInterestProductClientReader")
				.dataSource(dataSource)
				.sql("select * from Product " +
						"join item on (client = client.id)" +
						"join price on (product = product.id)")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<Product> rowMapper() {
		return new RowMapper<Product>() {

			@Override
			public ClientProductInterest mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setEmail(rs.getString("email"));
				
				Product product = new Product();
				product.setId(rs.getInt(6));
				product.setName(rs.getString(7));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				
				Price clientProductInterest = new Price();
				clientProductInterest.setItem(item);
				clientProductInterest.setProduct(product);
				return clientProductInterest;
			}
		};
	}
	
}
