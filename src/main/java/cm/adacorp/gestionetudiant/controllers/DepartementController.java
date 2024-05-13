package cm.adacorp.gestionetudiant.controllers;

import cm.adacorp.gestionetudiant.entity.Departement;
import cm.adacorp.gestionetudiant.services.DepartementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Departement")
public class DepartementController {
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("get-all")
    public List<Departement> getAllDepartement(Departement departement){
        return departementService.getAllDepartement();
    }

    @PutMapping("create")
    public Departement createDepartement(@RequestBody Departement departement){
        return departementService.createDepartement(departement);
    }
}
