package bo.app;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u000e"}, d2 = {"Lbo/app/f1;", "", "Lorg/json/JSONArray;", "a", "", "toString", "", "hashCode", "other", "", "equals", "featureFlagsData", "<init>", "(Lorg/json/JSONArray;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class f1 {

    /* renamed from: a  reason: collision with root package name */
    private final JSONArray f38517a;

    public f1(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsData");
        this.f38517a = jSONArray;
    }

    public final JSONArray a() {
        return this.f38517a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f1) && Intrinsics.areEqual((Object) this.f38517a, (Object) ((f1) obj).f38517a);
    }

    public int hashCode() {
        return this.f38517a.hashCode();
    }

    public String toString() {
        return "FeatureFlagsReceivedEvent(featureFlagsData=" + this.f38517a + ')';
    }
}
