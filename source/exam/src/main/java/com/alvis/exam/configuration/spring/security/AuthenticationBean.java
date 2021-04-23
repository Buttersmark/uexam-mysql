package com.alvis.exam.configuration.spring.security;

import lombok.Data;

/**
 * @author 高xh
 */

@Data
public class AuthenticationBean {
    private String userName;
    private String password;
    private boolean remember;
}
