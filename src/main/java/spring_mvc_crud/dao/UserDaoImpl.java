package spring_mvc_crud.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc_crud.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User u where u.id =: id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =: id", User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String userName) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username =: name", User.class);
        query.setParameter("name", userName);
        return query.getResultList().stream().findAny().orElse(null);
    }

}
