package com.newrelic.agent.android.logging;

import com.huawei.hms.flutter.map.constants.Param;
import java.io.PrintStream;

public class ConsoleAgentLog implements AgentLog {
    private int level = 3;

    private static void print(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println("[" + str + "][newrelic] " + str2);
    }

    public void audit(String str) {
        if (this.level == 6) {
            print("AUDIT", str);
        }
    }

    public void debug(String str) {
        if (this.level >= 5) {
            print("DEBUG", str);
        }
    }

    public void error(String str, Throwable th2) {
        if (this.level >= 1) {
            String message = th2.getMessage();
            print(Param.ERROR, str + " " + message);
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void info(String str) {
        if (this.level >= 3) {
            print("INFO", str);
        }
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void verbose(String str) {
        if (this.level >= 4) {
            print("VERBOSE", str);
        }
    }

    public void warn(String str) {
        if (this.level >= 2) {
            print("WARN", str);
        }
    }

    public void error(String str) {
        if (this.level >= 1) {
            print(Param.ERROR, str);
        }
    }
}
