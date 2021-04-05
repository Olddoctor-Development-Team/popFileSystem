package net.olddoctor.daemon.lib;

public class FileWatcher {
    static {
        System.loadLibrary("fileWatcher");
    }

    private int watcher;

    public FileWatcher() {
        this.watcher = this.createFileWatcher();
    }

    public void addFile() {

    }

    private native int createFileWatcher();

    private native int addFile(String filePath);

    private native int rmFile();
}
