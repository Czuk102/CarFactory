package emcars.CarFactory;

import java.util.List;
import javax.persistence.*;
public class Car {

	private Integer id;
	private String name;
	private Double engineCapacity;
	private Enum engine;
	private List<Equipment> equipments;
	private Integer price;

	public Car() {
	}

	public Car(Integer id, String name, Double engineCapacity, Enum engine, List<Equipment> equipments, Integer price) {
		this.id = id;
		this.name = name;
		this.engineCapacity = engineCapacity;
		this.engine = engine;
		this.equipments = equipments;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public Enum getEngine() {
		return engine;
	}

	public void setEngine(Enum engine) {
		this.engine = engine;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
}
