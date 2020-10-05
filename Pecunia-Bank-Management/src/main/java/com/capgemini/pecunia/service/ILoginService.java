package com.capgemini.pecunia.service;

import com.capgemini.pecunia.entity.Employee;

public interface ILoginService {

	Employee saveDetails(Employee employee);

	Employee fetchEmployeeByEmailID(String email);

	Employee fetchEmployeeByEmailIDAndPassword(String email, String password);

}