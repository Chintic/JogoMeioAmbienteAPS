package entities;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import services.Calculos;
import view.Principal;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelInimigo {
	
    final int DISTANCIA_MINIMA = 150;
    public JButton btnMira;
    public JLabel lblAnimais;
    private final int VIDA_INIMIGO = 5;
    private int valorProgresso = VIDA_INIMIGO;
    private JProgressBar pbBarraVidaInimigo;
    public JPanel inimigos;
    

    public PainelInimigo(JLabel lblAnimais, JLabel lblPontos) {
        inimigos = new JPanel();
        inimigos.setOpaque(false);

        this.lblAnimais = lblAnimais;
        
        Calculos calculos = new Calculos();
        inimigos.setBounds(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria(), 64, 73);
        inimigos.setLayout(null);
        Principal.contentPane.add(inimigos);
        
        pbBarraVidaInimigo = new JProgressBar();
        pbBarraVidaInimigo.setBounds(0, 0, 64, 10);
        pbBarraVidaInimigo.setValue(VIDA_INIMIGO);
        pbBarraVidaInimigo.setMaximum(VIDA_INIMIGO);
        inimigos.add(pbBarraVidaInimigo);
        
        btnMira = new JButton("");
        btnMira.setIcon(new ImageIcon("Imagens/mira.png"));
        btnMira.setBounds(0, 10, 65, 64);
        btnMira.setBorderPainted(false);
        btnMira.setContentAreaFilled(false);
        btnMira.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int xMira = btnMira.getX();
                int yMira = btnMira.getY();
                int xAnimal = lblAnimais.getX();
                int yAnimal = lblAnimais.getY();
                Calculos calculos = new Calculos();
                double distancia = calculos.calcularDistancia(xMira, yMira, xAnimal, yAnimal);
                if (distancia < DISTANCIA_MINIMA) {
                    // reposiciona a mira
                    btnMira.setLocation(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria());
                } else {
                    valorProgresso--;
                    if (valorProgresso <= pbBarraVidaInimigo.getMaximum()) {
                        if (valorProgresso <= 0) {
                            // Gera novas posições:
                            inimigos.setLocation(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria());
                            lblAnimais.setLocation(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria());
                            Principal.pontos++;
                            lblPontos.setText("Pontos: " + Principal.pontos);
                            // Redefine o valor da barra.
                            pbBarraVidaInimigo.setValue(VIDA_INIMIGO);
                            valorProgresso = VIDA_INIMIGO;
                        } else {
                            pbBarraVidaInimigo.setValue(valorProgresso);
                        }
                    }
                }
            }
        });
        inimigos.add(btnMira);
    }
}
