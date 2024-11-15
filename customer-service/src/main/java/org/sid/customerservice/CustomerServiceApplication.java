package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repositpry.CustomeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(CustomeRepository customeRepository ,
											   RepositoryRestConfiguration repositoryRestConfiguration){

		return args -> {
			repositoryRestConfiguration.exposeIdsFor(Customer.class);

			customeRepository.saveAll(
			List.of(
					Customer.builder().name("adnane").email("adnane@gmail.com").build(),
					Customer.builder().name("meryem").email("meryem@gmail.com").build(),
					Customer.builder().name("test").email("test@gmail.com").build()
			)
			);
			customeRepository.findAll().forEach(c->{
				System.out.println(c );
			});
		};
	}
}