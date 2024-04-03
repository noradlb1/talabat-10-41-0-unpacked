package org.mockito;

public interface ScopedMock extends AutoCloseable {
    void close();

    void closeOnDemand();

    boolean isClosed();
}
