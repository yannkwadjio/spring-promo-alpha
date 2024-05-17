package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.dtos.FiliereDto;
import cm.adacorp.gestionetudiant.entity.Filiere;
import cm.adacorp.gestionetudiant.repository.FiliereRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {
    FiliereRepo filiereRepo;

    public FiliereService(FiliereRepo filiereRepo) {
        this.filiereRepo = filiereRepo;
    }

    public Filiere createFiliere(Filiere filiere) {
        return filiereRepo.save(filiere);
    }

    public List<Filiere> getListfiliere() {
        return filiereRepo.findAll();
    }


    public FiliereDto getFiliereById(int idFiliere) {
        Filiere existingFiliere=filiereRepo.findById(idFiliere)
                .orElseThrow(()->new RuntimeException("Filière introuvable"));
        return new FiliereDto(
                existingFiliere.getNomFiliere(),
        existingFiliere.getCodeFiliere(),
                existingFiliere.getNbCours(),
                existingFiliere.getNbreEtudiant(),
                existingFiliere.getNbreEnseignant()
        );
    }

    public void deleteFiliereById(int idFiliere) {
        if(filiereRepo.existsById(idFiliere)){
            filiereRepo.deleteById(idFiliere);
        }
    }

    public Filiere updateFiliere(int idFiliere, Filiere filiere) {
       Filiere existingFiliere=filiereRepo.findById(idFiliere)
               .orElseThrow(()->new RuntimeException("Filière introuvable"));
        existingFiliere.setNomFiliere(filiere.getNomFiliere());
        existingFiliere.setCodeFiliere(filiere.getCodeFiliere());
        existingFiliere.setNbCours(filiere.getNbCours());
        existingFiliere.setNbreEnseignant(filiere.getNbreEnseignant());
        existingFiliere.setNbreEtudiant(filiere.getNbreEtudiant());

        return filiereRepo.save(existingFiliere);
    }
}
