package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;

@API(since = "5.0", status = API.Status.STABLE)
public class ExtensionContextException extends JUnitException {
    private static final long serialVersionUID = 1;

    public ExtensionContextException(String str) {
        super(str);
    }
}
