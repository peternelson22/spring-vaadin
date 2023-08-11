package dev.nelson.vaadincrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VaadinCrudApplication {
	private static final Logger log = LoggerFactory.getLogger(VaadinCrudApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VaadinCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("Jae", "Abiola"));
			repository.save(new Customer("Princess", "Bright"));
			repository.save(new Customer("Patience", "Antony"));
			repository.save(new Customer("Princess", "Iyi"));
			repository.save(new Customer("Success", "Adam"));

			log.info("Customers found with findAll():");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			Customer customer = repository.findById(1L).get();
			log.info("Customer found with findOne(1L):");
			log.info(customer.toString());
			log.info("");

			log.info("Customer found with findByFirstNameStartsWithIgnoreCase('Princess'):");
			for (Customer princess : repository
					.findByFirstNameStartsWithIgnoreCase("Princess")) {
				log.info(princess.toString());
			}
			log.info("");
		};
	}
}
