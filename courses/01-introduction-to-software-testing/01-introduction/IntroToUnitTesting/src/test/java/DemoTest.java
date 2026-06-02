import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
    private InputStream originalIn;
    private PrintStream originalOut;

    @Before
    public void setUpStreams() {
        originalIn = System.in;
        originalOut = System.out;
    }

    @After
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void validTriangleReturnsTrue() {
        assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void degenerateTriangleReturnsFalse() {
        assertFalse(Demo.isTriangle(1, 2, 3));
    }

    @Test
    public void invalidWhenFirstInequalityFails() {
        assertFalse(Demo.isTriangle(1, 2, 4));
    }

    @Test
    public void invalidWhenSecondInequalityFails() {
        assertFalse(Demo.isTriangle(1, 4, 2));
    }

    @Test
    public void invalidWhenThirdInequalityFails() {
        assertFalse(Demo.isTriangle(4, 1, 2));
    }

    @Test
    public void negativeSideReturnsFalse() {
        assertFalse(Demo.isTriangle(-1, 2, 3));
    }

    @Test
    public void mainPrintsTriangleMessage() {
        String output = runMainWithInput("3\n4\n5\n");

        assertEquals(
            "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is a triangle.\n",
            output
        );
    }

    @Test
    public void mainPrintsNonTriangleMessage() {
        String output = runMainWithInput("1\n2\n4\n");

        assertEquals(
            "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is not a triangle.\n",
            output
        );
    }

    private String runMainWithInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Demo.main(new String[0]);

        return out.toString();
    }
}
