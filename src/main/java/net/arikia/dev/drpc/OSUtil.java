package net.arikia.dev.drpc;

/**
 * @author Dejay
 * @version 1.6.0
 *
 * Object containing utils for detecting the user's OS.
 */
public final class OSUtil {

    public static boolean isMac() {
        return System.getProperty("os.name").toLowerCase()
                .startsWith("mac");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase()
                .startsWith("win");
    }

}