package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.visa.checkout.Profile;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import net.bytebuddy.asm.Advice;
import org.json.JSONArray;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010:\u001a\u00020\u0002\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\rR$\u0010\t\u001a\u0004\u0018\u00010\b8G@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0005\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0011\u0010%\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0017\u0010)\u001a\u00020\f8F¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b&\u0010$R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010+R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048F¢\u0006\u0006\u001a\u0004\b.\u0010+R\u0011\u00101\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b0\u0010\u0015R\u0011\u00103\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b2\u0010\u0015R\u0011\u00105\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b4\u0010\u0015R\u0011\u00107\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b6\u0010\u001d¨\u0006?"}, d2 = {"Lbo/app/e5;", "", "", "storageKey", "", "a", "", "s", "Lbo/app/c5;", "serverConfig", "b", "Lkotlin/Pair;", "", "", "t", "l", "Lbo/app/c5;", "k", "()Lbo/app/c5;", "(Lbo/app/c5;)V", "n", "()Z", "isEphemeralEventsEnabled", "q", "isGeofencesEnabledSet", "p", "isGeofencesEnabled", "", "j", "()I", "minTimeSinceLastRequest", "i", "minTimeSinceLastReport", "g", "maxNumToRegister", "h", "()J", "messagingSessionTimeout", "e", "getConfigTime$annotations", "()V", "configTime", "c", "()Ljava/util/Set;", "blocklistedEvents", "blocklistedAttributes", "d", "blocklistedPurchases", "m", "isContentCardsEnabled", "r", "isTestUserDeviceLoggingEnabled", "o", "isFeatureFlagsEnabled", "f", "featureFlagsRefreshRateLimit", "Landroid/content/Context;", "context", "apiKey", "Lbo/app/s2;", "serverConfigUpdateListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/s2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class e5 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f38483f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final s2 f38484a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f38485b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantLock f38486c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f38487d = MutexKt.Mutex$default(false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private c5 f38488e;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u0012\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004¨\u0006\u0019"}, d2 = {"Lbo/app/e5$a;", "", "", "BLOCKLISTED_ATTRIBUTES_KEY", "Ljava/lang/String;", "BLOCKLISTED_EVENTS_KEY", "BLOCKLISTED_PURCHASES_KEY", "CONFIG_TIME_KEY", "CONTENT_CARDS_ENABLED_KEY", "EMPTY_BLOCKLIST", "EPHEMERAL_EVENTS_ENABLED", "FEATURE_FLAGS_ENABLED_KEY", "FEATURE_FLAGS_RATE_REFRESH_RATE_LIMIT_KEY", "FILE_NAME_BASE", "GEOFENCES_ENABLED_KEY", "GEOFENCES_ENABLED_SET_KEY", "GEOFENCES_MAX_NUM_TO_REGISTER_KEY", "GEOFENCES_MIN_TIME_REPORT_KEY", "GEOFENCES_MIN_TIME_REQUEST_KEY", "LAST_ACCESSED_SDK_VERSION", "getLAST_ACCESSED_SDK_VERSION$annotations", "()V", "MESSAGING_SESSION_TIMEOUT_KEY", "TEST_USER_DEVICE_LOGGING_ENABLED_SET_KEY", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38489b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not allowing server config info unlock. Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "", "it", "", "a", "(I)Ljava/lang/Boolean;", "com/braze/support/JsonUtils$e"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function1<Integer, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38490b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONArray jSONArray) {
            super(1);
            this.f38490b = jSONArray;
        }

        public final Boolean a(int i11) {
            return Boolean.valueOf(this.f38490b.opt(i11) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0003\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "", "it", "a", "(I)Ljava/lang/Object;", "com/braze/support/JsonUtils$f"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function1<Integer, String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONArray f38491b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONArray jSONArray) {
            super(1);
            this.f38491b = jSONArray;
        }

        public final String a(int i11) {
            Object obj = this.f38491b.get(i11);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38492b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced exception retrieving blocklisted strings from local storage. Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38493b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to unlock server config info.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f38494b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unlocking config info lock.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38495b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Server config updated for Content Cards from disabled to enabled";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f38496b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not persist server config to shared preferences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c5 f38497b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c5 c5Var) {
            super(0);
            this.f38497b = c5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Finishing updating server config to ", this.f38497b);
        }
    }

    public e5(Context context, String str, s2 s2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(s2Var, "serverConfigUpdateListener");
        this.f38484a = s2Var;
        this.f38485b = q5.a(context, Intrinsics.stringPlus("com.braze.storage.server_config.", str), (String) null, 2, (Object) null);
        s();
    }

    private final void s() {
        c5 c5Var = new c5(0, (Set) null, (Set) null, (Set) null, 0, 0, 0, false, false, false, 0, false, false, false, 0, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
        c5Var.a(b());
        c5Var.b(c());
        c5Var.c(d());
        c5Var.a(e());
        c5Var.b(h());
        c5Var.d(j());
        c5Var.c(i());
        c5Var.b(g());
        c5Var.d(p());
        c5Var.e(q());
        c5Var.f(r());
        c5Var.a(m());
        c5Var.b(n());
        c5Var.c(o());
        c5Var.a(f());
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            a(c5Var);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(c5 c5Var) {
        this.f38488e = c5Var;
    }

    public final Set<String> b() {
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            Set<String> a11 = k11 == null ? null : k11.a();
            if (a11 == null) {
                a11 = a("blacklisted_attributes");
            }
            return a11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set<String> c() {
        Set<String> set;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                set = null;
            } else {
                set = k11.b();
            }
            if (set == null) {
                set = a("blacklisted_events");
            }
            return set;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set<String> d() {
        Set<String> set;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                set = null;
            } else {
                set = k11.c();
            }
            if (set == null) {
                set = a("blacklisted_purchases");
            }
            return set;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long e() {
        Long l11;
        long j11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(k11.d());
            }
            if (l11 == null) {
                j11 = this.f38485b.getLong("config_time", 0);
            } else {
                j11 = l11.longValue();
            }
            return j11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int f() {
        Integer num;
        int i11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                num = null;
            } else {
                num = Integer.valueOf(k11.g());
            }
            if (num == null) {
                i11 = this.f38485b.getInt("feature_flags_refresh_rate_limit", -1);
            } else {
                i11 = num.intValue();
            }
            return i11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int g() {
        Integer num;
        int i11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                num = null;
            } else {
                num = Integer.valueOf(k11.j());
            }
            if (num == null) {
                i11 = this.f38485b.getInt("geofences_max_num_to_register", -1);
            } else {
                i11 = num.intValue();
            }
            return i11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long h() {
        Long l11;
        long j11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(k11.k());
            }
            if (l11 == null) {
                j11 = this.f38485b.getLong("messaging_session_timeout", -1);
            } else {
                j11 = l11.longValue();
            }
            return j11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int i() {
        Integer num;
        int i11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                num = null;
            } else {
                num = Integer.valueOf(k11.l());
            }
            if (num == null) {
                i11 = this.f38485b.getInt("geofences_min_time_since_last_report", -1);
            } else {
                i11 = num.intValue();
            }
            return i11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int j() {
        Integer num;
        int i11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                num = null;
            } else {
                num = Integer.valueOf(k11.m());
            }
            if (num == null) {
                i11 = this.f38485b.getInt("geofences_min_time_since_last_request", -1);
            } else {
                i11 = num.intValue();
            }
            return i11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final c5 k() {
        return this.f38488e;
    }

    public final boolean l() {
        return e() <= 0;
    }

    public final boolean m() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.o());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("content_cards_enabled", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean n() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.e());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("ephemeral_events_enabled", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean o() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.f());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("feature_flags_enabled", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean p() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.h());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("geofences_enabled", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean q() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.i());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("geofences_enabled_set", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean r() {
        Boolean bool;
        boolean z11;
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            c5 k11 = k();
            if (k11 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(k11.n());
            }
            if (bool == null) {
                z11 = this.f38485b.getBoolean("test_user_device_logging_enabled", false);
            } else {
                z11 = bool.booleanValue();
            }
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void t() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) f.f38493b, 6, (Object) null);
        if (this.f38487d.isLocked()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) g.f38494b, 7, (Object) null);
            Mutex.DefaultImpls.unlock$default(this.f38487d, (Object) null, 1, (Object) null);
        }
    }

    public final Pair<Long, Boolean> a() {
        if (Mutex.DefaultImpls.tryLock$default(this.f38487d, (Object) null, 1, (Object) null)) {
            return new Pair<>(Long.valueOf(e()), Boolean.valueOf(l()));
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) b.f38489b, 6, (Object) null);
        return null;
    }

    public final void b(c5 c5Var) {
        Intrinsics.checkNotNullParameter(c5Var, "serverConfig");
        boolean z11 = !m() && c5Var.o();
        ReentrantLock reentrantLock = this.f38486c;
        reentrantLock.lock();
        try {
            a(c5Var);
            Unit unit = Unit.INSTANCE;
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f38495b, 7, (Object) null);
                this.f38484a.a();
            }
            try {
                SharedPreferences.Editor edit = this.f38485b.edit();
                if (c5Var.b() != null) {
                    edit.putString("blacklisted_events", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) c5Var.b())));
                }
                if (c5Var.a() != null) {
                    edit.putString("blacklisted_attributes", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) c5Var.a())));
                }
                if (c5Var.c() != null) {
                    edit.putString("blacklisted_purchases", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) c5Var.c())));
                }
                edit.putLong("config_time", c5Var.d());
                edit.putInt("geofences_min_time_since_last_request", c5Var.m());
                edit.putInt("geofences_min_time_since_last_report", c5Var.l());
                edit.putInt("geofences_max_num_to_register", c5Var.j());
                edit.putBoolean("geofences_enabled", c5Var.h());
                edit.putBoolean("geofences_enabled_set", c5Var.i());
                edit.putLong("messaging_session_timeout", c5Var.k());
                edit.putBoolean("test_user_device_logging_enabled", c5Var.n());
                edit.putBoolean("content_cards_enabled", c5Var.o());
                edit.putBoolean("ephemeral_events_enabled", c5Var.e());
                edit.putBoolean("feature_flags_enabled", c5Var.f());
                edit.putInt("feature_flags_refresh_rate_limit", c5Var.g());
                edit.apply();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) i.f38496b, 4, (Object) null);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new j(c5Var), 6, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ Exception -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            android.content.SharedPreferences r0 = r8.f38485b     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = ""
            java.lang.String r9 = r0.getString(r9, r1)     // Catch:{ Exception -> 0x0053 }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ Exception -> 0x0053 }
            r0.<init>()     // Catch:{ Exception -> 0x0053 }
            r1 = 0
            if (r9 == 0) goto L_0x0019
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r2 = r1
            goto L_0x001a
        L_0x0019:
            r2 = 1
        L_0x001a:
            if (r2 != 0) goto L_0x0067
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x0053 }
            r2.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x0053 }
            int r9 = r2.length()     // Catch:{ Exception -> 0x0053 }
            kotlin.ranges.IntRange r9 = kotlin.ranges.RangesKt___RangesKt.until((int) r1, (int) r9)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r9 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r9)     // Catch:{ Exception -> 0x0053 }
            bo.app.e5$c r1 = new bo.app.e5$c     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt___SequencesKt.filter(r9, r1)     // Catch:{ Exception -> 0x0053 }
            bo.app.e5$d r1 = new bo.app.e5$d     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r9 = kotlin.sequences.SequencesKt___SequencesKt.map(r9, r1)     // Catch:{ Exception -> 0x0053 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0053 }
        L_0x0043:
            boolean r1 = r9.hasNext()     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x0067
            java.lang.Object r1 = r9.next()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0053 }
            r0.add(r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0043
        L_0x0053:
            r9 = move-exception
            r3 = r9
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            bo.app.e5$e r5 = bo.app.e5.e.f38492b
            r4 = 0
            r6 = 4
            r7 = 0
            r1 = r8
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.e5.a(java.lang.String):java.util.Set");
    }
}
