package org.mockito.internal.junit;

import org.mockito.internal.invocation.finder.AllInvocationsFinder;
import org.mockito.invocation.Invocation;
import org.mockito.stubbing.Stubbing;

class ArgMismatchFinder {
    public StubbingArgMismatches a(Iterable<?> iterable) {
        StubbingArgMismatches stubbingArgMismatches = new StubbingArgMismatches();
        for (Invocation next : AllInvocationsFinder.find(iterable)) {
            if (next.stubInfo() == null) {
                for (Stubbing next2 : AllInvocationsFinder.findStubbings(iterable)) {
                    if (!next2.wasUsed() && next2.getInvocation().getMock() == next.getMock() && next2.getInvocation().getMethod().getName().equals(next.getMethod().getName())) {
                        stubbingArgMismatches.add(next, next2.getInvocation());
                    }
                }
            }
        }
        return stubbingArgMismatches;
    }
}
