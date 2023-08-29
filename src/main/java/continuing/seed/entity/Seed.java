package continuing.seed.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seedId;
	
	@EqualsAndHashCode.Exclude
	private String seedName;
	
	@EqualsAndHashCode.Exclude
	private String seedText;
	
	@OneToMany(mappedBy = "seed", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Role> roles = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "seed_genre",
			joinColumns = @JoinColumn(name = "seed_id"),
			inverseJoinColumns = @JoinColumn(name = "genre_id")
			)
	private Set<Genre> genres = new HashSet<>();

}
