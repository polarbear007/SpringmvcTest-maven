package cn.itcast.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.entity.Employees;
import cn.itcast.mapper.EmployeesMapper;
import cn.itcast.service.EmployeesService;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	@Autowired
	private EmployeesMapper employeesMapper;

	public List<Employees> findAll() {
		return employeesMapper.selectAll();
	}

	public Employees findById(Integer empNo) {
		return employeesMapper.selectByPrimaryKey(empNo);
	}

	@Transactional
	public void updateEmployees(Employees emp) {
		employeesMapper.updateByPrimaryKey(emp);
	}
	
	@Transactional
	public void deleteEmployeesById(Integer empNo) {
		employeesMapper.deleteByPrimaryKey(empNo);
		
	}

	@Transactional
	public void addEmployees(Employees emp) {
		employeesMapper.insert(emp);
	}
	
	
}
