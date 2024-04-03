package org.mockito.internal.invocation;

import java.util.Comparator;
import org.mockito.invocation.Invocation;

public class InvocationComparator implements Comparator<Invocation> {
    public int compare(Invocation invocation, Invocation invocation2) {
        return Integer.compare(invocation.getSequenceNumber(), invocation2.getSequenceNumber());
    }
}
