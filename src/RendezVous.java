import java.sql.Date;

public class RendezVous {
    public Patient patient;
    public Utilisateur utilisateur;
    public Date date;
    public String motif;
    public boolean etat;

    public RendezVous(Patient patient, Utilisateur utilisateur, Date date, String motif, boolean etat) {
        this.patient = patient;
        this.utilisateur = utilisateur;
        this.date = date;
        this.motif = motif;
        this.etat = etat;
    }
}
