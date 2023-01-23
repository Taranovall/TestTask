package com.university.journal.controller;

import com.university.journal.entity.Person;
import com.university.journal.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    public void printResultOfGlobalSearch(String template) {
        List<Person> people = personService.findGlobalByTemplate(template);
        if (people.isEmpty()) {
            log.info("Nothing found.");
        } else {
            String result = convertListToString(people);
            log.info(result);
        }
    }

    /**
     * Converts a list of people to string
     * @param people list with people
     * @return formatted string where each person is separated by comma
     */
    private String convertListToString(List<Person> people) {
        String previousSeparator = "";
        StringBuilder result = new StringBuilder();
        for (Person person : people) {
            result.append(previousSeparator).append(person.getFirstName()).append(" ").append(person.getLastName());
            previousSeparator = ", ";
        }
        return result.toString();
    }
}
