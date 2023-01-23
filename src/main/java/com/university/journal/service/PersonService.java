package com.university.journal.service;

import com.university.journal.entity.Person;

import java.util.List;

public interface PersonService {

    /**
     *
     * @param template
     * @return list of people whose first name of last name match with template
     */
    List<Person> findGlobalByTemplate(String template);
}
