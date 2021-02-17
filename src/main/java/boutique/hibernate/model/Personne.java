package boutique.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne")
    private int idPersonne;

    @Column(name = "login")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "prenom")
    private String prenomPersonne;

    @Column(name = "nom")
    private String nomPersonne;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "date_inscription")
    private Date dateInscription;

    @Column(name = "est_client")
    private int estClient;

    @Column(name = "est_administrateur")
    private int estAdmin;

    public Personne() {
    }

    public Personne(int idPersonne, String email, String password, String prenomPersonne, String nomPersonne, Date dateNaissance, Date dateInscription, int estClient, int estAdmin) {
        this.idPersonne = idPersonne;
        this.email = email;
        this.password = password;
        this.prenomPersonne = prenomPersonne;
        this.nomPersonne = nomPersonne;
        this.dateNaissance = dateNaissance;
        this.dateInscription = dateInscription;
        this.estClient = estClient;
        this.estAdmin = estAdmin;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idPersonne=" + idPersonne +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", prenomPersonne='" + prenomPersonne + '\'' +
                ", nomPersonne='" + nomPersonne + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", dateInscription=" + dateInscription +
                ", estClient=" + estClient +
                ", estAdmin=" + estAdmin +
                '}';
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenomPersonne() {
        return prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public int getEstClient() {
        return estClient;
    }

    public void setEstClient(int estClient) {
        this.estClient = estClient;
    }

    public int getEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(int estAdmin) {
        this.estAdmin = estAdmin;
    }
}
