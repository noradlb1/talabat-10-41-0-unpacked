package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\r"}, d2 = {"Lbo/app/u4;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbo/app/c2;", "request", "<init>", "(Lbo/app/c2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u4 {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f39455a;

    public u4(c2 c2Var) {
        Intrinsics.checkNotNullParameter(c2Var, "request");
        this.f39455a = c2Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u4) && Intrinsics.areEqual((Object) this.f39455a, (Object) ((u4) obj).f39455a);
    }

    public int hashCode() {
        return this.f39455a.hashCode();
    }

    public String toString() {
        return "RequestNetworkSuccessEvent(request=" + this.f39455a + ')';
    }
}
