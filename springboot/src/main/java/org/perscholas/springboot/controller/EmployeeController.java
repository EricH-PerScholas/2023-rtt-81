package org.perscholas.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;


    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("employee/create");

        log.info(" In create employee with no Args");
        return response;
    }


    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployee(CreateEmployeeFormBean form) {
        ModelAndView response = new ModelAndView("employee/create");

        log.info("firstname:" + form.getFirstName());
        log.info("lastname:" + form.getLastName());
        log.info("department:" + form.getDepartmentName());


        Employee employee = new Employee();

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setDepartment(form.getDepartmentName());


        //  customerDAO.save(customer);
        employeeDAO.save(employee);

        log.info(" In create customer with  Args");
        return response;
    }
}