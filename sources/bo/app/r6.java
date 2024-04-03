package bo.app;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000f"}, d2 = {"Lbo/app/r6;", "", "", "Lbo/app/b3;", "a", "", "toString", "", "hashCode", "other", "", "equals", "triggeredActions", "<init>", "(Ljava/util/List;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class r6 {

    /* renamed from: a  reason: collision with root package name */
    private final List<b3> f39298a;

    public r6(List<? extends b3> list) {
        Intrinsics.checkNotNullParameter(list, "triggeredActions");
        this.f39298a = list;
    }

    public final List<b3> a() {
        return this.f39298a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r6) && Intrinsics.areEqual((Object) this.f39298a, (Object) ((r6) obj).f39298a);
    }

    public int hashCode() {
        return this.f39298a.hashCode();
    }

    public String toString() {
        return "TriggeredActionsReceivedEvent(triggeredActions=" + this.f39298a + ')';
    }
}
