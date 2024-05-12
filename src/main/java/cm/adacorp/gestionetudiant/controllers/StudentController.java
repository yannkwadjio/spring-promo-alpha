package cm.adacorp.gestionetudiant.controllers;

import cm.adacorp.gestionetudiant.entity.Student;
import cm.adacorp.gestionetudiant.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {

    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Recuperer tous les etudiants de la Table student dans la BD
    @GetMapping("get-all") // GET http://localhost:8080/api/v1/students/get-all
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // Enregistrement d'un etudiant
    @PostMapping("create") // POST http://localhost:8080/api/v1/students/create
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
