package studentdetails.online_student_information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personalinfoService {

    @Autowired
    personalinfoRepository prepo;

    public personalinfoEntity createpersonal(personalinfoEntity personaldetails) {
        return prepo.save(personaldetails);
    }

    public personalinfoEntity makereadone(String mailid) {
        return prepo.findById(mailid).orElse(new personalinfoEntity());
    }

}
