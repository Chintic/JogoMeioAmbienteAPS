package jogo;

import java.awt.EventQueue;

import view.MenuInicial;

public class Apresentacao {
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuInicial framePrincipal = new MenuInicial();
                    framePrincipal.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
