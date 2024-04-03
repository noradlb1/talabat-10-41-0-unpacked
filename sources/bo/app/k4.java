package bo.app;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lbo/app/k4;", "Lbo/app/j;", "Lbo/app/c1;", "eventType", "Lorg/json/JSONObject;", "eventData", "<init>", "(Lbo/app/c1;Lorg/json/JSONObject;)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k4 extends j {

    /* renamed from: j  reason: collision with root package name */
    public static final a f38791j = new a((DefaultConstructorMarker) null);

    private k4(c1 c1Var, JSONObject jSONObject) {
        super(c1Var, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ k4(c1 c1Var, JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(c1Var, jSONObject);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lbo/app/k4$a;", "", "", "campaignId", "Lbo/app/k4;", "a", "Lbo/app/x1;", "event", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final k4 a(String str) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cid", (Object) str);
            return new k4(c1.PUSH_CLICKED, jSONObject, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final String a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            String string = x1Var.k().getString("cid");
            Intrinsics.checkNotNullExpressionValue(string, "event.data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
            return string;
        }
    }
}
