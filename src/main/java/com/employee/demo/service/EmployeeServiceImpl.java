package com.employee.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.entity.EmployeeEntity;
import com.employee.demo.model.ResponseViewModel;
import com.employee.demo.repository.EmployeeRepository;

/**
 * EmployeeServiceImpl is the class for implementing quiz page logics in EmployeeService.
 * 
 * @author Mohan Chidambaram
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<ResponseViewModel> getAllEmployee() {
		List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
		if(employeeEntityList.isEmpty()) {
			return Collections.emptyList();
		} else {
			return employeeEntityList.stream().map(employeeEntity -> 
				formViewModel(employeeEntity)
			).collect(Collectors.toList());
		}
	}

	@Override
	public ResponseViewModel editEmployee(ResponseViewModel viewModel) {
		EmployeeEntity employeeEntity = formEmployeeEntity(viewModel);
		if(Objects.nonNull(employeeEntity)) {
			EmployeeEntity empEntity = employeeRepository.save(employeeEntity);
			return formViewModel(empEntity);
		}
		return null;
	}

	@Override
	public ResponseViewModel addEmployee(ResponseViewModel viewModel) {
		EmployeeEntity employeeEntity = formEmployeeEntity(viewModel);
		if(Objects.nonNull(employeeEntity)) {
			EmployeeEntity empEntity = employeeRepository.save(employeeEntity);
			return formViewModel(empEntity);
		}
		return null;
	}

	@Override
	public void deleteEmployee(ResponseViewModel viewModel) {
		EmployeeEntity employeeEntity = formEmployeeEntity(viewModel);
		if(Objects.nonNull(employeeEntity)) {
			employeeRepository.delete(employeeEntity);
		}
		
	}
	
	/**
	 * formViewModel is used to convert employee entity into view model.
	 *  
	 * @param employeeEntity
	 * 			the employee entity to be converted.
	 * 
	 * @return ResponseViewModel
	 */
	public ResponseViewModel formViewModel(EmployeeEntity employeeEntity) {
		if(Objects.nonNull(employeeEntity)) {
			ResponseViewModel responseViewModel = new ResponseViewModel();
			responseViewModel.setKey(employeeEntity.getEmployeeId());
			responseViewModel.setName(employeeEntity.getEmployeeName());
			responseViewModel.setPhone(employeeEntity.getPhone());
			responseViewModel.setMail(employeeEntity.getMail());
			responseViewModel.setPlace(employeeEntity.getPlace());
			responseViewModel.setBirthDate(employeeEntity.getBirthDate());
			responseViewModel.setStatus(String.valueOf(employeeEntity.getDeptName()));
			return responseViewModel;
		}
		return null;
	}
	
	/**
	 * formEmployeeEntity is used to convert view model into employee entity.
	 *  
	 * @param viewModel
	 * 			the view model to be converted.
	 * 
	 * @return EmployeeEntity
	 */
	public EmployeeEntity formEmployeeEntity(ResponseViewModel viewModel) {
		if(Objects.nonNull(viewModel)) {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setEmployeeId(viewModel.getKey());
			employeeEntity.setEmployeeName(viewModel.getName());
			employeeEntity.setPhone(viewModel.getPhone());
			employeeEntity.setMail(viewModel.getMail());
			employeeEntity.setPlace(viewModel.getPlace());
			employeeEntity.setBirthDate(viewModel.getBirthDate());
			employeeEntity.setDeptName(Integer.parseInt(viewModel.getStatus()));
			return employeeEntity;
		}
		return null;
	}

}
