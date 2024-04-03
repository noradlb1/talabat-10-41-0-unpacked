package org.mockito.creation.instance;

import org.mockito.exceptions.base.MockitoException;

public class InstantiationException extends MockitoException {
    public InstantiationException(String str) {
        super(str);
    }

    public InstantiationException(String str, Throwable th2) {
        super(str, th2);
    }
}
