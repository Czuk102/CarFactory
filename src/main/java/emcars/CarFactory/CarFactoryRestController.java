package emcars.CarFactory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarFactoryRestController {
	Logger logger = LoggerFactory.getLogger(CarFactoryRestController.class);

	private final CarFactoryService carFactoryService;
	public CarFactoryRestController(CarFactoryService carFactoryService){
		this.carFactoryService = carFactoryService;
	}

	@GetMapping
	public ResponseEntity<String> helloWorld() {
		logger.info("użyłeś endpointa helloWold");
		return ResponseEntity.ok("Hello world");
	}

	@PostMapping("/makeCar")
	public ResponseEntity<Car> makeCar(){
		return ResponseEntity.ok(carFactoryService.makeCar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable Integer id){
		return ResponseEntity.ok(carFactoryService.findById(id));
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<Void> deleteByid(@PathVariable Integer id){
		return ResponseEntity.ok(carFactoryService.deleteById(id));}

	@GetMapping("/all")
	public ResponseEntity<List<?>> findAll() {
		return ResponseEntity.ok(carFactoryService.findAll());
	}

	@GetMapping("/topfive")
	public ResponseEntity<List<?>> getTopFiveCars() {
		return ResponseEntity.ok(carFactoryService.getTopFiveCars());
	}

	@GetMapping("/finalPrice/{id}")
	public ResponseEntity<Double> getFinalPricebyId(@PathVariable Integer id) {
		return ResponseEntity.ok(carFactoryService.getFinalPrice(carFactoryService.findById(id)));
	}
}
