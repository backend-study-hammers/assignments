package tobi.spring.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private String id;
    private String name;
    private String password;

    Level level;
    int login;
    int recommend;
    private String mail;

    public User(String id, String name, String password, Level level, int login, int recommend, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.login = login;
        this.recommend = recommend;
        this.mail = mail;
    }

    //Level의 순서를 userService가 알아야하는 이유는 없다.
    //또한 User에게 업그레이드 하라고 요청하는 편도 괜찮다.
    public void upgradeLevel() {
        Level nextLevel = this.level.nextLevel();

        if(nextLevel == null) {
            throw new IllegalStateException(this.level + "은 업그레이드가 불가능 합니다.");
        }
        else{
            this.level =nextLevel;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
