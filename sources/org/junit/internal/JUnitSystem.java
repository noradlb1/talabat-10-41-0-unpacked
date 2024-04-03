package org.junit.internal;

import java.io.PrintStream;

public interface JUnitSystem {
    @Deprecated
    void exit(int i11);

    PrintStream out();
}
