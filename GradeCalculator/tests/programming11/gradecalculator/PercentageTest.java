package programming11.gradecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class PercentageTest {

    private Percentage percentage;

    @BeforeEach
    void setUp() {
        percentage = new Percentage("Final Exam", 95.00, 100.00);
    }


    @Test
    void testAssignmentIsThere() {
        //check if assignment is there.
        assertEquals(percentage.getAssignment(), "Final Exam");
        assertFalse(percentage.getAssignment().contains("midterm"));
        percentage.setAssignment("midterm");
    }

    @Test
    void testGradeIsDouble() {
    }

    @Test
    void testPositiveValues() {
    }

}