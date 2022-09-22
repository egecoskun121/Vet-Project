package egecoskun121.vetproject.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "owner")
@RequiredArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;

    @OneToMany(fetch = LAZY,mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Pet> pet;




}
