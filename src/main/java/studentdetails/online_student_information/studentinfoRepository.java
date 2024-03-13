package studentdetails.online_student_information;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface studentinfoRepository extends JpaRepository<studentinfoEntity, String> {

    // hql-hibernate query language
    public List<studentinfoEntity> findByStudentClassadvisor(String ca);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE studentinformation stu SET stu.student_department=?EEE where stu.student_classadvisor=:userchoose", nativeQuery = true)
    public void updateByStudentClassadvisor(String userchoose);
}
