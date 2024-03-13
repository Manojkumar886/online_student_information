package studentdetails.online_student_information;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentinfoService {
    @Autowired
    studentinfoRepository repo;

    public studentinfoEntity makecreate(studentinfoEntity studentdetails) {
        return repo.save(studentdetails);
    }

    public List<studentinfoEntity> makeall() {
        return repo.findAll();
    }

    public studentinfoEntity makereadone(String mailid) {
        return repo.findById(mailid).orElse(new studentinfoEntity());
    }

    public String remove(String mailid) {
        // repo.deleteById(mailid);
        studentinfoEntity temp = repo.findById(mailid).orElse(new studentinfoEntity());
        repo.delete(temp);
        return temp.getStudentName() + " has been deleted successfully";
    }

    public List<studentinfoEntity> findbyCA(String ca) {
        return repo.findByStudentClassadvisor(ca);
    }

    public void updatedepartmentbyclassadvisor(String dept) {
        repo.updateByStudentClassadvisor(dept);
    }
}
