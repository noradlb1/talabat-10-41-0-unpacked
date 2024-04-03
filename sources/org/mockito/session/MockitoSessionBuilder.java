package org.mockito.session;

import org.mockito.MockitoSession;
import org.mockito.NotExtensible;
import org.mockito.exceptions.misusing.UnfinishedMockingSessionException;
import org.mockito.quality.Strictness;

@NotExtensible
public interface MockitoSessionBuilder {
    MockitoSessionBuilder initMocks(Object obj);

    MockitoSessionBuilder initMocks(Object... objArr);

    MockitoSessionBuilder logger(MockitoSessionLogger mockitoSessionLogger);

    MockitoSessionBuilder name(String str);

    MockitoSession startMocking() throws UnfinishedMockingSessionException;

    MockitoSessionBuilder strictness(Strictness strictness);
}
