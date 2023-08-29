package continuing.seed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import continuing.seed.entity.Genre;

public interface GenreDao extends JpaRepository<Genre, Long> {

}
