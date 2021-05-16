/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetreeprinter.printers;

/**
 *
 * @author filippo.engidashet
 */
public interface Callback {
 
    void onPrint(String line);

    void onDone();
}
