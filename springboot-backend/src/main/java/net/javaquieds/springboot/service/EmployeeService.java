package net.javaquieds.springboot.service;

import java.util.List;

import net.javaquieds.springboot.model.Employee;

public interface EmployeeService {
Employee savEmployee(Employee employee);
Employee saEmployee(Employee employee);
List<Employee> getAllEmployees();
Employee getEmployeeById(long id);
Employee updateEmployee(Employee employee,long id);
Employee deleteEmployee(long id);
}
