package seedu.addressbook.commands;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class PrintCommand extends Command {

    public static final String COMMAND_WORD = "print";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Saves the addressbook into a txt file for your viewing.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Addressbook has been saved! " +
            "Find your addressbook in the addressbook.txt file";

    public static String filename;

    //public PrintCommand(String filename) {this.filename = filename;}

    @Override
    public CommandResult execute(){
        List<ReadOnlyPerson> temp = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        String timeStamp = new SimpleDateFormat("dd/MM/YYYY" + " "+ "HH:mm:ss").format(new Date());
        lines.add("Addressbook was last updated on: " + timeStamp +"\n");

        for (ReadOnlyPerson person: addressBook.getAllPersons()) {

            String entry = person.getAsTextHidePrivate();
            lines.add(entry);
            temp.add(person);
        }


        Path file = Paths.get("addressbook.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
    
}
