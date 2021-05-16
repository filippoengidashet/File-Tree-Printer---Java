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
public interface FileTreePrinter {
    
    void print(String path, boolean showHiddenFiles);
    
    boolean isPrinting();
    
    void stop();
}
