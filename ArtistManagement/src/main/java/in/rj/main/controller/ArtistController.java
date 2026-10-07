package in.rj.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rj.main.Entity.Artist;
import in.rj.main.services.ArtistService;

@RestController
public class ArtistController 
{
	@Autowired
	private ArtistService artistService;
	
	@PostMapping("/artist")
	public Artist addArtist(@RequestBody Artist artist)
	{
		return artistService.createArtist(artist);
	}
	
	@GetMapping("/artist")
	public List<Artist> getAllArtistsDetails()
	{
		return artistService.getAllArtists();
	}
	
	@GetMapping("/artist/{id}")
	public ResponseEntity<Artist> getArtistDetails(@PathVariable int id)
	{
		Artist artist = artistService.getArtistDetails(id).orElse(null);
		if(artist != null)
		{
			return ResponseEntity.ok().body(artist);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/artist/{id}")
	public ResponseEntity<Artist> updateArtist(@PathVariable int id, @RequestBody Artist artist)
	{
		Artist updated_artist = artistService.updateArtistDetails(id, artist);
		if(updated_artist != null)
		{
			return ResponseEntity.ok().body(updated_artist);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("/artist/{id}")
	public ResponseEntity<Void> deleteArtistDetail(@PathVariable int id)
	{
		artistService.deleteArtist(id);
		return ResponseEntity.noContent().build();
	}
}
