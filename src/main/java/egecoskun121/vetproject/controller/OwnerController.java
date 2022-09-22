package egecoskun121.vetproject.controller;


import egecoskun121.vetproject.model.DTO.OwnerDTO;
import egecoskun121.vetproject.model.entity.Owner;
import egecoskun121.vetproject.model.mapper.OwnerMapper;
import egecoskun121.vetproject.repository.OwnerRepository;
import egecoskun121.vetproject.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    private OwnerService ownerService;
    private OwnerRepository ownerRepository;

    public OwnerController(OwnerService ownerService, OwnerRepository ownerRepository) {
        this.ownerService = ownerService;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/all")
    public ResponseEntity getAllOwners(){
        List<Owner> allOwners = ownerService.getAllOwners();
        return ResponseEntity.ok(allOwners);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOwnerById(@PathVariable("id") Long id){
        Owner owner = ownerService.getById(id);

        return ResponseEntity.ok(owner);
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OwnerDTO ownerDTO){
        Owner owner = ownerService.create(ownerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(owner);
    }

    @GetMapping("/showList")
    public ModelAndView showCustomer(){
        ModelAndView mav = new ModelAndView("list-owners");
        List<Owner> allOwners = ownerService.getAllOwners();
        mav.addObject("owners", allOwners);
        return mav;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody OwnerDTO ownerDTO,@PathVariable("id")Long id){
        Owner owner = ownerService.updateOwner(id, ownerDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Related owner updated succesfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(name="id")Long id){
        ownerService.delete(id);

        return ResponseEntity.ok("Related owner deleted succesfully");
    }

}
