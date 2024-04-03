package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.Encoder;
import java.util.ArrayList;
import java.util.List;

public class NullAgentImpl implements AgentImpl {
    public static final NullAgentImpl instance = new NullAgentImpl();
    DeviceInformation devInfo;
    private int responseBodyLimit = 1024;
    private TicToc sessionDurationMillis = new TicToc();

    public void addTransactionData(TransactionData transactionData) {
    }

    public void disable() {
    }

    public List<TransactionData> getAndClearTransactionData() {
        return new ArrayList();
    }

    public ApplicationInformation getApplicationInformation() {
        return new ApplicationInformation("null", "0.0", "null", "0");
    }

    public String getCrossProcessId() {
        return null;
    }

    public DeviceInformation getDeviceInformation() {
        if (this.devInfo == null) {
            DeviceInformation deviceInformation = new DeviceInformation();
            this.devInfo = deviceInformation;
            deviceInformation.setOsName("Android");
            this.devInfo.setOsVersion("12");
            this.devInfo.setOsBuild("12.0.1");
            this.devInfo.setManufacturer("NullAgent");
            this.devInfo.setModel("NullAgent");
            this.devInfo.setAgentName("AndroidAgent");
            this.devInfo.setAgentVersion("6.5.1");
            this.devInfo.setDeviceId("389C9738-A761-44DE-8A66-1668CFD67DA1");
            this.devInfo.setArchitecture("Fake Arch");
            this.devInfo.setRunTime("1.8.0");
            this.devInfo.setSize("Fake Size");
            this.devInfo.setApplicationFramework(ApplicationFramework.Native);
        }
        return this.devInfo;
    }

    public Encoder getEncoder() {
        return new Encoder() {
            public String encode(byte[] bArr) {
                return new String(bArr);
            }

            public String encodeNoWrap(byte[] bArr) {
                return encode(bArr);
            }
        };
    }

    public EnvironmentInformation getEnvironmentInformation() {
        return new EnvironmentInformation(0, 1, "none", "none", new long[]{0, 0});
    }

    public String getNetworkCarrier() {
        return "unknown";
    }

    public String getNetworkWanType() {
        return "unknown";
    }

    public int getResponseBodyLimit() {
        return this.responseBodyLimit;
    }

    public long getSessionDurationMillis() {
        return this.sessionDurationMillis.peek();
    }

    public int getStackTraceLimit() {
        return 0;
    }

    public boolean hasReachableNetworkConnection(String str) {
        return true;
    }

    public boolean isDisabled() {
        return true;
    }

    public boolean isInstantApp() {
        return false;
    }

    public void mergeTransactionData(List<TransactionData> list) {
    }

    public void setLocation(String str, String str2) {
    }

    public void setResponseBodyLimit(int i11) {
        this.responseBodyLimit = i11;
    }

    public void start() {
        this.sessionDurationMillis.tic();
    }

    public void stop() {
        this.sessionDurationMillis.toc();
    }

    public boolean updateSavedConnectInformation() {
        return false;
    }
}
