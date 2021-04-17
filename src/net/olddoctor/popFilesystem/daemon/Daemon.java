package net.olddoctor.popFilesystem.daemon;

import net.olddoctor.popFilesystem.daemon.lib.DaemonIsRunningError;
import net.olddoctor.popFilesystem.daemon.lib.GetPID;
import net.olddoctor.popFilesystem.daemon.lib.NoConfigFileError;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                throw new NoConfigFileError("daemon.conf");
            }

            BufferedReader configReader = new BufferedReader(new FileReader(configFile));

            String line;
            Map<String, String> config = new HashMap();
            while ((line = configReader.readLine()) != null) {
                if (!(line.equals("") || line.charAt(0) == '#')) {
                    String[] split = line.split("=", 2);
                    config.put(split[0], split[1]);
                }
            }

            configReader.close();

            //读取硬盘位置和速度
            File disksConfig = new File("/etc/popFilesystem/disks.conf");

            if (!disksConfig.exists()) {
                throw new NoConfigFileError("disks.conf");
            }
            
            BufferedReader diskListReader = new BufferedReader(new FileReader(disksConfig));

            ArrayList<String> diskList = new ArrayList<>();
            while((line = diskListReader.readLine()) != null) {
                if(!(line.equals("") || line.charAt(0) == '#')) {
                    diskList.add(line);
                }
            }

            diskListReader.close();

            //设置缺省配置


            //扫描popFilesystem



            //循环检测
            while (true) {

            }
        } else {
            throw new DaemonIsRunningError();
        }
    }
}
