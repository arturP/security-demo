package io.artur.spring.securitydemo.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 */
@NoArgsConstructor
@Getter
@Setter
public class UserNameAuthenticationRequest {
    private String userName;
    private String password;
}
