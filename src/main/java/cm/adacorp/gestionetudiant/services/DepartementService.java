package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.entity.Departement;
import cm.adacorp.gestionetudiant.repository.DepartementRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    private final DepartementRepo departementRepo;

    public DepartementService(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    public List<Departement> getAllDepartement() {
        return departementRepo.findAll();
    }

    public Departement createDepartement(Departement departement) {
        return departementRepo.save(departement);
    }
}
