package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.data.exception.IllegalValueException;

public class Dob {
    public static final String EXAMPLE = "01.12.1994";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person Dob should be in the format DD.MM.YY";
    public static final String DOB_VALIDATION_REGEX = "[\\d\\.]+.[\\d\\.]+[\\d\\.]+";

    public static final Pattern DOB_DATA_ARGS_FORMAT = // '/' forward slashes are reserved for delimiter prefixes
            Pattern.compile("(?<day>[^/]+)"
                    + ".(?<month>[^/]+)"
                    + ".(?<year>[^/]+)"); // variable number of tags

    public final String day;
    public final String month;
    public final String year;
    private boolean isPrivate;

    public Dob(String dob, boolean isPrivate) throws IllegalValueException {
        String trimmedDob = dob.trim();
        if (!isValidDob(trimmedDob)) {
            throw new IllegalValueException(MESSAGE_EMAIL_CONSTRAINTS);
        }
        final Matcher matcher = DOB_DATA_ARGS_FORMAT.matcher(dob.trim());

        this.day = matcher.group("day");
        this.month = matcher.group("month");
        this.year = matcher.group("year");
        this.isPrivate = isPrivate;
    }

    public static boolean isValidDob(String test) {
        return test.matches(DOB_VALIDATION_REGEX);
    }

}
