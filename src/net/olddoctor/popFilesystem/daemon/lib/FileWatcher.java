package net.olddoctor.popFilesystem.daemon.lib;

import java.util.HashMap;
import java.util.Map;

public class FileWatcher {
    static {
        System.loadLibrary("libfilewatcher");
    }

    private Map<String, Integer> wdList = new HashMap();

    private final int watcher;

    public FileWatcher() {
        this.watcher = this.createFileWatcherNative();
        if(this.watcher < 0)
            throw new FileWatcherError(this.watcher);
    }

    public void addFolder(String folder) {
        int wd;
        if((wd = this.addFolderNative(folder, this.watcher)) < 0)
            throw new FileWatcherException("adding new folder " + folder, wd);

        else
            wdList.put(folder, wd);
    }

    public void rmFolder(String folder) {
        int errCode;
        if((errCode = this.rmFolderNative(wdList.get(folder), this.watcher)) < 0)
            throw new FileWatcherException("removing new folder" + folder, errCode);
    }

    public int getEvent() {
        return getEventNative(this.watcher);
    }

    private native int createFileWatcherNative();

    private native int addFolderNative(String folder, int watcher);

    private native int rmFolderNative(int fd, int watcher);

    private native int getEventNative(int watcher);
}

class FileWatcherError extends Error {
    public FileWatcherError(int errCode) {
        super("Failed creating FileWatcher, error code: " + errCode);
    }
}

class FileWatcherException extends RuntimeException {
    public FileWatcherException(String position, int errCode) {
        super("Failed " + position + ", error code: " + errCode);
    }
}