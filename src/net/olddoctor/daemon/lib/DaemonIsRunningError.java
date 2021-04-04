package net.olddoctor.daemon.lib;

public class DaemonIsRunningError extends Error {
    public DaemonIsRunningError() {
        super("Another daemon is running");
    }
}