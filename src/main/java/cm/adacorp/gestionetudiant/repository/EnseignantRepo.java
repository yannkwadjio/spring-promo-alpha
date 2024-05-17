package cm.adacorp.gestionetudiant.repository;

import cm.adacorp.gestionetudiant.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepo extends JpaRepository<Enseignant,Integer> {
}
