package egecoskun121.vetproject.model.DTO;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
