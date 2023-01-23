package com.university.journal.service;

import com.university.journal.entity.Department;
import com.university.journal.exception.DepartmentNotExistException;

import java.util.Map;

public interface DepartmentService {

    /**
     *
     * @param departmentName
     * @return department by its name
     * @throws DepartmentNotExistException
     */
    Department getDepartmentByName(String departmentName) throws DepartmentNotExistException;

    /**
     *
     * @param departmentName
     * @return map where key is a name of degree and value is a amount of lector with this degree on specified department
     * @throws DepartmentNotExistException
     */
    Map<String, Long> getLectorStatisticByDepartment(String departmentName) throws DepartmentNotExistException;

    /**
     *
     * @param departmentName
     * @return average salary of all employees (lectors, head of department) by department name
     * @throws DepartmentNotExistException
     */
    double getAverageSalaryByDepartment(String departmentName) throws DepartmentNotExistException;

    /**
     *
     * @param departmentName
     * @return amount of employees in department by its name
     * @throws DepartmentNotExistException
     */
    int getCountOfEmployeeByDepartment(String departmentName) throws DepartmentNotExistException;
}
