package test.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.simple.SimpleLogger;;

public class Loger {
	private static SimpleLogger logger = (SimpleLogger) LogManager.getLogger("HelloWorld");

	public static void main(String[] args) {
	logger.debug("test");
	}
}