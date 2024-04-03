package com.newrelic.agent.android.instrumentation.okhttp2;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.BufferedSource;

public class PrebufferedResponseBody extends ResponseBody {
    ResponseBody impl;
    private BufferedSource source;

    public PrebufferedResponseBody(ResponseBody responseBody, BufferedSource bufferedSource) {
        this.impl = responseBody;
        this.source = bufferedSource;
    }

    public void close() throws IOException {
        this.impl.close();
    }

    public long contentLength() {
        try {
            long contentLength = this.impl.contentLength();
            if (((int) contentLength) != 0) {
                return contentLength;
            }
            return this.source.buffer().size();
        } catch (IOException unused) {
            return this.source.buffer().size();
        }
    }

    public MediaType contentType() {
        return this.impl.contentType();
    }

    public BufferedSource source() {
        return this.source;
    }
}
