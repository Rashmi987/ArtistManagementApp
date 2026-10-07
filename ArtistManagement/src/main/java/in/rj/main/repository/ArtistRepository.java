package in.rj.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rj.main.Entity.Artist;
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>
{

}
