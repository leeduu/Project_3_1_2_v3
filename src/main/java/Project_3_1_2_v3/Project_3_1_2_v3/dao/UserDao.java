package Project_3_1_2_v3.Project_3_1_2_v3.dao;

import Project_3_1_2_v3.Project_3_1_2_v3.models.User;

import java.util.List;

public interface UserDao {

    List<User> showUsers();
    User showUser(Long id);
    void save(User user);
    void update(Long id, User user);
    void delete(Long id);
}
