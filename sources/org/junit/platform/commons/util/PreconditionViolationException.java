package org.junit.platform.commons.util;

import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;

@Deprecated
@API(since = "1.5", status = API.Status.DEPRECATED)
public class PreconditionViolationException extends JUnitException {
    private static final long serialVersionUID = 1;

    public PreconditionViolationException(String str) {
        super(str);
    }

    public PreconditionViolationException(String str, Throwable th2) {
        super(str, th2);
    }
}
