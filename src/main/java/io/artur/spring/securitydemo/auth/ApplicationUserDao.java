package io.artur.spring.securitydemo.auth;

import java.util.Optional;

/**
 *
 */
public interface ApplicationUserDao {

    Optional<ApplicationUser> getApplicationUserByUserName(String userName);
}
