package net.olddoctor.popFilesystem.manager.lib;

public class UnknownArgumentException extends RuntimeException{
    public UnknownArgumentException() {
        super("Unknown option.");
    };
}
