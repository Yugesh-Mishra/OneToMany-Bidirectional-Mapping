package com.tcs.controller;

import java.util.ArrayList;
import java.util.List;

import com.tcs.dao.Company_Employee_Dao;
import com.tcs.dto.Company;
import com.tcs.dto.Employee;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Company company=new Company();
		company.setId(1003);
		company.setName("jspiders");
		company.setEmail("jp@gmail.com");
		company.setAddress("Mumbai");
		
		Employee employee=new Employee();
		employee.setEid(125);
		employee.setName("sidd");
		employee.setAddress("dombivli");
		employee.setSal(18000);
		employee.setCompany(company);
		
		Employee employee1=new Employee();
		employee1.setEid(126);
		employee1.setName("yug");
		employee1.setAddress("dadar");
		employee1.setSal(18000);
		employee1.setCompany(company);
		
		List<Employee>list=new ArrayList<Employee>();
		list.add(employee);
		list.add(employee1);
		
		company.setEmployee(list);
		
		Company_Employee_Dao dao=new Company_Employee_Dao();
	//	dao.saveCompany(company);
	//	dao.saveEmployee(employee);
	//	dao.saveEmployee(employee1);
	//	dao.updateCompanyEmployee(1004, list);
	//	dao.updateCompany(company);
	//	dao.findCompany(1003);
	//	dao.deleteCompany(1003);
		dao.findAll(company);
	}

}
