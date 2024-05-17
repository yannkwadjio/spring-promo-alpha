package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.dtos.DepartementDto;
import cm.adacorp.gestionetudiant.entity.Departement;
import cm.adacorp.gestionetudiant.repository.DepartementRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartementService {
    DepartementRepo departementRepo;

    public DepartementService(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    public List<DepartementDto> getAllDepartement() {
        List<Departement> listDepartement = departementRepo.findAll();
        List<DepartementDto> listDepartementDTO = new ArrayList<>();
        for (Departement departement : listDepartement) {
            listDepartementDTO.add(new DepartementDto(departement.getNomDeparement(),
                    departement.getResponsableDepartement(),
                    departement.getNbreEnseignant(),
                    departement.getNbreEtudiant(),
                    departement.getFiliere(),
                    departement.getTelephone(),
                    departement.getEmail()
            ));
        }

        return listDepartementDTO;
    }

    public Departement createDepartement(Departement departement) {
        return departementRepo.save(departement);
    }


    public String deleteDepartement(UUID codeDepartement) {
        Departement dep = departementRepo.findById(codeDepartement)
                .orElseThrow(() -> new RuntimeException("Erreur departement introuvable dans la BD !"));
        departementRepo.deleteById(codeDepartement);
        return "Suppression effectué avec succès";
    }


    public List<Departement> listDepartement(UUID codeDepartement) {

        return departementRepo.findAllById(Collections.singleton(codeDepartement));
    }


    public Departement updateDepartement(UUID codeDep, Departement departement) {
        Departement existDepartement=departementRepo.findById(codeDep)
                .orElseThrow(()->new RuntimeException("Departement non trouvé"));

        existDepartement.setNomDeparement(departement.getNomDeparement());
        existDepartement.setResponsableDepartement(departement.getResponsableDepartement());
        existDepartement.setNbreEnseignant(departement.getNbreEnseignant());
        existDepartement.setNbreEtudiant(departement.getNbreEtudiant());
        existDepartement.setFiliere(departement.getFiliere());
        existDepartement.setTelephone(departement.getTelephone());
        existDepartement.setEmail(departement.getEmail());

        return departementRepo.save(existDepartement);
    }



}
