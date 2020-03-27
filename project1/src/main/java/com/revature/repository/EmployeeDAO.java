package com.revature.repository;

import com.revature.instances.Employee;

public interface EmployeeDAO {
	boolean findByUserPass(String username, String password);

	Employee findById(int int1);

	Employee findByUser(String username);
}
