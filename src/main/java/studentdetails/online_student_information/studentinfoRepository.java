package studentdetails.online_student_information;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentinfoRepository extends JpaRepository<studentinfoEntity, String> {

    // hql-hibernate query language
    public List<studentinfoEntity> findByStudentClassadvisor(String ca);

}
