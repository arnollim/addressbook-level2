package seedu.addressbook.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class PrintCommand extends Command {

    public static final String COMMAND_WORD = "print";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Saves the addressbook into a txt file for your viewing.\n"
            + "Example: " + COMMAND_WORD;

    public static String filename;

    public PrintCommand(String filename) {this.filename = filename;}

    @Override
    public CommandResult execute(){

        List<ReadOnlyPerson> temp = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        for (ReadOnlyPerson person: addressBook.getAllPersons()) {
            String n = person.getName().fullName;
            String e = person.getEmail().value;
            String a = person.getAddress().value;
            String entry = n + " " + e + " " + a;
            lines.add(entry);
            temp.add(person);
        }

        //List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("addressbook.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return new CommandResult("LOL");
    }

}
