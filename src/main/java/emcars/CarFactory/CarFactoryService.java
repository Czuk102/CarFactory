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
		Equipment ac = new Equipment(null,"ac",1000.);
		Equipment radio = new Equipment(null, "radio", 800. );
		List<Equipment> equipments = List.of(ac,radio);
		Car car = new Car(null, "Polonez", 2.0, Engine.PETROL,equipments,50000. );
		carFactoryRepository.save(car);
		return car;
	}

	public Car findById(Integer id) {
		 return carFactoryRepository.findById(id)
				 .orElse(null);
	}

	public void addEquipment(Car car, Equipment equipment){
		if(car.getEquipments() != null) {
			car.getEquipments().add(equipment);
		} else {
			car.setEquipments(List.of(equipment));
		}
	}

	public void setName(Car car, String name) {
		if(car.getName() != null ){
			car.setName(name);
		}
	}

	public Double getEquipmentPrice(Car car){
		List<Equipment> equipments = car.getEquipments();
		if (equipments != null) {
			Double price = null;
			for (Equipment equipment : equipments) {
				price += equipment.getPrice();
			}return price;
		} else {
			throw new RuntimeException("Equipment are null");
		}
	}

	public Double getFinalPrice(Car car){
		Double basePrice = car.getPrice();
		if (basePrice != null){
			return basePrice + getEquipmentPrice(car);
		}else {
			throw new  RuntimeException("Base price is null");
		}
	}

	public List<Car> getTopFiveCars(){
		List<Integer> ids = List.of(1,2,3,4,5);
		return carFactoryRepository.findAllById(ids);
	}

	public List<Car> findAll() { return carFactoryRepository.findAll();}

	public void delete(Car car){ carFactoryRepository.delete(car);}

	public Void deleteById(Integer id) { carFactoryRepository.deleteById(id);
	return null;}

	public boolean exists(Integer id) { return carFactoryRepository.existsById(id);}
}
