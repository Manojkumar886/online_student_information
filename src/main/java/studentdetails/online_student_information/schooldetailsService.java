package studentdetails.online_student_information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class schooldetailsService {
    @Autowired
    schooldetailsRepository srepo;

    public schooldetailsEntity createschooldetails(schooldetailsEntity schooldetails) {
        return srepo.save(schooldetails);
    }

    public schooldetailsEntity makereadone(String mailid) {
        return srepo.findById(mailid).orElse(new schooldetailsEntity());
    }

}
