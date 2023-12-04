package semestarovka.models;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class User {
    private String Full_Name;
    private String Username;
    private String Email;
    private String Password;
    private String Gender;
    private String ProfilePicture;

    public boolean isAdmin() {
        return false;
    }
}