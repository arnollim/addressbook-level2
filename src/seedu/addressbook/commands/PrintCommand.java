package seedu.addressbook.commands;

import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

import java.util.List;

public class PrintCommand extends Command {

    public static String filename;

    public PrintCommand(String filename) {this.filename = filename;}

    @Override
    public CommandResult execute(){
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("addressbook.txt");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       return new CommandResult("LOL");
    }

}
