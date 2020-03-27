package id.co.mii.reimbursement.reimbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ReimbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReimbursementApplication.class, args);
	}

}
