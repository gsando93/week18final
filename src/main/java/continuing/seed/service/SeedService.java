package continuing.seed.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import continuing.seed.controller.model.SeedData;
import continuing.seed.controller.model.SeedData.RoleData;
import continuing.seed.dao.GenreDao;
import continuing.seed.dao.RoleDao;
import continuing.seed.dao.SeedDao;
import continuing.seed.entity.Genre;
import continuing.seed.entity.Role;
import continuing.seed.entity.Seed;

@Service
public class SeedService {
	
	@Autowired
	private SeedDao seedDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private GenreDao genreDao;

	@Transactional(readOnly = false)
	public SeedData saveSeed(SeedData seedData) {
		Seed seed = seedData.toSeed(); 
		Seed dbSeed = seedDao.save(seed);
		
		return new SeedData(dbSeed);
	}

	@Transactional(readOnly = true)
	public SeedData retrieveSeedById(Long seedId) {
		Seed seed = findSeedById(seedId);
		return new SeedData(seed);
	}

	private Seed findSeedById(Long seedId) {
		return seedDao.findById(seedId).orElseThrow(() -> 
		new NoSuchElementException("Seed with ID=" + seedId + " was not found."));
	}

	@Transactional(readOnly = true)
	public List<SeedData> retrieveAllSeeds() {
		
		// @formatter:off
		return seedDao.findAll()
				.stream()
				.map(SeedData::new)
				.toList();
		// @formatter:on
	}

	@Transactional(readOnly = false)
	public void deleteSeedById(Long seedId) {
		Seed seed = findSeedById(seedId);
		seedDao.delete(seed);
	}

	@Transactional(readOnly = false)
	public RoleData saveRole(Long seedId, RoleData roleData) {
		Seed seed = findSeedById(seedId);
		Role role = roleData.toRole();
		role.setSeed(seed);
		seed.getRoles().add(role);
		Role dbRole = roleDao.save(role);
		
		return new RoleData(dbRole);
	}

	@Transactional(readOnly = false)
	public void deleteGenre(Long genreId) {
		Genre genre = findGenreById(genreId);
		genreDao.delete(genre);
	}

	private Genre findGenreById(Long genreId) {
		return genreDao.findById(genreId).orElseThrow(() -> new NoSuchElementException("genre with ID = " + genreId + " was not found."));
	}

}
