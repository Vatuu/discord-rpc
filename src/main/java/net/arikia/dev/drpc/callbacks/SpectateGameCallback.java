package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;

public interface SpectateGameCallback extends Callback {
    void apply(String spectateSecret);
}
