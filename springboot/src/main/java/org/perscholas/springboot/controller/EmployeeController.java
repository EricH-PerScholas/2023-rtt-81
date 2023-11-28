package org.perscholas.springboot.controller;

import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(CreateEmployeeFormBean form) {
        ModelAndView response = new ModelAndView("customer/create");



        logger.info("In create customer with incoming args");

        return response;
    }
}
