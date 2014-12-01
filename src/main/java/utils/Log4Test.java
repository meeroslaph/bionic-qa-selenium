package utils;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Log4Test {
    private static final Logger LOGGER = Logger.getLogger(Log4Test.class);
    private static final String INFO_LOG = "INFO: %s";
    private static final String ERROR_LOG = "ERROR: %s";
    private Log4Test() {
    }

    public static void info(String info) {
        String message = String.format(INFO_LOG, info);
        LOGGER.info(message);
        Reporter.log(message);
    }

    public static void error(String error) {
        String message = String.format(ERROR_LOG, error);
        LOGGER.error(message);
        Reporter.log(message);
    }
}