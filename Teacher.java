/**
 * Write a description of class Teacher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher
{
    private int teacherId;
    private int workingHours;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;


    public Teacher(int teacherId, String teacherName,
                   String address, String workingType, String employmentStatus){
        this.teacherName=teacherName;
        this.teacherId=teacherId;
        this.address=address;
        this.workingType=workingType;
        this.employmentStatus=employmentStatus;

    }


    public int getTeacherId(){
        return teacherId;
    }


    public String getTeacherName(){
        return teacherName;
    }


    public String getAddress(){
        return address;
    }


    public String getWorkingType(){
        return workingType;
    }



    public String getEmploymentStatus(){
        return employmentStatus;
    }

    public void setWorkingHours(int newWorkingHours){
        this.workingHours=newWorkingHours;
    }

    public int getWorkingHours(){
        return workingHours;
    }


    public void display() {

        if (workingHours == 0) {
            System.out.println(" working hour not added");
        } else {
            System.out.println("workingHours" + workingHours);
        }
        System.out.println("teacherId" +" "+ teacherId);
        System.out.println("teacherName"  +" "+  teacherName);
        System.out.println("address"  +" "+  address);
        System.out.println("workingType"  +" "+  workingType);
        //System.out.println("workinghours"+workingHours);
        System.out.println("employmentStatus"  +" "+  employmentStatus);
    }
}


