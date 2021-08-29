package tobi.spring.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UserTest {
    User user = new User("aa", "AA", "p1", Level.BASIC, 0, 0, "asd");

    @Test
    public void upgradeLevel() {

        user.upgradeLevel();
        assertThat(user.getLevel(), is(Level.SILVER));
        user.upgradeLevel();
        assertThat(user.getLevel(), is(Level.GOLD));
    }

    @Test(expected = IllegalStateException.class)
    public void upgradeLevelException() {

        user.setLevel(Level.GOLD);

        user.upgradeLevel();
    }
}
