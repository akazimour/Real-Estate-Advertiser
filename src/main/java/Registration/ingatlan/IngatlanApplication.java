package Registration.ingatlan;

import Registration.ingatlan.service.InitDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class IngatlanApplication implements CommandLineRunner{
	@Autowired
	InitDbService initDbService;

	public static void main(String[] args) {
		SpringApplication.run(IngatlanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initDbService.addProperties();
	}
}

