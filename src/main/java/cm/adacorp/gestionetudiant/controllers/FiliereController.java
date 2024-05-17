package cm.adacorp.gestionetudiant.controllers;

import cm.adacorp.gestionetudiant.dtos.FiliereDto;
import cm.adacorp.gestionetudiant.entity.Filiere;
import cm.adacorp.gestionetudiant.services.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filiere/")
public class FiliereController {
    FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @PostMapping("create")
public Filiere createFiliere(@RequestBody Filiere filiere){
        return filiereService.createFiliere(filiere);
    }

    @GetMapping("get-all")
    public List<Filiere> getListfiliere(){
        return filiereService.getListfiliere();
    }

    @GetMapping("{idFiliere}")
    public FiliereDto getFiliereById(@PathVariable("idFiliere") int idFiliere){
        return filiereService.getFiliereById(idFiliere);
    }

    @DeleteMapping("{idFiliere}")
    public String deleteFiliereById(@PathVariable("idFiliere") int idFiliere){
        filiereService.deleteFiliereById(idFiliere);
        return "Suppression effectué avec succès";
    }

    @PutMapping("{idFiliere}")
    public Filiere updateFiliere(@PathVariable("idFiliere") int idFiliere,Filiere filiere){
        return filiereService.updateFiliere(idFiliere,filiere);
    }
}
