package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001e"}, d2 = {"Lbo/app/w4;", "Lbo/app/r2;", "Lorg/json/JSONObject;", "e", "", "startTime", "J", "c", "()J", "endTime", "h", "", "priority", "I", "u", "()I", "delayInSeconds", "g", "timeoutInMilliseconds", "a", "Lbo/app/n2;", "reEligibilityConfig", "Lbo/app/n2;", "t", "()Lbo/app/n2;", "minSecondsSinceLastTrigger", "l", "json", "<init>", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class w4 implements r2 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f39519i = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final long f39520b;

    /* renamed from: c  reason: collision with root package name */
    private final long f39521c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39522d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39523e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39524f;

    /* renamed from: g  reason: collision with root package name */
    private final n2 f39525g;

    /* renamed from: h  reason: collision with root package name */
    private final int f39526h;

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0016"}, d2 = {"Lbo/app/w4$a;", "", "", "DEFAULT_DELAY", "I", "", "DEFAULT_END_TIME", "J", "DEFAULT_MIN_SECONDS_SINCE_LAST", "DEFAULT_PRIORITY", "DEFAULT_START_TIME", "DEFAULT_TIMEOUT", "", "DELAY", "Ljava/lang/String;", "END_TIME", "MIN_SECONDS_SINCE_LAST", "PRIORITY", "START_TIME", "TIMEOUT", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f39527b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not convert ScheduleConfig to JSON";
        }
    }

    public w4(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        this.f39520b = jSONObject.optLong("start_time", -1);
        this.f39521c = jSONObject.optLong("end_time", -1);
        this.f39522d = jSONObject.optInt("priority", 0);
        this.f39526h = jSONObject.optInt("min_seconds_since_last_trigger", -1);
        this.f39523e = jSONObject.optInt("delay", 0);
        this.f39524f = jSONObject.optInt("timeout", -1);
        this.f39525g = new m4(jSONObject);
    }

    public int a() {
        return this.f39524f;
    }

    public long c() {
        return this.f39520b;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        try {
            JSONObject jSONObject = (JSONObject) t().forJsonPut();
            if (jSONObject == null) {
                return null;
            }
            jSONObject.put("start_time", c());
            jSONObject.put("end_time", h());
            jSONObject.put("priority", u());
            jSONObject.put("min_seconds_since_last_trigger", l());
            jSONObject.put("timeout", a());
            jSONObject.put("delay", g());
            return jSONObject;
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f39527b, 4, (Object) null);
            return null;
        }
    }

    public int g() {
        return this.f39523e;
    }

    public long h() {
        return this.f39521c;
    }

    public int l() {
        return this.f39526h;
    }

    public n2 t() {
        return this.f39525g;
    }

    public int u() {
        return this.f39522d;
    }
}
