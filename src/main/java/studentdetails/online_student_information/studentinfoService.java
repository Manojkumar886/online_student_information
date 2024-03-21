package studentdetails.online_student_information;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class studentinfoService implements UserDetailsService {
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

    public studentinfoEntity gettingByNumberExact(String emailid) {
        return repo.findById(emailid).orElse(new studentinfoEntity());
    }

    // predefined no implement method (userdetailsservice interface class)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        studentinfoEntity studentdetails = repo.findByUsername(username);

        if (studentdetails == null) {
            throw new UnsupportedOperationException("username not found..please enter correct username..!");
        }
        ;
        return studentdetails;
    }
}
