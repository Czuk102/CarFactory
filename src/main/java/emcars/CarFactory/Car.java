package emcars.CarFactory;

import org.hibernate.annotations.Cascade;

import java.util.List;
import javax.persistence.*;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double engineCapacity;
	private Enum engine;


	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Equipment> equipments;
	private Double price;

	public Car() {
	}

	public Car(Integer id, String name, Double engineCapacity, Enum engine, List<Equipment> equipments, Double price) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
