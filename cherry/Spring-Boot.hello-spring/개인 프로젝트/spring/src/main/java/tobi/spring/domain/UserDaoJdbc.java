package tobi.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import tobi.spring.exception.DuplicateUserIdException;
import tobi.spring.sql.SqlService;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbc implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoJdbc() {
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private SqlService sqlService;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userMapper= new RowMapper<User>() {

        @Override
        public User mapRow(ResultSet rs, int arg1) throws SQLException {
            // TODO Auto-generated method stub
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setLevel(Level.valueOf(rs.getInt("level")));
            user.setLogin(rs.getInt("login"));
            user.setRecommend(rs.getInt("recommend"));
            user.setMail(rs.getString("email"));

            return user;
        }
    };

    @Override
    public void add( final User user) {

        this.jdbcTemplate.update(this.sqlService.getSql("userAdd"),
                user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getMail());

    }

    @Override
    public User get(String id) {

        return this.jdbcTemplate.queryForObject( this.sqlService.getSql("userGet"), new Object[] {id}, this.userMapper);
    }

    @Override
    public void deleteAll() {
        this.jdbcTemplate.update(this.sqlService.getSql("userDeleteAll"));
    }

    @Override
    public int getCount() {

        return this.jdbcTemplate.queryForInt( this.sqlService.getSql("userGetCount"));

    }

    @Override
    public List<User> getAll(){

        return this.jdbcTemplate.query(this.sqlService.getSql("userGetAll"), this.userMapper);
    }

    @Override
    public int update(User user) {
        // TODO Auto-generated method stub
        return this.jdbcTemplate.update(this.sqlService.getSql("userUpdate")
                , user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getMail(), user.getId());
    }


}
