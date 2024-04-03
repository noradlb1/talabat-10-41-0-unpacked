package com.newrelic.agent.android.logging;

public class NullAgentLog implements AgentLog {
    public void audit(String str) {
    }

    public void debug(String str) {
    }

    public void error(String str) {
    }

    public void error(String str, Throwable th2) {
    }

    public int getLevel() {
        return 5;
    }

    public void info(String str) {
    }

    public void setLevel(int i11) {
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
