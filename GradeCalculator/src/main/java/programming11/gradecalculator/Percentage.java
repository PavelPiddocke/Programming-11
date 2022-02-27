package programming11.gradecalculator;

public class Percentage {



   // Class to convert entered values to percentage
        private String assignment;
        private Double grade = 0.00;
        private Double weight = 0.00;

    //Constructors

    public Percentage(String assign, Double grd, Double wt){

        assignment = assign;
        grade = grd;
        weight = wt;

    }

    public Percentage(Percentage selectedItem) {
    }

    //getters and setters

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
