package it.kayes.autoannouncer.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MessageSender extends MessageLoader {

    private boolean stopped;
    private short state;

    public MessageSender() {
        super();
        broadcast();
    }

    public void broadcast() {

        new BukkitRunnable() {

            @Override
            public void run() {
                if(!stopped) {

                    String[] message = MessageSender.messages.get(state);

                    for (Player p : Bukkit.getOnlinePlayers())
                        for (String s : message)
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));

                    state++;
                    if (state>=MessageSender.messages.size())
                        state = 0;
                }
            }

        }.runTaskTimerAsynchronously(Main.getInstance(), super.loop*20L, super.loop*20L);
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }
}
