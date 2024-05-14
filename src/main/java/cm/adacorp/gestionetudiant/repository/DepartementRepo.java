package cm.adacorp.gestionetudiant.repository;

import cm.adacorp.gestionetudiant.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DepartementRepo extends JpaRepository<Departement, UUID> {
    Departement findByNom(String nom);
}
