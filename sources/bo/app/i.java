package bo.app;

import com.braze.models.IPutIntoJson;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007HÖ\u0003¨\u0006\u000e"}, d2 = {"Lbo/app/i;", "Lcom/braze/models/IPutIntoJson;", "", "toString", "e", "", "hashCode", "", "other", "", "equals", "apiKey", "<init>", "(Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class i implements IPutIntoJson<String> {

    /* renamed from: b  reason: collision with root package name */
    private final String f38629b;

    public i(String str) {
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        this.f38629b = str;
    }

    /* renamed from: e */
    public String forJsonPut() {
        return this.f38629b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && Intrinsics.areEqual((Object) this.f38629b, (Object) ((i) obj).f38629b);
    }

    public int hashCode() {
        return this.f38629b.hashCode();
    }

    public String toString() {
        return this.f38629b;
    }
}
