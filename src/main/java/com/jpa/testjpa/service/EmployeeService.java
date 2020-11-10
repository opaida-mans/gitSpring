package com.jpa.testjpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.testjpa.entity.Employee;
import com.jpa.testjpa.repositories.EmployeeRepositories;


@Service
public class EmployeeService {

	
	@Autowired 
	EmployeeRepositories employeeRepositories;

	public   List<Employee> getAll() {
		 
		return (List<Employee>) employeeRepositories.findAll();
	}
 
	public String addEmployee(Employee emp) {
		if(employeeRepositories.save(emp) != null)
			return "Added Succesfulyy";
		else
		return "Something Went Wrong";
	}

	public String updateEmployee(Employee emp) {
		if(employeeRepositories.save(emp) != null)
			return "Added Succesfuly";
		else
		return "Something Went Wrong ";
	}

	public String deleteEmployee(int id) {
	try {	employeeRepositories.deleteById(id);
			return "Deleted Succesfuly";
	}catch (IllegalArgumentException e) {
		return "Something Went Wrong ";
	}
	}
	
	public Map<String,Object> get(int pageNo,int pageSize,String sortBy){
		Map<String,Object> response=new HashMap<String,Object>();
		//throw new ExceptionController("OOps we cant get employees Emad");
		Pageable pagable=PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		 Page<Employee> page=employeeRepositories.findAll(pagable);
		 response.put("count", page.getTotalElements());
		 response.put("currentPage", page.getNumber());
		 response.put("totalPage", page.getTotalPages());
		 response.put("data", page.getContent());
		 return response;
	}

	public List<Employee> search(String searchword) {
		// TODO Auto-generated method stub
		return employeeRepositories.findByFirstNameStartingWithOrLastName(searchword,searchword);
	}
	
	public List<Employee> searchQ(String searchword) {
		// TODO Auto-generated method stub
		return employeeRepositories.findEmployee(searchword);
	}
	
	
}
