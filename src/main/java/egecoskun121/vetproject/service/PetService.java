package egecoskun121.vetproject.service;


import egecoskun121.vetproject.exception.PetNotFoundWithIdException;
import egecoskun121.vetproject.exception.PetNotFoundWithNameException;
import egecoskun121.vetproject.model.DTO.OwnerDTO;
import egecoskun121.vetproject.model.DTO.PetDTO;
import egecoskun121.vetproject.model.entity.Owner;
import egecoskun121.vetproject.model.entity.Pet;
import egecoskun121.vetproject.model.mapper.PetMapper;
import egecoskun121.vetproject.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets(){
        List<Pet> allPets = petRepository.findAll();
        return allPets;
    }

    public Pet getByName(String name){
        Optional<Pet> pet = petRepository.findByName(name);

        return pet.orElseThrow(()->{
            return new PetNotFoundWithNameException(name,"name");
        });
    }

    public Pet updatePet(Long id, PetDTO petDTO){
        Optional<Pet> byId= petRepository.findById(id);
        if(byId.isEmpty()){
            return null;
        }

        Pet updatedPet = byId.get();

        if(!StringUtils.isEmpty(petDTO.getAge())){
            updatedPet.setAge(petDTO.getAge());
        }
        if(!StringUtils.isEmpty(petDTO.getDescription())){
            updatedPet.setDescription(petDTO.getDescription());
        }
        if(!StringUtils.isEmpty(petDTO.getName())){
            updatedPet.setName(petDTO.getName());
        }


        return petRepository.save(updatedPet);
    }

    public Pet getById(Long id){
        Optional<Pet> byId= petRepository.findById(id);
        return byId.orElseThrow(()->{
            return new PetNotFoundWithIdException(id,"id");
        });
    }

    public Pet create(PetDTO petDTO){
        Pet pet = PetMapper.toEntity(petDTO);
        return petRepository.save(pet);
    }

    public void delete(Long id){
        petRepository.deleteById(id);
    }


}
