package org.junit.internal;

import java.io.PrintStream;

public class RealSystem implements JUnitSystem {
    @Deprecated
    public void exit(int i11) {
        System.exit(i11);
    }

    public PrintStream out() {
        return System.out;
    }
}
