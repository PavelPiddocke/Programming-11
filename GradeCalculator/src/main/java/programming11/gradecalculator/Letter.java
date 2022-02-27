package programming11.gradecalculator;

public class Letter {

    //Requires:
    //Modifies:
    //Effects:

    // declare assignment, grade and weight for the letter class
    private String letAssignment;
    private String letGrade = "";
    private Double letWeight = 0.00;

    //Constructors

    public Letter(String assign, String grd, Double wt){

        letAssignment = assign;
        letGrade = grd;
        letWeight = wt;

    }

//getters and setters
    public String getLetAssignment() {
        return letAssignment;
    }

    public void setLetAssignment(String assignment) {
        this.letAssignment = assignment;
    }

    public String getLetGrade() {
        return letGrade;
    }

    public void setLetGrade(String grade) {
        this.letGrade = grade;
    }

    public Double getLetWeight() {
        return letWeight;
    }

    public void setLetWeight(Double weight) {
        this.letWeight = weight;
    }
}

