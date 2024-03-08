package studentdetails.online_student_information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080

@RestController
public class studentinfoController {

    @Autowired
    studentinfoService service;

    @GetMapping("/")
    public void run() {
        System.out.println(" welcome to online student registration project...!");
    }

    @PostMapping("/create")
    public String creation(@RequestBody studentinfoEntity studentdetails) {
        return service.makecreate(studentdetails).getStudentName() + " has been added in your database";
    }

}
