package org.mockito.plugins;

public interface InlineMockMaker extends MockMaker {
    void clearAllMocks();

    void clearMock(Object obj);
}
