package emcars.CarFactory;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarFactoryRestController {

	private final CarFactoryService carFactoryService;
	public CarFactoryRestController(CarFactoryService carFactoryService){
		this.carFactoryService = carFactoryService;
	}

	@GetMapping
	public ResponseEntity<String> helloWorld() {
		return ResponseEntity.ok("Hello world");
	}
	@GetMapping("/makeCar")
	public ResponseEntity<Car> makeCar(){
		return ResponseEntity.ok(carFactoryService.makeCar());
	}

}
