package org.perscholas.springboot.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserFormBean {

    private String email;
    private String password;
    private String confirmPassword;

}
