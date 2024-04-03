package org.mockito.internal.handler;

import org.mockito.internal.matchers.Equality;
import org.mockito.invocation.DescribedInvocation;
import org.mockito.invocation.Invocation;
import org.mockito.listeners.MethodInvocationReport;

public class NotifiedMethodInvocationReport implements MethodInvocationReport {
    private final Invocation invocation;
    private final Object returnedValue;
    private final Throwable throwable;

    public NotifiedMethodInvocationReport(Invocation invocation2, Object obj) {
        this.invocation = invocation2;
        this.returnedValue = obj;
        this.throwable = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotifiedMethodInvocationReport notifiedMethodInvocationReport = (NotifiedMethodInvocationReport) obj;
        if (!Equality.areEqual(this.invocation, notifiedMethodInvocationReport.invocation) || !Equality.areEqual(this.returnedValue, notifiedMethodInvocationReport.returnedValue) || !Equality.areEqual(this.throwable, notifiedMethodInvocationReport.throwable)) {
            return false;
        }
        return true;
    }

    public DescribedInvocation getInvocation() {
        return this.invocation;
    }

    public String getLocationOfStubbing() {
        if (this.invocation.stubInfo() == null) {
            return null;
        }
        return this.invocation.stubInfo().stubbedAt().toString();
    }

    public Object getReturnedValue() {
        return this.returnedValue;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        int i11;
        int i12;
        Invocation invocation2 = this.invocation;
        int i13 = 0;
        if (invocation2 != null) {
            i11 = invocation2.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        Object obj = this.returnedValue;
        if (obj != null) {
            i12 = obj.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        Throwable th2 = this.throwable;
        if (th2 != null) {
            i13 = th2.hashCode();
        }
        return i15 + i13;
    }

    public boolean threwException() {
        return this.throwable != null;
    }

    public NotifiedMethodInvocationReport(Invocation invocation2, Throwable th2) {
        this.invocation = invocation2;
        this.returnedValue = null;
        this.throwable = th2;
    }
}
