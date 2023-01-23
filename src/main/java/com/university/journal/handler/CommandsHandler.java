package com.university.journal.handler;

import com.university.journal.controller.DepartmentController;
import com.university.journal.controller.PersonController;
import com.university.journal.entity.Command;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CommandsHandler {

    private final DepartmentController departmentController;
    private final PersonController personController;

    @Bean
    public void scanCommand() {
        while (true) {
            log.info("Input command");
            String input = new Scanner(System.in).nextLine();
            handleCommand(input);
        }
    }

    private void handleCommand(String input) {
        Optional<Command> cmd = Command.getCommand(input);

        cmd.ifPresentOrElse(
                c -> getCommands().get(c).accept(c.getValue()),
                () -> log.info("Incorrect input '{}'", input)
        );
    }

    /**
     * All available commands
     * @return
     */
    private Map<Command, Consumer<String>> getCommands() {
        return Map.of(
                Command.SHOW_DEPARTMENT_HEAD, departmentController::printHeadOfDepartment,
                Command.SHOW_STATISTICS, departmentController::printDepartmentStatistic,
                Command.SHOW_AVERAGE_SALARY, departmentController::printAverageSalary,
                Command.SHOW_EMPLOYEE_COUNT, departmentController::printCountOfEmployee,
                Command.GLOBAL_SEARCH, personController::printResultOfGlobalSearch
        );
    }
}
