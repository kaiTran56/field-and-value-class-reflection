package com.tranquyet.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageBidings {
    String RECEIVE_MESSAGE = "receiveMessageTest";

    String RECEIVE_STUDENT = "receiveStudent";

    @Input(RECEIVE_MESSAGE)
    SubscribableChannel receiveMessageAmqp();

    @Input(RECEIVE_STUDENT)
    SubscribableChannel receiveStudent();
}
