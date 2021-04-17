package net.olddoctor.popFilesystem.daemon.lib;

public class NoConfigFileError extends Error {
    public NoConfigFileError(String configFileName) {
        super("No " + configFileName + " found");
    }
}
