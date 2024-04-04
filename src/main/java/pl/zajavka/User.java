package pl.zajavka;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@With
@Builder
public class User {
    private String name;
    private String surname;
    private String email;
}
