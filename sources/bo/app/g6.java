package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lbo/app/g6;", "", "", "toString", "", "hashCode", "other", "", "equals", "campaignId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "Lbo/app/x1;", "pushClickEvent", "Lbo/app/x1;", "b", "()Lbo/app/x1;", "<init>", "(Ljava/lang/String;Lbo/app/x1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class g6 {

    /* renamed from: a  reason: collision with root package name */
    private final String f38543a;

    /* renamed from: b  reason: collision with root package name */
    private final x1 f38544b;

    public g6(String str, x1 x1Var) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(x1Var, "pushClickEvent");
        this.f38543a = str;
        this.f38544b = x1Var;
    }

    public final String a() {
        return this.f38543a;
    }

    public final x1 b() {
        return this.f38544b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g6)) {
            return false;
        }
        g6 g6Var = (g6) obj;
        return Intrinsics.areEqual((Object) this.f38543a, (Object) g6Var.f38543a) && Intrinsics.areEqual((Object) this.f38544b, (Object) g6Var.f38544b);
    }

    public int hashCode() {
        return (this.f38543a.hashCode() * 31) + this.f38544b.hashCode();
    }

    public String toString() {
        return "TriggerEligiblePushClickEvent(campaignId=" + this.f38543a + ", pushClickEvent=" + this.f38544b + ')';
    }
}
