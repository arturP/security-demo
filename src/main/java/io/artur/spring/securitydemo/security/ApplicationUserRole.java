package io.artur.spring.securitydemo.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static io.artur.spring.securitydemo.security.ApplicationUserPermission.*;

/**
 *
 */

@RequiredArgsConstructor
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    @Getter
    private final Set<ApplicationUserPermission> permissions;


}
