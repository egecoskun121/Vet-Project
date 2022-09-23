package egecoskun121.vetproject.controller;


import egecoskun121.vetproject.model.DTO.OwnerDTO;
import egecoskun121.vetproject.model.DTO.PetDTO;
import egecoskun121.vetproject.model.entity.Owner;
import egecoskun121.vetproject.model.entity.Pet;
import egecoskun121.vetproject.model.mapper.PetMapper;
import egecoskun121.vetproject.repository.PetRepository;
import egecoskun121.vetproject.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    private PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;

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

    //-***************************************************************************-//

    @GetMapping("/showList")
    public ModelAndView showPetList(){
        ModelAndView mav = new ModelAndView("list-pets");
        mav.addObject("pets", petService.getAllPets());
        return mav;
    }

    @GetMapping("/showPetUpdateForm")
    public ModelAndView showPetUpdateForm(@RequestParam Long id){
        ModelAndView mav = new ModelAndView("update-pet-form");
        Pet pet = petService.getById(id);
        mav.addObject("pet",pet);
        return mav;
    }


    @GetMapping("/addPetForm")
    public ModelAndView createNewPetForm(){
        ModelAndView mav = new ModelAndView("create-pet-form");
        Pet pet = new Pet();
        mav.addObject("pet",pet);
        return mav;
    }

    @PostMapping("/savePet")
    public ModelAndView savePet(@ModelAttribute PetDTO petDTO){
        petService.create(petDTO);
        ModelAndView mav = new ModelAndView("list-pets");
        mav.addObject("pets", petService.getAllPets());
        return mav;
    }

    @RequestMapping(path = "/updatePetForm/{id}")
    public ModelAndView updatePetForm(@PathVariable("id") Long id,@ModelAttribute PetDTO petDTO){
        petService.updatePet(id,petDTO);
        ModelAndView mav = new ModelAndView("list-pets");
        mav.addObject("pets", petService.getAllPets());
        return mav;
    }

    @RequestMapping(path = "/deletePetForm")
    public ModelAndView deletePetForm(@RequestParam Long id){
        petService.delete(id);
        ModelAndView mav = new ModelAndView("list-pets");
        mav.addObject("pets", petService.getAllPets());
        return mav;
    }
}
