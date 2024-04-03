package org.mockito.listeners;

public interface VerificationStartedEvent {
    Object getMock();

    void setMock(Object obj);
}
