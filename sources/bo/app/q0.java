package bo.app;

import com.braze.Braze;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import x2.o;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB7\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u0005\u001a\u00020\rJ\u0013\u0010\b\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0007R\u0011\u0010\u0013\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lbo/app/q0;", "Lbo/app/h2;", "Lbo/app/x1;", "event", "", "b", "Lbo/app/j5;", "sessionId", "a", "Lbo/app/j2;", "internalEventPublisher", "Lbo/app/c2;", "request", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "brazeRequest", "Lbo/app/k;", "()Lbo/app/k;", "brazeEventsForDispatch", "c", "()Z", "isNetworkRequestsOffline", "Lbo/app/t6;", "userCache", "Lbo/app/f2;", "deviceDataProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/y4;", "sdkAuthenticationCache", "Lbo/app/a5;", "sdkMetadataCache", "<init>", "(Lbo/app/t6;Lbo/app/f2;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/y4;Lbo/app/a5;Lbo/app/j2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class q0 implements h2 {

    /* renamed from: j  reason: collision with root package name */
    public static final a f39201j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final t6 f39202a;

    /* renamed from: b  reason: collision with root package name */
    private final f2 f39203b;

    /* renamed from: c  reason: collision with root package name */
    private final BrazeConfigurationProvider f39204c;

    /* renamed from: d  reason: collision with root package name */
    private final y4 f39205d;

    /* renamed from: e  reason: collision with root package name */
    private final a5 f39206e;

    /* renamed from: f  reason: collision with root package name */
    private final Channel<c2> f39207f = ChannelKt.Channel$default(1000, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    /* renamed from: g  reason: collision with root package name */
    private final ConcurrentHashMap<String, x1> f39208g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final ConcurrentHashMap<String, x1> f39209h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f39210i = new AtomicInteger(0);

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R\u001a\u0010\r\u001a\u00020\f8\u0006XT¢\u0006\f\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006XT¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u0012\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006XT¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u0012\u0004\b\u0014\u0010\u0010¨\u0006\u0016"}, d2 = {"Lbo/app/q0$a;", "", "Lbo/app/f2;", "deviceDataProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/y4;", "sdkAuthenticationCache", "Lbo/app/c2;", "brazeRequest", "", "a", "", "MAX_EVENTS_PER_DISPATCH", "I", "getMAX_EVENTS_PER_DISPATCH$annotations", "()V", "MAX_INVALID_API_KEY_ERRORS", "getMAX_INVALID_API_KEY_ERRORS$annotations", "REQUEST_QUEUE_SIZE", "getREQUEST_QUEUE_SIZE$annotations", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.q0$a$a  reason: collision with other inner class name */
        public static final class C0032a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ y4 f39211b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0032a(y4 y4Var) {
                super(0);
                this.f39211b = y4Var;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Adding SDK Auth token to request '" + this.f39211b.a() + '\'';
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final b f39212b = new b();

            public b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK Auth is disabled, not adding token to request";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(f2 f2Var, BrazeConfigurationProvider brazeConfigurationProvider, y4 y4Var, c2 c2Var) {
            Intrinsics.checkNotNullParameter(f2Var, "deviceDataProvider");
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(y4Var, "sdkAuthenticationCache");
            Intrinsics.checkNotNullParameter(c2Var, "brazeRequest");
            String deviceId = f2Var.getDeviceId();
            if (deviceId != null) {
                c2Var.b(deviceId);
            }
            c2Var.f(brazeConfigurationProvider.getBrazeApiKey().toString());
            c2Var.g("23.3.0");
            c2Var.a(Long.valueOf(DateTimeUtils.nowInSeconds()));
            if (brazeConfigurationProvider.isSdkAuthenticationEnabled()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new C0032a(y4Var), 6, (Object) null);
                c2Var.d(y4Var.a());
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) b.f39212b, 6, (Object) null);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39213b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Network requests are offline, not adding request to queue.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c2 f39214b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c2 c2Var) {
            super(0);
            this.f39214b = c2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("A maximum of 5 invalid api key errors reached. Device data will remain unaffected after dropping this request ", this.f39214b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39215b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f39215b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Added request to dispatcher with parameters: \n", this.f39215b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39216b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f39216b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not add request to dispatcher as queue is full or closed. Marking as complete. Incoming Request: \n", this.f39216b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39217b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(x1 x1Var) {
            super(0);
            this.f39217b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Event dispatched: " + this.f39217b.forJsonPut() + " with uid: " + this.f39217b.r();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f39218b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Max number of events per dispatch reached: 32 . No more events will be included in this dispatch";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39219b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Flushing pending events to dispatcher map";
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.braze.dispatch.DispatchManager", f = "DispatchManager.kt", i = {0}, l = {168}, m = "takeRequest", n = {"this"}, s = {"L$0"})
    public static final class i extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        Object f39220b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f39221c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q0 f39222d;

        /* renamed from: e  reason: collision with root package name */
        int f39223e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(q0 q0Var, Continuation<? super i> continuation) {
            super(continuation);
            this.f39222d = q0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f39221c = obj;
            this.f39223e |= Integer.MIN_VALUE;
            return this.f39222d.a((Continuation<? super c2>) this);
        }
    }

    public q0(t6 t6Var, f2 f2Var, BrazeConfigurationProvider brazeConfigurationProvider, y4 y4Var, a5 a5Var, j2 j2Var) {
        Intrinsics.checkNotNullParameter(t6Var, "userCache");
        Intrinsics.checkNotNullParameter(f2Var, "deviceDataProvider");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(y4Var, "sdkAuthenticationCache");
        Intrinsics.checkNotNullParameter(a5Var, "sdkMetadataCache");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        this.f39202a = t6Var;
        this.f39203b = f2Var;
        this.f39204c = brazeConfigurationProvider;
        this.f39205d = y4Var;
        this.f39206e = a5Var;
        j2Var.a(new o(this), k3.class);
    }

    /* access modifiers changed from: private */
    public static final void a(q0 q0Var, k3 k3Var) {
        Intrinsics.checkNotNullParameter(q0Var, "this$0");
        Intrinsics.checkNotNullParameter(k3Var, "it");
        q0Var.f39210i.incrementAndGet();
    }

    public synchronized void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.f39209h.putIfAbsent(x1Var.r(), x1Var);
    }

    public final boolean c() {
        return Braze.Companion.getOutboundNetworkRequestsOffline();
    }

    public final c2 d() {
        c2 c2Var = (c2) ChannelResult.m7804getOrNullimpl(this.f39207f.m7818tryReceivePtdJZtk());
        if (c2Var == null) {
            return null;
        }
        b(c2Var);
        return c2Var;
    }

    public final synchronized k a() {
        LinkedHashSet linkedHashSet;
        Collection<x1> values = this.f39208g.values();
        Intrinsics.checkNotNullExpressionValue(values, "brazeEventMap.values");
        linkedHashSet = new LinkedHashSet();
        Iterator<x1> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            x1 next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "event");
            linkedHashSet.add(next);
            values.remove(next);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(next), 7, (Object) null);
            if (linkedHashSet.size() >= 32) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) g.f39218b, 6, (Object) null);
                break;
            }
        }
        return new k(linkedHashSet);
    }

    public final boolean b() {
        return !this.f39207f.isEmpty();
    }

    public final synchronized c2 b(c2 c2Var) {
        Intrinsics.checkNotNullParameter(c2Var, "brazeRequest");
        c2Var.a(this.f39202a.f());
        f39201j.a(this.f39203b, this.f39204c, this.f39205d, c2Var);
        if (c2Var.g()) {
            a(c2Var);
        }
        return c2Var;
    }

    public synchronized void a(j5 j5Var) {
        Intrinsics.checkNotNullParameter(j5Var, "sessionId");
        if (!this.f39209h.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f39219b, 7, (Object) null);
            Collection<x1> values = this.f39209h.values();
            Intrinsics.checkNotNullExpressionValue(values, "pendingBrazeEventMap.values");
            for (x1 a11 : values) {
                a11.a(j5Var);
            }
            this.f39208g.putAll(this.f39209h);
            this.f39209h.clear();
        }
    }

    public synchronized void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.f39208g.putIfAbsent(x1Var.r(), x1Var);
    }

    public void a(j2 j2Var, c2 c2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(c2Var, "request");
        if (c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f39213b, 6, (Object) null);
        } else if (this.f39210i.get() >= 5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(c2Var), 6, (Object) null);
        } else {
            String prettyPrintedString = JsonUtils.getPrettyPrintedString(c2Var.l());
            c2Var.a(j2Var);
            if (ChannelResult.m7809isSuccessimpl(this.f39207f.m7820trySendJP2dKIU(c2Var))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d(prettyPrintedString), 6, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, false, (Function0) new e(prettyPrintedString), 6, (Object) null);
            c2Var.b(j2Var);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super bo.app.c2> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof bo.app.q0.i
            if (r0 == 0) goto L_0x0013
            r0 = r5
            bo.app.q0$i r0 = (bo.app.q0.i) r0
            int r1 = r0.f39223e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39223e = r1
            goto L_0x0018
        L_0x0013:
            bo.app.q0$i r0 = new bo.app.q0$i
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f39221c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39223e
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f39220b
            bo.app.q0 r0 = (bo.app.q0) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.Channel<bo.app.c2> r5 = r4.f39207f
            r0.f39220b = r4
            r0.f39223e = r3
            java.lang.Object r5 = r5.receive(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            bo.app.c2 r5 = (bo.app.c2) r5
            bo.app.c2 r5 = r0.b((bo.app.c2) r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.q0.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(bo.app.c2 r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "brazeRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch:{ all -> 0x0066 }
            bo.app.f2 r0 = r2.f39203b     // Catch:{ all -> 0x0066 }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x0066 }
            r3.c(r0)     // Catch:{ all -> 0x0066 }
            com.braze.configuration.BrazeConfigurationProvider r0 = r2.f39204c     // Catch:{ all -> 0x0066 }
            com.appboy.enums.SdkFlavor r0 = r0.getSdkFlavor()     // Catch:{ all -> 0x0066 }
            r3.a((com.appboy.enums.SdkFlavor) r0)     // Catch:{ all -> 0x0066 }
            bo.app.f2 r0 = r2.f39203b     // Catch:{ all -> 0x0066 }
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x0066 }
            r3.e(r0)     // Catch:{ all -> 0x0066 }
            bo.app.f2 r0 = r2.f39203b     // Catch:{ all -> 0x0066 }
            bo.app.j0 r0 = r0.b()     // Catch:{ all -> 0x0066 }
            r3.a((bo.app.j0) r0)     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0035
        L_0x002d:
            boolean r0 = r0.v()     // Catch:{ all -> 0x0066 }
            r1 = 1
            if (r0 != r1) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            if (r1 == 0) goto L_0x003d
            bo.app.t6 r0 = r2.f39202a     // Catch:{ all -> 0x0066 }
            r0.h()     // Catch:{ all -> 0x0066 }
        L_0x003d:
            bo.app.t6 r0 = r2.f39202a     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = r0.a()     // Catch:{ all -> 0x0066 }
            bo.app.b4 r0 = (bo.app.b4) r0     // Catch:{ all -> 0x0066 }
            r3.a((bo.app.b4) r0)     // Catch:{ all -> 0x0066 }
            bo.app.k r0 = r2.a()     // Catch:{ all -> 0x0066 }
            r3.a((bo.app.k) r0)     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0064
            bo.app.a5 r0 = r2.f39206e     // Catch:{ all -> 0x0066 }
            com.braze.configuration.BrazeConfigurationProvider r1 = r2.f39204c     // Catch:{ all -> 0x0066 }
            java.util.EnumSet r1 = r1.getSdkMetadata()     // Catch:{ all -> 0x0066 }
            java.util.EnumSet r0 = r0.b(r1)     // Catch:{ all -> 0x0066 }
            r3.a((java.util.EnumSet<com.braze.enums.BrazeSdkMetadata>) r0)     // Catch:{ all -> 0x0066 }
        L_0x0064:
            monitor-exit(r2)
            return
        L_0x0066:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.q0.a(bo.app.c2):void");
    }
}
