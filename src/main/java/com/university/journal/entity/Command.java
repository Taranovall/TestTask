package com.university.journal.entity;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enum with all available commands
 */
public enum Command {

    SHOW_DEPARTMENT_HEAD("Who is head of department\\s(.+)"),
    SHOW_STATISTICS("Show\\s(.+)\\sstatistics."),
    SHOW_AVERAGE_SALARY("Show the average salary for the department\\s(.+)."),
    SHOW_EMPLOYEE_COUNT("Show count of employee for\\s(.+)."),
    GLOBAL_SEARCH("Global search by\\s(.+).");
    private String regex;
    private String value;

    Command(String regex) {
        this.regex = regex;
    }

    /**
     * @param input
     * @return command wrapped in optional. If there's no such command then returns Optional.empty()
     */
    public static Optional<Command> getCommand(String input) {
        for (Command c : Command.values()) {

            Pattern pattern = Pattern.compile(c.regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                c.setValue(matcher.group(1));
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    public String getValue() {
        return value;
    }

    public Command setValue(String value) {
        this.value = value;
        return this;
    }
}
