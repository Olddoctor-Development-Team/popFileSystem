package net.olddoctor.manager.lib;

public class Helper {

    public static void printHelp(int helpType) {
        //法律声明
        System.out.println("""
                PopFilesystem  Copyright (C) 2021  Olddoctor Development Team
                This program comes with ABSOLUTELY NO WARRANTY; for details type 'popfilesystem --license'.
                This is free software, and you are welcome to redistribute it
                under certain conditions; type 'popfilesystem --license' for details.""");

        /*
        helpType:
        0. --help 输出
        1. 错误用法输出
        2. 未传入参数输出
        */
        switch(helpType) {
            case 1 -> System.out.println("Incorrect usage.");
            case 2 -> System.out.println("No argument.");
        }

        System.out.print("""
                usage: popfilesystem [options]

                options:
                --start-daemon      -s: Start popFilesystem daemon.
                --kill-daemon       -k: Kill popFilesystem daemon.
                --restart-daemon    -r: Restart popFilesystem daemon.
                --help              -h,-?: Print help.
                --license           : Print license.""");
    }
}
