package com.example.simplelog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleLog extends JavaPlugin {

    private FileLogger fileLogger;
    private WarnLogAppender warnAppender;

    @Override
    public void onEnable() {
        // ファイルロガーを初期化
        this.fileLogger = new FileLogger(this);
        getLogger().info("FileLogger has been initialized.");

        // イベントリスナーを登録
        getServer().getPluginManager().registerEvents(new LogListener(this.fileLogger), this);
        getLogger().info("Event listeners have been registered.");

        // コンソールのWARNを記録するアペンダーをセットアップ
        try {
            Logger rootLogger = (Logger) LogManager.getRootLogger();
            this.warnAppender = new WarnLogAppender(this.fileLogger);
            this.warnAppender.start();
            rootLogger.addAppender(this.warnAppender);
            getLogger().info("WarnLogAppender has been attached to the root logger.");
        } catch (Exception e) {
            getLogger().severe("Failed to attach WarnLogAppender!");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // プラグイン無効時にアペンダーを削除
        if (this.warnAppender != null) {
            try {
                Logger rootLogger = (Logger) LogManager.getRootLogger();
                rootLogger.removeAppender(this.warnAppender);
                this.warnAppender.stop();
                getLogger().info("WarnLogAppender has been detached.");
            } catch (Exception e) {
                getLogger().severe("Failed to detach WarnLogAppender!");
                e.printStackTrace();
            }
        }
    }
}