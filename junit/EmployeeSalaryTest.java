package com.zensar.emdb.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.zensar.emdb.bean.EmployeeSalary;
import com.zensar.emdb.dao.EmployeeSalaryDaoClass;

	class DaoClass2Test {

		@Test
		void testCheckFunction() {
			EmployeeSalary e = new EmployeeSalary(1146, "VAISHANI", "SS", 12000,1236.00,123,124500);
			EmployeeSalaryDaoClass d = new EmployeeSalaryDaoClass();
			assertEquals(true, d.checkFunction(e));
		}

}


