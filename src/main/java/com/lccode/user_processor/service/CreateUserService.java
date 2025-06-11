package com.lccode.user_processor.service;

import com.lccode.user_processor.infrastructure.dto.CreateUserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Slf4j
@Service
public class CreateUserService {

    private final ApplicationEventPublisher eventPublisher;

    public void createUser(CreateUserDTO dto) {
        eventPublisher.publishEvent(new CreateUserMessage(dto, new Date()));
        log.info("Internal event published for create user: [{}]", dto);
    }

}
