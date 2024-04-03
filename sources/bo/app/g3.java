package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u0016"}, d2 = {"Lbo/app/g3;", "", "", "toString", "Lbo/app/w2;", "a", "Lbo/app/b3;", "b", "Lcom/braze/models/inappmessage/IInAppMessage;", "c", "d", "", "hashCode", "other", "", "equals", "triggerEvent", "triggeredAction", "inAppMessage", "userId", "<init>", "(Lbo/app/w2;Lbo/app/b3;Lcom/braze/models/inappmessage/IInAppMessage;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class g3 {

    /* renamed from: a  reason: collision with root package name */
    private final w2 f38536a;

    /* renamed from: b  reason: collision with root package name */
    private final b3 f38537b;

    /* renamed from: c  reason: collision with root package name */
    private final IInAppMessage f38538c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38539d;

    public g3(w2 w2Var, b3 b3Var, IInAppMessage iInAppMessage, String str) {
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        Intrinsics.checkNotNullParameter(b3Var, "triggeredAction");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        this.f38536a = w2Var;
        this.f38537b = b3Var;
        this.f38538c = iInAppMessage;
        this.f38539d = str;
    }

    public final w2 a() {
        return this.f38536a;
    }

    public final b3 b() {
        return this.f38537b;
    }

    public final IInAppMessage c() {
        return this.f38538c;
    }

    public final String d() {
        return this.f38539d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g3)) {
            return false;
        }
        g3 g3Var = (g3) obj;
        return Intrinsics.areEqual((Object) this.f38536a, (Object) g3Var.f38536a) && Intrinsics.areEqual((Object) this.f38537b, (Object) g3Var.f38537b) && Intrinsics.areEqual((Object) this.f38538c, (Object) g3Var.f38538c) && Intrinsics.areEqual((Object) this.f38539d, (Object) g3Var.f38539d);
    }

    public int hashCode() {
        int hashCode = ((((this.f38536a.hashCode() * 31) + this.f38537b.hashCode()) * 31) + this.f38538c.hashCode()) * 31;
        String str = this.f38539d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return StringsKt__IndentKt.trimIndent("\n             " + JsonUtils.getPrettyPrintedString((JSONObject) this.f38538c.forJsonPut()) + "\n             Triggered Action Id: " + this.f38537b.getId() + "\n             Trigger Event: " + this.f38536a + "\n             User Id: " + this.f38539d + "\n        ");
    }
}
