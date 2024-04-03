package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.instrumentation.TransactionState;

public interface TraceFacade {
    void setConfiguration(TraceConfiguration traceConfiguration);

    void setTraceListener(TraceListener traceListener);

    TraceContext startTrace(TransactionState transactionState);
}
