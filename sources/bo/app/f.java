package bo.app;

import bo.app.o0;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B1\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0006R\u0014\u0010\u0013\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0012¨\u0006\u001f"}, d2 = {"Lbo/app/f;", "Lbo/app/h2;", "Lkotlinx/coroutines/Job;", "c", "Lbo/app/c2;", "request", "", "a", "b", "Lbo/app/x1;", "event", "Lbo/app/j2;", "internalEventPublisher", "Lbo/app/j5;", "sessionId", "eventMessenger", "d", "Lbo/app/i0;", "()Lbo/app/i0;", "dataSyncRequest", "Lcom/braze/configuration/BrazeConfigurationProvider;", "appConfigurationProvider", "internalIEventMessenger", "Lbo/app/p2;", "requestExecutor", "Lbo/app/q0;", "dispatchManager", "", "mockAllNetworkRequests", "<init>", "(Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/j2;Lbo/app/p2;Lbo/app/q0;Z)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class f implements h2 {

    /* renamed from: i  reason: collision with root package name */
    public static final a f38499i = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final String f38500j = BrazeLogger.getBrazeLogTag((Class<?>) f.class);

    /* renamed from: a  reason: collision with root package name */
    private final BrazeConfigurationProvider f38501a;

    /* renamed from: b  reason: collision with root package name */
    private final p2 f38502b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final q0 f38503c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38504d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f38505e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private final s0 f38506f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f38507g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Job f38508h;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lbo/app/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38509a;

        static {
            int[] iArr = new int[o0.b.values().length];
            iArr[o0.b.ADD_PENDING_BRAZE_EVENT.ordinal()] = 1;
            iArr[o0.b.ADD_BRAZE_EVENT.ordinal()] = 2;
            iArr[o0.b.FLUSH_PENDING_BRAZE_EVENTS.ordinal()] = 3;
            iArr[o0.b.ADD_REQUEST.ordinal()] = 4;
            f38509a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.dispatch.AutomaticDispatchDecorator$kickoffDispatchJob$1", f = "AutomaticDispatchDecorator.kt", i = {0}, l = {128}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38510b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f38511c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f f38512d;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Exception f38513b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Exception exc) {
                super(0);
                this.f38513b = exc;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Automatic thread interrupted! This is usually the result of calling changeUser(). [" + this.f38513b + AbstractJsonLexerKt.END_LIST;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(f fVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f38512d = fVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.f38512d, continuation);
            cVar.f38511c = obj;
            return cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0030 A[SYNTHETIC, Splitter:B:14:0x0030] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.f38510b
                r2 = 1
                if (r1 == 0) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                java.lang.Object r1 = r12.f38511c
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x0015 }
                r3 = r13
                r13 = r12
                goto L_0x0041
            L_0x0015:
                r13 = move-exception
                r7 = r13
                r13 = r12
                goto L_0x004b
            L_0x0019:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0021:
                kotlin.ResultKt.throwOnFailure(r13)
                java.lang.Object r13 = r12.f38511c
                kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
                r1 = r13
                r13 = r12
            L_0x002a:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r3 == 0) goto L_0x0060
                bo.app.f r3 = r13.f38512d     // Catch:{ Exception -> 0x0049 }
                bo.app.q0 r3 = r3.f38503c     // Catch:{ Exception -> 0x0049 }
                r13.f38511c = r1     // Catch:{ Exception -> 0x0049 }
                r13.f38510b = r2     // Catch:{ Exception -> 0x0049 }
                java.lang.Object r3 = r3.a((kotlin.coroutines.Continuation<? super bo.app.c2>) r13)     // Catch:{ Exception -> 0x0049 }
                if (r3 != r0) goto L_0x0041
                return r0
            L_0x0041:
                bo.app.c2 r3 = (bo.app.c2) r3     // Catch:{ Exception -> 0x0049 }
                bo.app.f r4 = r13.f38512d     // Catch:{ Exception -> 0x0049 }
                r4.a((bo.app.c2) r3)     // Catch:{ Exception -> 0x0049 }
                goto L_0x002a
            L_0x0049:
                r3 = move-exception
                r7 = r3
            L_0x004b:
                com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r5 = bo.app.f.f38500j
                com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.V
                bo.app.f$c$a r9 = new bo.app.f$c$a
                r9.<init>(r7)
                r8 = 0
                r10 = 8
                r11 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                goto L_0x002a
            L_0x0060:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.f.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38514b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Automatic request execution start was previously requested, continuing without action.";
        }
    }

    public f(BrazeConfigurationProvider brazeConfigurationProvider, j2 j2Var, p2 p2Var, q0 q0Var, boolean z11) {
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        Intrinsics.checkNotNullParameter(j2Var, "internalIEventMessenger");
        Intrinsics.checkNotNullParameter(p2Var, "requestExecutor");
        Intrinsics.checkNotNullParameter(q0Var, "dispatchManager");
        this.f38501a = brazeConfigurationProvider;
        this.f38502b = p2Var;
        this.f38503c = q0Var;
        this.f38504d = z11;
        this.f38506f = new s0(j2Var, z11);
        j2Var.a(new x2.b(this, j2Var), o0.class);
    }

    private final i0 b() {
        return new i0(this.f38501a.getBaseUrlForRequests(), (a4) null, 2, (DefaultConstructorMarker) null);
    }

    private final Job c() {
        return BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new c(this, (Continuation<? super c>) null), 3, (Object) null);
    }

    public final void d() {
        ReentrantLock reentrantLock = this.f38505e;
        reentrantLock.lock();
        try {
            if (this.f38507g) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38500j, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d.f38514b, 14, (Object) null);
                return;
            }
            this.f38508h = c();
            this.f38507g = true;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.f38503c.b(x1Var);
    }

    private final void b(c2 c2Var) {
        if (c2Var.b() || this.f38504d) {
            this.f38506f.a(c2Var);
        } else {
            this.f38502b.a(c2Var);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, j2 j2Var, o0 o0Var) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(j2Var, "$internalIEventMessenger");
        Intrinsics.checkNotNullParameter(o0Var, "$dstr$commandType$brazeEvent$sessionId$brazeRequest");
        o0.b a11 = o0Var.a();
        x1 b11 = o0Var.b();
        j5 c11 = o0Var.c();
        c2 d11 = o0Var.d();
        int i11 = b.f38509a[a11.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 == 4 && d11 != null) {
                        fVar.a(j2Var, d11);
                    }
                } else if (c11 != null) {
                    fVar.a(c11);
                }
            } else if (b11 != null) {
                fVar.a(b11);
            }
        } else if (b11 != null) {
            fVar.b(b11);
        }
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.f38503c.a(x1Var);
    }

    public void a(j2 j2Var, c2 c2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(c2Var, "request");
        this.f38503c.a(j2Var, c2Var);
    }

    public void a(j5 j5Var) {
        Intrinsics.checkNotNullParameter(j5Var, "sessionId");
        this.f38503c.a(j5Var);
    }

    /* JADX INFO: finally extract failed */
    public final void a(j2 j2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "eventMessenger");
        ReentrantLock reentrantLock = this.f38505e;
        reentrantLock.lock();
        try {
            Job job = this.f38508h;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.f38508h = null;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (!this.f38503c.b()) {
                this.f38503c.a(j2Var, (c2) b());
            }
            c2 d11 = this.f38503c.d();
            if (d11 != null) {
                b(d11);
            }
            j2Var.a();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public final void a(c2 c2Var) {
        if (c2Var.b() || this.f38504d) {
            this.f38506f.b(c2Var);
        } else {
            this.f38502b.b(c2Var);
        }
    }
}
