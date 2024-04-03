package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001a\u0010\n\u001a\u00020\t8\u0016XD¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lbo/app/m1;", "Lbo/app/r;", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/d;", "apiResponse", "", "a", "", "containsNoNewData", "Z", "b", "()Z", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "", "urlBase", "Lbo/app/a2;", "location", "<init>", "(Ljava/lang/String;Lbo/app/a2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m1 extends r {

    /* renamed from: t  reason: collision with root package name */
    public static final a f38966t = new a((DefaultConstructorMarker) null);

    /* renamed from: r  reason: collision with root package name */
    private final x1 f38967r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f38968s;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/m1$a;", "", "", "LOCATION_EVENT", "Ljava/lang/String;", "URL_EXTENSION", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38969b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "GeofenceRefreshRequest executed successfully.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38970b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while creating geofence refresh request. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m1(String str, a2 a2Var) {
        super(new v4(Intrinsics.stringPlus(str, "geofence/request")));
        Intrinsics.checkNotNullParameter(str, "urlBase");
        Intrinsics.checkNotNullParameter(a2Var, "location");
        this.f38967r = j.f38653h.a(a2Var);
    }

    public void a(j2 j2Var, j2 j2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f38969b, 7, (Object) null);
    }

    public boolean b() {
        return this.f38968s;
    }

    public JSONObject l() {
        JSONObject l11 = super.l();
        if (l11 == null) {
            return null;
        }
        try {
            x1 x1Var = this.f38967r;
            if (x1Var != null) {
                l11.put("location_event", x1Var.forJsonPut());
            }
            return l11;
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) c.f38970b, 4, (Object) null);
            return null;
        }
    }
}
