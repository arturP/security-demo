package io.artur.spring.securitydemo.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.artur.spring.securitydemo.security.ApplicationUserRole.*;

/**
 *
 */
@RequiredArgsConstructor
@Repository("fake")
public class FakeApplicationUserDao implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> getApplicationUserByUserName(String userName) {
        return getApplicationUsers().stream()
                .filter(user -> userName.equals(user.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("1234"),
                        "michael",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password1234"),
                        "larry",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password1234"),
                        "paul",
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
