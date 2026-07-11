public class Student {
    private String studentId;
    private String studentName;
    private double cgpa;
    private String placementStatus;
    public Student(String studentId, String studentName,double cgpa, String placementStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.cgpa = cgpa;
        this.placementStatus = placementStatus;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    public String getPlacementStatus() {
        return placementStatus;
    }
    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }
}
public class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}
public class PlacementReport {
     public String evaluatePlacementEligibility(double cgpa) throws InvalidStudentException  {
       if (cgpa >= 8.0 && cgpa <= 10.0)   {
           return "HIGHLY ELIGIBLE";
       } else if (cgpa >= 6.5 && cgpa < 8.0) {
           return "ELIGIBLE";
       } else if (cgpa >= 5.0 && cgpa < 6.5) {
           return "MARGINAL ELIGIBILITY";
       } else  {
           throw new InvalidStudentException("CGPA is not valid for placement eligibility");
       }
    }
}
