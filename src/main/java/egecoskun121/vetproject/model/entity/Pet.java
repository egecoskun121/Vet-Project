package egecoskun121.vetproject.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="pet")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genus;
    private Type type;
    private String name;
    private short age;
    private String description;

    @NotNull
    @JoinColumn(name = "owner_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;

}
