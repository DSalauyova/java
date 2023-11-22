package business;

import java.util.Objects;

public class Departement {

    // Attributs
    private String code;
    private String nom;
    private Region region;

    // Constructeur(s)
    public Departement(String code, String nom) {
        super();
        this.code = code;
        this.nom = nom;
    }

    public Departement(String code, String nom, Region region) {
        this((code), nom);
        this.region = region;
    }

    // Getters/Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, nom, region);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Departement other = (Departement) obj;
        return Objects.equals(code, other.code) && Objects.equals(nom, other.nom)
                && Objects.equals(region, other.region);
    }

    @Override
    public String toString() {
        return "Departement [code=" + code + ", nom=" + nom + ", region=" + region + "]";
    }

}