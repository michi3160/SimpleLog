package com.example.simplelog;

public enum LogType {
    JOIN_LEFT("join-left"),
    CHAT("chat"),
    COMMAND("command"),
    WARN("warn");

    private final String directoryName;

    LogType(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryName() {
        return directoryName;
    }
}