package egecoskun121.vetproject.model.mapper;

import egecoskun121.vetproject.model.DTO.PetDTO;
import egecoskun121.vetproject.model.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PetMapper {

    public static PetDTO toDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setType(pet.getType());
        petDTO.setAge(pet.getAge());
        petDTO.setDescription(pet.getDescription());
        petDTO.setGenus(pet.getGenus());
        petDTO.setName(pet.getName());

        return petDTO;
    }

    public static Pet toEntity(PetDTO petDTO){
        Pet pet = new Pet();

        pet.setAge(petDTO.getAge());
        pet.setDescription(petDTO.getDescription());
        pet.setGenus(petDTO.getGenus());
        pet.setName(petDTO.getName());
        pet.setType(petDTO.getType());

        return pet;
    }

}
