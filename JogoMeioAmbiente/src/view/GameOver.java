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

public class GameOver extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane;
    private JButton btnOk;
    private JLabel lblGameOver;
    
    public GameOver() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblGameOver = new JLabel("GAME OVER!");
        lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameOver.setBounds(10, 50, 414, 50);
        contentPane.add(lblGameOver);
        
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
        btnOk.setBounds(159, 120, 117, 25);
        contentPane.add(btnOk);
    }
}
