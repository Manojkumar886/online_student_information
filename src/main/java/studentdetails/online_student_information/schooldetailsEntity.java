package studentdetails.online_student_information;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class schooldetailsEntity {
    @Id
    private String emailid;
    // SSLC
    private int sslcregisterno;
    private String sslcmediumofinstruction;
    private int sslcyearofcompletion;
    private String sslcschoolname;
    private int sslccertificateno;
    private int sslctotalmark;
    private double sslcpercentage;
    private String sslcsubjectname1;
    private int sslcsubjectmark1;
    private String sslcsubjectname2;
    private int sslcsubjectmark2;
    private String sslcsubjectname3;
    private int sslcsubjectmark3;
    // HSC
    private int hsccregisterno;
    private String hscmediumofinstruction;
    private int hscyearofcompletion;
    private String hscschoolname;
    private int hsccertificateno;
    private int hsctotalmark;
    private double hscpercentage;
    private String hscsubjectname1;
    private int hscsubjectmark1;
    private String hscsubjectname2;
    private int hscsubjectmark2;
    private String hscsubjectname3;
    private int hscsubjectmark3;
    // DIPLOMA
    private int dipcregisterno;
    private String dipmediumofinstruction;
    private int dipyearofcompletion;
    private String dipschoolname;
    private int dipcertificateno;
    private int diptotalmark;
    private double dippercentage;
    private String dipsubjectname1;
    private int dipsubjectmark1;
    private String dipsubjectname2;
    private int dipsubjectmark2;
    private String dipsubjectname3;
    private int dipsubjectmark3;
    // CONNECT
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_username")
    private studentinfoEntity studentdetails;

}
