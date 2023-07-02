package com.example.mapvsreduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class MapVsReduceApplication {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,4,5,6,7,8);
        int sum = 0;
        for(int num:numbers){
            sum=sum+num;
        }
        System.out.println("sum "+sum);

        int sum1 = numbers.stream().mapToInt(num->num).sum();
        System.out.println("sum1 "+sum1);

        int reduceSum = numbers.stream().reduce(0,(a,b) -> a+b);
        System.out.println("reduceSum "+reduceSum);

        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println("reduceSumWithMethodReference "+reduceSumWithMethodReference);

        Integer mulResult = numbers.stream().reduce(1,(a,b)->a*b);
        System.out.println("mulResult "+mulResult);

        int maxValue = numbers.stream().reduce(0,(a,b) -> a>b ? a : b);
        System.out.println("maxValue "+maxValue);

        List<Employee> gradeA =  EmployeeDatabase.getEmployees()
                .stream().filter(employee -> employee.getGrade().equalsIgnoreCase("A")).collect(Collectors.toList());
        System.out.println("gradeA employess - "+gradeA);

        List<Double> salaryFromEmployee = EmployeeDatabase.getEmployees().stream().map(employee -> employee.getSalary()).collect(Collectors.toList());
        System.out.println("salaryFromEmployee - "+salaryFromEmployee);

       double gradeASalariesAvg =  EmployeeDatabase.getEmployees()
                .stream()
               .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
               .map(employee -> employee.getSalary())
               .mapToDouble(i->i)
               .average()
               .getAsDouble();
        System.out.println("gradeASalariesAvg employess - "+gradeASalariesAvg);
    }

}
