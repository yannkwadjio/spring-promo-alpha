package cm.adacorp.gestionetudiant.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private String prenom;
    private String nom;
    private String matricule;
    private String filiere;
    private String email;
    private String password;
    private String telephone;
}
