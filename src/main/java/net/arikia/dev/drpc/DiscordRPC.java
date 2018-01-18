package net.arikia.dev.drpc;

import com.sun.jna.Library;
import com.sun.jna.Native;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 */

public final class DiscordRPC{

    static { loadDLL(); }

    //DLL-Version for Update Check.
    private static final String DLL_VERSION = "2.0.1";

    /**
     * Method to initialize the Discord-RPC.
     * @param applicationId ApplicationID/ClientID
     * @param handlers      EventHandlers
     * @param autoRegister  AutoRegister
     */
    public static void discordInitialize(String applicationId, DiscordEventHandlers handlers, boolean autoRegister){
        DLL.INSTANCE.Discord_Initialize(applicationId, handlers, autoRegister ? 1 : 0, null);
    }

    /**
     * Method to initialize the Discord-RPC within a Steam Application.
     * @param applicationId ApplicationID/ClientID
     * @param handlers      EventHandlersq
     *                      @see DiscordEventHandlers
     * @param autoRegister  AutoRegister
     * @param steamId       SteamAppID
     */
    public static void discordInitialize(String applicationId, DiscordEventHandlers handlers, boolean autoRegister, String steamId){
        DLL.INSTANCE.Discord_Initialize(applicationId, handlers, autoRegister ? 1 : 0, steamId);
    }

    /**
     * Method to shutdown the Discord-RPC from within the application.
     */
    public static void discordShutdown(){
        DLL.INSTANCE.Discord_Shutdown();
    }

    /**
     * Method to call Callbacks from within the library.
     * Must be called periodically.
     */
    public static void discordRunCallbacks(){
        DLL.INSTANCE.Discord_RunCallbacks();
    }

    /**
     * Method to update the DiscordRichPresence of the client.
     * @param presence Instance of DiscordRichPresence
     *                 @see DiscordRichPresence
     */
    public static void discordUpdatePresence(DiscordRichPresence presence){
        DLL.INSTANCE.Discord_UpdatePresence(presence);
    }

    /**
     * Method to respond to Join/Spectate Callback.
     * @param userId UserID of the user to respond to.
     * @param reply DiscordReply to request.
     *              @see DiscordReply
     */
    public static void discordRespond(String userId, DiscordReply reply){
        DLL.INSTANCE.Discord_Respond(userId, reply.reply);
    }

    //Load DLL depending on the user's architecture.
    private static void loadDLL(){
        String name = System.mapLibraryName("discord-rpc");
        String finalPath = "";
        String tempPath = "";

        if(SystemUtils.IS_OS_WINDOWS){
            boolean is64bit = System.getProperty("sun.arch.data.model").equals("64");
            finalPath = is64bit ? "/win-x64/discord-rpc.dll" : "/lib/win-x32/discord-rpc.dll";
            tempPath = System.getenv("TEMP") + "/discord-rpc.jar/discord-rpc.dll";
        }else if(SystemUtils.IS_OS_LINUX) {
            finalPath = "/linux/discord-rpc.so";
            tempPath = System.getenv("TMPDIR") + "/discord-rpc.jar/discord-rpc.so";
        }else if(SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX){
            finalPath = "/osx/discord-rpc.dylib";
            tempPath = System.getenv("TMPDIR") + "/discord-rpc/discord-rpc.dylib";
        }

        File f = new File(tempPath);

        try(InputStream in = DiscordRPC.class.getResourceAsStream(finalPath); OutputStream out = FileUtils.openOutputStream(f)){
            IOUtils.copy(in, out);
            FileUtils.forceDeleteOnExit(f);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.load(f.getAbsolutePath());
    }

    //JNA Interface
    private interface DLL extends Library{
        DLL INSTANCE = (DLL) Native.loadLibrary("discord-rpc", DLL.class);

        void Discord_Initialize(String applicationId, DiscordEventHandlers handlers, int autoRegister, String optionalSteamId);
        void Discord_Shutdown();
        void Discord_RunCallbacks();
        void Discord_UpdatePresence(DiscordRichPresence presence);
        void Discord_Respond(String userId, int reply);
    }
}
