package com.newrelic.agent.android.api.v1;

import com.newrelic.agent.android.api.common.ConnectionState;
import java.util.EventObject;

public final class ConnectionEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final ConnectionState connectionState;

    public ConnectionEvent(Object obj) {
        this(obj, (ConnectionState) null);
    }

    public ConnectionState getConnectionState() {
        return this.connectionState;
    }

    public ConnectionEvent(Object obj, ConnectionState connectionState2) {
        super(obj);
        this.connectionState = connectionState2;
    }
}
