package continuing.seed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import continuing.seed.entity.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
