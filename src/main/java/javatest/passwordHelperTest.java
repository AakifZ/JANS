package javatest;


import helper.passwordHelper;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class passwordHelperTest extends TestCase {

    /**
     * Testing the validPassword method when all conditions are met
     */
    @Test
    public void testValidPassword() {
        assertEquals(true, passwordHelper.validPassword("Password1"));
    }

    /**
     * Testing the validPassword method where first condition is not met
     */
    @Test
    public void testValidPasswordFirst() {
        assertEquals(false, passwordHelper.validPassword("Lower1"));
    }

    /**
     * Testing the validPassword method where second condition is not met
     */
    @Test
    public void testValidPasswordSecond() {
        assertEquals(false, passwordHelper.validPassword("PASSWORD1"));
    }

    /**
     * Testing the validPassword method where third condition is not met
     */
    @Test
    public void testValidPasswordThird() {
        assertEquals(false, passwordHelper.validPassword("password1"));
    }

    /**
     * Testing the validPassword method where fourth condition is not met
     */
    @Test
    public void testValidPasswordFourth() {
        assertEquals(false, passwordHelper.validPassword("Password"));
    }
}