package com.etsy.clout.userinterface;

import java.util.Scanner;

import com.etsy.clout.command.Command;
import com.etsy.clout.command.CommandFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandLineInterface implements UserInterface {

    private CommandFactory commandFactory;

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to 'clout', type 'exit' to quit.");

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                Command command = commandFactory.buildCommand(input);
                command.execute().getResponses().forEach(response -> System.out.println(response));
            }
        }
    }
}
