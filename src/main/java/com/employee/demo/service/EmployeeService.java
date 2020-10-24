package com.employee.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.demo.model.ResponseViewModel;

/**
 * EmployeeService is the interface for declaring employee page logics.
 * 
 * @author Mohan Chidambaram
 *
 */
@Service
public interface EmployeeService {

	
	/**
	 * getAllEmployee is used to fetch all the employees to display.
	 * 
	 * @return List<ResponseViewModel>
	 */
	List<ResponseViewModel> getAllEmployee();
	
	/**
	 * editEmployee is used to edit a specific employee information.
	 * 
	 * @param viewModel
	 * 			contains the employee to be edited.
	 * 
	 * @return ResponseViewModel
	 */
	ResponseViewModel editEmployee(ResponseViewModel viewModel);
	
	/**
	 * addEmployee is used to add a new employee.
	 * 
	 * @param viewModel
	 * 			contains the employee information to be added.
	 * 
	 * @return ResponseViewModel
	 */
	ResponseViewModel addEmployee(ResponseViewModel viewModel);
	
	/**
	 * deleteEmployee is used to remove a employee detail.
	 * 
	 * @param id
	 * 			contains the employee id to be removed.
	 */
	void deleteEmployee(int id);
	
	
}
