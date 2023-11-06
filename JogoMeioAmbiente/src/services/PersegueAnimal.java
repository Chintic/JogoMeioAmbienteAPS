package services;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GameOver;
import view.Principal;
import view.Vitoria;

public class PersegueAnimal implements ActionListener {
    private JLabel lblAnimais;
    private JPanel inimigos;
    private JLabel lblVidas;
    private boolean gameOver = false;
    private boolean vitoria = false;
    private Calculos calculos = new Calculos();
    private GameOver frameGameOver;
    private Vitoria frameVitoria;

    public PersegueAnimal(JLabel lblAnimais, JPanel inimigos, JLabel lblVidas, GameOver frameGameOver, Vitoria frameVitoria) {
        this.lblAnimais = lblAnimais;
        this.inimigos = inimigos;
        this.lblVidas = lblVidas;
        this.frameGameOver = frameGameOver;
        this.frameVitoria = frameVitoria;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int animalX = lblAnimais.getX();
        int animalY = lblAnimais.getY();
        int inimigoX = inimigos.getX();
        int inimigoY = inimigos.getY();
        int difX = animalX - inimigoX;
        int difY = animalY - inimigoY;

        int velocidade = 1;

        if (difX == 0 && difY == 0 && !gameOver && !vitoria) {
            Principal.vidas--;
            lblVidas.setText("Vidas: " + Principal.vidas);
            lblAnimais.setLocation(calculos.gerarPosXAleatoria(), calculos.gerarPosYAleatoria());
            lblAnimais.getParent().repaint();
        }

        if (Principal.vidas <= 0) {
            frameGameOver.setVisible(true);
            gameOver = true;
            Principal.vidas = 3;
            Principal.getFrame().dispose();
        }

        if (Principal.pontos >= 5) {
            frameVitoria.setVisible(true);
            vitoria = true;
            Principal.pontos = 0;
            Principal.getFrame().dispose();
        }

        if (Math.abs(difX) > Math.abs(difY)) {
            if (difX < 0) {
                inimigoX -= velocidade;
            } else {
                inimigoX += velocidade;
            }
        } else {
            if (difY < 0) {
                inimigoY -= velocidade;
            } else {
                inimigoY += velocidade;
            }
        }

        inimigos.setLocation(inimigoX, inimigoY);
    }
}
