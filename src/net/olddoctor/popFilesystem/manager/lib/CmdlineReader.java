package net.olddoctor.popFilesystem.manager.lib;

import java.util.Arrays;
import java.util.Iterator;

public class CmdlineReader {
    private final String[] args;
    private final Runnable runnable;

    //初始化
    public CmdlineReader(String[] args) throws NoArgumentException {
        this.args = args;
        runnable = this.read();
    }

    //解析参数
    public Runnable read() throws NoArgumentException, UnknownArgumentException, UnknownError {
        //如果没有传入任何参数
        if(args.length == 0) {
            throw new NoArgumentException();
        }

        String reading;
        Iterator<String> iterator = Arrays.stream(this.args).iterator();

        //循环读取参数
        while(iterator.hasNext()) {
            reading = iterator.next();
            if(reading.charAt(0) == '-') {      //如果是选项
                if(reading.charAt(1) == '-') {  //如果是选项全称
                    switch(reading.substring(2)) {
                        case "start-daemon" -> {
                            return RunnableList.startDaemon;
                        }

                        case "kill-daemon" -> {
                            return RunnableList.killDaemon;
                        }

                        case "restart-daemon" -> {
                            return RunnableList.restartDaemon;
                        }

                        case "help" -> {
                            return RunnableList.help;
                        }

                        case "license" -> {
                            return RunnableList.license;
                        }


                        default -> throw new UnknownArgumentException();
                    }

                } else {                        //否则是选项简称
                    switch(reading.charAt(1)) {
                        //start-manager
                        case 's' -> {
                            return RunnableList.startDaemon;
                        }

                        //help
                        case 'h', '?' -> {
                            return RunnableList.help;
                        }

                        default -> throw new UnknownArgumentException();
                    }

                }
            } else { //否则是参数
                switch (reading) {

                    default -> throw new UnknownArgumentException();
                }
            }
        }

        throw new UnknownError("Unknown error.");
    }

    //获取Runnable
    public Runnable getRunnable() {
        return runnable;
    }

}
