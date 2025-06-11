package com.lccode.user_processor.infrastructure.controller;

import com.lccode.user_processor.infrastructure.dto.CreateUserDTO;
import com.lccode.user_processor.service.CreateUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@AllArgsConstructor
public class UserProcessorController {

    private final CreateUserService createUserService;

    @PostMapping
    private ResponseEntity<Void> createUserRequest (@RequestBody CreateUserDTO dto) {
        createUserService.createUser(dto);
        return ResponseEntity.ok().build();
    }
}
