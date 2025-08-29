package com.example.simplelog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogListener implements Listener {

    private final FileLogger fileLogger;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public LogListener(FileLogger fileLogger) {
        this.fileLogger = fileLogger;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String time = timeFormat.format(new Date());
        String message = String.format("join-%s:%s-%s",
                player.getName(),
                player.getUniqueId(),
                time
        );
        fileLogger.log(LogType.JOIN_LEFT, message);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String time = timeFormat.format(new Date());
        String message = String.format("left-%s:%s-%s",
                player.getName(),
                player.getUniqueId(),
                time
        );
        fileLogger.log(LogType.JOIN_LEFT, message);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String time = timeFormat.format(new Date());
        String message = String.format("%s:%s-%s-%s",
                player.getName(),
                player.getUniqueId(),
                time,
                event.getMessage()
        );
        fileLogger.log(LogType.CHAT, message);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String time = timeFormat.format(new Date());
        String message = String.format("%s:%s-%s-%s",
                player.getName(),
                player.getUniqueId(),
                time,
                event.getMessage()
        );
        fileLogger.log(LogType.COMMAND, message);
    }
}