package bo.app;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lbo/app/k;", "Lbo/app/i2;", "", "a", "", "toString", "", "hashCode", "", "other", "equals", "", "Lbo/app/x1;", "eventsList", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "isEmpty", "Z", "e", "()Z", "<init>", "(Ljava/util/Set;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k implements i2 {

    /* renamed from: b  reason: collision with root package name */
    private final Set<x1> f38762b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38763c;

    public k(Set<? extends x1> set) {
        Intrinsics.checkNotNullParameter(set, "eventsList");
        this.f38762b = set;
        this.f38763c = set.isEmpty();
    }

    public final boolean a() {
        boolean z11;
        Set<x1> set = this.f38762b;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (x1 j11 : set) {
            if (j11.j() == c1.SESSION_START) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    public final Set<x1> b() {
        return this.f38762b;
    }

    public boolean e() {
        return this.f38763c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && Intrinsics.areEqual((Object) this.f38762b, (Object) ((k) obj).f38762b);
    }

    public int hashCode() {
        return this.f38762b.hashCode();
    }

    public String toString() {
        return "BrazeEventContainer(eventsList=" + this.f38762b + ')';
    }
}
