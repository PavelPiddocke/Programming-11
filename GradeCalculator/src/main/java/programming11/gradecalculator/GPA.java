package programming11.gradecalculator;
import java.util.Scanner;

public class GPA {

    //Requires:
    //Modifies:
    //Effects:

    // declare assignment, grade and weight for the letter class
    private String gPAAssignment;
    private Double gPAGrade = 0.00;
    private Double gPAWeight = 0.00;

    //Constructors

    public GPA(String assign, Double grd, Double wt){

        gPAAssignment = assign;
        gPAGrade = grd;
        gPAWeight = wt;

    }

    public String getGPAAssignment() {
        return gPAAssignment;
    }

    public void setGPAAssignment(String gPAAssignment) {
        this.gPAAssignment = gPAAssignment;
    }

    public Double getGPAGrade() {
        return gPAGrade;
    }

    public void setGPAGrade(Double gPAGrade) {
        this.gPAGrade = gPAGrade;
    }

    public Double getGPAWeight() {
        return gPAWeight;
    }

    public void setGPAWeight(Double gPAWeight) {
        this.gPAWeight = gPAWeight;
    }
}
