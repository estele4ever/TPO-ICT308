public class Utilisateur
{
    public String nom;
    public String email;
    public String password;

    public String specialite;
    public boolean disponibilite;

    public Utilisateur(String nom, String specialite, boolean disponibilite) {
        this.nom = nom;
        this.specialite = specialite;
        this.disponibilite = disponibilite;
    }
    public Utilisateur(String nom,String email,String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;

}
}
