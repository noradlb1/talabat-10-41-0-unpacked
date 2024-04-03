package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lbo/app/o4;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lbo/app/p4;", "pathType", "Lbo/app/p4;", "a", "()Lbo/app/p4;", "remoteUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Lbo/app/p4;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class o4 {

    /* renamed from: a  reason: collision with root package name */
    private final p4 f39101a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39102b;

    public o4(p4 p4Var, String str) {
        Intrinsics.checkNotNullParameter(p4Var, "pathType");
        Intrinsics.checkNotNullParameter(str, "remoteUrl");
        this.f39101a = p4Var;
        this.f39102b = str;
    }

    public final p4 a() {
        return this.f39101a;
    }

    public final String b() {
        return this.f39102b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o4)) {
            return false;
        }
        o4 o4Var = (o4) obj;
        return this.f39101a == o4Var.f39101a && Intrinsics.areEqual((Object) this.f39102b, (Object) o4Var.f39102b);
    }

    public int hashCode() {
        return (this.f39101a.hashCode() * 31) + this.f39102b.hashCode();
    }

    public String toString() {
        return "RemotePath(pathType=" + this.f39101a + ", remoteUrl=" + this.f39102b + ')';
    }
}
