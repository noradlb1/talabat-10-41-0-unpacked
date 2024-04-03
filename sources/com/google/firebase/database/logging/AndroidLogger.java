package com.google.firebase.database.logging;

import android.util.Log;
import com.google.firebase.database.logging.Logger;
import java.util.List;

public class AndroidLogger extends DefaultLogger {
    public AndroidLogger(Logger.Level level, List<String> list) {
        super(level, list);
    }

    public String buildLogMessage(Logger.Level level, String str, String str2, long j11) {
        return str2;
    }

    public void debug(String str, String str2) {
    }

    public void error(String str, String str2) {
        Log.e(str, str2);
    }

    public void info(String str, String str2) {
        Log.i(str, str2);
    }

    public void warn(String str, String str2) {
        Log.w(str, str2);
    }
}
