package net.arikia.dev.drpc;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 */
public class DiscordUser extends Structure {

    /*
    typedef struct DiscordUser {
        const char* userId;
        const char* username;
        const char* avatar;
        const char* discriminator;
    } DiscordUser;
    */

    @Override
    public List<String> getFieldOrder(){
        return Arrays.asList(new String[] {"userId", "username", "discriminator", "avatar"});
    }

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
    public String discriminator;

    /**
     * The avatar hash of the player asking to join.
     * @see <a href="https://discordapp.com/developers/docs/reference#image-formatting">Image Formatting</a>
     */
    public String avatar;
}
