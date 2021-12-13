package llc.nanocontext.cardsource;

import llc.nanocontext.cardsource.core.CardFactoryProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(
		basePackages = { "llc.nanocontext.cardsource" }
)
@EnableAsync                                               // enables asynchronous web processing
public class CardsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsourceApplication.class, args);
	}

	@Bean
	public CardFactoryProvider cardFactoryProvider() {
		return new CardFactoryProvider();
	}

}
