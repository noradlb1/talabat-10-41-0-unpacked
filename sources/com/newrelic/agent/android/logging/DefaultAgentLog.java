package com.newrelic.agent.android.logging;

public class DefaultAgentLog implements AgentLog {
    private AgentLog impl = new NullAgentLog();

    public void audit(String str) {
        synchronized (this) {
            this.impl.audit(str);
        }
    }

    public void debug(String str) {
        synchronized (this) {
            this.impl.debug(str);
        }
    }

    public void error(String str) {
        synchronized (this) {
            this.impl.error(str);
        }
    }

    public int getLevel() {
        int level;
        synchronized (this) {
            level = this.impl.getLevel();
        }
        return level;
    }

    public void info(String str) {
        synchronized (this) {
            this.impl.info(str);
        }
    }

    public void setImpl(AgentLog agentLog) {
        synchronized (this) {
            this.impl = agentLog;
        }
    }

    public void setLevel(int i11) {
        synchronized (this) {
            this.impl.setLevel(i11);
        }
    }

    public void verbose(String str) {
        synchronized (this) {
            this.impl.verbose(str);
        }
    }

    public void warn(String str) {
        synchronized (this) {
            this.impl.warn(str);
        }
    }

    public void error(String str, Throwable th2) {
        synchronized (this) {
            this.impl.error(str, th2);
        }
    }
}
