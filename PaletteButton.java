import javax.swing.*;
import java.awt.*;

public class PaletteButton extends JButton{
	/*
	 * Cette classe définit les boutons composant la palette de couleur.
	 */
	private Color couleur;
	private final String nom;
	
	public PaletteButton(Color couleur, String nom) {
		super();
		this.couleur = couleur;
		this.nom = nom;
		this.setActionCommand(nom); // Pour pouvoir discriminer le bouton appelant
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(this.couleur);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Color getColor() {
		return this.couleur;
	}
	
	public void setColor(Color c) { // Ajoutée pour pour assombrir/éclaircir la palette
		this.couleur = c;
	}
}