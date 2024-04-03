package bo.app;

import bo.app.a4;
import com.braze.support.BrazeLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b \u0010!J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u000bH\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00148\u0016XD¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lbo/app/i0;", "Lbo/app/r;", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/d;", "apiResponse", "", "a", "", "", "Lcom/braze/communication/MutableHttpHeaders;", "existingHeaders", "Lbo/app/a4;", "outboundRespondWith", "Lbo/app/a4;", "c", "()Lbo/app/a4;", "setOutboundRespondWith", "(Lbo/app/a4;)V", "", "b", "()Z", "containsNoNewData", "doesSendOptionalData", "Z", "g", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "urlBase", "<init>", "(Ljava/lang/String;Lbo/app/a4;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class i0 extends r {

    /* renamed from: t  reason: collision with root package name */
    public static final a f38630t = new a((DefaultConstructorMarker) null);

    /* renamed from: r  reason: collision with root package name */
    private a4 f38631r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f38632s;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/i0$a;", "", "", "BRAZE_NEWS_FEED_REQUEST_HEADER", "Ljava/lang/String;", "BRAZE_TRIGGERS_REQUEST_HEADER", "URL_EXTENSION", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38633b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "DataSyncRequest executed successfully.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38634b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(String str, a4 a4Var, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).a() : a4Var);
    }

    public void a(j2 j2Var, j2 j2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f38633b, 7, (Object) null);
    }

    public boolean b() {
        a4 c11 = c();
        return (c11 != null && c11.e()) && super.b();
    }

    public a4 c() {
        return this.f38631r;
    }

    public boolean g() {
        return this.f38632s;
    }

    public JSONObject l() {
        JSONObject jSONObject;
        JSONObject l11 = super.l();
        if (l11 == null) {
            return null;
        }
        try {
            a4 c11 = c();
            if (c11 == null) {
                jSONObject = null;
            } else {
                jSONObject = c11.forJsonPut();
            }
            l11.put("respond_with", (Object) jSONObject);
            return l11;
        } catch (JSONException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) c.f38634b, 4, (Object) null);
            return null;
        }
    }

    public void a(Map<String, String> map) {
        boolean z11;
        Intrinsics.checkNotNullParameter(map, "existingHeaders");
        super.a(map);
        a4 c11 = c();
        boolean z12 = false;
        boolean z13 = true;
        if (!(c11 != null && c11.e())) {
            a4 c12 = c();
            if (c12 != null && c12.x()) {
                map.put("X-Braze-FeedRequest", "true");
                z11 = true;
            } else {
                z11 = false;
            }
            a4 c13 = c();
            if (c13 != null && c13.y()) {
                z12 = true;
            }
            if (z12) {
                map.put("X-Braze-TriggersRequest", "true");
            } else {
                z13 = z11;
            }
            if (z13) {
                map.put("X-Braze-DataRequest", "true");
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(String str, a4 a4Var) {
        super(new v4(Intrinsics.stringPlus(str, "data")));
        Intrinsics.checkNotNullParameter(str, "urlBase");
        this.f38631r = a4Var;
        this.f38632s = true;
    }
}
