package continuing.seed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import continuing.seed.entity.Seed;

public interface SeedDao extends JpaRepository<Seed, Long> {

}
