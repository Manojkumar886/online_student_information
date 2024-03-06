package studentdetails.online_student_information;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentinformation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class studentinfoEntity {
    @Id
    @Column(name = "Emailid")
    private String username;
    private String password;
    private String confirmpassword;
    private String studentName;
    private int studentBatch;
    private String studentDegree;
    private String studentBranch;
    private int studentRegulation;
    private String studentRegistrationno;
    private Date studentDateofjoining;
    private String studentQuota;

}
