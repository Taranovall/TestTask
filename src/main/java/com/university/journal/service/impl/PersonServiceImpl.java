package com.university.journal.service.impl;

import com.university.journal.entity.Person;
import com.university.journal.repository.HeadOfDepartmentRepository;
import com.university.journal.repository.LectorRepository;
import com.university.journal.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final LectorRepository lectorRepository;
    private final HeadOfDepartmentRepository headOfDepartmentRepository;

    @Override
    public List<Person> findGlobalByTemplate(String template) {
        List<Person> allPersons = new ArrayList<>();

        allPersons.addAll(lectorRepository.findLectorByFirstNameOrLastNameContainingIgnoreCase(template, template));
        allPersons.addAll(headOfDepartmentRepository.findLectorByFirstNameOrLastNameContainingIgnoreCase(template, template));

        return allPersons;
    }
}
