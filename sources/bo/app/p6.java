package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0011"}, d2 = {"Lbo/app/p6;", "", "Lbo/app/w2;", "a", "Lbo/app/b3;", "b", "", "toString", "", "hashCode", "other", "", "equals", "originalTriggerEvent", "failedTriggeredAction", "<init>", "(Lbo/app/w2;Lbo/app/b3;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class p6 {

    /* renamed from: a  reason: collision with root package name */
    private final w2 f39188a;

    /* renamed from: b  reason: collision with root package name */
    private final b3 f39189b;

    public p6(w2 w2Var, b3 b3Var) {
        Intrinsics.checkNotNullParameter(w2Var, "originalTriggerEvent");
        Intrinsics.checkNotNullParameter(b3Var, "failedTriggeredAction");
        this.f39188a = w2Var;
        this.f39189b = b3Var;
    }

    public final w2 a() {
        return this.f39188a;
    }

    public final b3 b() {
        return this.f39189b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p6)) {
            return false;
        }
        p6 p6Var = (p6) obj;
        return Intrinsics.areEqual((Object) this.f39188a, (Object) p6Var.f39188a) && Intrinsics.areEqual((Object) this.f39189b, (Object) p6Var.f39189b);
    }

    public int hashCode() {
        return (this.f39188a.hashCode() * 31) + this.f39189b.hashCode();
    }

    public String toString() {
        return "TriggeredActionRetryEvent(originalTriggerEvent=" + this.f39188a + ", failedTriggeredAction=" + this.f39189b + ')';
    }
}
