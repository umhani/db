package areeba.dbassignment.proj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    StudentRepo repo;

    @GetMapping("")
    public Collection<Student> getall(){

        return repo.findAll();
    }

    @PostMapping("/add")
    public String postMethodName(@RequestBody Student student) {
        
        repo.save(student);
        return "Student saved as " + student.getName();
    }

    @PostMapping("/addmany")
    public String postMethodName(@RequestBody Collection<Student> student) {
        
        repo.saveAll(student);
        return student.size() + "Students saved";
    }
    
}
