package org.mockito.internal.junit;

import j$.util.Map;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.mockito.invocation.Invocation;
import org.mockito.plugins.MockitoLogger;

class StubbingArgMismatches {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Invocation, Set<Invocation>> f63214a = new LinkedHashMap();

    /* access modifiers changed from: private */
    public static /* synthetic */ Set lambda$add$0(Invocation invocation) {
        return new LinkedHashSet();
    }

    public void add(Invocation invocation, Invocation invocation2) {
        ((Set) Map.EL.computeIfAbsent(this.f63214a, invocation2, new d())).add(invocation);
    }

    public void format(String str, MockitoLogger mockitoLogger) {
        if (!this.f63214a.isEmpty()) {
            StubbingHint stubbingHint = new StubbingHint(str);
            int i11 = 1;
            for (Map.Entry next : this.f63214a.entrySet()) {
                int i12 = i11 + 1;
                stubbingHint.a(Integer.valueOf(i11), ". Unused... ", ((Invocation) next.getKey()).getLocation());
                for (Invocation location : (Set) next.getValue()) {
                    stubbingHint.a(" ...args ok? ", location.getLocation());
                }
                i11 = i12;
            }
            mockitoLogger.log(stubbingHint.toString());
        }
    }

    public int size() {
        return this.f63214a.size();
    }

    public String toString() {
        return "" + this.f63214a;
    }
}
