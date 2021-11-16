package io.artur.spring.securitydemo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@RequiredArgsConstructor
@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return applicationUserDao.getApplicationUserByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User with name: " + userName + " cannot be found!"));
    }
}
