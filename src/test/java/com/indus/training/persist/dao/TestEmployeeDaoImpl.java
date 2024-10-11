package com.indus.training.persist.dao;

import java.sql.Date;
import java.util.List;

import com.indus.training.persist.entity.Employee;
import com.indus.training.persist.impl.EmployeeDaoImpl;

import junit.framework.TestCase;

public class TestEmployeeDaoImpl extends TestCase {

	private EmployeeDaoImpl empDaoImplObj = null;

	protected void setUp() throws Exception {
		empDaoImplObj = new EmployeeDaoImpl();
	}

	protected void tearDown() throws Exception {
		empDaoImplObj = null;
	}

	// Test case for inserting an employee
//    public void testInsertEmployee() {
//        try {
//            Employee employee = new Employee();
//            employee.setFirstName("John");
//            employee.setLastName("Doe");
//            Boolean result = empDaoImplObj.insertEmployee(employee); 
//            assertTrue("Employee should be inserted", result);
//        } catch (Exception e) {
//            fail("Exception thrown during testInsertEmployee: " + e.getMessage());
//        }
//    }

//    // Test case for fetching an employee by ID
//    public void testFetchEmployeeById() {
//        try {
//            Employee employee = empDaoImplObj.fetchEmployeeById(101);
//            assertNotNull("Employee should be fetched", employee);
//            assertEquals(101, employee.getEmployeeId());
//        } catch (Exception e) {
//            fail("Exception thrown during testFetchEmployeeById: " + e.getMessage());
//        }
//    }

//
//    // Test case for deleting an employee by ID
//    public void testDeleteEmployeeById() {
//        try {
//            boolean result = empDaoImplObj.deleteEmployeeById(101);
//            assertTrue("Employee should be deleted", result);
//
//            Employee deletedEmployee = empDaoImplObj.fetchEmployeeById(101);
//            assertNull("Employee should no longer exist", deletedEmployee);
//        } catch (Exception e) {
//            fail("Exception thrown during testDeleteEmployeeById: " + e.getMessage());
//        }
//    }

	public void testFindAll() {
		Employee emp1 = new Employee();
		emp1.setFirstName("Navya");
		emp1.setLastName("Bade");
		Employee emp2 = new Employee();
		emp2.setFirstName("Roja");
		emp2.setLastName("Bade");
		try {
			empDaoImplObj.insertEmployee(emp1);
			empDaoImplObj.insertEmployee(emp2);
			List<Employee> employees = empDaoImplObj.findAll();
			assertNotNull(employees);
			assertTrue(employees.size() > 0);
			empDaoImplObj.deleteEmployeeById(emp1.getEmployeeId());
			empDaoImplObj.deleteEmployeeById(emp2.getEmployeeId());
		} catch (Exception e) {
			fail("An exception Occured");

		}
	}
	
	public void testFindByLastName() {
		Employee emp1 = new Employee();
		emp1.setFirstName("Navya");
		emp1.setLastName("Bade");
		Employee emp2 = new Employee();
		emp2.setFirstName("Roja");
		emp2.setLastName("Roja");
		try {
			empDaoImplObj.insertEmployee(emp1);
			empDaoImplObj.insertEmployee(emp2);
			List<Employee> employees = empDaoImplObj.findByLastName("Bade");
			assertNotNull(employees);
			assertTrue(employees.size() ==1);
			empDaoImplObj.deleteEmployeeById(emp1.getEmployeeId());
			empDaoImplObj.deleteEmployeeById(emp2.getEmployeeId());
		} catch (Exception e) {
			fail("An exception Occured");

		}
	}
	
	

}
