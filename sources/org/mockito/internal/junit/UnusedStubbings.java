package org.mockito.internal.junit;

import java.util.Collection;
import java.util.LinkedList;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.plugins.MockitoLogger;
import org.mockito.stubbing.Stubbing;

public class UnusedStubbings {
    private final Collection<? extends Stubbing> unused;

    public UnusedStubbings(Collection<? extends Stubbing> collection) {
        this.unused = collection;
    }

    public void a(String str, MockitoLogger mockitoLogger) {
        if (!this.unused.isEmpty()) {
            StubbingHint stubbingHint = new StubbingHint(str);
            int i11 = 1;
            for (Stubbing stubbing : this.unused) {
                if (!stubbing.wasUsed()) {
                    stubbingHint.a(Integer.valueOf(i11), ". Unused ", stubbing.getInvocation().getLocation());
                    i11++;
                }
            }
            mockitoLogger.log(stubbingHint.toString());
        }
    }

    public void b() {
        if (!this.unused.isEmpty()) {
            LinkedList linkedList = new LinkedList();
            for (Stubbing invocation : this.unused) {
                linkedList.add(invocation.getInvocation());
            }
            if (!linkedList.isEmpty()) {
                Reporter.unncessaryStubbingException(linkedList);
            }
        }
    }

    public int size() {
        return this.unused.size();
    }

    public String toString() {
        return this.unused.toString();
    }
}
