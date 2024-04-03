package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;

@API(since = "5.3", status = API.Status.EXPERIMENTAL)
public class TestInstantiationException extends JUnitException {
    private static final long serialVersionUID = 1;

    public TestInstantiationException(String str) {
        super(str);
    }

    public TestInstantiationException(String str, Throwable th2) {
        super(str, th2);
    }
}
