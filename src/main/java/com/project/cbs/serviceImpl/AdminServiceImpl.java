package com.project.cbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.cbs.entity.Car;
import com.project.cbs.entity.CarCategory;
import com.project.cbs.repository.CarCategoryRepo;
import com.project.cbs.repository.CarRepo;
import com.project.cbs.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	CarRepo carRepo;
	@Autowired
	CarCategoryRepo catRepo;
	@Override
	public void addCar(Car car) {
		carRepo.save(car);
		
	}

	@Override
	public List<CarCategory> getCategory() {
		return catRepo.findAll();
	}

	@Override
	public void addCarCat(CarCategory carCat) {
		catRepo.save(carCat);
		
	}

	@Override
	public List<Car> getAllCars() {
		return carRepo.findAll();
	}

	@Override
	public void deleteById(int id) {
		catRepo.deleteById(id);
		
	}

}
