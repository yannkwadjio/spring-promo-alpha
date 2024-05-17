package cm.adacorp.gestionetudiant.controllers;

import cm.adacorp.gestionetudiant.dtos.EnseignantDto;
import cm.adacorp.gestionetudiant.entity.Enseignant;
import cm.adacorp.gestionetudiant.services.EnseignantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher/")
public class EnseignantController {
    EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @PostMapping("create")
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.createEnseignant(enseignant);
    }

    @GetMapping("get-all")
    public List<Enseignant> getListenseignant(){
        return enseignantService.getListenseignant();
    }

    @GetMapping("{idEnseignant}")
    public EnseignantDto getEnseigantById(@PathVariable("idEnseignant") int idEnseignant){
        return enseignantService.getEnseigantById(idEnseignant);
    }

    @DeleteMapping("{idEnseignant}")
    public String deleteEnseignantById(@PathVariable("idEnseignant") int idEnseignant){
        enseignantService.deleteEnseignantById(idEnseignant);
        return "Suppression effectué avec succès";
    }

    @PutMapping("{idEnseignant}")
    public Enseignant updateEnseignant(@PathVariable("idEnseignant") int idEnseignant,@RequestBody Enseignant enseignant){
        return enseignantService.updateEnseignant(idEnseignant,enseignant);
    }
}
