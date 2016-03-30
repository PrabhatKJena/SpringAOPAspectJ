package edu.pk.service;

import edu.pk.bean.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<Employee>();

    {
        Employee employee = new Employee();
        employee.setId(101);
        employee.setName("EMP1");
        employeeList.add(employee);
        employee = new Employee();
        employee.setId(102);
        employee.setName("EMP2");
        employeeList.add(employee);
    }

    public Employee getEmployee(Integer id) {
        Optional<Employee> employee = employeeList.stream().findAny().filter(e -> {
            return e.getId() == id;
        });
        if(employee.isPresent())
            return employee.get();
        else
            throw new IllegalArgumentException("Invalid Emp ID");
    }

    public void saveEmployee(){

    }
}
