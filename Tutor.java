public class Tutor extends Teacher
{
    // instance variables - replace the example below with your own
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;

    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus
            ,int workingHours, double salary, String specialization, String academicQualifications,int performanceIndex, boolean isCertified)
    {
        super(teacherId, teacherName,address, workingType,employmentStatus);
        super.setWorkingHours(workingHours);
        this.salary=salary;
        this.specialization=specialization;
        this.academicQualifications=academicQualifications;
        this.performanceIndex=performanceIndex;
        this.isCertified=false;
    }

    public double getSalary(){
        return salary;
    }

    public String getSpecialization(){
        return specialization;
    }

    public String getAcademicQualifications(){
        return academicQualifications;
    }

    public int getPerformanceIndex(){
        return performanceIndex;
    }

    public boolean isCertified(){
        return isCertified;
    }

    public void setSalary(double newSalary, int newPerformanceIndex){

        if(newPerformanceIndex>5 && super.getWorkingHours()>20){
            if(newPerformanceIndex>5 && this.performanceIndex<7){
                this.salary=newSalary+(0.05*salary);
            }
            else if(newPerformanceIndex>8 && this.performanceIndex<9)
            {
                this.salary=newSalary+(0.1*salary);
            }
            else if(newPerformanceIndex>10){
                this.salary=newSalary+(0.2*salary);
            }
            this.isCertified=true;
        }else{
            System.out.println("Salalry cannot be approved");
        }
    }

    public void removeTutor(){
        if(isCertified==false){
            this.salary=0;
            this.specialization="";
            this.academicQualifications="";
            this.performanceIndex=0;
            this.isCertified=false;
        }
    }

    public void display(){
        if(!isCertified){
            super.display();
        }
        else{
            super.display();
            System.out.println("Salary"+" "+this.salary);
            System.out.println("Specialization"+" "+this.specialization);
            System.out.println("Academic"+" "+this.academicQualifications);
            System.out.println("performanceindex"+" "+this.performanceIndex);

        }
    }
}