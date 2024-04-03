package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lbo/app/k3;", "Lbo/app/q2;", "", "toString", "", "hashCode", "", "other", "", "equals", "errorMessage", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lbo/app/c2;", "originalRequest", "Lbo/app/c2;", "b", "()Lbo/app/c2;", "<init>", "(Ljava/lang/String;Lbo/app/c2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k3 implements q2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f38789a;

    /* renamed from: b  reason: collision with root package name */
    private final c2 f38790b;

    public k3(String str, c2 c2Var) {
        Intrinsics.checkNotNullParameter(c2Var, "originalRequest");
        this.f38789a = str;
        this.f38790b = c2Var;
    }

    public String a() {
        return this.f38789a;
    }

    public c2 b() {
        return this.f38790b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k3)) {
            return false;
        }
        k3 k3Var = (k3) obj;
        return Intrinsics.areEqual((Object) a(), (Object) k3Var.a()) && Intrinsics.areEqual((Object) b(), (Object) k3Var.b());
    }

    public int hashCode() {
        return ((a() == null ? 0 : a().hashCode()) * 31) + b().hashCode();
    }

    public String toString() {
        return "InvalidApiKeyError(errorMessage=" + a() + ", originalRequest=" + b() + ')';
    }
}
