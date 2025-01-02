import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ShapeButton extends JButton{
	/*
	 * Cette classe définit les boutons qui contiendrons une image
	 * (pour séléctionner la forme ou pour assombrir/éclaircir la palette
	 * par exemple).
	 */
	private String nomImage;
	private Image img;
	private final String nom;
	
	public ShapeButton(String nomImage, String nom) {
		super();
		this.nomImage = nomImage;
		this.nom = nom;
		this.setActionCommand(nom); // Pour pouvoir discriminer le bouton appelant
		
		try {
			this.img = ImageIO.read(new File(nomImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.img, (this.getWidth()/2)-24, (this.getHeight()/2)-24, 48, 48, this);
	}
	
	public String getNom() {
		return this.nom;
	}
}