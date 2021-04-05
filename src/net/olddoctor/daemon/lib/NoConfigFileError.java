package net.olddoctor.daemon.lib;

public class NoConfigFileError extends Error {
    public NoConfigFileError() {
        super("No config file found");
    }
}
