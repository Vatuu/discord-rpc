package net.arikia.dev.drpc;

import com.sun.jna.Structure;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */
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

    /**
     * State of the player's current party.
     */
    public String state;

    /**
     * Details to the current game-session of the player.
     */
    public String details;
    /**
     * unix timestamp for the start of the game
     */
    public long startTimestamp;

    /**
     * Unix timestamp for when the game will end
     */
    public long endTimestamp;

    /**
     * Name of the uploaded image for the large profile artwork.
     */
    public String largeImageKey;

    /**
     * Tooltip for the largeImageKey
     */
    public String largeImageText;

    /**
     * Name of the uploaded image for the small profile artwork.
     */
    public String smallImageKey;

    /**
     * Tooltip for the smallImageKey
     */
    public String smallImageText;

    /**
     * Id of the player's party, lobby, or group.
     */
    public String partyId;

    /**
     * Current size of the player's party, lobby, or group.
     */
    public int partySize;

    /**
     * Maximum size of the player's party, lobby, or group.
     */
    public int partyMax;

    /**
     * Unique hashed string for Spectate and Join.
     */
    public String matchSecret;

    /**
     * Unique hashed string for Spectate button.
     */
    public String spectateSecret;

    /**
     * Unique hashed string for chat invitations and Ask to Join.
     */
    public String joinSecret;

    /**
     * 	Marks the matchSecret as a game session with a specific beginning and end.
     */
    public int instance;
}
