import java.awt.event.ActionEvent;

public class FenetreSave extends FenetreSaveOpen{

	public FenetreSave() {
		super("Sauvegarder ?",
				"  Veuillez inscrire le nom du fichier de sauvegarde  ",
				"Sauvegarder", true);
		
		// Titre, Descriptif, Intitulé du bouton
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(!this.champ.getText().isBlank()) {
			Drawing.save(this.champ.getText());
		} else {
			Drawing.save("DefaultName.txt");
		}
		
		this.dispose();
	}
}
