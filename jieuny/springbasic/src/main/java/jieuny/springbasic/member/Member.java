package jieuny.springbasic.member;

public class Member {
    String name;
    Grade grade;
    Long id;

    public Member(String name, Grade grade, Long id){
        this.name=name;
        this.grade=grade;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
