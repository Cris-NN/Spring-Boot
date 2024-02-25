package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HolaMundo hola = (HolaMundo) context.getBean("holaMundo");

        System.out.println(hola.saludo());


    }
}
