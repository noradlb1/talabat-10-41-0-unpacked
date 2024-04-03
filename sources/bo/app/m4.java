package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lbo/app/m4;", "Lbo/app/n2;", "Lorg/json/JSONObject;", "e", "", "o", "()Z", "isAlwaysEligible", "s", "isOnlyEligibleOnce", "", "q", "()Ljava/lang/Integer;", "reEligibilityTime", "reEligibility", "<init>", "(I)V", "json", "(Lorg/json/JSONObject;)V", "a", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m4 implements n2 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f38985c = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f38986b;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lbo/app/m4$a;", "", "", "ALWAYS_ELIGIBLE", "I", "ELIGIBLE_ONCE", "", "RE_ELIGIBILITY", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38987b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not convert ReEligibilityConfig to JSON";
        }
    }

    public m4(int i11) {
        this.f38986b = i11;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            return new JSONObject().put("re_eligibility", this.f38986b);
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f38987b, 4, (Object) null);
            return null;
        }
    }

    public boolean o() {
        return this.f38986b == 0;
    }

    public Integer q() {
        int i11 = this.f38986b;
        if (i11 > 0) {
            return Integer.valueOf(i11);
        }
        return null;
    }

    public boolean s() {
        return this.f38986b == -1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public m4(JSONObject jSONObject) {
        this(jSONObject.optInt("re_eligibility", -1));
        Intrinsics.checkNotNullParameter(jSONObject, "json");
    }
}
