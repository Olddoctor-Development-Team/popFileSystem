package net.olddoctor.manager.lib;

public class NoArgumentException extends RuntimeException {
    public NoArgumentException() {
        super("No argument");
    }
}
