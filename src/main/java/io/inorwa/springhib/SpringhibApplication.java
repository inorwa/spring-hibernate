package io.inorwa.springhib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class SpringhibApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringhibApplication.class, args);
	}
}
