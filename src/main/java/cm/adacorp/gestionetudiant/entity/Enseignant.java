package cm.adacorp.gestionetudiant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enseignant {
    @Id
    @GeneratedValue
    int id;
    String nomEnseignant;
    String prenomEnseignant;
    int telephone;
    String adresse;
    String email;
    LocalDate dateNaissance;
    String LieuNaissance;
    int nbCours;
}
