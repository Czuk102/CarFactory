package emcars.CarFactory;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarFactoryRestController {

	private final CarFactoryService carFactoryService;
	public CarFactoryRestController(CarFactoryService carFactoryService){
		this.carFactoryService = carFactoryService;
	}

}
