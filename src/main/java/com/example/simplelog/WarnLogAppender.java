package com.example.simplelog;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.Level;

import java.text.SimpleDateFormat;
import java.util.Date;

@Plugin(name = "WarnLogAppender", category = "Core", elementType = "appender", printObject = true)
public class WarnLogAppender extends AbstractAppender {

    private final FileLogger fileLogger;
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public WarnLogAppender(FileLogger fileLogger) {
        super("WarnLogAppender", null,
              PatternLayout.createDefaultLayout(), false, Property.EMPTY_ARRAY);
        this.fileLogger = fileLogger;
    }

    @Override
    public void append(LogEvent event) {
        if (event.getLevel().equals(Level.WARN)) {
            String time = timeFormat.format(new Date());
            String message = String.format("%s-%s",
                    time,
                    event.getMessage().getFormattedMessage()
            );
            fileLogger.log(LogType.WARN, message);
        }
    }
}