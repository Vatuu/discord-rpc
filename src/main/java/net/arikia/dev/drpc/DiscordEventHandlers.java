package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.arikia.dev.drpc.callbacks.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */
@Data
public class DiscordEventHandlers extends Structure {

    @Override
    public List<String> getFieldOrder(){
        return Arrays.asList(new String[] {"ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest"});
    }

    /**
     * Callback called when Discord-RPC was initialized successfully.
     */
    private ReadyCallback ready;
    private DisconnectedCallback disconnected;
    private ErroredCallback errored;
    private JoinGameCallback joinGame;
    private SpectateGameCallback spectateGame;
    private JoinRequestCallback joinRequest;
}
