package edu.pk.test;

import edu.pk.bean.Employee;
import edu.pk.config.Configuration;
import edu.pk.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        try {
            employeeService.saveEmployee();
            System.out.println("-----------");
            Employee e = employeeService.getEmployee(101);
            System.out.println(e.getName());
            System.out.println("-----------");
            e = employeeService.getEmployee(300);
            System.out.println(e.getName());
        }catch (Exception e){

        }
    }
}
