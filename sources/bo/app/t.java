package bo.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.SessionStateChangedEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B?\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\"\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010)\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007R*\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lbo/app/t;", "", "", "i", "", "f", "k", "e", "c", "m", "o", "l", "n", "d", "Lbo/app/q3;", "internalSession", "Lbo/app/q3;", "h", "()Lbo/app/q3;", "a", "(Lbo/app/q3;)V", "getInternalSession$annotations", "()V", "Lbo/app/j5;", "g", "()Lbo/app/j5;", "currentSessionId", "j", "()Z", "isCurrentSessionSealed", "Landroid/content/Context;", "applicationContext", "Lbo/app/t2;", "sessionStorageManager", "Lbo/app/j2;", "internalEventPublisher", "externalEventPublisher", "Landroid/app/AlarmManager;", "alarmManager", "", "sessionTimeoutSeconds", "sessionStartBasedTimeoutEnabled", "<init>", "(Landroid/content/Context;Lbo/app/t2;Lbo/app/j2;Lbo/app/j2;Landroid/app/AlarmManager;IZ)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class t {

    /* renamed from: l  reason: collision with root package name */
    public static final a f39362l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final long f39363m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final long f39364n;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f39365a;

    /* renamed from: b  reason: collision with root package name */
    private final t2 f39366b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j2 f39367c;

    /* renamed from: d  reason: collision with root package name */
    private final j2 f39368d;

    /* renamed from: e  reason: collision with root package name */
    private final AlarmManager f39369e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39370f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f39371g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final ReentrantLock f39372h = new ReentrantLock();

    /* renamed from: i  reason: collision with root package name */
    private final String f39373i;

    /* renamed from: j  reason: collision with root package name */
    private Job f39374j = JobKt.Job$default((Job) null, 1, (Object) null);

    /* renamed from: k  reason: collision with root package name */
    private q3 f39375k;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0011J(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007J \u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007R \u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0018"}, d2 = {"Lbo/app/t$a;", "", "", "sessionStartTimeMs", "sessionEndTimeMs", "", "sessionTimeoutSeconds", "", "sessionStartBasedTimeoutEnabled", "a", "Lbo/app/q3;", "mutableSession", "", "START_BASED_SEAL_DELAY_MS", "J", "()J", "getSTART_BASED_SEAL_DELAY_MS$annotations", "()V", "SESSION_CLOSE_FLUSH_DELAY_MS", "", "SESSION_ID_INTENT_EXTRA_KEY", "Ljava/lang/String;", "SESSION_SHOULD_SEAL_INTENT", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return t.f39364n;
        }

        public final boolean a(double d11, double d12, int i11, boolean z11) {
            long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long millis = timeUnit.toMillis((long) i11);
            return !z11 ? timeUnit.toMillis((long) d12) + millis <= nowInMilliseconds : (timeUnit.toMillis((long) d11) + millis) + a() <= nowInMilliseconds;
        }

        public final long a(q3 q3Var, int i11, boolean z11) {
            Intrinsics.checkNotNullParameter(q3Var, "mutableSession");
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long millis = timeUnit.toMillis((long) i11);
            if (!z11) {
                return millis;
            }
            long millis2 = timeUnit.toMillis((long) q3Var.x());
            return Math.max(a(), (millis2 + millis) - DateTimeUtils.nowInMilliseconds());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39376b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cancelling session seal alarm";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39377b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to cancel session seal alarm";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39378b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(long j11) {
            super(0);
            this.f39378b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Creating a session seal alarm with a delay of " + this.f39378b + " ms";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39379b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to create session seal alarm";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q3 f39380b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(q3 q3Var) {
            super(0);
            this.f39380b = q3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Clearing completely dispatched sealed session ", this.f39380b.n());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q3 f39381b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(q3 q3Var) {
            super(0);
            this.f39381b = q3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("New session created with ID: ", this.f39381b.n());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39382b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Getting the stored open session";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q3 f39383b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(q3 q3Var) {
            super(0);
            this.f39383b = q3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Checking if this session needs to be sealed: ", this.f39383b.n());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q3 f39384b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(q3 q3Var) {
            super(0);
            this.f39384b = q3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Session [" + this.f39384b.n() + "] being sealed because its end time is over the grace period. Session: " + this.f39384b;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"bo/app/t$k", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class k extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f39385a;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f39386b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Session seal logic executing in broadcast";
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "com.braze.managers.BrazeSessionManager$sessionSealReceiver$1$onReceive$2", f = "BrazeSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: b  reason: collision with root package name */
            int f39387b;

            /* renamed from: c  reason: collision with root package name */
            private /* synthetic */ Object f39388c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ t f39389d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ BroadcastReceiver.PendingResult f39390e;

            @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
            public static final class a extends Lambda implements Function0<String> {

                /* renamed from: b  reason: collision with root package name */
                public static final a f39391b = new a();

                public a() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Failed to log throwable during seal session.";
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(t tVar, BroadcastReceiver.PendingResult pendingResult, Continuation<? super b> continuation) {
                super(2, continuation);
                this.f39389d = tVar;
                this.f39390e = pendingResult;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(this.f39389d, this.f39390e, continuation);
                bVar.f39388c = obj;
                return bVar;
            }

            /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|10) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r0 = r8.f39387b
                    if (r0 != 0) goto L_0x0048
                    kotlin.ResultKt.throwOnFailure(r9)
                    java.lang.Object r9 = r8.f39388c
                    r1 = r9
                    kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                    bo.app.t r9 = r8.f39389d
                    java.util.concurrent.locks.ReentrantLock r9 = r9.f39372h
                    bo.app.t r0 = r8.f39389d
                    r9.lock()
                    r0.k()     // Catch:{ Exception -> 0x0020 }
                    goto L_0x0037
                L_0x001e:
                    r0 = move-exception
                    goto L_0x0044
                L_0x0020:
                    r3 = move-exception
                    bo.app.j2 r0 = r0.f39367c     // Catch:{ Exception -> 0x002b }
                    java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
                    r0.a(r3, r2)     // Catch:{ Exception -> 0x002b }
                    goto L_0x0037
                L_0x002b:
                    com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x001e }
                    com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x001e }
                    r4 = 0
                    bo.app.t$k$b$a r5 = bo.app.t.k.b.a.f39391b     // Catch:{ all -> 0x001e }
                    r6 = 4
                    r7 = 0
                    com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ all -> 0x001e }
                L_0x0037:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001e }
                    r9.unlock()
                    android.content.BroadcastReceiver$PendingResult r9 = r8.f39390e
                    r9.finish()
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                L_0x0044:
                    r9.unlock()
                    throw r0
                L_0x0048:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: bo.app.t.k.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public k(t tVar) {
            this.f39385a = tVar;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) a.f39386b, 6, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new b(this.f39385a, goAsync(), (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.managers.BrazeSessionManager$startSessionStopFlushTimer$1", f = "BrazeSessionManager.kt", i = {0}, l = {328}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39392b;

        /* renamed from: c  reason: collision with root package name */
        private /* synthetic */ Object f39393c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ t f39394d;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final a f39395b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Requesting data flush on internal session close flush timer.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(t tVar, Continuation<? super l> continuation) {
            super(2, continuation);
            this.f39394d = tVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            l lVar = new l(this.f39394d, continuation);
            lVar.f39393c = obj;
            return lVar;
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f39392b;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.f39393c;
                long a11 = t.f39363m;
                this.f39393c = coroutineScope2;
                this.f39392b = 1;
                if (DelayKt.delay(a11, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.f39393c;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f39395b, 7, (Object) null);
            Braze.Companion.getInstance(this.f39394d.f39365a).requestImmediateDataFlush();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q3 f39396b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(q3 q3Var) {
            super(0);
            this.f39396b = q3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Closed session with id ", this.f39396b.n());
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f39363m = timeUnit.toMillis(10);
        f39364n = timeUnit.toMillis(10);
    }

    public t(Context context, t2 t2Var, j2 j2Var, j2 j2Var2, AlarmManager alarmManager, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(t2Var, "sessionStorageManager");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        this.f39365a = context;
        this.f39366b = t2Var;
        this.f39367c = j2Var;
        this.f39368d = j2Var2;
        this.f39369e = alarmManager;
        this.f39370f = i11;
        this.f39371g = z11;
        k kVar = new k(this);
        String stringPlus = Intrinsics.stringPlus(context.getPackageName(), ".intent.BRAZE_SESSION_SHOULD_SEAL");
        this.f39373i = stringPlus;
        if (Build.VERSION.SDK_INT >= 33) {
            Intent unused = context.registerReceiver(kVar, new IntentFilter(stringPlus), 4);
        } else {
            context.registerReceiver(kVar, new IntentFilter(stringPlus));
        }
    }

    private final void e() {
        q3 q3Var = this.f39375k;
        if (q3Var != null) {
            long a11 = f39362l.a(q3Var, this.f39370f, this.f39371g);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(a11), 7, (Object) null);
            try {
                Intent intent = new Intent(this.f39373i);
                intent.putExtra("session_id", q3Var.toString());
                this.f39369e.set(1, DateTimeUtils.nowInMilliseconds() + a11, PendingIntent.getBroadcast(this.f39365a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f39379b, 4, (Object) null);
            }
        }
    }

    private final boolean f() {
        ReentrantLock reentrantLock = this.f39372h;
        reentrantLock.lock();
        try {
            k();
            q3 h11 = h();
            boolean z11 = false;
            if (h11 != null) {
                if (!h11.y()) {
                    if (h11.w() != null) {
                        h11.a((Double) null);
                        z11 = true;
                    }
                    return z11;
                }
            }
            i();
            if (h11 != null) {
                if (h11.y()) {
                    z11 = true;
                }
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(h11), 7, (Object) null);
                this.f39366b.a(h11.n().toString());
            }
            z11 = true;
            return z11;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void i() {
        q3 q3Var = new q3((j5) null, 0.0d, (Double) null, false, 15, (DefaultConstructorMarker) null);
        this.f39375k = q3Var;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new g(q3Var), 6, (Object) null);
        this.f39367c.a(new i5(q3Var), i5.class);
        this.f39368d.a(new SessionStateChangedEvent(q3Var.n().toString(), SessionStateChangedEvent.ChangeType.SESSION_STARTED), SessionStateChangedEvent.class);
    }

    /* access modifiers changed from: private */
    public final void k() {
        j5 j5Var;
        q3 q3Var;
        ReentrantLock reentrantLock = this.f39372h;
        reentrantLock.lock();
        try {
            if (h() == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f39382b, 7, (Object) null);
                h5 a11 = this.f39366b.a();
                if (a11 == null) {
                    q3Var = null;
                } else {
                    q3Var = a11.z();
                }
                a(q3Var);
            }
            q3 h11 = h();
            if (h11 != null) {
                BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(h11), 7, (Object) null);
                Double w11 = h11.w();
                if (w11 != null && !h11.y()) {
                    if (f39362l.a(h11.x(), w11.doubleValue(), this.f39370f, this.f39371g)) {
                        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new j(h11), 6, (Object) null);
                        l();
                        t2 t2Var = this.f39366b;
                        q3 h12 = h();
                        if (h12 == null) {
                            j5Var = null;
                        } else {
                            j5Var = h12.n();
                        }
                        t2Var.a(String.valueOf(j5Var));
                        a((q3) null);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final j5 g() {
        j5 j5Var;
        ReentrantLock reentrantLock = this.f39372h;
        reentrantLock.lock();
        try {
            k();
            q3 h11 = h();
            if (h11 == null) {
                j5Var = null;
            } else {
                j5Var = h11.n();
            }
            return j5Var;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final q3 h() {
        return this.f39375k;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.y() == true) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j() {
        /*
            r3 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r3.f39372h
            r0.lock()
            bo.app.q3 r1 = r3.h()     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x000c
            goto L_0x0014
        L_0x000c:
            boolean r1 = r1.y()     // Catch:{ all -> 0x0019 }
            r2 = 1
            if (r1 != r2) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r0.unlock()
            return r2
        L_0x0019:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.t.j():boolean");
    }

    public final void l() {
        q3 q3Var = this.f39375k;
        if (q3Var != null) {
            ReentrantLock reentrantLock = this.f39372h;
            reentrantLock.lock();
            try {
                q3Var.A();
                this.f39366b.a((h5) q3Var);
                this.f39367c.a(new k5(q3Var), k5.class);
                this.f39368d.a(new SessionStateChangedEvent(q3Var.n().toString(), SessionStateChangedEvent.ChangeType.SESSION_ENDED), SessionStateChangedEvent.class);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void m() {
        ReentrantLock reentrantLock = this.f39372h;
        reentrantLock.lock();
        try {
            if (f()) {
                q3 h11 = h();
                if (h11 != null) {
                    this.f39366b.a((h5) h11);
                }
            }
            d();
            c();
            this.f39367c.a(l5.f38920b, l5.class);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void n() {
        Job.DefaultImpls.cancel$default(this.f39374j, (CancellationException) null, 1, (Object) null);
        this.f39374j = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new l(this, (Continuation<? super l>) null), 3, (Object) null);
    }

    public final void o() {
        ReentrantLock reentrantLock = this.f39372h;
        reentrantLock.lock();
        try {
            f();
            q3 h11 = h();
            if (h11 != null) {
                h11.a(Double.valueOf(DateTimeUtils.nowInSecondsPrecise()));
                this.f39366b.a((h5) h11);
                n();
                e();
                this.f39367c.a(n5.f39045b, n5.class);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new m(h11), 7, (Object) null);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void c() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f39376b, 7, (Object) null);
        try {
            Intent intent = new Intent(this.f39373i);
            intent.putExtra("session_id", String.valueOf(this.f39375k));
            this.f39369e.cancel(PendingIntent.getBroadcast(this.f39365a, 0, intent, IntentUtils.getImmutablePendingIntentFlags() | 1073741824));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f39377b, 4, (Object) null);
        }
    }

    public final void d() {
        Job.DefaultImpls.cancel$default(this.f39374j, (CancellationException) null, 1, (Object) null);
    }

    public final void a(q3 q3Var) {
        this.f39375k = q3Var;
    }
}
