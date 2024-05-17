package cm.adacorp.gestionetudiant.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {
    String nomFiliere;
    String codeFiliere;
    int nbCours;
    int nbreEtudiant;
    int nbreEnseignant;
}
