package bo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0007J\u0006\u0010\u0013\u001a\u00020\u0006J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0007H\u0007R\"\u0010\u0015\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u0005\u0010\u001e¨\u0006%"}, d2 = {"Lbo/app/h0;", "", "", "initialDelayMs", "Lkotlinx/coroutines/Job;", "a", "", "Lbo/app/j2;", "eventPublisher", "", "throwable", "b", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "", "e", "f", "c", "d", "g", "eventManager", "currentIntervalMs", "J", "()J", "setCurrentIntervalMs$android_sdk_base_release", "(J)V", "value", "isSyncPolicyDisabled", "Z", "()Z", "(Z)V", "Landroid/content/Context;", "context", "Lbo/app/g0;", "dataSyncConfigurationProvider", "<init>", "(Landroid/content/Context;Lbo/app/j2;Lbo/app/g0;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class h0 {

    /* renamed from: n  reason: collision with root package name */
    public static final c f38554n = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38555a;

    /* renamed from: b  reason: collision with root package name */
    private final g0 f38556b;

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f38557c;

    /* renamed from: d  reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f38558d;

    /* renamed from: e  reason: collision with root package name */
    private final d1 f38559e = new d1((int) TimeUnit.MINUTES.toMillis(5), 0, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public m5 f38560f = m5.NO_SESSION;

    /* renamed from: g  reason: collision with root package name */
    private long f38561g = -1;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f38562h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ConnectivityManager f38563i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public t3 f38564j;

    /* renamed from: k  reason: collision with root package name */
    private Job f38565k;

    /* renamed from: l  reason: collision with root package name */
    private int f38566l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38567m;

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"bo/app/h0$a", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "", "onCapabilitiesChanged", "onLost", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h0 f38568a;

        public a(h0 h0Var) {
            this.f38568a = h0Var;
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            this.f38568a.a(networkCapabilities);
        }

        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, SDKCoreEvent.Network.TYPE_NETWORK);
            super.onLost(network);
            Network activeNetwork = this.f38568a.f38563i.getActiveNetwork();
            h0 h0Var = this.f38568a;
            h0Var.a(h0Var.f38563i.getNetworkCapabilities(activeNetwork));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"bo/app/h0$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h0 f38569a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j2 f38570b;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.dispatch.DataSyncPolicyProvider$2$onReceive$1", f = "DataSyncPolicyProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: b  reason: collision with root package name */
            int f38571b;

            /* renamed from: c  reason: collision with root package name */
            private /* synthetic */ Object f38572c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ h0 f38573d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Intent f38574e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ j2 f38575f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f38576g;

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: bo.app.h0$b$a$a  reason: collision with other inner class name */
            public static final class C0021a extends Lambda implements Function0<String> {

                /* renamed from: b  reason: collision with root package name */
                public static final C0021a f38577b = new C0021a();

                public C0021a() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Retrieving connectivity event data in background";
                }
            }

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: bo.app.h0$b$a$b  reason: collision with other inner class name */
            public static final class C0022b extends Lambda implements Function0<String> {

                /* renamed from: b  reason: collision with root package name */
                public static final C0022b f38578b = new C0022b();

                public C0022b() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Failed to process connectivity event.";
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(h0 h0Var, Intent intent, j2 j2Var, BroadcastReceiver.PendingResult pendingResult, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f38573d = h0Var;
                this.f38574e = intent;
                this.f38575f = j2Var;
                this.f38576g = pendingResult;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f38573d, this.f38574e, this.f38575f, this.f38576g, continuation);
                aVar.f38572c = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f38571b == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f38572c;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) C0021a.f38577b, 6, (Object) null);
                    try {
                        h0 h0Var = this.f38573d;
                        h0Var.f38564j = v.a(this.f38574e, h0Var.f38563i);
                        this.f38573d.c();
                    } catch (Exception e11) {
                        Exception exc = e11;
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, BrazeLogger.Priority.E, (Throwable) exc, false, (Function0) C0022b.f38578b, 4, (Object) null);
                        this.f38573d.a(this.f38575f, (Throwable) exc);
                    }
                    this.f38576g.finish();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public b(h0 h0Var, j2 j2Var) {
            this.f38569a = h0Var;
            this.f38570b = j2Var;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            BroadcastReceiver.PendingResult goAsync = goAsync();
            BrazeCoroutineScope brazeCoroutineScope = BrazeCoroutineScope.INSTANCE;
            Job unused = BuildersKt__Builders_commonKt.launch$default(brazeCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new a(this.f38569a, intent, this.f38570b, goAsync, (Continuation<? super a>) null), 3, (Object) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lbo/app/h0$c;", "", "", "MAX_CONSECUTIVE_SDK_AUTH_FAILURES", "I", "getMAX_CONSECUTIVE_SDK_AUTH_FAILURES$annotations", "()V", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38579a;

        static {
            int[] iArr = new int[t3.values().length];
            iArr[t3.f39409b.ordinal()] = 1;
            iArr[t3.BAD.ordinal()] = 2;
            iArr[t3.GREAT.ordinal()] = 3;
            iArr[t3.GOOD.ordinal()] = 4;
            f38579a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38580b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received network error event. Backing off.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f38581b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(h0 h0Var) {
            super(0);
            this.f38581b = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Received successful request flush. Default flush interval reset to ", Long.valueOf(this.f38581b.b()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38582b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0 f38583c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(long j11, h0 h0Var) {
            super(0);
            this.f38582b = j11;
            this.f38583c = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Kicking off the Sync Job. initialDelaysMs: " + this.f38582b + ": currentIntervalMs " + this.f38583c.b() + " ms";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.dispatch.DataSyncPolicyProvider$kickoffSyncJob$2", f = "DataSyncPolicyProvider.kt", i = {0, 0, 1, 1}, l = {169, 173}, m = "invokeSuspend", n = {"$this$launch", "loopDelayMs", "$this$launch", "loopDelayMs"}, s = {"L$0", "J$0", "L$0", "J$0"})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        long f38584b;

        /* renamed from: c  reason: collision with root package name */
        int f38585c;

        /* renamed from: d  reason: collision with root package name */
        private /* synthetic */ Object f38586d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h0 f38587e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f38588f;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f38589b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Requesting data flush from automatic sync policy";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(h0 h0Var, long j11, Continuation<? super h> continuation) {
            super(2, continuation);
            this.f38587e = h0Var;
            this.f38588f = j11;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            h hVar = new h(this.f38587e, this.f38588f, continuation);
            hVar.f38586d = obj;
            return hVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.f38585c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x002c
                if (r1 == r3) goto L_0x0022
                if (r1 != r2) goto L_0x001a
                long r3 = r13.f38584b
                java.lang.Object r1 = r13.f38586d
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r14)
                r14 = r13
            L_0x0018:
                r11 = r3
                goto L_0x006d
            L_0x001a:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x0022:
                long r3 = r13.f38584b
                java.lang.Object r1 = r13.f38586d
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x004a
            L_0x002c:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.f38586d
                r1 = r14
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                bo.app.h0 r14 = r13.f38587e
                long r4 = r14.b()
                long r6 = r13.f38588f
                r13.f38586d = r1
                r13.f38584b = r4
                r13.f38585c = r3
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r6, r13)
                if (r14 != r0) goto L_0x0049
                return r0
            L_0x0049:
                r3 = r4
            L_0x004a:
                com.braze.Braze$Companion r14 = com.braze.Braze.Companion
                bo.app.h0 r5 = r13.f38587e
                android.content.Context r5 = r5.f38555a
                com.braze.Braze r14 = r14.getInstance(r5)
                r14.requestImmediateDataFlush()
                r14 = r13
            L_0x005a:
                boolean r5 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r5 == 0) goto L_0x008c
                r14.f38586d = r1
                r14.f38584b = r3
                r14.f38585c = r2
                java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r3, r14)
                if (r5 != r0) goto L_0x0018
                return r0
            L_0x006d:
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.V
                bo.app.h0$h$a r8 = bo.app.h0.h.a.f38589b
                r6 = 0
                r7 = 0
                r9 = 6
                r10 = 0
                r4 = r1
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
                com.braze.Braze$Companion r3 = com.braze.Braze.Companion
                bo.app.h0 r4 = r14.f38587e
                android.content.Context r4 = r4.f38555a
                com.braze.Braze r3 = r3.getInstance(r4)
                r3.requestImmediateDataFlush()
                r3 = r11
                goto L_0x005a
            L_0x008c:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.h0.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f38590b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(h0 h0Var) {
            super(0);
            this.f38590b = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data flush interval is " + this.f38590b.b() + " ms. Not scheduling a proceeding data flush.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f38591b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log throwable.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f38592b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(h0 h0Var) {
            super(0);
            this.f38592b = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "recalculateDispatchState called with session state: " + this.f38592b.f38560f + " lastNetworkLevel: " + this.f38592b.f38564j;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f38593b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(h0 h0Var) {
            super(0);
            this.f38593b = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Flush interval was too low (" + this.f38593b.b() + "), moving to minimum of 1000 ms";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h0 f38594b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(h0 h0Var) {
            super(0);
            this.f38594b = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("currentIntervalMs: ", Long.valueOf(this.f38594b.b()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38595b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h0 f38596c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(long j11, h0 h0Var) {
            super(0);
            this.f38595b = j11;
            this.f38596c = h0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data flush interval has changed from " + this.f38595b + " ms to " + this.f38596c.b() + " ms after connectivity state change to: " + this.f38596c.f38564j + " and session state: " + this.f38596c.f38560f;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38597b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(long j11) {
            super(0);
            this.f38597b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting new sync runnable with delay " + this.f38597b + " ms";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f38598b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The data sync policy is already running. Ignoring request.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final q f38599b = new q();

        public q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data sync started";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f38600b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The data sync policy is not running. Ignoring request.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s f38601b = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Data sync stopped";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final t f38602b = new t();

        public t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to unregister Connectivity callback";
        }
    }

    public h0(Context context, j2 j2Var, g0 g0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(j2Var, "eventPublisher");
        Intrinsics.checkNotNullParameter(g0Var, "dataSyncConfigurationProvider");
        this.f38555a = context;
        this.f38556b = g0Var;
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            this.f38563i = (ConnectivityManager) systemService;
            this.f38564j = t3.f39409b;
            if (Build.VERSION.SDK_INT >= 30) {
                this.f38558d = new a(this);
            } else {
                this.f38557c = new b(this, j2Var);
            }
            a(j2Var);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final synchronized boolean e() {
        if (this.f38562h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) p.f38598b, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) q.f38599b, 7, (Object) null);
        d();
        b(this.f38561g);
        this.f38562h = true;
        return true;
    }

    public final synchronized boolean f() {
        if (!this.f38562h) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) r.f38600b, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) s.f38601b, 7, (Object) null);
        a();
        g();
        this.f38562h = false;
        return true;
    }

    public final void g() {
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                ConnectivityManager connectivityManager = this.f38563i;
                ConnectivityManager.NetworkCallback networkCallback = this.f38558d;
                if (networkCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("connectivityNetworkCallback");
                    networkCallback = null;
                }
                connectivityManager.unregisterNetworkCallback(networkCallback);
                return;
            }
            this.f38555a.unregisterReceiver(this.f38557c);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) t.f38602b, 4, (Object) null);
        }
    }

    public final long b() {
        return this.f38561g;
    }

    public final void c() {
        long j11;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new k(this), 6, (Object) null);
        long j12 = this.f38561g;
        if (this.f38560f == m5.NO_SESSION || this.f38567m || this.f38566l >= 50) {
            this.f38561g = -1;
        } else {
            int i11 = d.f38579a[this.f38564j.ordinal()];
            if (i11 == 1) {
                j11 = -1;
            } else if (i11 == 2) {
                j11 = this.f38556b.a();
            } else if (i11 == 3) {
                j11 = this.f38556b.c();
            } else if (i11 == 4) {
                j11 = this.f38556b.b();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f38561g = j11;
            if (j11 != -1 && j11 < 1000) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new l(this), 6, (Object) null);
                this.f38561g = 1000;
            }
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new m(this), 6, (Object) null);
        if (j12 != this.f38561g) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new n(j12, this), 7, (Object) null);
            b(this.f38561g);
        }
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 30) {
            ConnectivityManager connectivityManager = this.f38563i;
            ConnectivityManager.NetworkCallback networkCallback = this.f38558d;
            if (networkCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("connectivityNetworkCallback");
                networkCallback = null;
            }
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
            a(this.f38563i.getNetworkCapabilities(this.f38563i.getActiveNetwork()));
            return;
        }
        this.f38555a.registerReceiver(this.f38557c, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
    }

    private final void b(long j11) {
        a();
        if (this.f38561g >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new o(j11), 7, (Object) null);
            this.f38565k = a(j11);
        }
    }

    public final synchronized void a(boolean z11) {
        this.f38567m = z11;
        c();
        if (z11) {
            f();
        } else {
            e();
        }
    }

    private final Job a(long j11) {
        long j12 = j11;
        if (this.f38561g >= 1000) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new g(j12, this), 6, (Object) null);
            return BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new h(this, j12, (Continuation<? super h>) null), 3, (Object) null);
        }
        Braze.Companion.getInstance(this.f38555a).requestImmediateDataFlush();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(this), 7, (Object) null);
        return null;
    }

    private final void a() {
        Job job = this.f38565k;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.f38565k = null;
    }

    /* access modifiers changed from: private */
    public final void a(j2 j2Var, Throwable th2) {
        try {
            j2Var.a(th2, Throwable.class);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) j.f38591b, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void a(NetworkCapabilities networkCapabilities) {
        this.f38564j = v.a(networkCapabilities);
        c();
    }

    public final void a(j2 j2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "eventManager");
        j2Var.a(new x2.c(this), l5.class);
        j2Var.a(new x2.d(this), n5.class);
        j2Var.a(new x2.e(this), t4.class);
        j2Var.a(new x2.f(this), u4.class);
        j2Var.a(new x2.g(this), g5.class);
    }

    /* access modifiers changed from: private */
    public static final void a(h0 h0Var, l5 l5Var) {
        Intrinsics.checkNotNullParameter(h0Var, "this$0");
        Intrinsics.checkNotNullParameter(l5Var, "it");
        h0Var.f38560f = m5.OPEN_SESSION;
        h0Var.f38566l = 0;
        h0Var.c();
    }

    /* access modifiers changed from: private */
    public static final void a(h0 h0Var, n5 n5Var) {
        Intrinsics.checkNotNullParameter(h0Var, "this$0");
        Intrinsics.checkNotNullParameter(n5Var, "it");
        h0Var.f38560f = m5.NO_SESSION;
        h0Var.c();
    }

    /* access modifiers changed from: private */
    public static final void a(h0 h0Var, t4 t4Var) {
        Intrinsics.checkNotNullParameter(h0Var, "this$0");
        Intrinsics.checkNotNullParameter(t4Var, "it");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) h0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) e.f38580b, 7, (Object) null);
        long j11 = h0Var.f38561g;
        h0Var.b(j11 + ((long) h0Var.f38559e.a((int) j11)));
    }

    /* access modifiers changed from: private */
    public static final void a(h0 h0Var, u4 u4Var) {
        Intrinsics.checkNotNullParameter(h0Var, "this$0");
        Intrinsics.checkNotNullParameter(u4Var, "it");
        if (h0Var.f38559e.b()) {
            h0Var.f38559e.c();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) h0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(h0Var), 7, (Object) null);
            h0Var.b(h0Var.f38561g);
        }
        h0Var.f38566l = 0;
    }

    /* access modifiers changed from: private */
    public static final void a(h0 h0Var, g5 g5Var) {
        Intrinsics.checkNotNullParameter(h0Var, "this$0");
        Intrinsics.checkNotNullParameter(g5Var, "$dstr$responseError");
        if (g5Var.a() instanceof x4) {
            h0Var.f38566l++;
            h0Var.c();
        }
    }
}
