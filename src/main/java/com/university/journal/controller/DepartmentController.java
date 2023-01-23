package com.university.journal.controller;

import com.university.journal.entity.Department;
import com.university.journal.exception.DepartmentNotExistException;
import com.university.journal.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * Prints head of department by department name to console
     * @param departmentName
     */
    public void printHeadOfDepartment(String departmentName) {
        try {
            Department department = departmentService.getDepartmentByName(departmentName);
            log.info("Head of {} department is {} {}", department.getName(),
                    department.getHead().getFirstName(),
                    department.getHead().getLastName());
        } catch (DepartmentNotExistException e) {
            log.info(e.getMessage());
        }
    }

    /**
     * Prints to console department statistic in format:
     * degree - amount lectors with this degree
     * @param departmentName
     */
    public void printDepartmentStatistic(String departmentName) {
        try {
            Map<String, Long> departmentStatisticMap = departmentService.getLectorStatisticByDepartment(departmentName);
            departmentStatisticMap.entrySet().forEach(e -> log.info("{} - {}", e.getKey(), e.getValue()));
        } catch (DepartmentNotExistException e) {
            log.info(e.getMessage());
        }
    }

    /**
     * Prints to console average salary of department by its name
     * @param departmentName
     */
    public void printAverageSalary(String departmentName) {
        try {
            double averageSalary = departmentService.getAverageSalaryByDepartment(departmentName);
            DecimalFormat format = new DecimalFormat("0.#");
            log.info("The average salary of {} is {}", departmentName, format.format(averageSalary));
        } catch (DepartmentNotExistException e) {
            log.info(e.getMessage());
        }
    }

    /**
     * Prints to console amount of employee of specified department
     * @param departmentName
     */
    public void printCountOfEmployee(String departmentName) {
        try {
            int countOfEmployee = departmentService.getCountOfEmployeeByDepartment(departmentName);
            log.info(String.valueOf(countOfEmployee));
        } catch (DepartmentNotExistException e) {
            log.info(e.getMessage());
        }
    }
}
