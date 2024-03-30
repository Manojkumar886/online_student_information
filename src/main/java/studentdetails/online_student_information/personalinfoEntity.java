package studentdetails.online_student_information;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personalinformation")
public class personalinfoEntity {
    // Personal information
    private String gender;
    private Date dateofbirth;
    private String nationality;
    private String religion;
    private String community;
    private String caste;
    private String mothertongue;
    private String languageknowns;
    private String permanentaddress;
    private String addressforcommunication;
    private Long mobileno;
    @Id
    private String emailid;
    private Long aadharcardno;
    private Long pancardno;
    private String identificationmark;
    private String bloodgroup;
    private String passportavilable;
    // parent details
    private String fathername;
    private String fatherqualifications;
    private String fatheroccupation;
    private Long fathercontactno;
    private String mothername;
    private String motherqualifications;
    private String motheroccupation;
    private Long mothercontactno;
    private int noofbrotherelder;
    private int noofbrotheryounger;
    private int noofsisterelder;
    private int noofsisteryounger;
    // Guardian Details
    private String guardianname;
    private Long guardianmobileno;
    private String guardianaddress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_username")
    @Nullable
    private studentinfoEntity studentdetails;

}
