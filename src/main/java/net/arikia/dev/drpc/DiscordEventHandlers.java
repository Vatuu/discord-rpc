package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import net.arikia.dev.drpc.callbacks.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */

public class DiscordEventHandlers extends Structure {

    @Override
    public List<String> getFieldOrder(){
        return Arrays.asList(new String[] {"ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest"});
    }

    /**
     * Callback called when Discord-RPC was initialized successfully.
     */
    public ReadyCallback ready;
    public DisconnectedCallback disconnected;
    public ErroredCallback errored;
    public JoinGameCallback joinGame;
    public SpectateGameCallback spectateGame;
    public JoinRequestCallback joinRequest;
}
