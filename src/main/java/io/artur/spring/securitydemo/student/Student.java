package io.artur.spring.securitydemo.student;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 */
@RequiredArgsConstructor
@Builder
public class Student {

    @Getter
    private final Long id;
    @Getter
    private final String name;

}
