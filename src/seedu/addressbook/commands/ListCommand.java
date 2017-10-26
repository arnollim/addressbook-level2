package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> temp = new ArrayList<>();
        for (ReadOnlyPerson person: addressBook.getAllPersons()) {
            temp.add(person);
        }
        Comparator<ReadOnlyPerson> ALPHA_ORDER = new Comparator<ReadOnlyPerson>() {
            public int compare(ReadOnlyPerson first, ReadOnlyPerson second) {
                int x = String.CASE_INSENSITIVE_ORDER.compare(first.getName().fullName, second.getName().fullName);
                if (x== 0) {
                    x = (first.getName().fullName).compareTo(second.getName().fullName);
                }
                return x;
            }
        };
        Collections.sort(temp, ALPHA_ORDER);
        return new CommandResult(getMessageForPersonListShownSummary(temp), temp);
    }
}
