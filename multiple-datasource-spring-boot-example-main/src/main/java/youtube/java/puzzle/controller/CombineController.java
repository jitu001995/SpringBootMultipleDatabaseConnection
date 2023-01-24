package youtube.java.puzzle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import youtube.java.puzzle.college.entity.College;
import youtube.java.puzzle.college.repository.CollegeRepository;
import youtube.java.puzzle.model.Response;
import youtube.java.puzzle.student.entity.Student;
import youtube.java.puzzle.student.repository.StudentRepository;

@Controller
@RequestMapping("/mul")
public class CombineController {

    @Autowired
    CollegeRepository collegeRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public Response getResponse(){
        Response response = new Response();
        
        response.setStudents(studentRepository.findAll());
        response.setColleges(collegeRepository.findAll());
        return response;
    }
    
    @GetMapping(value="/save")
    public String saveData() {
    	System.out.println("came");
    	Student std = new Student();
        std.setName("jitu");
        std.setAge("25");
        
        College clg=new College();
        clg.setName("ABC");
        clg.setLocation("Tumkur");
        studentRepository.save(std);
        collegeRepository.save(clg);
        return "success";
    }
}
