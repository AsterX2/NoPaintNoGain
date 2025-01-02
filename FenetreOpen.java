import javax.swing.*;
import java.awt.event.ActionEvent;

public class FenetreOpen extends FenetreSaveOpen{

	private JOptionPane attention;
	
	public FenetreOpen() {
		super("Ouvrir ?",
				"  Veuillez inscrire le nom du fichier à ouvrir  ",
				"Ouvrir", true);
		
		// Titre, Descriptif, Intitulé du bouton
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(!this.champ.getText().isBlank()) {
			Window.chevalet.open(this.champ.getText());
		} else { // Si aucun nom saisi, on affiche un avertissement
				// Durant 5 secondes.

			this.attention = new JOptionPane();
			JOptionPane.showInternalMessageDialog(this.attention,
			"Attention, le champs de saisie est vide.",
			"Attention !",JOptionPane.WARNING_MESSAGE);
			
			try {
				Thread.sleep(5000);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		this.dispose();
	}
}