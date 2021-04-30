package spring_mvc_crud.service;

import spring_mvc_crud.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role getRoleById(Long id);
}
