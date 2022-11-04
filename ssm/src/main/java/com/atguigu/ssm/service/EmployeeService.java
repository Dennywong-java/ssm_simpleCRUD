package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    //获取员工的分页信息
    PageInfo<Employee> getEmployeePage(int i);

    void addEmployee(Employee employee);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);
}
