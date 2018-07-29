package net.arikia.dev.drpc;

public final class OSUtil {

    //I wanted this to be easier and no stupid static.

    public static boolean isMac() {
        return System.("os.name").toLowerCase()
                .startsWith("mac");
    }

    public static boolean isWindows() {
        return System.("os.name").toLowerCase()
                .startsWith("win");
    }

    private OSUtil() {
        super();
    }
}