import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
    /*
     * Une des classes les plus importantes, c'est ici que se définies les
     * fonctions permettant l'enregistrement et l'ouverture des dessins.
     * Cette classe représente un chevalet.
     */
    static private String nomDessin;

    private Color currentColor;
    private String currentFigureName;
    private Figure currentFig;

    private Point pos1, pos2; // Les points de débuts et de fin de la figure.

    static private ArrayList<Figure> listFig = new ArrayList<Figure>();

    private JOptionPane erreurFichierVide; // En cas d'ouverture d'un fichier vide

    static protected boolean saved; // Indique si le dessin a été sauvegardé
    // Départ à true et mise à false dès le premier changement, et tout ceux qui suivent
    // Remise à true à chaque sauvegarde.

    public Drawing() {
        nomDessin = "DefaultName.txt";
        saved = true;

        this.setBackground(Color.WHITE);

        this.currentColor = Color.BLACK;
        this.currentFigureName = "rectangle";
        this.currentFig = null;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void setColor(Color c) {
        this.currentColor = c;
    }

    public Color getColor() {
        /*
         * Ajoutée pour pouvoir actualiser en direct les changements de couleurs.
         */
        return this.currentColor;
    }

    public void setFigure(String f) {
        this.currentFigureName = f;
    }

    public void paintComponent(Graphics g) {
        /*
         * Affiche une à une toutes les figures de la liste, à chaque appel.
         */
        super.paintComponent(g);
        //if (!listFig.isEmpty()) {
        for(Figure fig : listFig) {
            if(fig != null) {
                fig.draw(g);
            }
        }
        //}
    }


    public void mouseEntered(MouseEvent me) {}

    public void mouseExited(MouseEvent me) {}

    public void mouseMoved(MouseEvent e) {}

    public void mousePressed(MouseEvent me) {
        // On ancre un point en appuyant...
        this.pos1 = new Point(me.getX(), me.getY());
        listFig.add(null); 	// (Ajoute un élément null qui sera remplacé au fur et
        // mesure lors de l'étirage ("mouseDragged").)
    }

    public void mouseDragged(MouseEvent me) {
        listFig.remove(listFig.size()-1); // (Retire le dernier élément pour le modifier)
        this.pos2 = new Point(me.getX(), me.getY());
        // ...Et un second point provisoire en glissant...

        int largeur = Math.abs(pos2.x - pos1.x);
        int hauteur = Math.abs(pos2.y - pos1.y);

        if (this.currentFigureName.equals("rectangle")) {
            currentFig = new Rectangle(largeur,hauteur,currentColor);
        } else if (this.currentFigureName.equals("square")) {
            currentFig = new Square(largeur,hauteur,currentColor);
        } else if (this.currentFigureName.equals("ellipse")) {
            currentFig = new Ellipse(largeur,hauteur,currentColor);
        } else {
            currentFig = new Circle(largeur,hauteur,currentColor);
        }

        currentFig.setPoint(new Point(Math.min(pos1.x, pos2.x), Math.min(pos1.y, pos2.y)));

        listFig.add(currentFig);
        this.repaint();
        // (il n'a servit que le temps de l'affichage)
    }

    public void mouseReleased(MouseEvent me) {
        /* ...Et on fixe le second point en relachant.
         * mouseDragged a déjà configuré la figure comme il faut à l'entrée dans cette fonction.
         * Il ne reste plus qu'à placer la variable saved à false.
         */

        saved = false;
    }

    public void mouseClicked(MouseEvent me) {}


    public void viderFigures() { // Ajoutée pour la commande "New".
        listFig.clear();
        this.repaint();
    }

    static public boolean isSaved() {
        return saved;
    }

    static public String getNomDessin() {
        return nomDessin;
    }
    static public void setNomDessin(String newNomDessin) {
        nomDessin = newNomDessin;
    }

    public ArrayList<Figure> getList(){
        return listFig;
    }


    static public void save(String nomFichier) {
        try {

            FileOutputStream fos = new FileOutputStream(nomFichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(listFig.size()); // Utile pour l'ouverture du fichier.
            for(Figure fig : listFig) {
                oos.writeObject(fig);
            }

            oos.close();
            fos.close();

            nomDessin = nomFichier;
            saved = true;

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void open(String nomFichier) {

        ArrayList<Figure> listeDesFigures = new ArrayList<Figure>();
        int taille = 0; // Valeur arbitraire par défaut

        try {
            FileInputStream fis = new FileInputStream(nomFichier);
            ObjectInputStream ois = new ObjectInputStream(fis);

            taille = ois.readInt(); // Pour savoir combien de Figure il faut extraire

            for(int i = 0; i < taille; i++) {
                listeDesFigures.add((Figure) ois.readObject());
            }

            ois.close();
            fis.close();

            listFig = listeDesFigures;
            this.repaint();

            nomDessin = nomFichier;
            saved = false;

        } catch(Exception e) { 	// On envoit une fenêtre d'erreure si l'on tente d'ouvrir
            // un fichier vide.

            this.erreurFichierVide = new JOptionPane();
            JOptionPane.showInternalMessageDialog(this.erreurFichierVide,
                    "Erreur ! Vous tentez d'ouvrir un fichier vide ou inexistant.\n"
                            + "Utilisez la commande \"New\" du menu \"File\" pour créer\n"
                            + "un nouveau dessin.",
                    "Erreur !",JOptionPane.ERROR_MESSAGE);
        }
    }
}
