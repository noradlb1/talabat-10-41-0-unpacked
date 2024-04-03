package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.asm.Advice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u0005Bµ\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0019\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010)\u001a\u00020#\u0012\b\b\u0002\u0010+\u001a\u00020#\u0012\b\b\u0002\u0010-\u001a\u00020\u000e\u0012\b\b\u0002\u0010/\u001a\u00020#\u0012\b\b\u0002\u00101\u001a\u00020#\u0012\b\b\u0002\u00102\u001a\u00020#\u0012\b\b\u0002\u00103\u001a\u00020\u0019¢\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b5\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0005\u0010\u0012R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015\"\u0004\b\u0007\u0010\u0016R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0005\u0010\u0015\"\u0004\b\u0005\u0010\u0016R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0006\u0010\u0015\"\u0004\b\u0006\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\t\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b\u0006\u0010\u001eR\"\u0010!\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b\u0007\u0010\u001eR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\b\u0010(R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'\"\u0004\b\t\u0010(R\"\u0010+\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b\u0005\u0010(R\"\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0011\"\u0004\b\u0007\u0010\u0012R\"\u0010/\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'\"\u0004\b\n\u0010(R\"\u00101\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b\b\u0010'\"\u0004\b\u0007\u0010(R\"\u00102\u001a\u00020#8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010%\u001a\u0004\b\n\u0010'\"\u0004\b\u0006\u0010(R\"\u00103\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001b\u001a\u0004\b4\u0010\u001d\"\u0004\b\u0005\u0010\u001e¨\u00068"}, d2 = {"Lbo/app/c5;", "", "Lorg/json/JSONObject;", "jsonObject", "", "a", "c", "b", "e", "d", "f", "", "blocklistKey", "", "", "configTime", "J", "()J", "(J)V", "blocklistedEvents", "Ljava/util/Set;", "()Ljava/util/Set;", "(Ljava/util/Set;)V", "blocklistedAttributes", "blocklistedPurchases", "", "minTimeSinceLastRequest", "I", "m", "()I", "(I)V", "minTimeSinceLastReport", "l", "maxNumToRegister", "j", "", "geofencesEnabledSet", "Z", "i", "()Z", "(Z)V", "geofencesEnabled", "h", "isContentCardsFeatureEnabled", "o", "messagingSessionTimeout", "k", "testUserDeviceLoggingEnabled", "n", "ephemeralEventsEnabled", "featureFlagsEnabled", "featureFlagsRefreshRateLimit", "g", "<init>", "(JLjava/util/Set;Ljava/util/Set;Ljava/util/Set;IIIZZZJZZZI)V", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class c5 {

    /* renamed from: p  reason: collision with root package name */
    public static final a f38360p = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private long f38361a;

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f38362b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f38363c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f38364d;

    /* renamed from: e  reason: collision with root package name */
    private int f38365e;

    /* renamed from: f  reason: collision with root package name */
    private int f38366f;

    /* renamed from: g  reason: collision with root package name */
    private int f38367g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38368h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f38369i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f38370j;

    /* renamed from: k  reason: collision with root package name */
    private long f38371k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f38372l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38373m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f38374n;

    /* renamed from: o  reason: collision with root package name */
    private int f38375o;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u0012\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u0019"}, d2 = {"Lbo/app/c5$a;", "", "", "ATTRIBUTES_BLOCKLIST", "Ljava/lang/String;", "getATTRIBUTES_BLOCKLIST$annotations", "()V", "CONFIG_TIME", "CONTENT_CARDS", "ENABLED", "EPHEMERAL_EVENTS", "EVENTS_BLOCKLIST", "getEVENTS_BLOCKLIST$annotations", "FEATURE_FLAGS", "GEOFENCES", "GEOFENCES_MAX_NUM_TO_REGISTER", "GEOFENCES_MIN_TIME_REPORT", "GEOFENCES_MIN_TIME_REQUEST", "MESSAGING_SESSION_TIMEOUT", "PURCHASES_BLOCKLIST", "getPURCHASES_BLOCKLIST$annotations", "REFRESH_RATE_LIMIT", "TEST_USER_DEVICE_LOGGING_ENABLED", "TEST_USER_OBJECT", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38376b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required content cards fields. Using defaults.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38377b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required ephemeral events fields. Using defaults.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38378b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required feature flag fields. Disabling feature flags.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38379b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required geofence fields. Using defaults.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38380b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error getting required test user fields. Using defaults";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38381b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(JSONArray jSONArray) {
            super(1);
            this.f38381b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f38381b.opt(i11) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function1<Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38382b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(JSONArray jSONArray) {
            super(1);
            this.f38382b = jSONArray;
        }

        public final String a(int i11) {
            Object obj = this.f38382b.get(i11);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public c5(long j11, Set<String> set, Set<String> set2, Set<String> set3, int i11, int i12, int i13, boolean z11, boolean z12, boolean z13, long j12, boolean z14, boolean z15, boolean z16, int i14) {
        this.f38361a = j11;
        this.f38362b = set;
        this.f38363c = set2;
        this.f38364d = set3;
        this.f38365e = i11;
        this.f38366f = i12;
        this.f38367g = i13;
        this.f38368h = z11;
        this.f38369i = z12;
        this.f38370j = z13;
        this.f38371k = j12;
        this.f38372l = z14;
        this.f38373m = z15;
        this.f38374n = z16;
        this.f38375o = i14;
    }

    public final void a(long j11) {
        this.f38361a = j11;
    }

    public final Set<String> b() {
        return this.f38362b;
    }

    public final Set<String> c() {
        return this.f38364d;
    }

    public final long d() {
        return this.f38361a;
    }

    public final void e(boolean z11) {
        this.f38368h = z11;
    }

    public final void f(boolean z11) {
        this.f38372l = z11;
    }

    public final int g() {
        return this.f38375o;
    }

    public final boolean h() {
        return this.f38369i;
    }

    public final boolean i() {
        return this.f38368h;
    }

    public final int j() {
        return this.f38367g;
    }

    public final long k() {
        return this.f38371k;
    }

    public final int l() {
        return this.f38366f;
    }

    public final int m() {
        return this.f38365e;
    }

    public final boolean n() {
        return this.f38372l;
    }

    public final boolean o() {
        return this.f38370j;
    }

    public final Set<String> a() {
        return this.f38363c;
    }

    public final void b(Set<String> set) {
        this.f38362b = set;
    }

    public final void c(Set<String> set) {
        this.f38364d = set;
    }

    public final void d(int i11) {
        this.f38365e = i11;
    }

    public final boolean e() {
        return this.f38373m;
    }

    public final boolean f() {
        return this.f38374n;
    }

    private final void e(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("geofences");
        if (optJSONObject != null) {
            try {
                this.f38365e = optJSONObject.getInt("min_time_since_last_request");
                this.f38366f = optJSONObject.getInt("min_time_since_last_report");
                this.f38369i = optJSONObject.getBoolean("enabled");
                this.f38368h = true;
                this.f38367g = optJSONObject.optInt("max_num_to_register", 20);
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f38379b, 4, (Object) null);
                this.f38365e = -1;
                this.f38366f = -1;
                this.f38367g = -1;
                this.f38369i = false;
                this.f38368h = false;
            }
        }
    }

    private final void f(JSONObject jSONObject) {
        boolean z11;
        JSONObject optJSONObject = jSONObject.optJSONObject("test_user");
        if (optJSONObject != null) {
            try {
                z11 = optJSONObject.getBoolean("device_logging_enabled");
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) f.f38380b, 4, (Object) null);
                z11 = false;
            }
            this.f38372l = z11;
        }
    }

    public final void a(Set<String> set) {
        this.f38363c = set;
    }

    public final void b(int i11) {
        this.f38367g = i11;
    }

    public final void c(int i11) {
        this.f38366f = i11;
    }

    public final void d(boolean z11) {
        this.f38369i = z11;
    }

    private final void d(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("feature_flags");
        if (optJSONObject != null) {
            try {
                this.f38374n = optJSONObject.optBoolean("enabled");
                this.f38375o = optJSONObject.getInt("refresh_rate_limit");
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f38378b, 4, (Object) null);
                this.f38374n = false;
            }
        }
    }

    public final void a(boolean z11) {
        this.f38370j = z11;
    }

    public final void b(long j11) {
        this.f38371k = j11;
    }

    public final void c(boolean z11) {
        this.f38374n = z11;
    }

    private final void c(JSONObject jSONObject) {
        boolean z11;
        JSONObject optJSONObject = jSONObject.optJSONObject("ephemeral_events");
        if (optJSONObject != null) {
            try {
                z11 = optJSONObject.getBoolean("enabled");
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f38377b, 4, (Object) null);
                z11 = false;
            }
            b(z11);
        }
    }

    public final void a(int i11) {
        this.f38375o = i11;
    }

    public final void b(boolean z11) {
        this.f38373m = z11;
    }

    private final void a(JSONObject jSONObject) {
        this.f38362b = a(jSONObject, "events_blacklist");
        this.f38363c = a(jSONObject, "attributes_blacklist");
        this.f38364d = a(jSONObject, "purchases_blacklist");
    }

    private final void b(JSONObject jSONObject) {
        boolean z11;
        JSONObject optJSONObject = jSONObject.optJSONObject("content_cards");
        if (optJSONObject != null) {
            try {
                z11 = optJSONObject.getBoolean("enabled");
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f38376b, 4, (Object) null);
                z11 = false;
            }
            this.f38370j = z11;
        }
    }

    private final Set<String> a(JSONObject jSONObject, String str) {
        Iterator it;
        HashSet hashSet = new HashSet();
        if (jSONObject.has(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                it = CollectionsKt__CollectionsKt.emptyList().iterator();
            } else {
                it = SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(RangesKt___RangesKt.until(0, optJSONArray.length())), new g(optJSONArray)), new h(optJSONArray)).iterator();
            }
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        return hashSet;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c5(long r17, java.util.Set r19, java.util.Set r20, java.util.Set r21, int r22, int r23, int r24, boolean r25, boolean r26, boolean r27, long r28, boolean r30, boolean r31, boolean r32, int r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r16 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r19
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r4
            goto L_0x001c
        L_0x001a:
            r5 = r20
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = r21
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = -1
            goto L_0x002b
        L_0x0029:
            r6 = r22
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = -1
            goto L_0x0033
        L_0x0031:
            r8 = r23
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = -1
            goto L_0x003b
        L_0x0039:
            r9 = r24
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r25
        L_0x0043:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0049
            r12 = 0
            goto L_0x004b
        L_0x0049:
            r12 = r26
        L_0x004b:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0051
            r13 = 0
            goto L_0x0053
        L_0x0051:
            r13 = r27
        L_0x0053:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005a
            r14 = -1
            goto L_0x005c
        L_0x005a:
            r14 = r28
        L_0x005c:
            r7 = r0 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0062
            r7 = 0
            goto L_0x0064
        L_0x0062:
            r7 = r30
        L_0x0064:
            r11 = r0 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x006a
            r11 = 0
            goto L_0x006c
        L_0x006a:
            r11 = r31
        L_0x006c:
            r35 = r11
            r11 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x0074
            r11 = 0
            goto L_0x0076
        L_0x0074:
            r11 = r32
        L_0x0076:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x007c
            r0 = -1
            goto L_0x007e
        L_0x007c:
            r0 = r33
        L_0x007e:
            r17 = r16
            r18 = r1
            r20 = r3
            r21 = r5
            r22 = r4
            r23 = r6
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r12
            r28 = r13
            r29 = r14
            r31 = r7
            r32 = r35
            r33 = r11
            r34 = r0
            r17.<init>(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.c5.<init>(long, java.util.Set, java.util.Set, java.util.Set, int, int, int, boolean, boolean, boolean, long, boolean, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c5(JSONObject jSONObject) {
        this(0, (Set) null, (Set) null, (Set) null, 0, 0, 0, false, false, false, 0, false, false, false, 0, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        JSONObject jSONObject2 = jSONObject;
        this.f38361a = jSONObject2.optLong("time", 0);
        this.f38371k = jSONObject2.optLong("messaging_session_timeout", -1);
        a(jSONObject);
        b(jSONObject);
        e(jSONObject);
        f(jSONObject);
        c(jSONObject);
        d(jSONObject);
    }
}
