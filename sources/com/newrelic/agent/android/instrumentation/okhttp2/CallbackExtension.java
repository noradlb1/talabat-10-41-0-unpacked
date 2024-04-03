package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallbackExtension implements Callback {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Callback impl;
    private TransactionState transactionState;

    public CallbackExtension(Callback callback, TransactionState transactionState2) {
        this.impl = callback;
        this.transactionState = transactionState2;
    }

    private Response checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return response;
        }
        log.verbose("CallbackExtension.checkResponse() - transaction is not complete.  Inspecting and instrumenting response.");
        return OkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
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

    public TransactionState getTransactionState() {
        return this.transactionState;
    }

    public void onFailure(Request request, IOException iOException) {
        error(iOException);
        this.impl.onFailure(request, iOException);
    }

    public void onResponse(Response response) throws IOException {
        this.impl.onResponse(checkResponse(response));
    }
}
