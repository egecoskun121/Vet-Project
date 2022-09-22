package egecoskun121.vetproject.controller;


import egecoskun121.vetproject.model.DTO.PetDTO;
import egecoskun121.vetproject.model.entity.Pet;
import egecoskun121.vetproject.model.mapper.PetMapper;
import egecoskun121.vetproject.repository.PetRepository;
import egecoskun121.vetproject.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    private PetService petService;
    private PetRepository petRepository;

    public PetController(PetService petService, PetRepository petRepository) {
        this.petService = petService;
        this.petRepository = petRepository;
    }

    @GetMapping("/all")
    public ResponseEntity getAllPets(){
        List<Pet> allPets = petService.getAllPets();

        return ResponseEntity.ok(allPets);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody PetDTO petDTO,@PathVariable("id")Long id){
        Pet pet = petService.updatePet(id, petDTO);

        return ResponseEntity.ok("Related pet updated succesfully");
    }



    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable("id")Long id){
        Pet byId = petService.getById(id);

        return ResponseEntity.ok(byId);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody PetDTO petDTO){
        Pet pet = petService.create(petDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")Long id){
        petService.delete(id);
        return ResponseEntity.ok("Related pet deleted succesfully.");
    }
}
