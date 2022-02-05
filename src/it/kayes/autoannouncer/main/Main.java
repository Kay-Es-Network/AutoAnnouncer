package it.kayes.autoannouncer.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private static MessageSender broadcast;

    public void onEnable() {
        instance = this;

        broadcast = new MessageSender();

    }

    public static Main getInstance() {
        return instance;
    }

    public static MessageSender getBroadcast() {
        return broadcast;
    }
}
