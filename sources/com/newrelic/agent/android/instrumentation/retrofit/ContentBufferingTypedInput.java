package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import retrofit.mime.TypedInput;

public class ContentBufferingTypedInput implements TypedInput {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private TypedInput impl;
    private CountingInputStream inputStream;

    public ContentBufferingTypedInput(TypedInput typedInput) {
        throw null;
    }

    private void prepareInputStream() throws IOException {
        if (this.inputStream == null) {
            try {
                InputStream in2 = this.impl.in();
                if (in2 == null) {
                    in2 = new ByteArrayInputStream(new byte[0]);
                }
                this.inputStream = new CountingInputStream(in2, true);
            } catch (Exception e11) {
                AgentLog agentLog = log;
                String obj = e11.toString();
                agentLog.error("ContentBufferingTypedInput: " + obj);
            }
        }
    }

    public InputStream in() throws IOException {
        prepareInputStream();
        return this.inputStream;
    }

    public long length() {
        try {
            prepareInputStream();
            return (long) this.inputStream.available();
        } catch (IOException e11) {
            log.error("ContentBufferingTypedInput generated an IO exception: ", e11);
            return -1;
        }
    }

    public String mimeType() {
        return this.impl.mimeType();
    }
}
