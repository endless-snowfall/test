package com.etsy.clout;

import java.util.Scanner;

import com.etsy.clout.command.Command;
import com.etsy.clout.command.CommandFactory;
import com.etsy.clout.service.CloutServiceImpl;

public class Clout {

    public static void main(String args[]) {
        CommandFactory commandFactory = CommandFactory.of(new CloutServiceImpl());

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                Command command = commandFactory.buildCommand(input);
                command.execute();
            }
        }
    }
}
