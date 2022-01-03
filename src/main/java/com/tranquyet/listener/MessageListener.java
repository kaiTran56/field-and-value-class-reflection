package com.tranquyet.listener;

import com.tranquyet.bindings.MessageBidings;
import com.tranquyet.model.Student;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MessageBidings.class)
public class MessageListener {

    @StreamListener(target = MessageBidings.RECEIVE_MESSAGE)
    public void listenMessage(Student message){
        System.out.println("22222--------------------> "+message.toString());
    }
    @StreamListener(target = MessageBidings.RECEIVE_STUDENT)
    public void listenStudent(Student student){
        System.out.println("--------------------> STUDENT: "+student.toString());
    }
}
