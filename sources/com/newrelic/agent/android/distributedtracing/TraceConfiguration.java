package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import java.util.concurrent.atomic.AtomicReference;

public class TraceConfiguration extends HarvestAdapter {
    public static AtomicReference<TraceConfiguration> instance = new AtomicReference<>(new TraceConfiguration());
    String accountId;
    String applicationId;
    String trustedAccountId;

    public TraceConfiguration(String str, String str2, String str3) {
        this.accountId = str;
        this.applicationId = str2;
        this.trustedAccountId = str3;
        Harvest.addHarvestListener(this);
    }

    public static TraceConfiguration getInstance() {
        return instance.get();
    }

    public static TraceConfiguration setInstance(TraceConfiguration traceConfiguration) {
        instance.set(traceConfiguration);
        return getInstance();
    }

    public boolean isSampled() {
        return false;
    }

    public void onHarvestConnected() {
        setConfiguration(Harvest.getHarvestConfiguration());
    }

    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        this.applicationId = harvestConfiguration.getApplication_id();
        this.accountId = harvestConfiguration.getAccount_id();
        this.trustedAccountId = harvestConfiguration.getTrusted_account_key();
    }

    public TraceConfiguration(HarvestConfiguration harvestConfiguration) {
        this(harvestConfiguration.getAccount_id(), harvestConfiguration.getApplication_id(), harvestConfiguration.getTrusted_account_key());
    }

    public TraceConfiguration() {
        this(HarvestConfiguration.getDefaultHarvestConfiguration());
    }
}
