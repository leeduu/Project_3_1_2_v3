package Project_3_1_2_v3.Project_3_1_2_v3.dao;

import Project_3_1_2_v3.Project_3_1_2_v3.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        User userToUpdate = showUser(id);
        userToUpdate.setFirst_name(user.getFirst_name());
        userToUpdate.setLast_name(user.getLast_name());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setId(user.getId());
        entityManager.merge(userToUpdate);
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}
