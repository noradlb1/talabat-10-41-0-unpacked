package com.newrelic.agent.android.instrumentation.httpclient;

import com.newrelic.agent.android.instrumentation.ApacheInstrumentation;
import com.newrelic.agent.android.instrumentation.TransactionState;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

@Deprecated
public final class ResponseHandlerImpl<T> implements ResponseHandler<T> {
    private final ResponseHandler<T> impl;
    private final TransactionState transactionState;

    private ResponseHandlerImpl(ResponseHandler<T> responseHandler, TransactionState transactionState2) {
        this.impl = responseHandler;
        this.transactionState = transactionState2;
    }

    public static <T> ResponseHandler<? extends T> wrap(ResponseHandler<? extends T> responseHandler, TransactionState transactionState2) {
        return new ResponseHandlerImpl(responseHandler, transactionState2);
    }

    public T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        ApacheInstrumentation.inspectAndInstrument(this.transactionState, httpResponse);
        return this.impl.handleResponse(httpResponse);
    }
}
