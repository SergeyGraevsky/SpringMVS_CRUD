package spring_mvc_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_mvc_crud.dao.RoleDaoImpl;
import spring_mvc_crud.dao.UserDaoImpl;
import spring_mvc_crud.models.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDaoImpl roleDao;

    @Autowired
    public RoleServiceImpl(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}
