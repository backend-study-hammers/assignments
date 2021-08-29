package individual_project.profile.profile;

import javax.persistence.*;

@Entity
public class Profile {
    @Id
    @Column(name = "NAME")
    private String name;
    @Column(name = "UNIVERSITY")
    private String university;
    @Column(name = "MAJOR")
    private String major;
    @Column(name= "STUDENTID")
    private Long studentID;

    /*public Profile(String name, String university, String major, Long studentID){
        this.name= name;
        this.university= university;
        this.major= major;
        this.studentID= studentID;
    }
    */ //기본 생성자 넣어야함
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

    public void setStudentID(Long studentId) {
        this.studentID = studentId;
    }
}
