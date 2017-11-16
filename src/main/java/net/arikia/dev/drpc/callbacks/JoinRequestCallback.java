package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;
import net.arikia.dev.drpc.DiscordJoinRequest;

public interface JoinRequestCallback extends Callback {
    void apply(DiscordJoinRequest request);
}
