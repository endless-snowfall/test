package com.etsy.clout.userinterface;

import com.etsy.clout.command.CommandFactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserInterfaceFactory {

    public UserInterface buildUserInterface(String[] args, CommandFactory commandFactory) {
        if (args.length != 2) {
            return new CommandLineInterface(commandFactory);
        }

        // TODO
        return null;
    }
}
