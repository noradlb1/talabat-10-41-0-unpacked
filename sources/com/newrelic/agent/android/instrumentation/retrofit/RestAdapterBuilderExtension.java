package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.Executor;
import retrofit.Endpoint;
import retrofit.ErrorHandler;
import retrofit.Profiler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;

public class RestAdapterBuilderExtension extends RestAdapter.Builder {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private RestAdapter.Builder impl;

    public RestAdapterBuilderExtension(RestAdapter.Builder builder) {
        this.impl = builder;
    }

    public RestAdapter build() {
        return this.impl.build();
    }

    public RestAdapter.Builder setClient(Client client) {
        AgentLog agentLog = log;
        agentLog.debug("RestAdapterBuilderExtension.setClient() wrapping client " + client + " with new ClientExtension.");
        return this.impl.setClient(new ClientExtension(client));
    }

    public RestAdapter.Builder setConverter(Converter converter) {
        return this.impl.setConverter(converter);
    }

    public RestAdapter.Builder setEndpoint(String str) {
        return this.impl.setEndpoint(str);
    }

    public RestAdapter.Builder setErrorHandler(ErrorHandler errorHandler) {
        return this.impl.setErrorHandler(errorHandler);
    }

    public RestAdapter.Builder setExecutors(Executor executor, Executor executor2) {
        return this.impl.setExecutors(executor, executor2);
    }

    public RestAdapter.Builder setLog(RestAdapter.Log log2) {
        return this.impl.setLog(log2);
    }

    public RestAdapter.Builder setLogLevel(RestAdapter.LogLevel logLevel) {
        return this.impl.setLogLevel(logLevel);
    }

    public RestAdapter.Builder setProfiler(Profiler profiler) {
        return this.impl.setProfiler(profiler);
    }

    public RestAdapter.Builder setRequestInterceptor(RequestInterceptor requestInterceptor) {
        return this.impl.setRequestInterceptor(requestInterceptor);
    }

    public RestAdapter.Builder setEndpoint(Endpoint endpoint) {
        return this.impl.setEndpoint(endpoint);
    }

    public RestAdapter.Builder setClient(Client.Provider provider) {
        return this.impl.setClient(provider);
    }
}
