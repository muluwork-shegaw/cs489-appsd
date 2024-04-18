package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role getRoleById(Long id);
    void deleteRole(Long id);
}
