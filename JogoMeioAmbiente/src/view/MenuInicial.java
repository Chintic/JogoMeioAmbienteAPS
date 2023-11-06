package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MenuInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
    private JButton btnIniciar;
    private JButton btnSair;
    private JLabel lblTitulo;

    public MenuInicial() {
        
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setBounds(500, 100, 450, 300);
         contentPane = new JPanel();
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         lblTitulo = new JLabel("Jogo de Proteção ao Meio Ambiente");
         lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
         lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
         lblTitulo.setBounds(10, 50, 414, 50);
         contentPane.add(lblTitulo);
         
         btnIniciar = new JButton("Iniciar Jogo");
         btnIniciar.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             	setVisible(false);
                 Principal framePrincipal = new Principal();
                 framePrincipal.setVisible(true);
             }
         });
         btnIniciar.setBounds(159, 120, 117, 25);
         contentPane.add(btnIniciar);
         
         btnSair = new JButton("Sair");
         btnSair.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 dispose();
             }
         });
         btnSair.setBounds(159, 160, 117, 25);
         contentPane.add(btnSair);
     }
}