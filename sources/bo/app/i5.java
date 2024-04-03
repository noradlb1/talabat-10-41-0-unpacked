package bo.app;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lbo/app/i5;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbo/app/h5;", "session", "Lbo/app/h5;", "a", "()Lbo/app/h5;", "<init>", "(Lbo/app/h5;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class i5 {

    /* renamed from: a  reason: collision with root package name */
    private final h5 f38651a;

    public i5(h5 h5Var) {
        Intrinsics.checkNotNullParameter(h5Var, SDKCoreEvent.Session.TYPE_SESSION);
        this.f38651a = h5Var;
        if (!(!h5Var.y())) {
            throw new IllegalArgumentException("Session created events cannot be created with already sealed sessions.".toString());
        }
    }

    public final h5 a() {
        return this.f38651a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i5) && Intrinsics.areEqual((Object) this.f38651a, (Object) ((i5) obj).f38651a);
    }

    public int hashCode() {
        return this.f38651a.hashCode();
    }

    public String toString() {
        return "SessionCreatedEvent(session=" + this.f38651a + ')';
    }
}
