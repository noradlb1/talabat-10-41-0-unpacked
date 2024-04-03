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
import okhttp3.Response;

public class CallbackExtension implements Callback {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private CallExtension callExtension;
    private Callback impl;
    private TransactionState transactionState;

    public CallbackExtension(Callback callback, TransactionState transactionState2, CallExtension callExtension2) {
        this.impl = callback;
        this.transactionState = transactionState2;
        this.callExtension = callExtension2;
    }

    private Response checkResponse(Response response) {
        if (getTransactionState().isComplete()) {
            return response;
        }
        log.debug("CallbackExtension.checkResponse() - transaction is not complete.  Inspecting and instrumenting response.");
        return OkHttp3TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
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

    public void onFailure(Call call, IOException iOException) {
        error(iOException);
        this.impl.onFailure(this.callExtension, iOException);
    }

    public void onResponse(Call call, Response response) throws IOException {
        this.impl.onResponse(this.callExtension, checkResponse(response));
    }
}
