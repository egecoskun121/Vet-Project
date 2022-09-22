package egecoskun121.vetproject.repository;

import egecoskun121.vetproject.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet,Long> {

    Optional<Pet> findByName(String name);

    @Query(value = "SELECT * FROM pet WHERE applicant.identification_number=:identificationNumber",nativeQuery = true)
    Long getApplicantByIdentificationNumber(@Param("identificationNumber") Long identificationNumber);
}
