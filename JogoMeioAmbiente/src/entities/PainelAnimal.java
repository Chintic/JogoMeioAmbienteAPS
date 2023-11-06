package entities;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import services.Calculos;
import view.Principal;

public class PainelAnimal {
	
	public JLabel lblAnimais = new JLabel("");
	
	public JLabel getLblAnimais() {
        return lblAnimais;
    }
	
	public PainelAnimal() {	
		Calculos calculos = new Calculos();
		lblAnimais.setIcon(new ImageIcon("Imagens/pombo.png"));
		lblAnimais.setBounds(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria(), 50, 50);
		Principal.contentPane.add(lblAnimais);
	}
}
