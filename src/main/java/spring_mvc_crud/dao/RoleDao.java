package spring_mvc_crud.dao;

import spring_mvc_crud.models.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();
    Role getRoleById(Long id);
}
