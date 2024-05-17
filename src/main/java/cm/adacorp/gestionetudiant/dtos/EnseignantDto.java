package cm.adacorp.gestionetudiant.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EnseignantDto {
    String nomEnseignant;
    String prenomEnseignant;
    int telephone;
    String adresse;
    String email;
    LocalDate dateNaissance;
    String LieuNaissance;
    int nbCours;
}
