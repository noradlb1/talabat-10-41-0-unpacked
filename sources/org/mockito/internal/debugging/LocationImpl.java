package org.mockito.internal.debugging;

import java.io.Serializable;
import org.mockito.internal.exceptions.stacktrace.StackTraceFilter;
import org.mockito.invocation.Location;

public class LocationImpl implements Location, Serializable {
    private static final long serialVersionUID = -9054861157390980624L;
    private static final StackTraceFilter stackTraceFilter = new StackTraceFilter();
    private String sourceFile;
    private String stackTraceLine;

    public LocationImpl() {
        this(new Throwable(), false);
    }

    private void computeStackTraceInformation(StackTraceFilter stackTraceFilter2, Throwable th2, boolean z11) {
        StackTraceElement filterFirst = stackTraceFilter2.filterFirst(th2, z11);
        if (filterFirst == null) {
            this.stackTraceLine = "-> at <<unknown line>>";
            this.sourceFile = "<unknown source file>";
            return;
        }
        this.stackTraceLine = "-> at " + filterFirst;
        this.sourceFile = filterFirst.getFileName();
    }

    public String getSourceFile() {
        return this.sourceFile;
    }

    public String toString() {
        return this.stackTraceLine;
    }

    public LocationImpl(Throwable th2, boolean z11) {
        this(stackTraceFilter, th2, z11);
    }

    public LocationImpl(StackTraceFilter stackTraceFilter2) {
        this(stackTraceFilter2, new Throwable(), false);
    }

    private LocationImpl(StackTraceFilter stackTraceFilter2, Throwable th2, boolean z11) {
        computeStackTraceInformation(stackTraceFilter2, th2, z11);
    }
}
