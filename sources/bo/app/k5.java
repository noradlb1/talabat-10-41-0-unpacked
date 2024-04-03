package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lbo/app/k5;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbo/app/h5;", "sealedSession", "Lbo/app/h5;", "a", "()Lbo/app/h5;", "<init>", "(Lbo/app/h5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k5 {

    /* renamed from: a  reason: collision with root package name */
    private final h5 f38792a;

    public k5(h5 h5Var) {
        Intrinsics.checkNotNullParameter(h5Var, "sealedSession");
        this.f38792a = h5Var;
    }

    public final h5 a() {
        return this.f38792a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k5) && Intrinsics.areEqual((Object) this.f38792a, (Object) ((k5) obj).f38792a);
    }

    public int hashCode() {
        return this.f38792a.hashCode();
    }

    public String toString() {
        return "SessionSealedEvent(sealedSession=" + this.f38792a + ')';
    }
}
