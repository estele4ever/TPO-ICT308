import java.util.Date;

public class Patient {

    public Patient(String nom, Date dateNaiss, boolean sexe, int numeroDossier ){
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.numeroDossier = numeroDossier;

    }

    private String nom;
    private String prenom;
    private Date dateNaiss;
    private boolean sexe;
    private int numeroDossier;

    public String getNom() {
            return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isSexe() {
        return sexe;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public int getNumeroDossier() {
        return numeroDossier;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public void setNumeroDossier(int numeroDossier) {
        this.numeroDossier = numeroDossier;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

}
