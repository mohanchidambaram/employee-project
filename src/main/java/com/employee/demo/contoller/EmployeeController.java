package com.employee.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.model.ResponseViewModel;
import com.employee.demo.service.EmployeeService;

/**
 * EmployeeController is the front controller file that receives the request from employee web page.
 * 
 * @author Mohan Chidambaram
 *
 */
@RestController
//@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/getAllEmployee")
	public List<ResponseViewModel> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/addEmployee")
	public ResponseViewModel addEmployee(ResponseViewModel viewModel) {
		return employeeService.addEmployee(viewModel);
	}
	
	@PutMapping("/editEmployee")
	public ResponseViewModel editEmployee(ResponseViewModel viewModel) {
		return employeeService.addEmployee(viewModel);
	}
	
	@DeleteMapping("/deleteEmployee")
	public void deleteEmployee(ResponseViewModel viewModel) {
		employeeService.deleteEmployee(viewModel);
	}
}
