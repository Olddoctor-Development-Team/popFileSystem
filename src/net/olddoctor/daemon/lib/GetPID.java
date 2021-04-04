package net.olddoctor.daemon.lib;

import java.lang.management.ManagementFactory;

public class GetPID {
    public static String GetPID() {
        return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
    }
}
