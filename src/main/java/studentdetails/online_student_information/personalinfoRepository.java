package studentdetails.online_student_information;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personalinfoRepository extends JpaRepository<personalinfoEntity, String> {

}
