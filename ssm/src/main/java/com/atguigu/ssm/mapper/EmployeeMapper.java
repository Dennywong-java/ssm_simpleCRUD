package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
