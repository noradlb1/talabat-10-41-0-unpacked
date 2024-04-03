package bo.app;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010h\u001a\u00020g\u0012\u0006\u0010j\u001a\u00020i\u0012\u0006\u0010l\u001a\u00020k\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010r\u001a\u00020q\u0012\u0006\u0010s\u001a\u00020q\u0012\u0006\u0010u\u001a\u00020t¢\u0006\u0004\bv\u0010wJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u0003\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0003\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0016X\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u00109\u001a\u0002088\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010H\u001a\u00020G8\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020L8\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010R\u001a\u00020Q8\u0016X\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010W\u001a\u00020V8\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001a\u0010\\\u001a\u00020[8\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010a\u001a\u00020`8\u0016X\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d¨\u0006x"}, d2 = {"Lbo/app/u6;", "Lbo/app/c3;", "", "a", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/e5;", "e", "()Lbo/app/e5;", "Lbo/app/t6;", "userCache", "Lbo/app/t6;", "b", "()Lbo/app/t6;", "(Lbo/app/t6;)V", "Lbo/app/k0;", "deviceCache", "Lbo/app/k0;", "c", "()Lbo/app/k0;", "(Lbo/app/k0;)V", "Lbo/app/z0;", "eventManager", "Lbo/app/z0;", "k", "()Lbo/app/z0;", "Lbo/app/f;", "automaticDispatchManager", "Lbo/app/f;", "n", "()Lbo/app/f;", "Lbo/app/y0;", "eventListenerFactory", "Lbo/app/y0;", "q", "()Lbo/app/y0;", "Lbo/app/h0;", "dataRefreshPolicyProvider", "Lbo/app/h0;", "d", "()Lbo/app/h0;", "Lbo/app/t;", "brazeSessionManager", "Lbo/app/t;", "t", "()Lbo/app/t;", "Lbo/app/b1;", "eventStorageManager", "Lbo/app/b1;", "f", "()Lbo/app/b1;", "Lbo/app/f2;", "deviceDataProvider", "Lbo/app/f2;", "r", "()Lbo/app/f2;", "Lbo/app/y4;", "sdkAuthenticationCache", "Lbo/app/y4;", "o", "()Lbo/app/y4;", "Lbo/app/q;", "brazeMessagingSessionManager", "Lbo/app/q;", "s", "()Lbo/app/q;", "Lbo/app/b2;", "brazeManager", "Lbo/app/b2;", "m", "()Lbo/app/b2;", "Lbo/app/k6;", "triggerManager", "Lbo/app/k6;", "l", "()Lbo/app/k6;", "Lbo/app/l;", "geofenceManager", "Lbo/app/l;", "i", "()Lbo/app/l;", "Lbo/app/o;", "brazeLocationManager", "Lbo/app/o;", "h", "()Lbo/app/o;", "Lbo/app/e1;", "featureFlagsManager", "Lbo/app/e1;", "p", "()Lbo/app/e1;", "Lbo/app/j1;", "feedStorageProvider", "Lbo/app/j1;", "g", "()Lbo/app/j1;", "Lbo/app/a0;", "contentCardsStorageProvider", "Lbo/app/a0;", "j", "()Lbo/app/a0;", "Landroid/content/Context;", "applicationContext", "Lbo/app/v3;", "offlineUserStorageProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/j2;", "externalEventPublisher", "Lbo/app/g2;", "deviceIdProvider", "Lbo/app/m2;", "registrationDataProvider", "", "disableAllNetworkRequests", "disableAutomaticNetworkRequests", "Lbo/app/b6;", "testUserDeviceLoggingManager", "<init>", "(Landroid/content/Context;Lbo/app/v3;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/j2;Lbo/app/g2;Lbo/app/m2;ZZLbo/app/b6;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class u6 implements c3 {
    private final j1 A;
    private final a0 B;
    private final p2 C;

    /* renamed from: a  reason: collision with root package name */
    private final String f39458a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39459b;

    /* renamed from: c  reason: collision with root package name */
    private final z4 f39460c;

    /* renamed from: d  reason: collision with root package name */
    private final f5 f39461d;

    /* renamed from: e  reason: collision with root package name */
    private final e5 f39462e;

    /* renamed from: f  reason: collision with root package name */
    public t6 f39463f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f39464g;

    /* renamed from: h  reason: collision with root package name */
    private final z0 f39465h;

    /* renamed from: i  reason: collision with root package name */
    private final f f39466i;

    /* renamed from: j  reason: collision with root package name */
    private final p5 f39467j;

    /* renamed from: k  reason: collision with root package name */
    private final w0 f39468k;

    /* renamed from: l  reason: collision with root package name */
    private final y0 f39469l;

    /* renamed from: m  reason: collision with root package name */
    private final h0 f39470m;

    /* renamed from: n  reason: collision with root package name */
    private final t f39471n;

    /* renamed from: o  reason: collision with root package name */
    private final o5 f39472o;

    /* renamed from: p  reason: collision with root package name */
    private final a1 f39473p;

    /* renamed from: q  reason: collision with root package name */
    private final b1 f39474q;

    /* renamed from: r  reason: collision with root package name */
    private final f2 f39475r;

    /* renamed from: s  reason: collision with root package name */
    private final y4 f39476s;

    /* renamed from: t  reason: collision with root package name */
    private final q f39477t;

    /* renamed from: u  reason: collision with root package name */
    private final a5 f39478u;

    /* renamed from: v  reason: collision with root package name */
    private final b2 f39479v;

    /* renamed from: w  reason: collision with root package name */
    private final k6 f39480w;

    /* renamed from: x  reason: collision with root package name */
    private final l f39481x;

    /* renamed from: y  reason: collision with root package name */
    private final o f39482y;

    /* renamed from: z  reason: collision with root package name */
    private final e1 f39483z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.managers.UserDependencyManager$requestClose$1", f = "UserDependencyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39484b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f39485c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ u6 f39486d;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.u6$a$a  reason: collision with other inner class name */
        public static final class C0034a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0034a f39487b = new C0034a();

            public C0034a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "User cache was locked, waiting.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f39488b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "User cache notified. Continuing UserDependencyManager shutdown";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f39489b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Device cache was locked, waiting.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final d f39490b = new d();

            public d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Device cache notified. Continuing UserDependencyManager shutdown";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final e f39491b = new e();

            public e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while shutting down dispatch manager. Continuing.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final f f39492b = new f();

            public f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while stopping data sync. Continuing.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(u6 u6Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f39486d = u6Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f39486d, continuation);
            aVar.f39485c = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f39484b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f39485c;
                try {
                    if (this.f39486d.b().b()) {
                        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                        BrazeLogger.brazelog$default(brazeLogger, (Object) coroutineScope, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) C0034a.f39487b, 6, (Object) null);
                        this.f39486d.b().c();
                        BrazeLogger.brazelog$default(brazeLogger, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f39488b, 7, (Object) null);
                    }
                    if (this.f39486d.c().b()) {
                        BrazeLogger brazeLogger2 = BrazeLogger.INSTANCE;
                        BrazeLogger.brazelog$default(brazeLogger2, (Object) coroutineScope, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f39489b, 6, (Object) null);
                        this.f39486d.c().c();
                        BrazeLogger.brazelog$default(brazeLogger2, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f39490b, 7, (Object) null);
                    }
                    this.f39486d.n().a((j2) this.f39486d.k());
                } catch (Exception e11) {
                    CoroutineScope coroutineScope2 = coroutineScope;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope2, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) e.f39491b, 4, (Object) null);
                }
                try {
                    this.f39486d.d().f();
                } catch (Exception e12) {
                    CoroutineScope coroutineScope3 = coroutineScope;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope3, BrazeLogger.Priority.W, (Throwable) e12, false, (Function0) f.f39492b, 4, (Object) null);
                }
                this.f39486d.k().a(new w(), w.class);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public u6(Context context, v3 v3Var, BrazeConfigurationProvider brazeConfigurationProvider, j2 j2Var, g2 g2Var, m2 m2Var, boolean z11, boolean z12, b6 b6Var) {
        Context context2 = context;
        BrazeConfigurationProvider brazeConfigurationProvider2 = brazeConfigurationProvider;
        Intrinsics.checkNotNullParameter(context2, "applicationContext");
        Intrinsics.checkNotNullParameter(v3Var, "offlineUserStorageProvider");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider2, "configurationProvider");
        Intrinsics.checkNotNullParameter(j2Var, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(g2Var, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(m2Var, "registrationDataProvider");
        Intrinsics.checkNotNullParameter(b6Var, "testUserDeviceLoggingManager");
        String a11 = v3Var.a();
        this.f39458a = a11;
        String iVar = brazeConfigurationProvider.getBrazeApiKey().toString();
        this.f39459b = iVar;
        z4 z4Var = new z4(context2);
        this.f39460c = z4Var;
        f5 f5Var = new f5(context2);
        this.f39461d = f5Var;
        this.f39462e = new e5(context2, iVar, f5Var);
        this.f39465h = new z0(z4Var);
        p5 p5Var = new p5(context2, a11, iVar);
        this.f39467j = p5Var;
        w0 w0Var = new w0(p5Var, k());
        this.f39468k = w0Var;
        this.f39470m = new h0(context2, k(), new g0(context2));
        z0 k11 = k();
        Object systemService = context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            t tVar = r1;
            AlarmManager alarmManager = (AlarmManager) systemService;
            z4 z4Var2 = z4Var;
            String str = iVar;
            t tVar2 = new t(context, w0Var, k11, j2Var, alarmManager, brazeConfigurationProvider.getSessionTimeoutSeconds(), brazeConfigurationProvider.isSessionStartBasedTimeoutEnabled());
            this.f39471n = tVar;
            o5 o5Var = new o5(context2, a11, str);
            this.f39472o = o5Var;
            a1 a1Var = new a1(o5Var, k());
            this.f39473p = a1Var;
            this.f39474q = new b1(a1Var);
            this.f39476s = new y4(context2, a11, str);
            this.f39477t = new q(context2, k(), e());
            a5 a5Var = new a5(context2, a11, str);
            this.f39478u = a5Var;
            Context context3 = context;
            p pVar = r1;
            String str2 = a11;
            a5 a5Var2 = a5Var;
            p pVar2 = new p(context3, a11, str, t(), k(), brazeConfigurationProvider, e(), f(), z12, s(), z4Var2);
            this.f39479v = pVar;
            this.f39480w = new k6(context3, m(), k(), j2Var, brazeConfigurationProvider, str2, str);
            this.f39481x = new l(context3, str, m(), brazeConfigurationProvider, e(), k());
            Context context4 = context;
            this.f39482y = new o(context4, m(), brazeConfigurationProvider2);
            this.f39483z = new e1(context4, str, e(), m());
            String str3 = str2;
            this.A = new j1(context4, str3, m());
            this.B = new a0(context, str3, str, m(), (String) null, 16, (DefaultConstructorMarker) null);
            r4 r4Var = new r4(u1.a(), k(), j2Var, g(), e(), j(), m());
            this.C = r4Var;
            if (Intrinsics.areEqual((Object) str3, (Object) "")) {
                Context context5 = context;
                a(new t6(context5, m2Var, z4Var2, (String) null, (String) null, 24, (DefaultConstructorMarker) null));
                a(new k0(context5, (String) null, (String) null, 6, (DefaultConstructorMarker) null));
            } else {
                a(new t6(context, m2Var, z4Var2, str3, str));
                a(new k0(context4, str3, str));
            }
            this.f39475r = new l0(context4, brazeConfigurationProvider2, g2Var, c());
            q0 q0Var = new q0(b(), r(), brazeConfigurationProvider, o(), a5Var2, k());
            d().a(z12);
            this.f39466i = new f(brazeConfigurationProvider, k(), r4Var, q0Var, z11);
            y0 y0Var = r1;
            y0 y0Var2 = new y0(context, h(), n(), m(), b(), c(), l(), l().f(), f(), i(), b6Var, j2Var, brazeConfigurationProvider, j(), a5Var2, e(), p());
            this.f39469l = y0Var;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    public void a(t6 t6Var) {
        Intrinsics.checkNotNullParameter(t6Var, "<set-?>");
        this.f39463f = t6Var;
    }

    public t6 b() {
        t6 t6Var = this.f39463f;
        if (t6Var != null) {
            return t6Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userCache");
        return null;
    }

    public k0 c() {
        k0 k0Var = this.f39464g;
        if (k0Var != null) {
            return k0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceCache");
        return null;
    }

    public h0 d() {
        return this.f39470m;
    }

    public e5 e() {
        return this.f39462e;
    }

    public b1 f() {
        return this.f39474q;
    }

    public j1 g() {
        return this.A;
    }

    public o h() {
        return this.f39482y;
    }

    public l i() {
        return this.f39481x;
    }

    public a0 j() {
        return this.B;
    }

    public z0 k() {
        return this.f39465h;
    }

    public k6 l() {
        return this.f39480w;
    }

    public b2 m() {
        return this.f39479v;
    }

    public f n() {
        return this.f39466i;
    }

    public y4 o() {
        return this.f39476s;
    }

    public e1 p() {
        return this.f39483z;
    }

    public y0 q() {
        return this.f39469l;
    }

    public f2 r() {
        return this.f39475r;
    }

    public q s() {
        return this.f39477t;
    }

    public t t() {
        return this.f39471n;
    }

    public void a(k0 k0Var) {
        Intrinsics.checkNotNullParameter(k0Var, "<set-?>");
        this.f39464g = k0Var;
    }

    public void a() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new a(this, (Continuation<? super a>) null), 3, (Object) null);
    }
}
