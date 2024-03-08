package studentdetails.online_student_information;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentinfoService {
    @Autowired
    studentinfoRepository repo;

    public studentinfoEntity makecreate(studentinfoEntity studentdetails) {
        return repo.save(studentdetails);
    }
}
