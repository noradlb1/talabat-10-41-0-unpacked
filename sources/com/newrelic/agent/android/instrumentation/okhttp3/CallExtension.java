package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

public class CallExtension implements Call {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private OkHttpClient client;
    Call impl;
    Request request;
    private TransactionState transactionState;

    public CallExtension(OkHttpClient okHttpClient, Request request2, Call call, TransactionState transactionState2) {
        this.client = okHttpClient;
        this.request = request2;
        this.impl = call;
        this.transactionState = transactionState2;
    }

    private Response checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return response;
        }
        if (response.request() != null) {
            OkHttp3TransactionStateUtil.inspectAndInstrument(this.transactionState, response.request());
        }
        return OkHttp3TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
    }

    public void cancel() {
        this.impl.cancel();
    }

    public void enqueue(Callback callback) {
        getTransactionState();
        this.impl.enqueue(new CallbackExtension(callback, this.transactionState, this));
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

    public Call getImpl() {
        return this.impl;
    }

    public TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        OkHttp3TransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
        return this.transactionState;
    }

    public boolean isCanceled() {
        return this.impl.isCanceled();
    }

    public boolean isExecuted() {
        return false;
    }

    public Request request() {
        return this.impl.request();
    }

    public Timeout timeout() {
        return this.impl.timeout();
    }

    public Call clone() {
        return this.impl.clone();
    }
}
