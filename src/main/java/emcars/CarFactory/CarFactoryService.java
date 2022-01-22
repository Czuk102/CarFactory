package emcars.CarFactory;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarFactoryService {

	private final CarFactoryRepository carFactoryRepository;

	public CarFactoryService(CarFactoryRepository carFactoryRepository) {
		this.carFactoryRepository = carFactoryRepository;
	}

	public Car makeCar(){
		Equipment ac = new Equipment(null,"ac",1000);
		Equipment radio = new Equipment(null, "radio", 800 );
		List<Equipment> equipments = List.of(ac,radio);
		Car car = new Car(null, "Polonez", 2.0, Engine.PETROL,equipments,50000 );
		carFactoryRepository.save(car);
		return car;
	}
}
