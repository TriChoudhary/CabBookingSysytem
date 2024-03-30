package com.project.cbs.service;

import java.util.List;

import com.project.cbs.entity.Car;

public interface UserService {
	String login(String email , String password);
	public List<Car> getAllCars();
}
