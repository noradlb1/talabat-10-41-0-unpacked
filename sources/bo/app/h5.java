package bo.app;

import bo.app.j5;
import com.braze.models.IPutIntoJson;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0018B3\b\u0016\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b'\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0016@TX\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u001a8\u0006@DX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u0018\u0010\u001fR\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lbo/app/h5;", "Lcom/braze/models/IPutIntoJson;", "Lorg/json/JSONObject;", "e", "Lbo/app/q3;", "z", "()Lbo/app/q3;", "", "toString", "Lbo/app/j5;", "sessionId", "Lbo/app/j5;", "n", "()Lbo/app/j5;", "", "startTime", "D", "x", "()D", "<set-?>", "endTime", "Ljava/lang/Double;", "w", "()Ljava/lang/Double;", "a", "(Ljava/lang/Double;)V", "", "isSealed", "Z", "y", "()Z", "(Z)V", "", "v", "()J", "duration", "startTimeSeconds", "endTimeSeconds", "sealed", "<init>", "(Lbo/app/j5;DLjava/lang/Double;Z)V", "sessionData", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class h5 implements IPutIntoJson<JSONObject> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f38617f = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final j5 f38618b;

    /* renamed from: c  reason: collision with root package name */
    private final double f38619c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Double f38620d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f38621e;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lbo/app/h5$a;", "", "", "END_TIME_KEY", "Ljava/lang/String;", "IS_SEALED_KEY", "", "NIL_DURATION", "J", "SESSION_ID_KEY", "START_TIME_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ double f38622b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h5 f38623c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(double d11, h5 h5Var) {
            super(0);
            this.f38622b = d11;
            this.f38623c = h5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "End time '" + this.f38622b + "' for session is less than the start time '" + this.f38623c.x() + "' for this session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38624b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating Session Json.";
        }
    }

    public h5(j5 j5Var, double d11, Double d12, boolean z11) {
        Intrinsics.checkNotNullParameter(j5Var, "sessionId");
        this.f38618b = j5Var;
        this.f38619c = d11;
        a(d12);
        this.f38621e = z11;
    }

    public void a(Double d11) {
        this.f38620d = d11;
    }

    /* renamed from: e */
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("session_id", (Object) this.f38618b);
            jSONObject.put("start_time", this.f38619c);
            jSONObject.put("is_sealed", this.f38621e);
            if (w() != null) {
                jSONObject.put("end_time", (Object) w());
            }
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f38624b, 4, (Object) null);
        }
        return jSONObject;
    }

    public final j5 n() {
        return this.f38618b;
    }

    public String toString() {
        return "\nSession(sessionId=" + this.f38618b + ", startTime=" + this.f38619c + ", endTime=" + w() + ", isSealed=" + this.f38621e + ", duration=" + v() + ')';
    }

    public final long v() {
        Double w11 = w();
        if (w11 == null) {
            return -1;
        }
        double doubleValue = w11.doubleValue();
        long j11 = (long) (doubleValue - this.f38619c);
        if (j11 < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(doubleValue, this), 6, (Object) null);
        }
        return j11;
    }

    public Double w() {
        return this.f38620d;
    }

    public final double x() {
        return this.f38619c;
    }

    public final boolean y() {
        return this.f38621e;
    }

    public final q3 z() {
        return new q3(this.f38618b, this.f38619c, w(), this.f38621e);
    }

    public final void a(boolean z11) {
        this.f38621e = z11;
    }

    public h5(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "sessionData");
        j5.a aVar = j5.f38758d;
        String string = jSONObject.getString("session_id");
        Intrinsics.checkNotNullExpressionValue(string, "sessionData.getString(SESSION_ID_KEY)");
        this.f38618b = aVar.a(string);
        this.f38619c = jSONObject.getDouble("start_time");
        this.f38621e = jSONObject.getBoolean("is_sealed");
        a(JsonUtils.getDoubleOrNull(jSONObject, "end_time"));
    }
}
