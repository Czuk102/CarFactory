package emcars.CarFactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class CarFactoryServiceITest {

	@MockBean
	private CarFactoryRepository carFactoryRepository;

	@Autowired
	private CarFactoryService carFactoryService;

	@Test
	void shouldChangeName() {
		// given
		Car car = new Car(null, "testName", null, null, Collections.emptyList(), null);
		String newName = "newName";

		carFactoryService.setName(car, newName);
		Assertions.assertThat(car.getName()).isEqualTo("newName");
	}

	@Test
	void shouldAddEquipment() {
		// given
		Equipment cc = new Equipment(1, "CC", 100d);
		Car car = new Car(null, "testname", null, null, Collections.emptyList(), 200d);
		//then
		carFactoryService.addEquipment(car, cc);
		// given
		Assertions.assertThat(car.getEquipments()).isEqualTo(List.of(cc));
	}


}
