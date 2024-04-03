package pl.zajavka;

import lombok.Data;
import lombok.With;

@Data
@With
public class User {
    private String name;
    private String surname;
    private String email;
}
