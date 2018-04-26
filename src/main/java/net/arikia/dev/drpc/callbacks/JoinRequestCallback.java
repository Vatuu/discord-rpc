package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;
import net.arikia.dev.drpc.DiscordUser;

public interface JoinRequestCallback extends Callback {
    void apply(DiscordUser request);
}
