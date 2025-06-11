package com.lccode.user_processor.infrastructure.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lccode.user_processor.service.CreateUserMessage;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class CreateUserSqsProducer {

    @Value("${producer.sqsQueue}")
    private final String queue;

    private final SqsTemplate sqsTemplate;
    private final ObjectMapper objectMapper;

    @Async
    @EventListener
    public void createUserProducer(CreateUserMessage createUserMessage){
        try {
        String messageBody = objectMapper.writeValueAsString(createUserMessage);
        sqsTemplate.send(queue, MessageBuilder.withPayload(messageBody).build());
        log.info("Published sqs event for create user: [{}]", messageBody);

        } catch (JsonProcessingException ex) {
            log.error("Erro during publish sqs event: [{}]", ex.getMessage());
        }
    }

}
