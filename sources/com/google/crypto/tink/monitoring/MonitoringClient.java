package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.annotations.Alpha;

@Alpha
public interface MonitoringClient {

    public interface Logger {
        void log(int i11, long j11);

        void logFailure();
    }

    Logger createLogger(MonitoringKeysetInfo monitoringKeysetInfo, String str, String str2);
}
