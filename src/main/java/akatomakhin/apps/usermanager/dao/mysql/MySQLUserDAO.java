package akatomakhin.apps.usermanager.dao.mysql;

import akatomakhin.apps.usermanager.dao.UserDAO;
import akatomakhin.apps.usermanager.dao.mysql.entity.MySQLConnectionData;
import akatomakhin.apps.usermanager.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
@Repository
public class MySQLUserDAO implements UserDAO {
    /*
    * Create response to create some user
     * and prepare data to send to the server
     */
    public void createUser(User user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(new MySQLConnectionData()));
        jdbcTemplate.update("insert into users(user_name,user_age,user_employment,user_hoby) value (?,?,?,?)",user.getName(),user.getAge(),user.getEmployment(),user.getHoby());
    }

    /*
    * Create response to delete some user
     * and prepare data to send to the server
     */
    public void deleteUser(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(new MySQLConnectionData()));
        String insertQueryStatement = "delete from users where user_id = ?";
        jdbcTemplate.update(insertQueryStatement,id);
    }

    /*
    * Create response to update some user
     * and prepare data to send to the server
     */
    public void updateUser (User user) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(new MySQLConnectionData()));
        String insertQueryStatement = "update users" +
                " set user_name = ?, user_age = ?, user_employment = ?, user_hoby = ?" +
                " where user_id = ?";
        jdbcTemplate.update(insertQueryStatement,user.getName(),user.getAge(),user.getEmployment(),user.getHoby(),user.getId());
    }

    /*
    * Create request to get user data
     * and prepare data to send to the server
     */
    public User getUser(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(new MySQLConnectionData()));
        String insertQueryStatement = "SELECT user_id, user_name, user_age, user_employment, user_hoby" +
                " FROM users" +
                " where user_id = ?";
        User user = jdbcTemplate.queryForObject(insertQueryStatement,new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("user_name"));
                user.setAge(resultSet.getInt("user_age"));
                user.setEmployment(resultSet.getString("user_employment"));
                user.setHoby(resultSet.getString("user_hoby"));
                return user;
            }
        },id);
        return user;
    }

    /* statement for DB to get all users */
    public ArrayList<User> getAllUsers() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource(new MySQLConnectionData()));
        String insertQueryStatement = "SELECT * FROM users WHERE user_id IS NOT NULL";
        ArrayList<User> allUsers = jdbcTemplate.queryForObject(insertQueryStatement, new RowMapper<ArrayList<User>>() {
            public ArrayList<User> mapRow(ResultSet resultSet, int i) throws SQLException {
                ArrayList<User> userData = new ArrayList<User>();
                while (resultSet.next()){
                    User user = new User();
                    user.setId(resultSet.getInt("user_id"));
                    user.setName(resultSet.getString("user_name"));
                    user.setAge(resultSet.getInt("user_age"));
                    user.setEmployment(resultSet.getString("user_employment"));
                    user.setHoby(resultSet.getString("user_hoby"));
                    userData.add(user);
                }
                return userData;
            }
        });
        return allUsers;
    }


    private DriverManagerDataSource driverManagerDataSource(MySQLConnectionData connectionData) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(connectionData.getDriver());
        dataSource.setUrl(connectionData.getUrl());
        dataSource.setUsername(connectionData.getUser());
        dataSource.setPassword(connectionData.getPassword());
        return dataSource;
    }
}
