package net.javaquieds.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaquieds.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
