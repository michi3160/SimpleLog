# SimpleLog　plugin
A lightweight and straightforward logging plugin for Spigot/Paper servers, designed to keep a clear and organized record of server activities.

## Overview
SimpleLog is a simple, "drop-and-play" plugin that automatically logs key server events into well-structured text files. It's designed for server administrators who need an easy way to monitor player activities and server health without the complexity of larger plugins. Once installed, it runs silently in the background, requiring no configuration.

# Features
- Player Connection Logging: Records every time a player joins or leaves the server.

- Chat Logging: Captures all public player chat messages.

- Command Logging: Logs all commands executed by players.

- Warning Logging: Captures and saves all [WARN] messages from the server console.

- Organized File Structure: Automatically organizes logs into separate folders (join-left, chat, command, warn).

- Daily Log Files: Creates a new log file for each day, named with the current date (e.g., 2025-08-28.log).

- High Compatibility: Built for Minecraft 1.21.x and compatible with Spigot, Paper, and Bukkit.

- Zero Configuration: No setup required. Just drop it into your plugins folder and it works.

## Installation
1. Download the latest SimpleLog-vx.x-x.jar from the Releases page.

2. Place the downloaded .jar file into your server's /plugins directory.

3. Restart or reload your server. The plugin will automatically generate the required folders and start logging.

## Log File Structure
All logs are stored within the plugins/SimpleLog/ directory. The structure is as follows:


```
plugins/
└── SimpleLog/
    ├── chat/
    │   └── 2025-08-28.log
    ├── command/
    │   └── 2025-08-28.log
    ├── join-left/
    │   └── 2025-08-28.log
    └── warn/
        └── 2025-08-28.log
```

Log Formats
Each log entry is formatted for easy reading and parsing.

- ```join-left/YYYY-MM-DD.log```

```join-PlayerName:player-uuid-HH:mm:ss```
```left-PlayerName:player-uuid-HH:mm:ss```
- ```chat/YYYY-MM-DD.log```

```PlayerName:player-uuid-HH:mm:ss-The chat message sent by the player.```
- ```command/YYYY-MM-DD.log```

```PlayerName:player-uuid-HH:mm:ss-/the command and its arguments```
- ```warn/YYYY-MM-DD.log```

- ```HH:mm:ss-The full warning message from the console.```
