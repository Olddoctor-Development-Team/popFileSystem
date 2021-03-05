package net.olddoctor.daemon.lib;

public class GetThreadID {
    static {
        System.loadLibrary("getThreadID");
    }

    public native int getThreadID();}
