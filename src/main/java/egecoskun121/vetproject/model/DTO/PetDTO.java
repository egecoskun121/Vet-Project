package egecoskun121.vetproject.model.DTO;

import egecoskun121.vetproject.model.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private String genus;
    private Type type;
    private String name;
    private int age;
    private String description;

}
