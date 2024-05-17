package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.dtos.EnseignantDto;
import cm.adacorp.gestionetudiant.entity.Enseignant;
import cm.adacorp.gestionetudiant.repository.EnseignantRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantService {
    EnseignantRepo enseignantRepo;

    public EnseignantService(EnseignantRepo enseignantRepo) {
        this.enseignantRepo = enseignantRepo;
    }

    public Enseignant createEnseignant(Enseignant enseignant) {
        return enseignantRepo.save(enseignant);
    }

    public List<Enseignant> getListenseignant() {
        return enseignantRepo.findAll();
    }


    public EnseignantDto getEnseigantById(int idEnseignant) {
        Enseignant existingEnseignant=enseignantRepo.findById(idEnseignant)
                .orElseThrow(()->new RuntimeException("Enseignant introuvable"));
        return new EnseignantDto(
                existingEnseignant.getNomEnseignant(),
                existingEnseignant.getPrenomEnseignant(),
                existingEnseignant.getTelephone(),
                existingEnseignant.getAdresse(),
                existingEnseignant.getEmail(),
                existingEnseignant.getDateNaissance(),
                existingEnseignant.getLieuNaissance(),
                existingEnseignant.getNbCours()
        );
    }

    public void deleteEnseignantById(int idEnseignant, String statut) {
        if(enseignantRepo.existsById(idEnseignant)){
            statut="ok";
            enseignantRepo.deleteById(idEnseignant);
    }
    }

    public Enseignant updateEnseignant(int idEnseignant, Enseignant enseignant) {
        Enseignant existingEnseignant=enseignantRepo.findById(idEnseignant)
                .orElseThrow(()->new RuntimeException("Enseignant introuvable"));
        existingEnseignant.setNomEnseignant(enseignant.getNomEnseignant());
        existingEnseignant.setPrenomEnseignant(enseignant.getPrenomEnseignant());
        existingEnseignant.setTelephone(enseignant.getTelephone());
        existingEnseignant.setAdresse(enseignant.getAdresse());
        existingEnseignant.setEmail(enseignant.getEmail());
        existingEnseignant.setDateNaissance(enseignant.getDateNaissance());
        existingEnseignant.setLieuNaissance(enseignant.getLieuNaissance());
        existingEnseignant.setNbCours(enseignant.getNbCours());
        return enseignantRepo.save(existingEnseignant);
    }
}
