package net.javaquieds.springboot.service.impl;

import java.util.List;
//import java.util.Optional;

//import org.graalvm.compiler.core.common.type.ArithmeticOpTable.Op;
import org.springframework.stereotype.Service;

import net.javaquieds.springboot.exception.ResourceNotFoundException;
import net.javaquieds.springboot.model.Employee;
import net.javaquieds.springboot.repository.EmployeeRepository;
import net.javaquieds.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		
	}


	@Override
	public Employee savEmployee(Employee employee) {
	
		return employeeRepository.save(employee);
	}


	@Override
	public Employee saEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> getAllEmployees() {
	
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
	/* Optional<Employee>  employee= employeeRepository.findById(id);
	if(employee.isPresent()) {
		return employee.get();
	}
	else {
		//bizim oluşturudğumuz hata mesajının olduğu yere gidecek
		throw new ResourceNotFoundException("Employee","Id", id);
	}
	*/
		
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id", id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing(mevcut) emplyee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public Employee deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		return null;
	}

}
