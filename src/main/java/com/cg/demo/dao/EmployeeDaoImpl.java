package com.cg.demo.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.cg.demo.entities.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDaoI {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Employee CreateEmployee(Employee emp) {
		return entityManager.merge(emp);
	}

	@Override
	public Employee findEmployeeById(long empId) {
		return entityManager.find(Employee.class,empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		//Employee emp=entityManager.find(Employee.class,employee.getEmpId());
		Employee emp=findEmployeeById(employee.getEmpId());
		emp.setEmpName(employee.getEmpName());
		emp.setEmpSal(employee.getEmpSal());
		emp=entityManager.merge(emp);
		return emp;
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		Query q = entityManager.createQuery("select e from Employee e");
	    List<Employee> list=q.getResultList();
		return list; //
		
	/*	
		mysql> select * from employee;
		+--------+----------+---------+
		| emp_id | emp_name | emp_sal |
		+--------+----------+---------+
		|     10 | ram      |   55000 |
		|     20 | Ramesh   |   65000 |
		|     30 | Kumar    |   95000 |
		+--------+----------+---------+
		3 rows in set (0.00 sec)  */
	}
	
	
	
	@Override
	public void deleteEmployee(long empId) {
		Employee emp=entityManager.find(Employee.class, empId);
		entityManager.remove(emp);
	}

}
	
