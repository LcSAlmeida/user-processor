package com.lccode.user_processor.service;

import com.lccode.user_processor.infrastructure.dto.CreateUserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserMessage {
    private CreateUserDTO content;
    private Date date;
}
