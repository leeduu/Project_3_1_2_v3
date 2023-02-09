package Project_3_1_2_v3.Project_3_1_2_v3.service;

import Project_3_1_2_v3.Project_3_1_2_v3.dao.UserDao;
import Project_3_1_2_v3.Project_3_1_2_v3.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }

    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(Long id, User user){
        userDao.update(id, user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
