package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;

public interface JoinGameCallback extends Callback {
    void apply(String joinSecret);
}
