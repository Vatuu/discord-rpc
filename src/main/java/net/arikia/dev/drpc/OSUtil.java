package net.arikia.dev.drpc;

/**
 * @author DeJay
 * @version 1.5.1
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