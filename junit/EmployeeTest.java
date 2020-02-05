package com.zensar.emdb.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.zensar.emdb.bean.Employee;
import com.zensar.emdb.dao.EmployeeDaoClass;

class EmployeeTest {

	//@Test --done
	void test() {
		Employee e = new Employee(1146, "VAISHANI", "SS", 45, 12000);
		EmployeeDaoClass d = new EmployeeDaoClass();
		assertEquals(true, d.insert(e));
	}
	//@Test  --done
	void testDelete() {
		Employee e = new Employee(1234, "SAKSHI", "SSE", 25, 123000);
		EmployeeDaoClass d = new EmployeeDaoClass();
		assertEquals(true, d.delete(e));
	}

	//@Test --done
	void testModifySalary() {
		Employee e = new Employee(1146, "VIVEK", "SSE", 32, 12000);
		EmployeeDaoClass d = new EmployeeDaoClass();
		assertEquals(true, d.modifySalary(e));
	}

	//@Test --done
	void testModifyDesignation() {
		Employee e = new Employee(1146, "VIVEK", "SSS", 32, 45000);
		EmployeeDaoClass d = new EmployeeDaoClass();
		assertEquals(true, d.modifyDesignation(e));
	}
	
}
