package cm.adacorp.gestionetudiant.repository;

import cm.adacorp.gestionetudiant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Student findByMatricule(String matricule);
}
