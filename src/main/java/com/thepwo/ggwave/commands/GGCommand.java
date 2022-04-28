package com.thepwo.ggwave.commands;

import com.thepwo.ggwave.GGWave;
import org.bukkit.Bukkit;
import org.bukkit.command.*;

import java.util.List;

@SuppressWarnings("NullableProblems")
public class GGCommand implements CommandExecutor, TabCompleter {
    private final GGWave plugin = GGWave.getPlugin();

    public void register() {
        PluginCommand command = this.plugin.getCommand("ggwave");
        command.setExecutor(this);
        command.setTabCompleter(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("ggwave.admin")) {
            sender.sendMessage(this.plugin.getMessage("no-permission"));
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(this.plugin.getMessage("ggwave-main-message"));
            return false;
        }

        switch (args[0].toUpperCase()) {
            case "START" -> {
                if (args.length != 2) {
                    sender.sendMessage(this.plugin.getMessage("invalid-usage")
                            .replace("%usage%", "/ggwave start <duration in seconds>"));
                    return false;
                }

                if (this.plugin.isGgWaveRunning()) {
                    sender.sendMessage(this.plugin.getMessage("ggwave-already-started"));
                    return false;
                }

                try {
                    long duration = Long.parseLong(args[1]);

                    if (duration <= 0) {
                        sender.sendMessage(this.plugin.getMessage("invalid-number"));
                        return false;
                    }

                    this.plugin.startGGWave(duration);
                    sender.sendMessage(this.plugin.getMessage("ggwave-started")
                            .replace("%duration%", String.valueOf(duration)));
                } catch (NumberFormatException e) {
                    sender.sendMessage(this.plugin.getMessage("invalid-number"));
                    return false;
                }
            }
            case "STOP" -> {
                if (!this.plugin.isGgWaveRunning()) {
                    sender.sendMessage(this.plugin.getMessage("ggwave-already-stopped"));
                    return false;
                }

                this.plugin.setGgWaveRunning(false);
                sender.sendMessage(this.plugin.getMessage("ggwave-stopped"));
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) return List.of("start", "stop");
        else if (args.length == 2 && args[0].equalsIgnoreCase("start")) return List.of("5", "10", "15", "20");
        return null;
    }
}
