package com.jpa.testjpa.repositories;

import java.sql.ResultSet;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jpa.testjpa.entity.Employee;
 


@Repository
public interface EmployeeRepositories extends JpaRepository<Employee, Integer> {

	
	public List<Employee> findByFirstNameStartingWithOrLastName(String firstName,String lastName);
	
	public List<Employee> findEmployee(@Param("searchword") String searchword);
}
