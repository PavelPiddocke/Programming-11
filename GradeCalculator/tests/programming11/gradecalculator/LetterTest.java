package programming11.gradecalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LetterTest {

    private Letter letter;

    @BeforeEach
    void setUp() {
       letter = new Letter("Final Exam", "A", 100.00);
    }


    @Test
    void testAssignmentIsThere() {
        //check if assignment is there.
        assertEquals(letter.getLetAssignment(), "Final Exam");
        assertFalse(letter.getLetAssignment().contains("midterm"));
        letter.setLetAssignment("midterm");
    }
    @Test
    void testGradeIsGPA() {
        assertEquals(String.valueOf(letter.getLetGrade()), "A");
        assertNotEquals(letter.getLetGrade(), "B");
        letter.setLetGrade("B");
        assertEquals(letter.getLetGrade(), "B");

    }

    @Test
    void testPositiveValues() {

        double weight = letter.getLetWeight();
        if (Double.compare(weight, 0.0) < 0 ) {
            System.out.println("Negative");
        }
    }
}