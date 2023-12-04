package org.perscholas.springboot.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerFormBean {

    private Integer id;


    private String firstName;
    private String lastName;
    private String phone;
    private String city;

}
