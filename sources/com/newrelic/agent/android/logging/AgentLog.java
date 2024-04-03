package com.newrelic.agent.android.logging;

public interface AgentLog {
    public static final int AUDIT = 6;
    public static final int DEBUG = 5;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int VERBOSE = 4;
    public static final int WARN = 2;

    void audit(String str);

    void debug(String str);

    void error(String str);

    void error(String str, Throwable th2);

    int getLevel();

    void info(String str);

    void setLevel(int i11);

    void verbose(String str);

    void warn(String str);
}
