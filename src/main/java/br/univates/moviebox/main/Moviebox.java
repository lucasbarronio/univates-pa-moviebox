/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.univates.moviebox.main;

import br.univates.moviebox.utils.ConexaoBD;
import br.univates.moviebox.view.JffMain;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Moviebox {

    public static void main(String[] args) {
        try {
            ConexaoBD.getInstance().getConnection();
            JffMain janela = new JffMain();
            janela.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados!");
        }
    }
}
