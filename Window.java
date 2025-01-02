import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener{

    /*
     * La classe la plus grande, qui forme la fenêtre et sa multitude de composants.
     * Contient beaucoup de mise en place.
     */

    private final Container contentPanel;
    static public Drawing chevalet;
    private final JPanel outils;
    private final JPanel palette;
    private final JPanel shades_shapes;
    private JOptionPane info;


    private final PaletteButton col1;
    private final PaletteButton col2;
    private final PaletteButton col3;
    private final PaletteButton col4;
    private final PaletteButton col5;
    private final PaletteButton col6;
    private final PaletteButton col7;
    private final PaletteButton col8;
    private final PaletteButton col9;
    private final PaletteButton col10;
    private final PaletteButton col11;
    private final PaletteButton col12;
    private final PaletteButton col13;
    private final PaletteButton col14;
    private final PaletteButton col15;
    private final PaletteButton col16;
    private final PaletteButton col17;
    private final PaletteButton col18;
    private final PaletteButton col19;
    private final PaletteButton col20;

    private final ShapeButton shadePlus;
    private final ShapeButton shadeMinus;

    private final ShapeButton rectangle;
    private final ShapeButton square;
    private final ShapeButton ellipse;
    private final ShapeButton circle;

    private final JMenu menuFile;
    private final JMenu menuAPropos;
    private final JMenuItem ouvrir;
    private final JMenuItem sauvegarder;
    private final JMenuItem sauvegarderSous;
    private final JMenuItem quitter;
    private final JMenuItem aPropos;
    private final JMenuItem oeuf;

    private FenetreOpen fOpen;
    private FenetreSave fSaveAs;

    public Window() {
        this.setTitle("Peinture");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        contentPanel = this.getContentPane();

        // Définition de la "barre de menus", de ses "menus", et de leurs "items".
        // DÉBUT //////////////////////////////////////////////////////////////////

        JMenuBar barre = new JMenuBar();

        menuFile = new JMenu("File");
        menuAPropos = new JMenu("À propos");

        JMenuItem nouveau = new JMenuItem("New");
        ouvrir = new JMenuItem("Open");
        sauvegarder = new JMenuItem("Save");
        sauvegarderSous = new JMenuItem("SaveAs");
        quitter = new JMenuItem("Quit");

        aPropos = new JMenuItem("À propos du projet");
        oeuf = new JMenuItem("\"Œuf  de Pâques\"");

        menuFile.add(nouveau);
        menuFile.add(ouvrir);
        menuFile.add(sauvegarder);
        menuFile.add(sauvegarderSous);
        menuFile.add(quitter);

        menuAPropos.add(aPropos);
        menuAPropos.add(oeuf);

        barre.add(menuFile);
        barre.add(menuAPropos);

        // FIN ////////////////////////////////////////////////////////////////////


        // Initialisation de toutes les composantes de la fenêtre.
        // DÉBUT /////////////////////////////////////////////////

        col1 = new PaletteButton(Color.BLACK, "black");
        col2 = new PaletteButton(Color.DARK_GRAY, "dark_gray");
        col3 = new PaletteButton(new Color(158, 28, 98), "cardinal_red");
        col4 = new PaletteButton(Color.RED, "red");
        col5 = new PaletteButton(Color.ORANGE, "orange");
        col6 = new PaletteButton(Color.YELLOW, "yellow");
        col7 = new PaletteButton(Color.GREEN, "green");
        col8 = new PaletteButton(new Color(119, 191, 254), "sky_blue");
        col9 = new PaletteButton(new Color(110, 30, 250), "indigo");
        col10 = new PaletteButton(new Color(120, 15, 120), "purple");
        col11 = new PaletteButton(Color.WHITE, "white");
        col12 = new PaletteButton(Color.LIGHT_GRAY, "light_gray");
        col13 = new PaletteButton(new Color(179, 139, 109), "light_brown");
        col14 = new PaletteButton(Color.PINK, "pink");
        col15 = new PaletteButton(new Color(242, 196, 56), "ocre");
        col16 = new PaletteButton(new Color(240, 230, 190), "light_beige");
        col17 = new PaletteButton(new Color(52, 201, 36), "light_green");
        col18 = new PaletteButton(new Color(192, 223, 239), "light_blue");
        col19 = new PaletteButton(new Color(114, 147, 168), "gray_blue");
        col20 = new PaletteButton(new Color(176, 157, 185), "lavander");


        shadePlus = new ShapeButton("Graphismes\\PLUS.png", "plus");
        shadeMinus = new ShapeButton("Graphismes\\MOINS.png", "minus");

        rectangle = new ShapeButton("Graphismes\\RECTANGLE.png", "rectangle");
        square = new ShapeButton("Graphismes\\CARRE.png", "square");
        ellipse = new ShapeButton("Graphismes\\ELLIPSE.png", "ellipse");
        circle = new ShapeButton("Graphismes\\ROND.png", "circle");


        chevalet = new Drawing();

        // FIN ///////////////////////////////////////////////////


        // Pose des écouteurs.
        // DÉBUT ////////////

        col1.addActionListener(this);
        col2.addActionListener(this);
        col3.addActionListener(this);
        col4.addActionListener(this);
        col5.addActionListener(this);
        col6.addActionListener(this);
        col7.addActionListener(this);
        col8.addActionListener(this);
        col9.addActionListener(this);
        col10.addActionListener(this);
        col11.addActionListener(this);
        col12.addActionListener(this);
        col13.addActionListener(this);
        col14.addActionListener(this);
        col15.addActionListener(this);
        col16.addActionListener(this);
        col17.addActionListener(this);
        col18.addActionListener(this);
        col19.addActionListener(this);
        col20.addActionListener(this);

        shadePlus.addActionListener(this);
        shadeMinus.addActionListener(this);

        rectangle.addActionListener(this);
        square.addActionListener(this);
        ellipse.addActionListener(this);
        circle.addActionListener(this);

        // Les boutons des différents menus :
        nouveau.addActionListener(this);
        ouvrir.addActionListener(this);
        sauvegarder.addActionListener(this);
        sauvegarderSous.addActionListener(this);
        quitter.addActionListener(this);

        aPropos.addActionListener(this);
        oeuf.addActionListener(this);

        // FIN //////////////


        // Agencement des différentes composantes
        // DÉBUT ////////////////////////////////

        contentPanel.add(barre, BorderLayout.NORTH);

        outils = new JPanel(new GridLayout(3,1));
        palette = new JPanel(new GridLayout(5,4));
        shades_shapes = new JPanel(new GridLayout(3,2));

        // FIN //////////////////////////////////

        // Placement de toutes les composantes de la fenêtre.
        // DÉBUT ////////////////////////////////////////////

        ////// Pour la palette de couleurs (20 au total).
        palette.add(col1);
        palette.add(col2);
        palette.add(col12);
        palette.add(col11);
        palette.add(col10);
        palette.add(col3);
        palette.add(col14);
        palette.add(col20);
        palette.add(col9);
        palette.add(col19);
        palette.add(col8);
        palette.add(col18);
        palette.add(col7);
        palette.add(col17);
        palette.add(col13);
        palette.add(col4);
        palette.add(col5);
        palette.add(col15);
        palette.add(col6);
        palette.add(col16);

        ////// Pour changer les teintes (plus ou moins foncées).
        shades_shapes.add(shadePlus);
        shades_shapes.add(shadeMinus);

        ////// On regroupe les différentes formes disponibles.
        shades_shapes.add(rectangle);
        shades_shapes.add(square);
        shades_shapes.add(ellipse);
        shades_shapes.add(circle);

        ////// On place couleurs et formes dans notre Panneau outils.
        outils.add(palette);
        outils.add(shades_shapes);

        ////// On range enfin le tout dans notre conteneur global.
        contentPanel.add(barre, BorderLayout.NORTH);
        contentPanel.add(outils, BorderLayout.WEST);
        contentPanel.add(chevalet, BorderLayout.CENTER);

        // FIN //////////////////////////////////////////////

        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        /*
         * Gestion des cas pour les appuis de boutons.
         */
        String caller = e.getActionCommand();

        switch(caller) {
            case "black":
                chevalet.setColor(col1.getColor());
                break;
            case "dark_gray":
                chevalet.setColor(col2.getColor());
                break;
            case "cardinal_red":
                chevalet.setColor(col3.getColor());
                break;
            case "red":
                chevalet.setColor(col4.getColor());
                break;
            case "orange":
                chevalet.setColor(col5.getColor());
                break;
            case "yellow":
                chevalet.setColor(col6.getColor());
                break;
            case "green":
                chevalet.setColor(col7.getColor());
                break;
            case "sky_blue":
                chevalet.setColor(col8.getColor());
                break;
            case "indigo":
                chevalet.setColor(col9.getColor());
                break;
            case "purple":
                chevalet.setColor(col10.getColor());
                break;
            case "white":
                chevalet.setColor(col11.getColor());
                break;
            case "light_gray":
                chevalet.setColor(col12.getColor());
                break;
            case "light_brown":
                chevalet.setColor(col13.getColor());
                break;
            case "pink":
                chevalet.setColor(col14.getColor());
                break;
            case "ocre":
                chevalet.setColor(col15.getColor());
                break;
            case "light_beige":
                chevalet.setColor(col16.getColor());
                break;
            case "light_green":
                chevalet.setColor(col17.getColor());
                break;
            case "light_blue":
                chevalet.setColor(col18.getColor());
                break;
            case "gray_blue":
                chevalet.setColor(col19.getColor());
                break;
            case "lavander":
                chevalet.setColor(col20.getColor());
                break;


            case "plus":
                this.paletteDarkening(); // Définie plus bas; Opacifit la palette
                chevalet.setColor(darken(chevalet.getColor()));
                break;
            case "minus":
                this.paletteLightening(); // Définie plus bas; Éclaircit la palette
                chevalet.setColor(lighten(chevalet.getColor()));
                break;


            case "rectangle":
                chevalet.setFigure("rectangle");
                break;
            case "square":
                chevalet.setFigure("square");
                break;
            case "ellipse":
                chevalet.setFigure("ellipse");
                break;
            case "circle":
                chevalet.setFigure("circle");
                break;



            case "New":
                chevalet.viderFigures();
                Drawing.setNomDessin("DefaultName.txt");
                break;
            case "Open":
                fOpen = new FenetreOpen();
                break;
            case "Save":
                if(Drawing.getNomDessin() != "DefaultName.txt") {
                    Drawing.save(Drawing.getNomDessin());
                } else {
                    fSaveAs = new FenetreSave();
                }
                break;
            case "SaveAs":
                fSaveAs = new FenetreSave();
                break;
            case "Quit":
                if(!Drawing.isSaved() && !chevalet.getList().isEmpty()) {

                    // Pour le message d'avertissement, dessin non sauvegardé bien que non-vide
                    // DÉBUT ///////////////////////////////////////////////////////////////////
                    JOptionPane notSaved = new JOptionPane();
                    JOptionPane.showInternalMessageDialog(notSaved,
                            "  Attention ! Vous n'avez pas sauvegardé votre dessin.  ",
                            "Attention !",JOptionPane.WARNING_MESSAGE);
                    // FIN /////////////////////////////////////////////////////////////////////

                } else {
                    this.dispose(); // Ferme la fenêtre et tout ce qu'elle contient, libère l'espace
                }
                break;

            case "À propos du projet":

                // Pour le message informatif sur le projet
                // DÉBUT //////////////////////////////////
                this.info = new JOptionPane();
                JOptionPane.showInternalMessageDialog(this.info, "\t\tAuthor : AsterX2 JK \n"
                        ,
                        "Informations",JOptionPane.INFORMATION_MESSAGE);
                // FIN ////////////////////////////////////

                break;

        }
        palette.repaint(); // Pour actualiser le visuel
    }


    public void paletteDarkening() { // Opacifie toute la palette
        this.col1.setColor(darken(this.col1.getColor()));
        this.col2.setColor(darken(this.col2.getColor()));
        this.col3.setColor(darken(this.col3.getColor()));
        this.col4.setColor(darken(this.col4.getColor()));
        this.col5.setColor(darken(this.col5.getColor()));
        this.col6.setColor(darken(this.col6.getColor()));
        this.col7.setColor(darken(this.col7.getColor()));
        this.col8.setColor(darken(this.col8.getColor()));
        this.col9.setColor(darken(this.col9.getColor()));
        this.col10.setColor(darken(this.col10.getColor()));
        this.col11.setColor(darken(this.col11.getColor()));
        this.col12.setColor(darken(this.col12.getColor()));
        this.col13.setColor(darken(this.col13.getColor()));
        this.col14.setColor(darken(this.col14.getColor()));
        this.col15.setColor(darken(this.col15.getColor()));
        this.col16.setColor(darken(this.col16.getColor()));
        this.col17.setColor(darken(this.col17.getColor()));
        this.col18.setColor(darken(this.col18.getColor()));
        this.col19.setColor(darken(this.col19.getColor()));
        this.col20.setColor(darken(this.col20.getColor()));
    }

    public void paletteLightening() { // Éclaircie toute la palette
        this.col1.setColor(lighten(this.col1.getColor()));
        this.col2.setColor(lighten(this.col2.getColor()));
        this.col3.setColor(lighten(this.col3.getColor()));
        this.col4.setColor(lighten(this.col4.getColor()));
        this.col5.setColor(lighten(this.col5.getColor()));
        this.col6.setColor(lighten(this.col6.getColor()));
        this.col7.setColor(lighten(this.col7.getColor()));
        this.col8.setColor(lighten(this.col8.getColor()));
        this.col9.setColor(lighten(this.col9.getColor()));
        this.col10.setColor(lighten(this.col10.getColor()));
        this.col11.setColor(lighten(this.col11.getColor()));
        this.col12.setColor(lighten(this.col12.getColor()));
        this.col13.setColor(lighten(this.col13.getColor()));
        this.col14.setColor(lighten(this.col14.getColor()));
        this.col15.setColor(lighten(this.col15.getColor()));
        this.col16.setColor(lighten(this.col16.getColor()));
        this.col17.setColor(lighten(this.col17.getColor()));
        this.col18.setColor(lighten(this.col18.getColor()));
        this.col19.setColor(lighten(this.col19.getColor()));
        this.col20.setColor(lighten(this.col20.getColor()));
    }

    /* Des méthodes darker() et brighter() sont déjà définies pour la
     * classe Color mais n'avaient pas exactement l'effet escompté.
     */

    public Color darken(Color c) {
        int alpha = 32+(15*c.getAlpha())/16; // Test afin de ne pas dépasser 255 pour alpha.
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha<=255?alpha:255);
    }

    public Color lighten(Color c) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), (15*c.getAlpha())/16);
    }
}
