package cm.adacorp.gestionetudiant.controllers;

import cm.adacorp.gestionetudiant.dtos.DepartementDto;
import cm.adacorp.gestionetudiant.entity.Departement;
import cm.adacorp.gestionetudiant.services.DepartementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/departement")
public class DepartementController {
    DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("get-all")
    public List<DepartementDto> getAllDepartement(Departement departement) {
        return departementService.getAllDepartement();
    }

    @PostMapping("create")
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementService.createDepartement(departement);
    }

    @DeleteMapping("{id}")
    public String deleteDepartement(@PathVariable("id") UUID codeDepartement) {
        departementService.deleteDepartement(codeDepartement);
        return "suppression effectuée avec succès";
    }

    @GetMapping("{id}")
    public List<Departement> listDepartement(@PathVariable("id") UUID codeDepartement) {
        return departementService.listDepartement(codeDepartement);
    }


    @PutMapping("{id}")
    public Departement updateDepartement(@PathVariable("id") UUID codeDep, @RequestBody Departement departement) {

        return departementService.updateDepartement(codeDep, departement);
    }


}
