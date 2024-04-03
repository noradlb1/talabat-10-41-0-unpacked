package org.mockito.internal.session;

import org.mockito.plugins.MockitoLogger;
import org.mockito.session.MockitoSessionLogger;

class MockitoLoggerAdapter implements MockitoLogger {
    private final MockitoSessionLogger logger;

    public MockitoLoggerAdapter(MockitoSessionLogger mockitoSessionLogger) {
        this.logger = mockitoSessionLogger;
    }

    public void log(Object obj) {
        this.logger.log(String.valueOf(obj));
    }
}
