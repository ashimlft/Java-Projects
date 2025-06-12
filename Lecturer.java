/**
 * Write a description of class Lecturer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Lecturer extends Teacher
{
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    public Lecturer(int teacherId, String teacherName, String address,
                    String workingType, String employmentStatus,
                    int yearsOfExperience,  String department){
        super(teacherId, teacherName, address, workingType, employmentStatus);
        //super.setWorkingHours();
        this.department=department;
        this.yearsOfExperience=yearsOfExperience;
        this.gradedScore=0;
        this.hasGraded=false;
    }
    public String getDepartment() {
        return department;
    }

    public void setGradedScore(int gradedScore) {
        this.gradedScore = gradedScore;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getGradedScore() {
        return gradedScore;
    }

    public boolean isGraded() {
        return hasGraded;
    }
    public void gradeAssignment(int gradedScore,
                                String department,int yearsOfExperience){
        if(yearsOfExperience>=5 && this.department==department){
            if (gradedScore >= 70) {
                this.gradedScore = 70;
                System.out.println("A is obtained");
            } else if (gradedScore >= 60 && gradedScore<=70) {
                this.gradedScore = 60;
                System.out.println("B is obtained");
            } else if (gradedScore >= 50 && gradedScore<=60) {
                this.gradedScore = 50;
                System.out.println("C is obtained");
            } else if (gradedScore >= 40 && gradedScore<=50) {
                this.gradedScore = 40;
                System.out.println("D is obtained");
            }
            else{
                this.gradedScore = gradedScore;
                System.out.println("E is obtained");
            }
            hasGraded = true;
        } else {
            System.out.println("already graded the assignment!!");
        }
    }
    public void display() {
        super.display();  // Call the display method of the baseClass)
        System.out.println("Department"+ " "+department);
        System.out.println("Years of Experience" + " "+ yearsOfExperience);
        if (hasGraded) {
            System.out.println("Graded Score: " + gradedScore);
        } else {
            System.out.println("Assignments not yet graded.");
        }
    }
}
