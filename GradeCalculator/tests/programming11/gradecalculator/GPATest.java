package programming11.gradecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GPATest {

    private GPA gPA;

    @BeforeEach
    void setUp() {
        gPA = new GPA("Final Exam", 4.0, 100.00);
    }


    @Test
    void testAssignmentIsThere() {
        //check if assignment is there.
        assertEquals(gPA.getGPAAssignment(), "Final Exam");
        assertFalse(gPA.getGPAAssignment().contains("midterm"));
        gPA.setGPAAssignment("midterm");
        assertEquals(gPA.getGPAAssignment(), "midterm");
    }

    @Test
    void testGradeIsGPA() {
        assertEquals(String.valueOf(gPA.getGPAGrade()), "4.0");
        assertNotEquals(3.0, gPA.getGPAGrade(), 0.0);
        gPA.setGPAGrade(3.0);
        assertEquals(gPA.getGPAGrade(), 3.0);

    }

    @Test
    void testPositiveValues() {
        double grade = gPA.getGPAGrade();
        double weight = gPA.getGPAWeight();
        if (Double.compare(weight, 0.0) < 0 || Double.compare(grade, 0.0) < 0) {
            System.out.println("Negative");
        }
    }
}