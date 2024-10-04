package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;


import seedu.address.commons.core.index.Index;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemarkCommand;

public class RemarkCommandParser {

    public static final Prefix PREFIX_REMARK = new Prefix("r/");
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";


    public RemarkCommand parse(String args) throws ParseException {
    requireNonNull(args);
    ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_REMARK);
    Index index;
    try {
        index = ParserUtil.parseIndex(argMultimap.getPreamble());
    } catch (IllegalValueException ive) {
        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE), ive);
    }

    String remark = argMultimap.getValue(PREFIX_REMARK).orElse("");

    return new RemarkCommand(index, remark);
}

    
}
