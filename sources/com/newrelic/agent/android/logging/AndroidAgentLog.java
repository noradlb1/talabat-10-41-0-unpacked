package com.newrelic.agent.android.logging;

import android.util.Log;

public class AndroidAgentLog implements AgentLog {
    private static final String TAG = "newrelic";
    private int level = 3;

    public void audit(String str) {
    }

    public void debug(String str) {
    }

    public void error(String str) {
        if (this.level >= 1) {
            Log.e("newrelic", str);
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void info(String str) {
        if (this.level >= 3) {
            Log.i("newrelic", str);
        }
    }

    public void setLevel(int i11) {
        if (i11 > 6 || i11 < 1) {
            throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
        }
        this.level = i11;
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
        if (this.level >= 2) {
            Log.w("newrelic", str);
        }
    }

    public void error(String str, Throwable th2) {
        if (this.level >= 1) {
            Log.e("newrelic", str, th2);
        }
    }
}
