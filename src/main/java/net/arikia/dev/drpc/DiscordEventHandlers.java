package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import net.arikia.dev.drpc.callbacks.*;

public class DiscordEventHandlers extends Structure {

    public static class ByValue extends DiscordEventHandlers implements Structure.ByValue {}

    public ReadyCallback ready;
    public DisconnectedCallback disconnected;
    public ErroredCallback errored;
    public JoinGameCallback joinGame;
    public SpectateGameCallback spectateGame;
    public JoinRequestCallback joinRequest;

    /*public static abstract class ReadyEvent implements Callback{
        public abstract void apply();
    }

    public static abstract class DisconnectedEvent implements Callback{
        public abstract void apply(int errorCode, String message);
    }

    public static abstract class ErroredEvent implements Callback{
        public abstract void apply(int errorCode, String message);
    }

    public static abstract class JoinGameEvent implements Callback{
        public abstract void apply(String joinSecret);
    }

    public static abstract class SpectateGameEvent implements Callback{
        public abstract void apply(String spectateSecret);
    }

    public static abstract class JoinRequestEvent implements Callback{
        public abstract void apply(DiscordJoinRequest request);
    }*/
}
