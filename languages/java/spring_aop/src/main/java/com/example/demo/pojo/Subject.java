package com.example.demo.pojo;

import com.example.demo.annotation.InterceptClass;
import com.example.demo.annotation.InterceptMethod;
import org.springframework.stereotype.Component;

@Component
// When using Spring AOP, the classes that are targeted by AOP should also be beans
@InterceptClass
public class Subject {
    @InterceptMethod
    public String doAction(String message) {
        return message;
    }
}
