/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetreeprinter;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author filippo.engidashet
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FileTreePrinterView view = new FileTreePrinterView();
            view.setTitle("File Tree Printer");
            view.setLocationRelativeTo(null);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setExtendedState(JFrame.MAXIMIZED_BOTH);
            view.setVisible(true);
        });
    }

}
