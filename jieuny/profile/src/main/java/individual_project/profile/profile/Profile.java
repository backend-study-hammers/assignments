package individual_project.profile.profile;

public class Profile {
    String name;
    String university;
    String major;
    Long studentID;

    public Profile(String name, String university, String major, Long studentID){
        this.name= name;
        this.university= university;
        this.major= major;
        this.studentID= studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }


}
