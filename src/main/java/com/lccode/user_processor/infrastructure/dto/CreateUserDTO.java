package com.lccode.user_processor.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
public class CreateUserDTO {
    private final String fullName;
    private final String document;
    private final String phoneNumber;
    private final String email;
    private final String image;
}
