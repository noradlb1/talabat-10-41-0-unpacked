package com.newrelic.agent.android.instrumentation.okhttp3;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class PrebufferedResponseBody extends ResponseBody {
    private final long contentLength;
    private final ResponseBody impl;
    private final BufferedSource source;

    public PrebufferedResponseBody(ResponseBody responseBody) {
        long j11;
        BufferedSource source2 = responseBody.source();
        if (responseBody.contentLength() == -1) {
            Buffer buffer = new Buffer();
            try {
                source2.readAll(buffer);
                source2 = buffer;
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        this.impl = responseBody;
        this.source = source2;
        if (responseBody.contentLength() >= 0) {
            j11 = responseBody.contentLength();
        } else {
            j11 = source2.buffer().size();
        }
        this.contentLength = j11;
    }

    public void close() {
        this.impl.close();
    }

    public long contentLength() {
        long contentLength2 = this.impl.contentLength();
        if (((int) contentLength2) != 0) {
            return contentLength2;
        }
        return this.source.buffer().size();
    }

    public MediaType contentType() {
        return this.impl.contentType();
    }

    public BufferedSource source() {
        return this.source;
    }
}
