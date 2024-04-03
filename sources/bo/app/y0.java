package bo.app;

import android.content.Context;
import bo.app.a4;
import com.braze.Braze;
import com.braze.BrazeInternal;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.instabug.library.model.State;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import x2.a0;
import x2.b0;
import x2.c0;
import x2.d0;
import x2.e0;
import x2.f0;
import x2.g0;
import x2.h0;
import x2.i0;
import x2.j0;
import x2.k0;
import x2.l0;
import x2.m0;
import x2.n0;
import x2.x;
import x2.y;
import x2.z;

@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010H\u001a\u00020G\u0012\b\b\u0001\u0010J\u001a\u00020I\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010P\u001a\u00020O\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010V\u001a\u00020U\u0012\u0006\u0010W\u001a\u00020\u0006\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u00020\u0004H\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0011R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0011R\u0017\u0010'\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\f8G¢\u0006\u0006\u001a\u0004\b,\u0010\u0011R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020.0\f8G¢\u0006\u0006\u001a\u0004\b/\u0010\u0011R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002010\f8G¢\u0006\u0006\u001a\u0004\b2\u0010\u0011R\u0017\u00106\u001a\b\u0012\u0004\u0012\u0002040\f8G¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0017\u00109\u001a\b\u0012\u0004\u0012\u0002070\f8G¢\u0006\u0006\u001a\u0004\b8\u0010\u0011R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\f8G¢\u0006\u0006\u001a\u0004\b;\u0010\u0011R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\f8G¢\u0006\u0006\u001a\u0004\b>\u0010\u0011R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020@0\f8G¢\u0006\u0006\u001a\u0004\bA\u0010\u0011¨\u0006d"}, d2 = {"Lbo/app/y0;", "", "Lbo/app/k5;", "sessionSealedEvent", "", "a", "Lbo/app/j2;", "eventMessenger", "s", "r", "Ljava/util/concurrent/Semaphore;", "semaphore", "Lcom/braze/events/IEventSubscriber;", "", "t", "Lbo/app/p3;", "g", "()Lcom/braze/events/IEventSubscriber;", "messagingSessionEventSubscriber", "k", "sessionSealedEventSubscriber", "Lbo/app/d5;", "i", "serverConfigEventSubscriber", "Lbo/app/i6;", "n", "triggerEventEventSubscriber", "Lbo/app/p6;", "o", "triggeredActionRetryEventSubscriber", "Lbo/app/x;", "h", "retryContentCardsEventSubscriber", "Lbo/app/w;", "cancelRetryContentCardsEventSubscriber", "Lbo/app/r5;", "l", "storageExceptionSubscriber", "Lbo/app/t6;", "userCache", "Lbo/app/t6;", "q", "()Lbo/app/t6;", "Lbo/app/r0;", "c", "dispatchSucceededEventSubscriber", "Lbo/app/p0;", "b", "dispatchFailedEventSubscriber", "Lbo/app/i5;", "j", "sessionCreatedEventSubscriber", "Lbo/app/q1;", "e", "geofencesEventSubscriber", "Lbo/app/f1;", "d", "featureFlagsEventSubscriber", "Lbo/app/g6;", "m", "triggerEligiblePushClickEventSubscriber", "Lbo/app/r6;", "p", "triggeredActionsReceivedEventSubscriber", "Lbo/app/g3;", "f", "inAppMessagePublishEventSubscriber", "Landroid/content/Context;", "applicationContext", "Lbo/app/l2;", "locationManager", "Lbo/app/h2;", "dispatchManager", "Lbo/app/b2;", "brazeManager", "Lbo/app/k0;", "deviceCache", "Lbo/app/x2;", "triggerManager", "Lbo/app/a3;", "triggerReEligibilityManager", "Lbo/app/b1;", "eventStorageManager", "Lbo/app/l;", "geofenceManager", "Lbo/app/b6;", "testUserDeviceLoggingManager", "externalEventPublisher", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/a0;", "contentCardsStorageProvider", "Lbo/app/a5;", "sdkMetadataCache", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/e1;", "featureFlagsManager", "<init>", "(Landroid/content/Context;Lbo/app/l2;Lbo/app/h2;Lbo/app/b2;Lbo/app/t6;Lbo/app/k0;Lbo/app/x2;Lbo/app/a3;Lbo/app/b1;Lbo/app/l;Lbo/app/b6;Lbo/app/j2;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/a0;Lbo/app/a5;Lbo/app/e5;Lbo/app/e1;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class y0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f39567a;

    /* renamed from: b  reason: collision with root package name */
    private final l2 f39568b;

    /* renamed from: c  reason: collision with root package name */
    private final h2 f39569c;

    /* renamed from: d  reason: collision with root package name */
    public final b2 f39570d;

    /* renamed from: e  reason: collision with root package name */
    private final t6 f39571e;

    /* renamed from: f  reason: collision with root package name */
    private final k0 f39572f;

    /* renamed from: g  reason: collision with root package name */
    private final x2 f39573g;

    /* renamed from: h  reason: collision with root package name */
    private final a3 f39574h;

    /* renamed from: i  reason: collision with root package name */
    private final b1 f39575i;

    /* renamed from: j  reason: collision with root package name */
    private final l f39576j;

    /* renamed from: k  reason: collision with root package name */
    private final b6 f39577k;

    /* renamed from: l  reason: collision with root package name */
    private final j2 f39578l;

    /* renamed from: m  reason: collision with root package name */
    private final BrazeConfigurationProvider f39579m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final a0 f39580n;

    /* renamed from: o  reason: collision with root package name */
    private final a5 f39581o;

    /* renamed from: p  reason: collision with root package name */
    private final e5 f39582p;

    /* renamed from: q  reason: collision with root package name */
    private final e1 f39583q;

    /* renamed from: r  reason: collision with root package name */
    public final AtomicBoolean f39584r = new AtomicBoolean(false);

    /* renamed from: s  reason: collision with root package name */
    private final AtomicBoolean f39585s = new AtomicBoolean(false);

    /* renamed from: t  reason: collision with root package name */
    private g6 f39586t;

    /* renamed from: u  reason: collision with root package name */
    private Job f39587u;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39588b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log error.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f39589b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b3 b3Var) {
            super(0);
            this.f39589b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not publish in-app message with trigger action id: ", this.f39589b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39590b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting trigger refresh.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39591b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f39592c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(long j11, int i11) {
            super(0);
            this.f39591b = j11;
            this.f39592c = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "ContentCardRetryEvent received. timeInMS: " + this.f39591b + ", retryCount: " + this.f39592c;
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.events.EventListenerFactory$retryContentCardsEventSubscriber$1$2", f = "EventListenerFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39593b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ y0 f39594c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f39595d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(y0 y0Var, int i11, Continuation<? super e> continuation) {
            super(1, continuation);
            this.f39594c = y0Var;
            this.f39595d = i11;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((e) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new e(this.f39594c, this.f39595d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f39593b == 0) {
                ResultKt.throwOnFailure(obj);
                y0 y0Var = this.f39594c;
                y0Var.f39570d.a(y0Var.f39580n.e(), this.f39594c.f39580n.f(), this.f39595d);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39596b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session start event for new session received.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f39597b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Braze Geofence refresh on session created event due to configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39598b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log the storage exception.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f39599b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting trigger update due to trigger-eligible push click event";
        }
    }

    public y0(Context context, l2 l2Var, h2 h2Var, b2 b2Var, t6 t6Var, k0 k0Var, x2 x2Var, a3 a3Var, b1 b1Var, l lVar, b6 b6Var, j2 j2Var, BrazeConfigurationProvider brazeConfigurationProvider, a0 a0Var, a5 a5Var, e5 e5Var, e1 e1Var) {
        Context context2 = context;
        l2 l2Var2 = l2Var;
        h2 h2Var2 = h2Var;
        b2 b2Var2 = b2Var;
        t6 t6Var2 = t6Var;
        k0 k0Var2 = k0Var;
        x2 x2Var2 = x2Var;
        a3 a3Var2 = a3Var;
        b1 b1Var2 = b1Var;
        l lVar2 = lVar;
        b6 b6Var2 = b6Var;
        j2 j2Var2 = j2Var;
        BrazeConfigurationProvider brazeConfigurationProvider2 = brazeConfigurationProvider;
        a0 a0Var2 = a0Var;
        e5 e5Var2 = e5Var;
        Intrinsics.checkNotNullParameter(context2, "applicationContext");
        Intrinsics.checkNotNullParameter(l2Var2, "locationManager");
        Intrinsics.checkNotNullParameter(h2Var2, "dispatchManager");
        Intrinsics.checkNotNullParameter(b2Var2, "brazeManager");
        Intrinsics.checkNotNullParameter(t6Var2, "userCache");
        Intrinsics.checkNotNullParameter(k0Var2, "deviceCache");
        Intrinsics.checkNotNullParameter(x2Var2, "triggerManager");
        Intrinsics.checkNotNullParameter(a3Var2, "triggerReEligibilityManager");
        Intrinsics.checkNotNullParameter(b1Var2, "eventStorageManager");
        Intrinsics.checkNotNullParameter(lVar2, "geofenceManager");
        Intrinsics.checkNotNullParameter(b6Var2, "testUserDeviceLoggingManager");
        Intrinsics.checkNotNullParameter(j2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider2, "configurationProvider");
        Intrinsics.checkNotNullParameter(a0Var2, "contentCardsStorageProvider");
        Intrinsics.checkNotNullParameter(a5Var, "sdkMetadataCache");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(e1Var, "featureFlagsManager");
        this.f39567a = context2;
        this.f39568b = l2Var2;
        this.f39569c = h2Var2;
        this.f39570d = b2Var2;
        this.f39571e = t6Var2;
        this.f39572f = k0Var2;
        this.f39573g = x2Var2;
        this.f39574h = a3Var2;
        this.f39575i = b1Var2;
        this.f39576j = lVar2;
        this.f39577k = b6Var2;
        this.f39578l = j2Var2;
        this.f39579m = brazeConfigurationProvider2;
        this.f39580n = a0Var2;
        this.f39581o = a5Var;
        this.f39582p = e5Var;
        this.f39583q = e1Var;
    }

    private final IEventSubscriber<p3> g() {
        return new a0(this);
    }

    private final IEventSubscriber<x> h() {
        return new z(this);
    }

    private final IEventSubscriber<d5> i() {
        return new b0(this);
    }

    private final IEventSubscriber<k5> k() {
        return new h0(this);
    }

    private final IEventSubscriber<r5> l() {
        return new l0(this);
    }

    private final IEventSubscriber<i6> n() {
        return new x(this);
    }

    private final IEventSubscriber<p6> o() {
        return new c0(this);
    }

    public final IEventSubscriber<p0> b() {
        return new j0(this);
    }

    public final IEventSubscriber<r0> c() {
        return new m0(this);
    }

    public final IEventSubscriber<f1> d() {
        return new i0(this);
    }

    public final IEventSubscriber<q1> e() {
        return new e0(this);
    }

    public final IEventSubscriber<g3> f() {
        return new g0(this);
    }

    public final IEventSubscriber<i5> j() {
        return new n0(this);
    }

    public final IEventSubscriber<g6> m() {
        return new f0(this);
    }

    public final IEventSubscriber<r6> p() {
        return new d0(this);
    }

    public final t6 q() {
        return this.f39571e;
    }

    public final void r() {
        g6 g6Var;
        if (this.f39585s.compareAndSet(true, false) && (g6Var = this.f39586t) != null) {
            this.f39573g.a((w2) new j4(g6Var.a(), g6Var.b()));
            this.f39586t = null;
        }
    }

    public final void s() {
        if (this.f39584r.compareAndSet(true, false)) {
            this.f39573g.a((w2) new x3());
        }
    }

    public final void t() {
        if (this.f39570d.c()) {
            this.f39584r.set(true);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f39590b, 7, (Object) null);
            this.f39570d.a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).c());
            this.f39570d.a(false);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, r0 r0Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(r0Var, "$dstr$brazeRequest");
        c2 a11 = r0Var.a();
        j0 f11 = a11.f();
        boolean z11 = true;
        if (f11 != null) {
            y0Var.f39572f.a(f11, true);
        }
        b4 d11 = a11.d();
        if (d11 != null) {
            y0Var.q().a(d11, true);
        }
        k e11 = a11.e();
        if (e11 != null) {
            y0Var.f39575i.a((Set<? extends x1>) e11.b());
        }
        a4 c11 = a11.c();
        if (c11 != null && c11.y()) {
            y0Var.f39570d.a(false);
        }
        EnumSet<BrazeSdkMetadata> i11 = a11.i();
        if (i11 != null) {
            y0Var.f39581o.a(i11);
        }
        a4 c12 = a11.c();
        if (c12 == null || !c12.w()) {
            z11 = false;
        }
        if (z11) {
            y0Var.f39582p.t();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, p0 p0Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(p0Var, "$dstr$brazeRequest");
        c2 a11 = p0Var.a();
        a4 c11 = a11.c();
        boolean z11 = false;
        if (c11 != null && c11.y()) {
            y0Var.s();
            y0Var.r();
            y0Var.f39570d.a(true);
        }
        j0 f11 = a11.f();
        if (f11 != null) {
            y0Var.f39572f.a(f11, false);
        }
        b4 d11 = a11.d();
        if (d11 != null) {
            y0Var.q().a(d11, false);
            if (d11.w().has(State.KEY_PUSH_TOKEN)) {
                y0Var.q().h();
                y0Var.f39572f.e();
            }
        }
        k e11 = a11.e();
        if (e11 != null) {
            for (x1 a12 : e11.b()) {
                y0Var.f39569c.a(a12);
            }
        }
        a4 c12 = a11.c();
        if (c12 != null && c12.w()) {
            z11 = true;
        }
        if (z11) {
            y0Var.f39582p.t();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, i5 i5Var) {
        y0 y0Var2 = y0Var;
        Intrinsics.checkNotNullParameter(y0Var2, "this$0");
        Intrinsics.checkNotNullParameter(i5Var, "it");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) y0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) f.f39596b, 7, (Object) null);
        x1 a11 = j.f38653h.a(i5Var.a().n());
        if (a11 != null) {
            a11.a(i5Var.a().n());
        }
        if (a11 != null) {
            y0Var2.f39570d.a(a11);
        }
        y0Var2.f39568b.a();
        y0Var2.f39570d.a(true);
        y0Var2.f39571e.h();
        y0Var2.f39572f.e();
        y0Var.t();
        if (y0Var2.f39579m.isAutomaticGeofenceRequestsEnabled()) {
            BrazeInternal.requestGeofenceRefresh(y0Var2.f39567a, false);
        } else {
            BrazeLogger.brazelog$default(brazeLogger, (Object) y0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) g.f39597b, 7, (Object) null);
        }
        x2.a.a(y0Var2.f39570d, y0Var2.f39580n.e(), y0Var2.f39580n.f(), 0, 4, (Object) null);
        if (y0Var2.f39582p.o()) {
            y0Var2.f39583q.c();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, p3 p3Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(p3Var, "it");
        y0Var.f39570d.a(true);
        y0Var.t();
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, k5 k5Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(k5Var, "message");
        y0Var.a(k5Var);
        Braze.Companion.getInstance(y0Var.f39567a).requestImmediateDataFlush();
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, d5 d5Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(d5Var, "$dstr$serverConfig");
        c5 a11 = d5Var.a();
        y0Var.f39576j.a(a11);
        y0Var.f39577k.a(a11);
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, q1 q1Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(q1Var, "$dstr$geofences");
        y0Var.f39576j.a(q1Var.a());
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, f1 f1Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(f1Var, "$dstr$featureFlags");
        y0Var.f39578l.a(y0Var.f39583q.a(f1Var.a()), FeatureFlagsUpdatedEvent.class);
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, g6 g6Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(g6Var, "message");
        y0Var.f39585s.set(true);
        y0Var.f39586t = g6Var;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) y0Var, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) i.f39599b, 6, (Object) null);
        y0Var.f39570d.a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null).c());
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, r6 r6Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(r6Var, "$dstr$triggeredActions");
        y0Var.f39573g.a(r6Var.a());
        y0Var.s();
        y0Var.r();
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, i6 i6Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(i6Var, "$dstr$triggerEvent");
        y0Var.f39573g.a(i6Var.a());
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, g3 g3Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(g3Var, "$dstr$triggerEvent$triggeredAction$inAppMessage$userId");
        w2 a11 = g3Var.a();
        b3 b11 = g3Var.b();
        IInAppMessage c11 = g3Var.c();
        String d11 = g3Var.d();
        synchronized (y0Var.f39574h) {
            if (y0Var.f39574h.b(b11)) {
                y0Var.f39578l.a(new InAppMessageEvent(a11, b11, c11, d11), InAppMessageEvent.class);
                y0Var.f39574h.a(b11, DateTimeUtils.nowInSeconds());
                y0Var.f39573g.a(DateTimeUtils.nowInSeconds());
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) y0Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(b11), 7, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, p6 p6Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(p6Var, "$dstr$originalTriggerEvent$failedTriggeredAction");
        y0Var.f39573g.a(p6Var.a(), p6Var.b());
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, x xVar) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(xVar, "$dstr$timeInMs$retryCount");
        long a11 = xVar.a();
        int b11 = xVar.b();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) y0Var, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d(a11, b11), 6, (Object) null);
        Job job = y0Var.f39587u;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        y0Var.f39587u = BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(a11), (CoroutineContext) null, new e(y0Var, b11, (Continuation<? super e>) null), 2, (Object) null);
    }

    private final IEventSubscriber<w> a() {
        return new k0(this);
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, w wVar) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(wVar, "it");
        Job job = y0Var.f39587u;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        y0Var.f39587u = null;
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, r5 r5Var) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        Intrinsics.checkNotNullParameter(r5Var, "storageException");
        try {
            y0Var.f39570d.a((Throwable) r5Var);
        } catch (Exception e11) {
            y0 y0Var2 = y0Var;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) y0Var2, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) h.f39598b, 4, (Object) null);
        }
    }

    public final void a(j2 j2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "eventMessenger");
        j2Var.a(b(), p0.class);
        j2Var.a(c(), r0.class);
        j2Var.a(j(), i5.class);
        j2Var.a(k(), k5.class);
        j2Var.a(m(), g6.class);
        j2Var.a(i(), d5.class);
        j2Var.a(a((Semaphore) null), Throwable.class);
        j2Var.a(l(), r5.class);
        j2Var.a(p(), r6.class);
        j2Var.a(g(), p3.class);
        j2Var.a(e(), q1.class);
        j2Var.a(d(), f1.class);
        j2Var.a(n(), i6.class);
        j2Var.a(f(), g3.class);
        j2Var.a(o(), p6.class);
        j2Var.a(h(), x.class);
        j2Var.a(a(), w.class);
    }

    public final IEventSubscriber<Throwable> a(Semaphore semaphore) {
        return new y(this, semaphore);
    }

    /* access modifiers changed from: private */
    public static final void a(y0 y0Var, Semaphore semaphore, Throwable th2) {
        Intrinsics.checkNotNullParameter(y0Var, "this$0");
        if (th2 != null) {
            try {
                y0Var.f39570d.b(th2);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) y0Var, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f39588b, 4, (Object) null);
                if (semaphore == null) {
                    return;
                }
            } catch (Throwable th3) {
                if (semaphore != null) {
                    semaphore.release();
                }
                throw th3;
            }
        }
        if (semaphore == null) {
            return;
        }
        semaphore.release();
    }

    private final void a(k5 k5Var) {
        h5 a11 = k5Var.a();
        x1 a12 = j.f38653h.a(a11.v());
        if (a12 != null) {
            a12.a(a11.n());
            this.f39570d.a(a12);
        }
    }
}
