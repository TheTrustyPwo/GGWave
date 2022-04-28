package com.thepwo.ggwave;

import com.thepwo.ggwave.commands.GGCommand;
import com.thepwo.ggwave.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.stream.Collectors;

public final class GGWave extends JavaPlugin {
    private static GGWave plugin;
    private boolean ggWaveRunning;
    private BukkitTask ggWaveTask;

    @Override
    public void onEnable() {
        plugin = this;
        ggWaveRunning = false;
        saveDefaultConfig();
        registerCommands();
        registerListeners();
        getLogger().info("GGWave Enabled!");
    }

    private void registerCommands() {
        (new GGCommand()).register();
    }

    private void registerListeners() {
        (new ChatListener()).register();
    }

    @Override
    public void onDisable() {
        getLogger().info("GGWave Disabled!");
    }

    public static GGWave getPlugin() {
        return plugin;
    }

    public String getMessage(String identifier) {
        return getConfig().getStringList("messages." + identifier)
                .stream()
                .map(s -> ChatColor.translateAlternateColorCodes('&', s))
                .collect(Collectors.joining("\n"));
    }

    public void startGGWave(long duration) {
        setGgWaveRunning(true);
        this.ggWaveTask = Bukkit.getScheduler().runTaskLaterAsynchronously(this,
                () -> setGgWaveRunning(false), duration * 20);
    }

    public boolean isGgWaveRunning() {
        return ggWaveRunning;
    }

    public void setGgWaveRunning(boolean ggWaveRunning) {
        this.ggWaveRunning = ggWaveRunning;
        if (ggWaveRunning) {
            Bukkit.broadcastMessage(getMessage("ggwave-start-broadcast"));
        } else {
            Bukkit.broadcastMessage(getMessage("ggwave-end-broadcast"));
            this.ggWaveTask.cancel();
        }
    }
}
