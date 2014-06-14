package com.hackbulgaria.corejava;

public class LoggerTest {

    public static void main(String[] args) {

        // Logger logger = new Logger();
        Logger logger = new DateLogger();

        logger.log(2, "Somewhat important message");
        logger.log(3, "Less important message");
        logger.log(5, "Not important");
        logger.log("Meh");

        logger.setLevel(2);
        logger.log("My message");

        logger.setLevel(3);
        logger.log("My message");

        logger.log("");
    }
}
