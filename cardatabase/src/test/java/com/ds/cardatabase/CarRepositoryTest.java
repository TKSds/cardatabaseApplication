package com.ds.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ds.cardatabase.domain.Car;
import com.ds.cardatabase.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	CarRepository carRepository;

	// Test cases

	@Test
	public void testSaveCar() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);

		entityManager.persistAndFlush(car);

		assertThat(car.getId()).isNotNull();
	}

	@Test
	public void testDeleteCars() {
		entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
		entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500));
		
		carRepository.deleteAll();
		assertThat(carRepository.findAll()).isEmpty();
	}

}
