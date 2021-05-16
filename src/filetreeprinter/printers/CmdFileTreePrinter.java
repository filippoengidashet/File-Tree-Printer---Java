/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetreeprinter.printers;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author filippo.engidashet
 */
public class CmdFileTreePrinter implements FileTreePrinter {

    private final Callback callback;
    private Thread task;
    private boolean printing = false;

    public CmdFileTreePrinter(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void print(String path, boolean showHiddenFiles) {
        stop();
        this.task = new Thread(() -> {
            printing = true;
            callback.onPrint(".");
            callback.onPrint("\n");
            System.out.println(".");
            File dir = new File(path);
            printDirs(dir, 0, showHiddenFiles);
            this.callback.onDone();
        });
        this.task.start();
    }

    private void printDirs(File dir, int level, boolean showHiddenFiles) {
        if (dir.isHidden() && !showHiddenFiles) {
            return;
        }
        if (dir.isDirectory()) {
            for (int i = 0; i < level; i++) {
                callback.onPrint("│\t");
            }
            File[] files = dir.listFiles();
            if (files != null) {
                callback.onPrint("├── (" + files.length + ") " + dir.getName() + "/");
                callback.onPrint("\n");
                Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));
                for (File file : files) {
                    printDirs(file, level + 1, showHiddenFiles);
                }
            }
        } else {
            for (int i = 0; i < level; i++) {
                callback.onPrint("│\t");
            }
            callback.onPrint("└── " + dir.getName());
            callback.onPrint("\n");
        }
    }

    @Override
    public boolean isPrinting() {
        return printing;
    }

    @Override
    public void stop() {
        if (this.task != null) {
            this.task.stop();
        }
        this.task = null;
        printing = false;
    }
}
