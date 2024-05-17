package cm.adacorp.gestionetudiant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filiere {
    @Id
    @GeneratedValue
    int id;
    String nomFiliere;
    String codeFiliere;
    int nbCours;
    int nbreEtudiant;
    int nbreEnseignant;

}
