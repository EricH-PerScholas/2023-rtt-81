package org.perscholas.springboot.controller;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    // add a label to the existing form input for first name
    // add a 2nd form input for last name
    // change the controller to accept the new form input for last name as well as first name
    // change the query to search by first name OR last name
    // change the query to use like for both first name and last name
    // make both search fields populate the user input if it was given


    // --- component scan phase 1
    // 1. Find all classes with @Component, @Service, @Repository, @Controller, @RestController and instantiate them and add them to the spring context
    // 2. Find all classes with @Configuration and instantiate them and add them to the Spring context
    // 3. Runs all the methods in the Configuration classes and anything marked with @Bean will be added them to the Spring context
    // 4. Find all classes with @ControllerAdvice and add them to the Spring context

    // -- component scan phase 2
    // 1. Inject all of the dependencies using @Autowired

    // -- component scan phase 3
    // 1. Run all of the methods marked with @PostConstruct


    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstNameSearch,
                               @RequestParam(required = false) String lastNameSearch) {
        ModelAndView response = new ModelAndView("customer/search");

        log.debug("in the customer search controller method : first name = " + firstNameSearch + " last name = " + lastNameSearch);

        if (!StringUtils.isEmpty(firstNameSearch) || !StringUtils.isEmpty(lastNameSearch)) {

            response.addObject("firstNameSearch", firstNameSearch);
            response.addObject("lastNameSearch", lastNameSearch);

            if (!StringUtils.isEmpty(firstNameSearch)) {
                firstNameSearch = "%" + firstNameSearch + "%";
            }

            if (!StringUtils.isEmpty(lastNameSearch)) {
                lastNameSearch = "%" + lastNameSearch + "%";
            }

            // we only want to do this code if the user has entered either a first name or a last name
            List<Customer> customers = customerDao.findByFirstNameOrLastName(firstNameSearch, lastNameSearch);

            response.addObject("customerVar", customers);


            for (Customer customer : customers) {
                log.debug("customer: id = " + customer.getId() + " last name = " + customer.getLastName());
            }
        }

        return response;
    }

//    @GetMapping("/customer/delete/{customerId}")
//    public ModelAndView deleteCustomer(@PathVariable int customerId) {
//        ModelAndView response = new ModelAndView("customer/search");
//
//        Customer customer = customerDao.findById(customerId);
//
//        if ( customer != null ) {
//            customerDao.delete(customer);
//        } else {
//            log.warn("Customer with id " + customerId + " was not found") ;
//        }
//
//        return response;
//    }

    @GetMapping("/customer/edit/{customerId}")
    public ModelAndView editCustomer(@PathVariable int customerId, @RequestParam(required = false) String success) {
        log.info("######################### In /customer/edit #########################");
        ModelAndView response = new ModelAndView("customer/create");

        Customer customer = customerDao.findById(customerId);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }

        CreateCustomerFormBean form = new CreateCustomerFormBean();

        if (customer != null) {
            form.setId(customer.getId());
            form.setFirstName(customer.getFirstName());
            form.setLastName(customer.getLastName());
            form.setPhone(customer.getPhone());
            form.setCity(customer.getCity());
        } else {
            log.warn("Customer with id " + customerId + " was not found");
        }

        response.addObject("form", form);

        return response;

    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("customer/create");

        log.debug("In create customer with no args - log.debug");
        log.info("In create customer with no args - log.info");

        return response;
    }


    // the action attribute on the form tag is set to /customer/createSubmit so this method will be called when the user clicks the submit button
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("customer/create");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create customer submit - no error found #########################");

        Customer c = customerService.createCustomer(form);

        // the view name can either be a jsp file name or a redirect to another controller method
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/edit/" + c.getId() + "?success=Customer Saved Successfully");

        return response;


    }


}
