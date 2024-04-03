package org.mockito.internal.exceptions.stacktrace;

import java.io.Serializable;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.internal.configuration.GlobalConfiguration;

public class ConditionalStackTraceFilter implements Serializable {
    private static final long serialVersionUID = -8085849703510292641L;
    private final IMockitoConfiguration config = new GlobalConfiguration();
    private final StackTraceFilter filter = new StackTraceFilter();

    public void filter(Throwable th2) {
        if (this.config.cleansStackTrace()) {
            th2.setStackTrace(this.filter.filter(th2.getStackTrace(), true));
        }
    }
}
