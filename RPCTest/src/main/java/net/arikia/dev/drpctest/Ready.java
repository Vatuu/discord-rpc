package net.arikia.dev.drpctest;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Ready implements ReadyCallback {

    public void apply(DiscordUser user) {
        Main.ready = true;
        System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
        DiscordRichPresence rich = new DiscordRichPresence();
        rich.state = "Running Test | Private";
        rich.details = "Score = 0";
        DiscordRPC.discordUpdatePresence(rich);
    }
}
