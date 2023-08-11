package dev.nelson.vaadincrud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.*;


@SpringBootTest(classes = VaadinCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class VaadinCrudApplicationTests {

	@Autowired
	private CustomerRepository repository;

	@Test
	public void shouldFillOutComponentsWithDataWhenTheApplicationIsStarted() {
		then(this.repository.count()).isEqualTo(5);
	}

	@Test
	public void shouldFindTwoPrincessCustomers() {
		then(this.repository.findByFirstNameStartsWithIgnoreCase("Princess")).hasSize(2);
	}
}
