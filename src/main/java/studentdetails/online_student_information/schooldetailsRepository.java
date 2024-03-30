package studentdetails.online_student_information;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface schooldetailsRepository extends JpaRepository<schooldetailsEntity, String> {

}
