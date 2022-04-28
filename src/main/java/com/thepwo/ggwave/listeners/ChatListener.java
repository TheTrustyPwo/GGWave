package com.thepwo.ggwave.listeners;

import com.thepwo.ggwave.GGWave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChatListener implements Listener {
    private final GGWave plugin = GGWave.getPlugin();

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (!this.plugin.isGgWaveRunning()) return;
        if (!e.getMessage().equalsIgnoreCase("gg")) return;

        List<String> list = this.plugin.getConfig().getStringList("gg-messages");
        String ggMessage = list.get(ThreadLocalRandom.current().nextInt(list.size()));
        e.setMessage(ChatColor.translateAlternateColorCodes('&', ggMessage));
    }
}
