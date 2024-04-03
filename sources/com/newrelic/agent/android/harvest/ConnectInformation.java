package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;

public class ConnectInformation extends HarvestableArray {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private ApplicationInformation applicationInformation;
    private DeviceInformation deviceInformation;

    public ConnectInformation(ApplicationInformation applicationInformation2, DeviceInformation deviceInformation2) {
        if (applicationInformation2 == null) {
            log.error("null applicationInformation passed into ConnectInformation constructor");
        }
        if (deviceInformation2 == null) {
            log.error("null deviceInformation passed into ConnectInformation constructor");
        }
        this.applicationInformation = applicationInformation2;
        this.deviceInformation = deviceInformation2;
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        notNull(this.applicationInformation);
        jsonArray.add((JsonElement) this.applicationInformation.asJsonArray());
        notNull(this.deviceInformation);
        jsonArray.add((JsonElement) this.deviceInformation.asJsonArray());
        return jsonArray;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConnectInformation connectInformation = (ConnectInformation) obj;
        ApplicationInformation applicationInformation2 = this.applicationInformation;
        if (applicationInformation2 == null ? connectInformation.applicationInformation != null : !applicationInformation2.equals(connectInformation.applicationInformation)) {
            return false;
        }
        DeviceInformation deviceInformation2 = this.deviceInformation;
        DeviceInformation deviceInformation3 = connectInformation.deviceInformation;
        if (deviceInformation2 == null ? deviceInformation3 == null : deviceInformation2.equals(deviceInformation3)) {
            return true;
        }
        return false;
    }

    public ApplicationInformation getApplicationInformation() {
        return this.applicationInformation;
    }

    public DeviceInformation getDeviceInformation() {
        return this.deviceInformation;
    }

    public int hashCode() {
        int i11;
        ApplicationInformation applicationInformation2 = this.applicationInformation;
        int i12 = 0;
        if (applicationInformation2 != null) {
            i11 = applicationInformation2.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        DeviceInformation deviceInformation2 = this.deviceInformation;
        if (deviceInformation2 != null) {
            i12 = deviceInformation2.hashCode();
        }
        return i13 + i12;
    }

    public void setApplicationInformation(ApplicationInformation applicationInformation2) {
        this.applicationInformation = applicationInformation2;
    }

    public void setDeviceInformation(DeviceInformation deviceInformation2) {
        this.deviceInformation = deviceInformation2;
    }
}
