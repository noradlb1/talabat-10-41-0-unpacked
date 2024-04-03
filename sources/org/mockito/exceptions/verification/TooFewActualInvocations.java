package org.mockito.exceptions.verification;

import org.mockito.exceptions.base.MockitoAssertionError;

public class TooFewActualInvocations extends MockitoAssertionError {
    private static final long serialVersionUID = 1;

    public TooFewActualInvocations(String str) {
        super(str);
    }
}
