package org.junit.platform.commons;

import org.apiguardian.api.API;

@API(since = "1.5", status = API.Status.STABLE)
public class JUnitException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public JUnitException(String str) {
        super(str);
    }

    public JUnitException(String str, Throwable th2) {
        super(str, th2);
    }
}
