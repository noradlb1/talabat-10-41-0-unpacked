package bo.app;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB!\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lbo/app/h4;", "Lbo/app/j;", "", "isNoneActionType", "Z", "x", "()Z", "Lbo/app/c1;", "eventType", "Lorg/json/JSONObject;", "eventData", "", "actionType", "<init>", "(Lbo/app/c1;Lorg/json/JSONObject;Ljava/lang/String;)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class h4 extends j {

    /* renamed from: k  reason: collision with root package name */
    public static final a f38615k = new a((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    private final boolean f38616j;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¨\u0006\n"}, d2 = {"Lbo/app/h4$a;", "", "", "campaignId", "actionId", "actionType", "Lbo/app/x1;", "a", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final x1 a(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            Intrinsics.checkNotNullParameter(str2, "actionId");
            Intrinsics.checkNotNullParameter(str3, "actionType");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cid", (Object) str);
            jSONObject.put("a", (Object) str2);
            return new h4(c1.PUSH_ACTION_BUTTON_CLICKED, jSONObject, str3, (DefaultConstructorMarker) null);
        }
    }

    private h4(c1 c1Var, JSONObject jSONObject, String str) {
        super(c1Var, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
        this.f38616j = Intrinsics.areEqual((Object) str, (Object) "ab_none");
    }

    public /* synthetic */ h4(c1 c1Var, JSONObject jSONObject, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(c1Var, jSONObject, str);
    }

    public final boolean x() {
        return this.f38616j;
    }
}
