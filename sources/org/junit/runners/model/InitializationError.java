package org.junit.runners.model;

import java.util.Arrays;
import java.util.List;

public class InitializationError extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public InitializationError(List<Throwable> list) {
        this.fErrors = list;
    }

    public List<Throwable> getCauses() {
        return this.fErrors;
    }

    public InitializationError(Throwable th2) {
        this((List<Throwable>) Arrays.asList(new Throwable[]{th2}));
    }

    public InitializationError(String str) {
        this((Throwable) new Exception(str));
    }
}
