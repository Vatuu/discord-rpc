package net.arikia.dev.drpc;

import com.sun.jna.Structure;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */
public class DiscordJoinRequest extends Structure {

    /*
    typedef struct DiscordJoinRequest {
        const char* userId;
        const char* username;
        const char* avatar;
    } DiscordJoinRequest;
    */

    /**
     * The userId of the player asking to join.
     */
    public String userId;

    /**
     * The username of the player asking to join.
     */
    public String username;

    /**
     * The discriminator of the player asking to join.
     */
    public int discriminator;

    /**
     * The avatar hash of the player asking to join.
     * @see <a href="https://discordapp.com/developers/docs/reference#image-formatting">Image Formatting</a>
     */
    public String avatar;
}
