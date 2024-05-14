package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.dtos.DepartementDto;
import cm.adacorp.gestionetudiant.entity.Departement;
import cm.adacorp.gestionetudiant.repository.DepartementRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartementService {
    private final DepartementRepo departementRepo;

    public DepartementService(DepartementRepo departementRepo) {
        this.departementRepo = departementRepo;
    }

    public List<DepartementDto> getAllDepartement() {
        List<Departement> listDepartement = departementRepo.findAll();
        List<DepartementDto> listDepartementDTO = new ArrayList<>();
        for (Departement departement : listDepartement) {
            listDepartementDTO.add(new DepartementDto(departement.getNom(),
                    departement.getResponsable(),
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
        try {
            Optional<Departement> existingDepartement = departementRepo.findById(codeDep);
            if (existingDepartement.isPresent()) {
                Departement depToUpdate = existingDepartement.get();
                depToUpdate.setNom(departement.getNom());
                depToUpdate.setResponsable(departement.getResponsable());
                depToUpdate.setNbreEtudiant(departement.getNbreEtudiant());
                depToUpdate.setNbreEnseignant(departement.getNbreEnseignant());
                depToUpdate.setFiliere(departement.getFiliere());
                depToUpdate.setTelephone(departement.getTelephone());
                depToUpdate.setEmail(departement.getEmail());
                // Continue with other fields to update...
                return departementRepo.save(depToUpdate);
            } else {
                throw new RuntimeException("Departement not found with id " + codeDep);
            }
        } catch (Exception e) {
            // Log the exception and rethrow it or handle it accordingly
            e.printStackTrace();
            throw new RuntimeException("Failed to update departement", e);
        }
    }

}
