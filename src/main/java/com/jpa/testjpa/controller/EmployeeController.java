package com.jpa.testjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.testjpa.entity.Employee;
import com.jpa.testjpa.service.EmployeeService;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping(value= {"/viewemp"})
	public  List<Employee> getAll(){
		//throw new ExceptionController("OOps we cant get employees Emad");
		return employeeService.getAll();
	}
	
	@PostMapping(value= {"/addemp"})
	public String addEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	@PutMapping(value= {"updateemp"})
	public String updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/deleteemp")
	public String deleteEmployee(@RequestParam (value="id",required = false,defaultValue = "0")int id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping(value= {"/searchK"})
	public  List<Employee> search(@RequestParam (value="searchwoed")String searchword){
		//throw new ExceptionController("OOps we cant get employees Emad");
		return employeeService.search(searchword);
	}
	
	@GetMapping(value= {"/searchQ"})
	public  List<Employee> searchQ(@RequestParam (value="searchwoed")String searchword){
		//throw new ExceptionController("OOps we cant get employees Emad");
		return employeeService.search(searchword);
	}
	
	
	@GetMapping(value= {"/page"})
	public  Map<String,Object> get(@RequestParam (value="pageno",required = false,defaultValue = "0")int pageNo,
			@RequestParam (value="pagesize",required = false,defaultValue = "4")int pagesize,
			@RequestParam (value="sortBy",required = false,defaultValue = "id")String sortBy){
		//throw new ExceptionController("OOps we cant get employees Emad");
		return employeeService.get(pageNo, pagesize, sortBy);
	}

}
