package net.arikia.dev.drpc.callbacks;

import com.sun.jna.Callback;

/**
 * @author Nicolas "Vatuu" Adamoglou
 * @version 1.0
 *
 *
 **/
public interface DisconnectedCallback extends Callback{

    /**
     * Method called when disconnected.
     * @param errorCode Error Code
     * @param message   Message
     */
    void apply(int errorCode, String message);
}
