package in.rj.main.services;

import java.util.List;
import java.util.Optional;

import in.rj.main.Entity.Artist;

public interface ArtistService 
{
	public Artist createArtist(Artist artist);
	public List<Artist> getAllArtists();
	public Optional<Artist> getArtistDetails(int id);
	public Artist updateArtistDetails(int id, Artist artist);
	public void deleteArtist(int id);
}
