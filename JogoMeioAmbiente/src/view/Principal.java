package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import entities.PainelAnimal;
import entities.PainelInimigo;
import services.Calculos;
import services.PersegueAnimal;

public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;

    public static JPanel contentPane = new JPanel();
    private JLabel lblTitulo;
    public static int vidas = 3;
    public static int pontos = 0;
    private JLabel lblVidas;
    private JLabel lblPontos;
    private JLabel lblAnimais;
    private JPanel inimigos;
    int velocidade = 1;

    Calculos calculos = new Calculos();
    private static Principal instance;

    public Principal() {
        instance = this;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 600, 400);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("Salve os animais dos caçadores! Clique nas miras para fazê-los errar!");
        lblTitulo.setBounds(10, 10, 566, 13);
        contentPane.add(lblTitulo);

        lblVidas = new JLabel("Vidas: " + vidas);
        lblVidas.setBounds(10, 340, 64, 13);
        contentPane.add(lblVidas);

        lblPontos = new JLabel("Pontos: " + pontos);
        lblPontos.setBounds(512, 340, 64, 13);
        contentPane.add(lblPontos);

        PainelAnimal painelAnimal = new PainelAnimal();
        PainelInimigo painelInimigo = new PainelInimigo(painelAnimal.getLblAnimais(), lblPontos);

        lblAnimais = painelAnimal.lblAnimais;
        inimigos = painelInimigo.inimigos;

        GameOver frameGameOver = new GameOver();
        Vitoria frameVitoria = new Vitoria();

        ActionListener persegueAnimal = new PersegueAnimal(lblAnimais, inimigos, lblVidas, frameGameOver, frameVitoria);

        // Adicionando o listener para a movimentação do inimigo
        Timer timer = new Timer(1, persegueAnimal);
        timer.start();
    }

    public static Principal getFrame() {
        return instance;
    }

}
