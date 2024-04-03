package org.mockito.stubbing;

import org.mockito.invocation.InvocationOnMock;

public interface ValidableAnswer {
    void validateFor(InvocationOnMock invocationOnMock);
}
