package com.umbrella.rabitMQDemo.controller;

import com.umbrella.rabitMQDemo.model.Employee;
import com.umbrella.rabitMQDemo.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RabbitMQWebController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/rabbitmq/receive/message")
    public String consume(@RequestParam("employeeName") String empName, @RequestParam("employeeCode") String empId, @RequestParam("employeeEx") int exp) {

        Employee employee=new Employee();
        employee.setDomain(empId);
        employee.setName(empName);
        employee.setExperience(exp);
        rabbitMQSender.send(employee);

        return "Message has been sent to the RabbitMQ demo successfully";
    }

}
