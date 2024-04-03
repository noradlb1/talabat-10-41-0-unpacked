package org.mockito.exceptions.misusing;

import org.mockito.exceptions.base.MockitoException;

public class InjectMocksException extends MockitoException {
    public InjectMocksException(String str, Throwable th2) {
        super(str, th2);
    }
}
