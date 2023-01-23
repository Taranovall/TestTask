package com.university.journal.service.impl;

import com.university.journal.entity.Department;
import com.university.journal.entity.Person;
import com.university.journal.exception.DepartmentNotExistException;
import com.university.journal.repository.DepartmentRepository;
import com.university.journal.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;


    @Override
    public Department getDepartmentByName(String departmentName) throws DepartmentNotExistException {
        return departmentRepository.findByNameIgnoreCase(departmentName)
                .orElseThrow(() -> new DepartmentNotExistException(String.format("Department with name '%s' doesn't exist", departmentName)));
    }

    @Override
    public Map<String, Long> getLectorStatisticByDepartment(String departmentName) throws DepartmentNotExistException {
        Department department = getDepartmentByName(departmentName);

        return department.getLectors().stream()
                .collect(Collectors.groupingBy(lector -> lector.getDegree().getName(), Collectors.counting()));
    }

    @Override
    public double getAverageSalaryByDepartment(String departmentName) throws DepartmentNotExistException {
        Department department = getDepartmentByName(departmentName);

        List<Person> allEmployee = new ArrayList<>(department.getLectors());
        allEmployee.add(department.getHead());

        return allEmployee.stream().mapToInt(Person::getSalary).average().getAsDouble();
    }

    @Override
    public int getCountOfEmployeeByDepartment(String departmentName) throws DepartmentNotExistException {
        Department department = getDepartmentByName(departmentName);

        int count = department.getLectors().size();
        return department.getHead() != null ? count + 1 : count;
    }
}
