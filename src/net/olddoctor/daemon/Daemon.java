package net.olddoctor.daemon;

import net.olddoctor.daemon.lib.DaemonIsRunningError;
import net.olddoctor.daemon.lib.GetPID;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Daemon {
    public static void main(String[] args) throws IOException, DaemonIsRunningError {

        //检查是否存在daemon lock
        File daemonLock = new File(System.getProperty("usr.dir") + "/daemon.lock");
        if (!daemonLock.exists()) {
            daemonLock.createNewFile();
            BufferedWriter daemonLockWriter = new BufferedWriter(new FileWriter(daemonLock));
            daemonLockWriter.write(GetPID.GetPID());
            daemonLockWriter.close();
        } else {
            throw new DaemonIsRunningError();
        }
    }
}
