package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;

public interface ReadyCallback extends Callback {
    void apply();
}

