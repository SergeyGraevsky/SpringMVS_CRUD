package spring_mvc_crud.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc_crud.models.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public Role getRoleById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.id =: id", Role.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select r from Role r ", Role.class).getResultList();
    }
}
