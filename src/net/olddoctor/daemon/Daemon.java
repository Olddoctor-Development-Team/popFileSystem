package net.olddoctor.daemon;

import net.olddoctor.daemon.lib.DaemonIsRunningError;
import net.olddoctor.daemon.lib.GetPID;
import net.olddoctor.daemon.lib.NoConfigFileError;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Daemon {
    public static void main(String[] args) throws IOException, DaemonIsRunningError, NoConfigFileError {

        //检查是否存在daemon lock
        File daemonLock = new File(System.getProperty("usr.dir") + "/daemon.lock");
        if (!daemonLock.exists()) {
            daemonLock.createNewFile();
            BufferedWriter daemonLockWriter = new BufferedWriter(new FileWriter(daemonLock));
            daemonLockWriter.write(GetPID.GetPID());
            daemonLockWriter.close();

            //读取config
            File configFile = new File("/etc/popFilesystem/daemon.conf");
            if (!configFile.exists()) {
                throw new NoConfigFileError();
            }

            BufferedReader configReader = new BufferedReader(new FileReader(configFile));

            String line;
            Map<String, String> config = new HashMap();
            while((line = configReader.readLine()) != null) {
                if ((!line.equals("")) && (line.charAt(0) != '#')) {
                    String[] split = line.split("=", 2);
                    config.put(split[0], split[1]);
                }
            }

            //读取硬盘ID、速度和位置
            File diskFile = new File("/etc/popFilesystem/disk.conf");


            //扫描popFilesystem



            //循环检测
            while (true) {

            }
        } else {
            throw new DaemonIsRunningError();
        }
    }
}
