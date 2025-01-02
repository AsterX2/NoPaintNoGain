import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract public class FenetreSaveOpen extends JFrame implements ActionListener{
	
	/* Cette classe abstraite sert de squelette aux fenêtres de :
	 * Sauvegarde;
	 * Ouverture;
	 * Oeuf.
	 */
	
	protected JLabel text;
	protected JTextField champ;
	protected JButton bouton;
	
	protected Container contentPanel;
	
	public FenetreSaveOpen(String title, String descriptif, String nomBouton, boolean standard) {
		// standard détermine si l'on utilise le Layout standard défini ci-dessous
		
		this.setTitle(title);
		
		this.text = new JLabel(descriptif);
		this.champ = new JTextField();
		this.bouton = new JButton(nomBouton);
		
		this.contentPanel = this.getContentPane();
		
		bouton.addActionListener(this);
		
		if(standard) {
			// Layout : DÉBUT
			this.contentPanel.setLayout(new GridLayout(3,1));
			this.contentPanel.add(this.text);
			this.contentPanel.add(this.champ);
			this.contentPanel.add(this.bouton);
			this.pack();
		// Layout : FIN
		}
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.setVisible(true);
	}
}