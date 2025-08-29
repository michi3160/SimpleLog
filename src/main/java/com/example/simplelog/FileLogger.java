package com.example.simplelog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {

    private final File dataFolder;

    public FileLogger(SimpleLog plugin) {
        this.dataFolder = plugin.getDataFolder();
    }

    // ログを書き込むメインのメソッド
    public synchronized void log(LogType type, String message) {
        File directory = new File(dataFolder, type.getDirectoryName());
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File logFile = new File(directory, date + ".log");

        try (FileWriter fw = new FileWriter(logFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}