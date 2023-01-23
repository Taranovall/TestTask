package com.university.journal.entity;

import lombok.Data;

@Data
public class ParsedCommand {

    private Command command;
    private String value;
}
