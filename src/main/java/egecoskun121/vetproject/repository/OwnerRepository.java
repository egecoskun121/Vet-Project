package egecoskun121.vetproject.repository;

import egecoskun121.vetproject.model.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Optional<Owner> findByFirstName(String firstName);
}
