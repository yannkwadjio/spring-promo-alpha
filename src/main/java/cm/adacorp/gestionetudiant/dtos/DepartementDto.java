package cm.adacorp.gestionetudiant.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    String nom;
    String responsable;
    int nbreEnseignant;
    int nbreEtudiant;
    String filiere;
    int Telephone;
    String email;
}
