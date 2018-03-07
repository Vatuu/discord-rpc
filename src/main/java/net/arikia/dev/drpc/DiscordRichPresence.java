package net.arikia.dev.drpc;

import com.sun.jna.Structure;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */
@Data
public class DiscordRichPresence extends Structure {

    /*
    typedef struct DiscordRichPresence {
        const char* state;
        const char* details;
        int64_t startTimestamp;
        int64_t endTimestamp;
        const char* largeImageKey;
        const char* largeImageText;
        const char* smallImageKey;
        const char* smallImageText;
        const char* partyId;
        int partySize;
        int partyMax;
        const char* matchSecret;
        const char* joinSecret;
        const char* spectateSecret;
        int8_t instance;
    } DiscordRichPresence;
    */

    @Override
    public List<String> getFieldOrder(){
        return Arrays.asList(new String[] {"state", "details", "startTimestamp", "endTimestamp", "largeImageKey", "largeImageText", "smallImageKey", "smallImageText", "partyId", "partySize", "partyMax", "matchSecret", "joinSecret", "spectateSecret", "instance"});
    }
    /**
     * State of the player's current party.
     */
    private String state;

    /**
     * Details to the current game-session of the player.
     */
    private String details;
    /**
     * unix timestamp for the start of the game
     */
    private long startTimestamp;

    /**
     * Unix timestamp for when the game will end
     */
    private long endTimestamp;

    /**
     * Name of the uploaded image for the large profile artwork.
     */
    private String largeImageKey;

    /**
     * Tooltip for the largeImageKey
     */
    private String largeImageText;

    /**
     * Name of the uploaded image for the small profile artwork.
     */
    private String smallImageKey;

    /**
     * Tooltip for the smallImageKey
     */
    private String smallImageText;

    /**
     * Id of the player's party, lobby, or group.
     */
    private String partyId;

    /**
     * Current size of the player's party, lobby, or group.
     */
    private int partySize;

    /**
     * Maximum size of the player's party, lobby, or group.
     */
    private int partyMax;

    /**
     * Unique hashed string for Spectate and Join.
     */
    private String matchSecret;

    /**
     * Unique hashed string for Spectate button.
     */
    private String spectateSecret;

    /**
     * Unique hashed string for chat invitations and Ask to Join.
     */
    private String joinSecret;

    /**
     * 	Marks the matchSecret as a game session with a specific beginning and end.
     */
    private int instance;
}
