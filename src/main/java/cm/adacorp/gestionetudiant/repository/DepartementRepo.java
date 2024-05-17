package cm.adacorp.gestionetudiant.repository;

import cm.adacorp.gestionetudiant.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartementRepo extends JpaRepository<Departement, UUID> {
}
