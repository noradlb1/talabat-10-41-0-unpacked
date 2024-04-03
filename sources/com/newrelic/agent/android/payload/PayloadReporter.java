package com.newrelic.agent.android.payload;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PayloadReporter {
    /* access modifiers changed from: protected */
    public static final AgentLog log = AgentLogManager.getAgentLog();
    protected final AgentConfiguration agentConfiguration;
    protected final AtomicBoolean isEnabled = new AtomicBoolean(false);
    protected final AtomicBoolean isStarted = new AtomicBoolean(false);

    public PayloadReporter(AgentConfiguration agentConfiguration2) {
        this.agentConfiguration = agentConfiguration2;
    }

    public AgentConfiguration getAgentConfiguration() {
        return this.agentConfiguration;
    }

    public boolean isEnabled() {
        return this.isEnabled.get();
    }

    public void setEnabled(boolean z11) {
        this.isEnabled.set(z11);
    }

    public abstract void start();

    public abstract void stop();
}
