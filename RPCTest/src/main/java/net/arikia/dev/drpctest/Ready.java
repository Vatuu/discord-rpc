package net.arikia.dev.drpctest;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Ready implements ReadyCallback {

    public void apply() {
        System.out.println("Ready.");
        DiscordRichPresence rich = new DiscordRichPresence();
        rich.state = "Running Test | Private";
        rich.details = "Score = 0";
        DiscordRPC.discordUpdatePresence(rich);
    }

}
