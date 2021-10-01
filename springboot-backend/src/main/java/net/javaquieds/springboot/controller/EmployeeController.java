package net.javaquieds.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaquieds.springboot.model.Employee;
import net.javaquieds.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	//BUİLD CREATE  post REST API
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.savEmployee(employee)
				,HttpStatus.CREATED);
		
	}
	//build get all RESTAPİ
	@GetMapping()
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//by id RestApi
	//http://locahlhost/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeBuId(@PathVariable("id") long employeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeId),HttpStatus.OK);
	}
	
	//update by id
	//http://locahlhost/api/employees/1

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id ,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);	
	}

//delete by id
	
@DeleteMapping("{id}")
public ResponseEntity<String>deleteEmployee(@PathVariable("id")long id ) {
	employeeService.deleteEmployee(id);
	return new ResponseEntity<String>("succesful",HttpStatus.OK);
}

	
	
}
