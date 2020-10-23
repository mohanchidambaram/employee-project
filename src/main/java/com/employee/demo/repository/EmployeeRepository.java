package com.employee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.demo.entity.EmployeeEntity;

/**
 * EmployeeRepository is the repository interface to perform operation on employee table.
 * 
 * @author Mohan Chidambaram
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
