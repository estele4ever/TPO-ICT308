import java.sql.Date;

public class Consultation {
    public String diagnostic;
    public String traitement ;
    public Date date;
    public String observation;

    public Consultation(String diagnostic, String traitement, Date date, String observation) {
        this.diagnostic = diagnostic;
        this.traitement = traitement;
        this.date = date;
        observation = observation;
    }
}
