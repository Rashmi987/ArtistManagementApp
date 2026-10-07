package in.rj.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rj.main.Entity.Artist;
import in.rj.main.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService
{
	@Autowired
	private ArtistRepository artistRepository;
	
	@Override
	public Artist createArtist(Artist artist) 
	{
		return artistRepository.save(artist);
	}

	@Override
	public List<Artist> getAllArtists() 
	{
		return artistRepository.findAll();
	}

	@Override
	public Optional<Artist> getArtistDetails(int id) 
	{
		return artistRepository.findById(id);
	}

	@Override
	public Artist updateArtistDetails(int id, Artist artist) 
	{
		Artist artistData = artistRepository.findById(id).orElse(null);
		
		if(artistData != null)
		{
			return artistRepository.save(artist);
		}
		else 
		{
			throw new RuntimeException("Artist not found with id "+id);
		}
	}

	@Override
	public void deleteArtist(int id) 
	{
		artistRepository.deleteById(id);
	}
}
