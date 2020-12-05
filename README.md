<img src="https://raw.githubusercontent.com/vatuu/discord-rpc/master/rpc.png" align="right" height="256" width="256"/>

[![jitpack](https://jitpack.io/v/Vatuu/discord-rpc.svg)](https://jitpack.io/#Vatuu/discord-rpc) [![Build Status](https://travis-ci.org/Vatuu/discord-rpc.svg?branch=master)](https://travis-ci.org/Vatuu/discord-rpc) 

# discord-rpc
Java Wrapper of the Discord-RPC Library for Discord Rich Presence.

Ever wanted to use the Discord Rich Presence API in a Java Application, but then realized that the native version is C++ only?
Well, worry no more, because Vatuu's Discord RPC is here. A complete wrapper of all functions the native Dynamic Library contains.

## Features
Set advanced pieces of information about your game in the players' profile, when they use your Application, from text to images, timers and even giving the option of joining/spectating a game!

The so-called Rich Presence contains the following fields for you to fill in:

- State: The general state the current play-session is in (Waiting, Playing, Watching some leaderboards, etc).
- Details: Details to the current play-session, like the location, or current score.
- Timestamps: Show how long the current game-session will go, or how long the player is already playing, up to you.
- Images: One big cubic, and one smaller round images with a custom tooltip text, to show some more details.
- Parties: Show the current size of parties or lobbies to indicate if the player is forever alone or not.
- Match/Join/Spectate: Some super secret Strings that are needed for joining and spectating a game. More to that below.
- Instance Int: If it's a game instance or not, as simple as that.

## How to use?
Using this wrapper is as simple as it can be, with barely any difference of the "original" API.

### Step 0
  Download one of the releases or download the sources to build your own release. Then, simply add and include it in your project.
  
  Currently supported OS include ``Windows x86``, ``Windows x64`` and ``Unix x64``. OSX and macOS support is currently broken,
  although we're working hard on getting it to work again.

### Step 1
Initialize the Discord RPC when your Application starts up. The Library is mostly static, so there is no need to create an Instance.
The ``DiscordRPC.discordInitialize();`` method takes 3 arguments to start.
- ``Client ID`` is the ID of your Discord Application.
- ``Handler`` is an instance of a DiscordEventHandler-Object. Callbacks to HandlerClasses are registered in there.
- ``AutoRegister``does not really matter right now and is always ``true``.
- If your application is a Steam Application, the Initialize Methods takes another String of your Steam App ID.
  
The Event Handler contains instances of the classes that handle Callbacks of the DiscordRPC. These classes have to implement
the appropriate Interface for the Callback. The Callback-Interfaces are the following:
- ``DisconnectedCallback``
- ``ErroredCallback``
- ``JoinGameCallback``
- ``JoinRequestCallback``
- ``ReadyCallback``
- ``SpectateGameCallback``
  
To register a Callback, simply follow the following code:
```java
public static class ReadyEvent implements ReadyCallback {
  public void apply() {
    System.out.println("Discord's ready!");
  }
}
  
public class MainClass {
  public void startup() {
    DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
        System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
    }).build();
  }
}
```
  
*All Callbacks are optional. You only need to register Classes that implement the Callbacks you need, or if you don't need any,
simply pass an empty DiscordEventHandler Object.*
  
To summarize:
```java 
public void startup() {
  DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
      System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
  }).build();
  DiscordRPC.discordInitialize("1234567890", handlers, true);
}
```
  
This would result in the message "Welcome User#1234!" being printed out in the console after the connection to Discord has been established, and fitted with the users username and discriminator.
  
### Step 2
To allow callbacks to be fired, you have to periodically call the method ``DiscordRPC.discordRunCallbacks();``. Otherwise, no callbacks will be passed
to the application.
  
**Congratulations, your Application is ready to utilize the Rich Presence.**
 
## Updating the Presence
 
To update the Rich Presence of a player, a ``DiscordRichPresence`` Object is required. There are created in the same way as the
EventHandler is created, by using a Builder:
```java
public void createNewPresence() {
  DiscordRichPresence rich = new DiscordRichPresence.Builder("This is the current state.").setDetails("These are some details.").build();
}
```
After the Object has been created, it simply has to be passed to the DiscordRPC with the methods ``DiscordRPC.discordUpdatePresence(DiscordRichPresence);``

```java
public void createNewPresence() {
  DiscordRichPresence rich = new DiscordRichPresence.Builder("This is the current state.").setDetails("These are some details.").build();
  DiscordRPC.discordUpdatePresence(rich);
}
```

After calling that method, the presence of the player will have updated, according to the information passed. Just like the EventHandler
before, all fields are optional and can be left empty if one desires so. Just keep in mind that a Match- Join- and Spectate Secret are needed when
utilizing the Join and Spectate features. 

More information regarding the fields of the Rich Presence and the correct usage of them can be found [HERE](https://discordapp.com/developers/docs/rich-presence/how-to#updating-presence "Discord Developer Docs").

## Shutting down the RPC
To allow the IOStream utilized by the RPC to close properly, the method ``DiscordRPC.discordShutdown();`` should **always** be called on
exit of your application, otherwise issues might occure.

## Joining and Spectating
The method ``DiscordRPC.discordRespond(String userId, DiscordReply reply);`` handles the reply on a JoinRequest by a player.
When a player requests to join a game, the ``JoinRequestCallback`` is called, which should be used to process the request. That request contains the Username, UserID and
the avatar of that user transformed into a SHA-1 hash.

***Important Note:*** **To let a application use the Spectate Feature, the application has to be greenlit by the Discord Developers.
Otherwise, only certain users added to the Application will be able to use these features.**

For further information regarding joining, spectating and getting greenlit, please visit [THIS PAGE](https://discordapp.com/developers/docs/rich-presence/how-to#joining "Discord Developer Docs").

~~ *More will be added soon* ~~

## The Example Application
Contained in this repository is a .JAR file called ``RPCTest.jar``. This simple command line application can be used to test the Rich Presence
for yourself! Simply add the Application named "RPCTest" to your Discord Games, and it will be recognized. Since Discord only detects games that have an active window, I discourage you from closing the small window called "Derp" that will pop up as soon as you start the RPCTest.

The RPCTest has only two commands:
  - ``test`` will increase the "score" value in the details of your presence.
  - ``shutdown`` is self-explanatory.
 
 -----------------------------------------------------------------------------------------------------------------------------------------------------------------
 More questions? I recommend checking the official [Discord Developer Docs](https://discordapp.com/developers/docs/rich-presence/ "Discord Developer Docs").
 
 **Best regards,**
Vatuu   

[![Donate](https://img.shields.io/badge/Donate-PayPal-7289DA.svg)](https://www.paypal.me/NicolasAdamoglou)
