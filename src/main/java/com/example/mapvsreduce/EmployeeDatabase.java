package com.example.mapvsreduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

    public static List<Employee> getEmployees(){
        return Stream.of(new Employee(101,"john","A",60000),
                new Employee(102,"peter","B",30000),
                new Employee(103,"katy","A",80000),
                new Employee(104,"wil","C",90000))
                .collect(Collectors.toList());
    }
}