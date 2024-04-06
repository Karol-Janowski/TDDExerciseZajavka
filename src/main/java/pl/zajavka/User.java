package pl.zajavka;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@With
@Builder
public class User implements Comparable<User>{
    private String name;
    private String surname;
    private String email;

    @Override
    public int compareTo(User o) {
        int result = (this.email.compareTo(o.email));

        return result;
    }
}
