package business;

import java.util.ArrayList;
import java.util.List;

import business.Ville;

/*
 * Cette classe represente Ville
 */

public class Ville {
    private Long id;
    private String codeInsee;
    private String nom;
    private String codePostal;
    private double longitude;
    private double latitude;
    private String complement;
    // Une ville appartient à un et un seul département
    private Departement departement;
    private static Long compteur = 0L;
    // On déclare une liste de joueurs dans cette classe
    private List<Joueur> joueurs = new ArrayList<>();

    public Ville() {
        id = ++compteur;
    }

    /**
     * 
     * @param nom
     * @param codePostal
     */
    public Ville(String nom, String codePostal) {
        this();
        this.nom = nom;
        this.codePostal = codePostal;
    }

    /**
     * 
     * @param codeInsee
     * @param nom
     * @param codePostal
     */

    public Ville(String codeInsee, String nom, String codePostal) {
        this(nom, codePostal);
        this.codeInsee = codeInsee;
    }

    /**
     * 
     * @param id
     * @param codeInsee
     * @param nom
     * @param longitude
     * @param latitude
     * @param complement
     */
    public Ville(Long id, String codeInsee, String nom, double longitude, double latitude, String complement) {

        this(codeInsee, nom);
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public String getNom() {
        return nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getComplement() {
        return complement;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public static void setCompteur(Long compteur) {
        Ville.compteur = compteur;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + "]";
    }

}
