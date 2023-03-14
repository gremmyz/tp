package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Email(null));
    }

    @Test
    public void constructor_invalidEmail_throwsIllegalArgumentException() {
        String invalidEmail = " ";
        assertThrows(IllegalArgumentException.class, () -> new Email(invalidEmail));
    }

    @Test
    public void isValidEmail() {
        // null email
        assertThrows(NullPointerException.class, () -> Email.isValidEmail(null));

        // blank email
        assertFalse(Email.isParsedEmail("")); // empty string
        assertFalse(Email.isParsedEmail(" ")); // empty string

        assertFalse(Email.isValidEmail(" ")); // spaces only

        // missing parts
        assertFalse(Email.isParsedEmail("@example.com")); // missing local part
        assertFalse(Email.isParsedEmail("peterjackexample.com")); // missing '@' symbol
        assertFalse(Email.isParsedEmail("peterjack@")); // missing domain name

        assertFalse(Email.isValidEmail("@example.com")); // missing local part
        assertFalse(Email.isValidEmail("peterjackexample.com")); // missing '@' symbol
        assertFalse(Email.isValidEmail("peterjack@")); // missing domain name

        // invalid parts
        assertFalse(Email.isParsedEmail("peterjack@-")); // invalid domain name
        assertFalse(Email.isParsedEmail("peterjack@exam_ple.com")); // underscore in domain name
        assertFalse(Email.isParsedEmail("peter jack@example.com")); // spaces in local part
        assertFalse(Email.isParsedEmail("peterjack@exam ple.com")); // spaces in domain name
        assertFalse(Email.isParsedEmail(" peterjack@example.com")); // leading space
        assertFalse(Email.isParsedEmail("peterjack@example.com ")); // trailing space
        assertFalse(Email.isParsedEmail("peterjack@@example.com")); // double '@' symbol
        assertFalse(Email.isParsedEmail("peter@jack@example.com")); // '@' symbol in local part
        assertFalse(Email.isParsedEmail("-peterjack@example.com")); // local part starts with a hyphen
        assertFalse(Email.isParsedEmail("peterjack-@example.com")); // local part ends with a hyphen
        assertFalse(Email.isParsedEmail("peter..jack@example.com")); // local part has two consecutive periods
        assertFalse(Email.isParsedEmail("peterjack@example@com")); // '@' symbol in domain name
        assertFalse(Email.isParsedEmail("peterjack@.example.com")); // domain name starts with a period
        assertFalse(Email.isParsedEmail("peterjack@example.com.")); // domain name ends with a period
        assertFalse(Email.isParsedEmail("peterjack@-example.com")); // domain name starts with a hyphen
        assertFalse(Email.isParsedEmail("peterjack@example.com-")); // domain name ends with a hyphen
        assertFalse(Email.isParsedEmail("peterjack@example.c")); // top level domain has less than two chars

        assertFalse(Email.isValidEmail("peterjack@-")); // invalid domain name
        assertFalse(Email.isValidEmail("peterjack@exam_ple.com")); // underscore in domain name
        assertFalse(Email.isValidEmail("peter jack@example.com")); // spaces in local part
        assertFalse(Email.isValidEmail("peterjack@exam ple.com")); // spaces in domain name
        assertFalse(Email.isValidEmail(" peterjack@example.com")); // leading space
        assertFalse(Email.isValidEmail("peterjack@example.com ")); // trailing space
        assertFalse(Email.isValidEmail("peterjack@@example.com")); // double '@' symbol
        assertFalse(Email.isValidEmail("peter@jack@example.com")); // '@' symbol in local part
        assertFalse(Email.isValidEmail("-peterjack@example.com")); // local part starts with a hyphen
        assertFalse(Email.isValidEmail("peterjack-@example.com")); // local part ends with a hyphen
        assertFalse(Email.isValidEmail("peter..jack@example.com")); // local part has two consecutive periods
        assertFalse(Email.isValidEmail("peterjack@example@com")); // '@' symbol in domain name
        assertFalse(Email.isValidEmail("peterjack@.example.com")); // domain name starts with a period
        assertFalse(Email.isValidEmail("peterjack@example.com.")); // domain name ends with a period
        assertFalse(Email.isValidEmail("peterjack@-example.com")); // domain name starts with a hyphen
        assertFalse(Email.isValidEmail("peterjack@example.com-")); // domain name ends with a hyphen
        assertFalse(Email.isValidEmail("peterjack@example.c")); // top level domain has less than two chars

        // valid email
        assertTrue(Email.isParsedEmail("PeterJack_1190@example.com")); // underscore in local part
        assertTrue(Email.isParsedEmail("PeterJack.1190@example.com")); // period in local part
        assertTrue(Email.isParsedEmail("PeterJack+1190@example.com")); // '+' symbol in local part
        assertTrue(Email.isParsedEmail("PeterJack-1190@example.com")); // hyphen in local part
        assertTrue(Email.isParsedEmail("a@bc")); // minimal
        assertTrue(Email.isParsedEmail("test@localhost")); // alphabets only
        assertTrue(Email.isParsedEmail("123@145")); // numeric local part and domain name
        assertTrue(Email.isParsedEmail("a1+be.d@example1.com")); // mixture of alphanumeric and special characters
        assertTrue(Email.isParsedEmail("peter_jack@very-very-very-long-example.com")); // long domain name
        assertTrue(Email.isParsedEmail("if.you.dream.it_you.can.do.it@example.com")); // long local part
        assertTrue(Email.isParsedEmail("e1234567@u.nus.edu")); // more than one period in domain

        assertTrue(Email.isValidEmail("PeterJack_1190@example.com")); // underscore in local part
        assertTrue(Email.isValidEmail("PeterJack.1190@example.com")); // period in local part
        assertTrue(Email.isValidEmail("PeterJack+1190@example.com")); // '+' symbol in local part
        assertTrue(Email.isValidEmail("PeterJack-1190@example.com")); // hyphen in local part
        assertTrue(Email.isValidEmail("a@bc")); // minimal
        assertTrue(Email.isValidEmail("test@localhost")); // alphabets only
        assertTrue(Email.isValidEmail("123@145")); // numeric local part and domain name
        assertTrue(Email.isValidEmail("a1+be.d@example1.com")); // mixture of alphanumeric and special characters
        assertTrue(Email.isValidEmail("peter_jack@very-very-very-long-example.com")); // long domain name
        assertTrue(Email.isValidEmail("if.you.dream.it_you.can.do.it@example.com")); // long local part
        assertTrue(Email.isValidEmail("e1234567@u.nus.edu")); // more than one period in domain
    }
}
