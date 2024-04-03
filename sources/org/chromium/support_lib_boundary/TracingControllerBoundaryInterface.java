package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i11, Collection<String> collection, int i12) throws IllegalStateException, IllegalArgumentException;

    boolean stop(OutputStream outputStream, Executor executor);
}
