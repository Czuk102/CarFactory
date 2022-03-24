package emcars.CarFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.logging.Logger;

@Component
public class MyRunner implements CommandLineRunner {

	public final CarFactoryRepository repo;
	public static final Logger LOGGER = Logger.getLogger(CarFactoryApplication.class.getName());

	public MyRunner(CarFactoryRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) {
		repo.save(new Car("Mazda", 12000d, Engine.DIESEL, Collections.emptyList(), 200000d));
		LOGGER.info("My app is up and running...");
	}
}
