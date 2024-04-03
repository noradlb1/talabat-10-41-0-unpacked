package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.util.Constants;
import okhttp3.Request;

public class RequestBuilderExtension {
    private Request.Builder impl;

    public RequestBuilderExtension(Request.Builder builder) {
        this.impl = builder;
        setCrossProcessHeader();
    }

    private void setCrossProcessHeader() {
        String crossProcessId = Agent.getCrossProcessId();
        if (crossProcessId != null) {
            this.impl.removeHeader(Constants.Network.CROSS_PROCESS_ID_HEADER);
            this.impl.addHeader(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId);
        }
    }

    public Request build() {
        return this.impl.build();
    }
}
