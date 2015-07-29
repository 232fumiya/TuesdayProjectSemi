package UserRegister.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Created by KAJIWARAYutaka on 2015/05/09.
 */
@Data
public class updateForm {
    @NotNull
    @Size(min = 1,max= 128)
    private String name;
    @NotNull
    @Size(min = 1,max= 128)
    private String pass;
}
