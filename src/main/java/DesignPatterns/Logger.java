package DesignPatterns;

import java.text.SimpleDateFormat;
import java.util.Date;

//Singleton
public class Logger {
    private static Logger instance;

    private Logger(){};

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
        System.out.println(timestamp + " - " + message);
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Same instance? " + (logger1 == logger2));

        logger1.log("App started");
        logger2.log("User logged in");
        Logger.getInstance().log("Data processed");
    }
}
