package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallExtension extends Call {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private OkHttpClient client;
    Call impl;
    Request request;
    private TransactionState transactionState;

    public CallExtension(OkHttpClient okHttpClient, Request request2, Call call, TransactionState transactionState2) {
        super(okHttpClient, request2);
        this.client = okHttpClient;
        this.request = request2;
        this.impl = call;
        this.transactionState = transactionState2;
    }

    private Response checkResponse(Response response) {
        if (!getTransactionState().isComplete()) {
            response = OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
            if (response.request() != null) {
                OkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, response.request());
            }
        }
        return response;
    }

    public void cancel() {
        this.impl.cancel();
    }

    public void enqueue(Callback callback) {
        getTransactionState();
        this.impl.enqueue(new CallbackExtension(callback, this.transactionState));
    }

    public void error(Exception exc) {
        TransactionData end;
        TransactionState transactionState2 = getTransactionState();
        TransactionStateUtil.setErrorCodeFromException(transactionState2, exc);
        if (!transactionState2.isComplete() && (end = transactionState2.end()) != null) {
            end.setResponseBody(exc.toString());
            TaskQueue.queue(new HttpTransactionMeasurement(end));
        }
    }

    public Response execute() throws IOException {
        getTransactionState();
        try {
            return checkResponse(this.impl.execute());
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        OkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
        return this.transactionState;
    }

    public boolean isCanceled() {
        return this.impl.isCanceled();
    }
}
