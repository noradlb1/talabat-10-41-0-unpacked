package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.util.Constants;
import java.io.IOException;
import java.util.ArrayList;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;

public class ClientExtension implements Client {
    private Client impl;
    private Request request;
    private TransactionState transactionState;

    public ClientExtension(Client client) {
        this.impl = client;
    }

    private void checkResponse(Response response) {
        if (!getTransactionState().isComplete()) {
            RetrofitTransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), response);
        }
    }

    private Request setCrossProcessHeaders(Request request2) {
        String crossProcessId = Agent.getCrossProcessId();
        ArrayList arrayList = new ArrayList(request2.getHeaders());
        if (crossProcessId != null) {
            arrayList.add(new Header(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId));
        }
        return new Request(request2.getMethod(), request2.getUrl(), arrayList, request2.getBody());
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

    public Response execute(Request request2) throws IOException {
        this.request = request2;
        this.transactionState = getTransactionState();
        Request crossProcessHeaders = setCrossProcessHeaders(request2);
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            this.transactionState.setTrace(DistributedTracing.getInstance().startTrace(this.transactionState));
            crossProcessHeaders = RetrofitTransactionStateUtil.setDistributedTraceHeaders(this.transactionState, crossProcessHeaders);
        }
        try {
            Response execute = this.impl.execute(crossProcessHeaders);
            execute.getUrl();
            execute.getStatus();
            execute.getReason();
            execute.getHeaders();
            new ContentBufferingTypedInput(execute.getBody());
            throw null;
        } catch (IOException e11) {
            error(e11);
            throw e11;
        }
    }

    public TransactionState getTransactionState() {
        if (this.transactionState == null) {
            this.transactionState = new TransactionState();
        }
        RetrofitTransactionStateUtil.inspectAndInstrument(this.transactionState, this.request);
        return this.transactionState;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }
}
