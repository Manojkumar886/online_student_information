package studentdetails.online_student_information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

// http://localhost:8080/myproject

@RestController
@RequestMapping("/myproject")
@CrossOrigin(origins = "http://localhost:3000")
public class studentinfoController {

    @Autowired
    studentinfoService service;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public void run() {
        System.out.println(" welcome to online student registration project...!");
    }

    @PostMapping("/create")
    public String creation(@RequestBody studentinfoEntity studentdetails) {
        // studentdetails.password(manojkumar)
        String temp = encoder.encode(studentdetails.getPassword()); // manojkmar--$jdhdidhdhuhu7875675hdhgd52
        studentdetails.setPassword(temp);
        return service.makecreate(studentdetails).getStudentName() + " has been added in your database";
    }

    @GetMapping("/get/{emailid}")
    public studentinfoEntity callAllByAcc(@PathVariable("emailid") String emailid) {
        studentinfoEntity t = service.gettingByNumberExact(emailid);
        return t;
    }

    @GetMapping("/list")
    public List<studentinfoEntity> listall() {
        return service.makeall();
    }

    @GetMapping("/readone/{mailid}")
    public studentinfoEntity readone(@PathVariable("mailid") String mailid) {
        return service.makereadone(mailid);
    }

    @DeleteMapping("/delete/{mailid}")
    public String deleteone(@PathVariable("mailid") String mailid) {
        return service.remove(mailid) + "";
    }

    @PutMapping("/update")
    public String updating(@RequestBody studentinfoEntity studentdetails) {

        return service.makecreate(studentdetails).getStudentRegistrationno() + "has been updated successfully";
    }

    @GetMapping("/findbyca/{CA}")
    public List<studentinfoEntity> findbyCA(@PathVariable("CA") String CA) {
        return service.findbyCA(CA);
    }

    @PutMapping("/updatedept/{newdept}")
    public void putMethodName(@PathVariable("newdept") String newdept) {
        service.updatedepartmentbyclassadvisor(newdept);
    }

    @GetMapping("/{user}")
    public studentinfoEntity purpose(@PathVariable("user") String user) {
        studentinfoEntity student = (studentinfoEntity) service.loadUserByUsername(user);
        return student;
    }

    // Personal Details REST APIS
    @Autowired
    personalinfoService pserv;

    @PostMapping("/createpersonal")
    public personalinfoEntity createperPersonalinfoEntity(@RequestBody personalinfoEntity personaldetails) {
        System.out.println(personaldetails);
        pserv.createpersonal(personaldetails);
        return personaldetails;
    }

    @PutMapping("/updatepersonal")
    public personalinfoEntity updatepPersonalinfoEntity(@RequestBody personalinfoEntity personaldetails) {
        return pserv.createpersonal(personaldetails);
    }

    @GetMapping("/readonepersonalinfo/{mailid}")
    public personalinfoEntity readonepersonalinfo(@PathVariable("mailid") String mailid) {
        return pserv.makereadone(mailid);
    }

    // SCHOOL DETAILS REST APIS
    @Autowired
    schooldetailsService sserv;

    @PostMapping("/createschool")
    public schooldetailsEntity createschooldetails(@RequestBody schooldetailsEntity schooldetails) {
        System.out.println(schooldetails);
        sserv.createschooldetails(schooldetails);
        return schooldetails;
    }

    @PutMapping("/updateschool")
    public schooldetailsEntity updatepschooldetails(@RequestBody schooldetailsEntity schooldetailsEntity) {
        return sserv.createschooldetails(schooldetailsEntity);
    }

    @GetMapping("/readschoolinfo/{mailid}")
    public schooldetailsEntity readoneschoolinfo(@PathVariable("mailid") String mailid) {
        return sserv.makereadone(mailid);
    }
}
