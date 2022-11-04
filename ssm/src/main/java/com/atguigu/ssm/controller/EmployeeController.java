package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Date:2022/7/11
 * Author:ybc
 * Description:
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        //获取员工的分页信息
        PageInfo<Employee> pageInfo = employeeService.getEmployeePage(pageNum);
        //将分页信息共享到请求域中
        model.addAttribute("page", pageInfo);
        //跳转到列表页面
        return "employee_list";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将得到的员工信息共享到请求域中
        model.addAttribute("list",list);
        //跳转到employee_list.html
        return "employee_list";
    }

    @RequestMapping(value = "/to/add",method = RequestMethod.GET)
    public String insertEmployee(){
        //跳转到employee_add.html
        return "employee_add";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployeeForm(Employee employee){
        employeeService.addEmployee(employee);
        //重新指向employee.html再次出发get请求
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        System.out.println(employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/page/1";
    }

}
