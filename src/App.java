import business.Departement;
import business.Joueur;
import business.Region;
import business.Ville;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class App {

    private static List<String> prenoms = new ArrayList<>();

    private static List<Joueur> joueurs = new ArrayList<>();
    private static List<Ville> villes = new ArrayList<>();
    private static Set<Departement> departements = new HashSet<>();
    private static Set<Region> regions = new HashSet<>();

    private static void ajouterPrenoms() {
        prenoms.add("Mathieu");
        prenoms.add("Rhady");
        prenoms.add("Alex");
        prenoms.add("Benamar");
        prenoms.add("PL");
        prenoms.add("Lucas");
        prenoms.add("Joseph");
        prenoms.add("Cédric");
        prenoms.add("Dasha");
        prenoms.add("Victorien");
        prenoms.add("Léa");
        prenoms.add(0, "Coraline");
        prenoms.add(1, "Eloi");
        prenoms.add("Alex");
        prenoms.add("Yanis");
    }

    public static void main(String[] args) throws Exception {
        // 1) On importe les villes, les départements et les régions
        importerVilles();
        // 2) On ajoute 15 prénoms dans la liste des prénoms
        ajouterPrenoms();
        // 3) On ajoute 4 joueurs
        // ajouterJoueur();
        // afficheJoueur();
        // ex comment importer les regions et les departements via class regions
        // (getters/setters)
        // Region region = new Region("AURA");
        // region.getNom();
        // region.getDepartements();

        // 5) On demande a l'utilisateur de remplir sa grille

        // On definit la ville ou le joueur reside.
        // une liste de tous les joueurs qui resident dans cette ville

        // écrire une méthode qui affiche toutes les villes qui ont des joueurs avec
        // pour chaque ville :

        System.out.println(recupererVilles("69001"));

        Joueur joueur1 = new Joueur("TOTO");
        joueur1.setPrenom("Sophie");
        joueur1.setGrille(remplirTableauAleatoirement());

        Joueur joueur2 = new Joueur("TITI", LocalDate.of(2000, 1, 1));
        System.out.println(joueur2);

        Joueur utilisateur1 = new Joueur();
        utilisateur1.setGrille(saisirGrille());

        ajouterJoueurs(1000);

        afficheVillesEtSesJoueurs();

    }

    // methode pour donner des grilles à tous les joueurs generés dans la methode
    // precedantes
    private static void GrillePourChaqueJoueur() {
        // ajouter une grille a chaque joueur
        for (Joueur joueur : joueurs) {
            joueur.setGrille(remplirTableauAleatoirement());
        }

    }

    // ajoute un joueur avec un prénom choisi aléatoirement dans la liste des
    // prénoms

    /**
     * 
     * @return
     *         private static void ajouterJoueur() {
     *         joueurs.add(0, new Joueur("Dasha"));
     *         joueurs.add(1, new Joueur("PL"));
     *         joueurs.add(new Joueur("FX"));
     *         joueurs.add(new Joueur("Victorien"));
     *         }
     */

    private static void ajouterJoueurs(int nbJoueursAAjouter) {
        Random random = new Random();
        for (int i = 0; i < nbJoueursAAjouter; i++) {
            String unPrenomAuHasard = prenoms.get(random.nextInt(prenoms.size()));
            Joueur joueur = new Joueur(unPrenomAuHasard);
            joueur.setVille(villes.get(random.nextInt(villes.size())));
            joueurs.add(joueur);
        }

        System.out.println("Nombre de joueurs : " + joueurs.size());
        // System.out.println("Le premier joueur est : " + joueurs.get(0));
        // tous les joueurs
        // System.out.println("Les joueurs : " + joueurs);
    }

    private static void afficheJoueur() {

        for (Joueur joueur : joueurs) {
            System.out.println(joueur);
        }
    }

    private static int[] remplirTableauAleatoirement() {
        int grille[] = new int[5];
        for (int i = 0; i < grille.length; i++) {
            Random random = new Random();
            grille[i] = random.nextInt(100);
        }
        return grille;
    }

    // demander utilisteur de remplir sa grille
    private static int[] saisirGrille() {
        int grille[] = new int[5];
        System.out.println("Replissez la grille de loto");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < grille.length; i++) {
            System.out.println("Saisissez un chiffre");
            int response = scanner.nextInt();
            grille[i] = response;
        }
        scanner.close();

        System.out.println("Voici vos numeros : " + Arrays.toString(grille));
        return grille;
    }

    int[] grilleGagnante = remplirTableauAleatoirement();

    private static boolean compareGrilles(int[] saisirGrille, int[] grilleGagnante) {
        Arrays.sort(grilleGagnante);
        for (int i = 0; i < saisirGrille.length; i++) {
            Arrays.sort(saisirGrille);
            if (saisirGrille[i] != grilleGagnante[i]) {
                return false;
            }
        }
        return true;
    }

    private static void importerVilles() {

        try {
            URI uri = new URI("https://www.data.gouv.fr/fr/datasets/r/dbe8a621-a9c4-4bc3-9cae-be1699c5ff25");
            URL url = URL.of(uri, null);

            InputStream inputStream = url.openStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            // isr.
            // File file = new File("data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // public static data() = new InputStream​.readAllBytes​();
            // System.out.println(data);

            String ligne = null;
            // On lit la première ligne (qui correspond à l'entête)
            // Cette ligne ne va pas nous servir
            reader.readLine();

            while ((ligne = reader.readLine()) != null) {
                // System.out.println(ligne);
                String elements[] = ligne.split(",");

                // apres avoir l'acces a la lecture (met read), nous creons des objets
                Ville ville = new Ville();
                ville.setNom(elements[1]);
                ville.setCodePostal(elements[2]);
                ville.setCodeInsee(elements[1]);
                if (!elements[5].isEmpty() && !elements[6].isEmpty()) {
                    ville.setLatitude(Double.parseDouble(elements[5]));
                    ville.setLongitude(Double.parseDouble(elements[6]));
                }
                // On ajoute la ville à la liste des villes
                villes.add(ville);

                Region region = null;

                if (elements.length >= 14) {
                    region = new Region(elements[14]);
                    System.out.println(region);
                    Departement departement = new Departement(elements[12], elements[11], region);
                    departements.add(departement);
                    System.out.println(departement);
                    regions.add(region);
                    System.out.println(departement);
                    ville.setDepartement(departement);
                }

            }

        } catch (MalformedURLException e) {
            System.out.println("URL incorrecte");
            // On décide d'arrêter l'application
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Problème réseau");
            // En cas de panne réseau, nous allons arriver ici
            System.exit(-1);
        } catch (URISyntaxException e) {
            System.out.println("Verifiez le lien");
            System.exit(-1);
        }

        System.out.println("Nombre de villes : " + villes.size());
        System.out.println("Nombre de départements : " + departements.size());
        System.out.println("Nombre de régions : " + regions.size());

    }

    // prend en paramètre un code postal et qui renvoie la liste des villes
    // associées à ce code postal
    private static List<Ville> recupererVilles(String codePostal) {
        // les ingredients
        // On declare une liste locale de villes
        List<Ville> villesCorrespondantes = new ArrayList<>();

        // algo
        // on parcours la liste des villes
        // et pour chaque ville on regarde si sont code postale est egale a celui en
        // param
        // On parcours toutes les villes avec la boucles foreach
        for (Ville ville : villes) {
            // on compare le code postal en parametre avec le codes existants a l'aide de la
            // methode get
            if (codePostal.equals(ville.getCodePostal())) {
                // on affiche le nom de la ville a l'aide de methode nom
                // on rajoute la ville dans la memoire (villesCorrespondates)
                villesCorrespondantes.add(ville);
            }
        }
        // retour des villes (toutes données)
        return villesCorrespondantes;
    }

    // méthode qui affiche toutes les villes qui ont des joueurs avec
    public static void afficheVillesEtSesJoueurs() {
        for (Ville ville : villes) {
            System.out.println("Nom de ville : " + ville.getNom());
            System.out.println("Nombre de joueurs : " + ville.getJoueurs().size());
        }
    }
}
