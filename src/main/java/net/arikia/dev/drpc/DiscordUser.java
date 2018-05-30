package net.arikia.dev.drpc;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.5.0
 *
 * Object containing information about a Discord user.
 */
public class DiscordUser extends Structure {

<<<<<<< HEAD
    /*
    typedef struct DiscordUser {
        const char* userId;
        const char* username;
        const char* avatar;
        const char* discriminator;
    } DiscordUser;
    */

=======
>>>>>>> 031fe6a9d23cfd42695b9ba9a869da5002217d25
    @Override
    public List<String> getFieldOrder(){
        return Arrays.asList("userId", "username", "discriminator", "avatar");
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
