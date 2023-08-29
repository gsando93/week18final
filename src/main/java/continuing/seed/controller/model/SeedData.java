package continuing.seed.controller.model;

import java.util.HashSet;
import java.util.Set;

import continuing.seed.entity.Genre;
import continuing.seed.entity.Role;
import continuing.seed.entity.Seed;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeedData {
	private Long seedId;
	private String seedName;
	private String seedText;
	private Set<RoleData> roles = new HashSet<>();
	private Set<GenreData> genres = new HashSet<>();

	public SeedData(Seed seed) {
		this.seedId = seed.getSeedId();
		this.seedName = seed.getSeedName();
		this.seedText = seed.getSeedText();
		
		for(Role role : seed.getRoles()) {
			this.roles.add(new RoleData(role));
		}
		
		for(Genre genre : seed.getGenres()) {
			this.genres.add(new GenreData(genre));
		}
	}
	
	public SeedData(Long seedId, String seedName, String seedText) {
		this.seedId = seedId;
		this.seedName = seedName;
		this.seedText = seedText;
	}
	
	public Seed toSeed() {
		Seed seed = new Seed();
		
		seed.setSeedId(seedId);
		seed.setSeedName(seedName);
		seed.setSeedText(seedText);
		
		for(RoleData roleData : roles) {
			seed.getRoles().add(roleData.toRole());
		}
		
		for(GenreData genreData : genres) {
			seed.getGenres().add(genreData.toGenre());
		}
		
		return seed;
	}
	
	@Data
	@NoArgsConstructor
	public static class RoleData {
		private Long roleId;
		private String roleName;
		private String primaryTrait;
		
		public RoleData(Role role) {
			this.roleId = role.getRoleId();
			this.roleName = role.getRoleName();
			this.primaryTrait = role.getPrimaryTrait();
		}
		
		public Role toRole() {
			Role role = new Role();
			
			role.setRoleId(roleId);
			role.setRoleName(roleName);
			role.setPrimaryTrait(primaryTrait);
			
			return role;
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class GenreData {
		private Long genreId;
		private String genreName;
		
		public GenreData(Genre genre) {
			this.genreId = genre.getGenreId();
			this.genreName = genre.getGenreName();
			
		}
		
		public Genre toGenre() {
			Genre genre = new Genre();
			
			genre.setGenreId(genreId);
			genre.setGenreName(genreName);
			
			return genre;
		}
	}
}
