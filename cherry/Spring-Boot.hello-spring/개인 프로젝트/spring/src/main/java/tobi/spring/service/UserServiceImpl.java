package tobi.spring.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import tobi.spring.domain.Level;
import tobi.spring.domain.User;
import tobi.spring.domain.UserDao;
import tobi.spring.domain.UserDaoJdbc;

import java.util.List;

@Setter
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    MailSender mailSender;

    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void setMailSender(MailSender mailSender2) {
        this.mailSender = mailSender2;
    }

    @Override
    public void add(User user) {
        // TODO Auto-generated method stub
        if(user.getLevel() == null) {user.setLevel(Level.BASIC);}

        userDao.add(user);
    }

    @Override
    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for(User user: users) {
            if(canUpgradeLevel(user)) {
                upgradeLevel(user);
            }
        }
    }

    private boolean canUpgradeLevel(User user) {

        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("Unknown Level: " + currentLevel);
        }
    }

    protected void upgradeLevel(User user) {
        user.upgradeLevel();
        userDao.update(user);
        sendUpgradeEmail(user);
    }

    private void sendUpgradeEmail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getMail());
        mailMessage.setFrom("useradmin@ksug.org");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText("사용자님의 등급이 " + user.getLevel().name() + "으로 변경되었습니다");

        this.mailSender.send(mailMessage);
    }
    @Override
    public User get(String id) {
        // TODO Auto-generated method stub
        return userDao.get(id);
    }
    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return userDao.getAll();
    }
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        userDao.deleteAll();
    }
    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        userDao.update(user);
    }
}