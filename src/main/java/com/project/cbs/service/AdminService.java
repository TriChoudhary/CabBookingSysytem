package com.project.cbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.cbs.entity.Car;
import com.project.cbs.entity.CarCategory;
@Service
public interface AdminService {
	public void addCar(Car car);
	public List<CarCategory> getCategory();
	public void addCarCat(CarCategory carCat);
	public List<Car> getAllCars();
	public void deleteById(int id);
}
