package emcars.CarFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CarFactoryRestController {
	Logger logger = LoggerFactory.getLogger(CarFactoryRestController.class);

	private final CarFactoryService carFactoryService;

	public CarFactoryRestController(CarFactoryService carFactoryService) {
		this.carFactoryService = carFactoryService;
	}

	@GetMapping("/hello")
	public ResponseEntity<String> helloWorld() {
		logger.info("użyłeś endpointa helloWold");
		return ResponseEntity.ok("Hello world");
	}

	@PostMapping("/cars/makeCar")
	public ResponseEntity<Car> makeCar() {
		return ResponseEntity.ok(carFactoryService.makeCar());
	}

	@PostMapping("/cars")
	public ResponseEntity<Car> makeCar(@RequestBody Car car) {
		return ResponseEntity.ok(carFactoryService.makeCar(car));
	}

	@PutMapping("/cars/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car carDetails) {
		return ResponseEntity.ok(carFactoryService.updateCar(id, carDetails));
	}

	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(carFactoryService.findById(id));
	}

	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Void> deleteByid(@PathVariable Integer id) {
		return ResponseEntity.ok(carFactoryService.deleteById(id));
	}

	@GetMapping("/cars/all")
	public ResponseEntity<List<Car>> findAll() {
		return ResponseEntity.ok(carFactoryService.findAll());
	}

	@GetMapping("/cars/topfive")
	public ResponseEntity<List<Car>> getTopFiveCars() {
		return ResponseEntity.ok(carFactoryService.getTopFiveCars());
	}

	@GetMapping("/cars/finalPrice/{id}")
	public ResponseEntity<Double> getFinalPricebyId(@PathVariable Integer id) {
		return ResponseEntity.ok(carFactoryService.getFinalPrice(carFactoryService.findById(id)));
	}
}
