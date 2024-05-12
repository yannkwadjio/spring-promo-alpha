package cm.adacorp.gestionetudiant.services;

import cm.adacorp.gestionetudiant.dtos.StudentDto;
import cm.adacorp.gestionetudiant.entity.Student;
import cm.adacorp.gestionetudiant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student student : studentList) {
            studentDtoList.add(new StudentDto(
                    student.getPrenom(),
                    student.getNom(),
                    student.getMatricule(),
                    student.getFiliere(),
                    student.getEmail(),
                    student.getPassword(),
                    student.getTelephone()));
        }

        return studentDtoList;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudentById(UUID studentId) {
        Student studentToBeDeleted = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Erreur etudiant introuvable dans la BD !"));

        studentRepository.deleteById(studentId);

        return "Etudiant avec ID : " + studentId + " supprimé avec succès !";
    }

    public Student getStudentByMatricule(String matricule) {

        return studentRepository.findByMatricule(matricule);
    }
}
