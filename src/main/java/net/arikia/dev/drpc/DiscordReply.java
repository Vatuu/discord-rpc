package net.arikia.dev.drpc;

public enum DiscordReply {

    NO(0),
    YES(1),
    IGNORE(2);

    public final int reply;

    DiscordReply(int reply){
        this.reply = reply;
    }
}
