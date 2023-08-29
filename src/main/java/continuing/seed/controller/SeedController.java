package continuing.seed.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import continuing.seed.controller.model.SeedData;
import continuing.seed.controller.model.SeedData.RoleData;
import continuing.seed.service.SeedService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/continuing_seed")
@Slf4j
public class SeedController {
	
	@Autowired
	private SeedService seedService;
	
	@PostMapping("/seed")
	@ResponseStatus(code = HttpStatus.CREATED)
	public SeedData createSeed(@RequestBody SeedData seedData) {
		log.info("Creating seed {}", seedData);
		return seedService.saveSeed(seedData);
	}

	@GetMapping("/seed/{seedId}")
	public SeedData retrieveSeed(@PathVariable Long seedId) {
		log.info("Retrieving seed with ID= {}", seedId);
		return seedService.retrieveSeedById(seedId);
	}
	
	@GetMapping("/seed")
	public List<SeedData> retrieveAllSeeds() {
		log.info("Retrieving all seeds.");
		return seedService.retrieveAllSeeds();
	}
	
	@PutMapping("/seed/{seedId}")
	public SeedData updateSeed(@PathVariable Long seedId,
			@RequestBody SeedData seedData) {
		seedData.setSeedId(seedId);
		log.info("Updating seed {}", seedData);
		return seedService.saveSeed(seedData);
	}
	
	@DeleteMapping("/seed/{seedId}")
	public Map<String, String> deleteSeed(@PathVariable Long seedId) {
		log.info("Deleting seed with ID = {}", seedId);
		seedService.deleteSeedById(seedId);
		
		return Map.of("message", "Seed with ID="
		+ seedId + "was deleted successfully.");
	}
	
	@PostMapping("/seed/{seedId}/role")
	public RoleData createRole(@PathVariable Long seedId, @RequestBody RoleData roleData) {
		log.info("Creating role {} in seed with ID = {}", roleData, seedId);
		return seedService.saveRole(seedId, roleData);
	}
	
	@DeleteMapping("genre/{genreId}")
	public Map<String, String> deleteGenre(@PathVariable Long genreId) {
		log.info("Deleting genre with ID = {}", genreId);
		seedService.deleteGenre(genreId);
		
		return Map.of("message", "Genre with Id=" + genreId + " was deleted successfully.");
	}
}
