package org.junit.platform.commons;

import org.apiguardian.api.API;

@API(since = "1.5", status = API.Status.STABLE)
public class PreconditionViolationException extends org.junit.platform.commons.util.PreconditionViolationException {
    private static final long serialVersionUID = 1;

    public PreconditionViolationException(String str) {
        super(str);
    }

    public PreconditionViolationException(String str, Throwable th2) {
        super(str, th2);
    }
}
