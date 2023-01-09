package com.tcs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.tcs.dto.Company;
import com.tcs.dto.Employee;

public class Company_Employee_Dao {

   private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
   private EntityManager entityManager=entityManagerFactory.createEntityManager();
   private EntityTransaction entityTransaction=entityManager.getTransaction();
   
   public void saveCompany(Company company) {
	   entityTransaction.begin();
	   entityManager.persist(company);
	   entityTransaction.commit();
   }
   
   public void saveEmployee(Employee employee) {
	   entityTransaction.begin();
	   entityManager.persist(employee);
	   entityTransaction.commit();
   }
   
   public void updateCompanyEmployee(int id,List<Employee>employees) {
		entityTransaction.begin();
		Company company  =entityManager.find(Company.class, id);
		List<Employee> emp2=company.getEmployee();
		emp2.addAll(employees);
		for (Employee employee : emp2) {
			employee.setCompany(company);
		}		
		entityManager.merge(company);
		entityTransaction.commit();		
	}
   
   public void updateCompany(Company company) {
	    entityTransaction.begin();
		List<Employee> emp2=company.getEmployee();
		company.setEmployee(emp2);
		entityManager.merge(company);	
		entityTransaction.commit();
   }
   
   public void updateEmployee(Employee employee) {
	   
   }
   
   public void findCompany(int id) {
		Company company=entityManager.find(Company.class, id);
		entityTransaction.begin();
	   if(company !=null)
			{
				System.out.println(company);
			}
			else {
				System.out.println("Id not found");
			}
	}
   
   public void deleteCompany(int id) {
		 Company company=entityManager.find(Company.class, id);
	   		entityTransaction.begin();
	   		if(company != null)
	   		{
	   			entityManager.remove(company);
	   			entityTransaction.commit();
	   		}
	   		else {
	   			System.out.println("Object not found");
	   		}
	       }
	       
	 public List<Company> findAll(Company company) {
			Query query=entityManager.createQuery("select a From Company a");
			System.out.println(company);
	 		return query.getResultList();
	 		
	 		
		}
   
}
