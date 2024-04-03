package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import com.facebook.internal.NativeProtocol;
import com.visa.checkout.Profile;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007BC\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00102\u001a\u000200\u0012\u0006\u00104\u001a\u000203\u0012\b\u00105\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u00106\u001a\u00020\u0010¢\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000b\u001a\u00020\u0002H\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\bH\u0007J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000fH\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0007R\u0017\u0010\u0014\u001a\u00020\u00138G¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u001d8G¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000e\u0010 R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!8G¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u0007\u0010+¨\u00069"}, d2 = {"Lbo/app/k6;", "Lbo/app/x2;", "", "i", "", "Lbo/app/b3;", "triggeredActions", "a", "Lbo/app/w2;", "triggerEvent", "failedAction", "b", "(Lbo/app/w2;)V", "event", "c", "", "", "h", "action", "Landroid/content/SharedPreferences;", "triggeredActionStorage", "Landroid/content/SharedPreferences;", "g", "()Landroid/content/SharedPreferences;", "Lbo/app/a3;", "reEligibilityManager", "Lbo/app/a3;", "f", "()Lbo/app/a3;", "Ljava/util/concurrent/atomic/AtomicInteger;", "inFlightTriggerRequests", "Ljava/util/concurrent/atomic/AtomicInteger;", "()Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/Queue;", "pendingTriggerEvents", "Ljava/util/Queue;", "e", "()Ljava/util/Queue;", "", "lastDisplayTimeSeconds", "J", "d", "()J", "(J)V", "Landroid/content/Context;", "context", "Lbo/app/b2;", "brazeManager", "Lbo/app/j2;", "internalEventPublisher", "externalEventPublisher", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "userId", "apiKey", "<init>", "(Landroid/content/Context;Lbo/app/b2;Lbo/app/j2;Lbo/app/j2;Lcom/braze/configuration/BrazeConfigurationProvider;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k6 implements x2 {

    /* renamed from: o  reason: collision with root package name */
    public static final a f38793o = new a((DefaultConstructorMarker) null);

    /* renamed from: p  reason: collision with root package name */
    private static final long f38794p = TimeUnit.SECONDS.toMillis(30);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final String f38795q = BrazeLogger.getBrazeLogTag((Class<?>) k6.class);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f38796a;

    /* renamed from: b  reason: collision with root package name */
    private final b2 f38797b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j2 f38798c;

    /* renamed from: d  reason: collision with root package name */
    private j2 f38799d;

    /* renamed from: e  reason: collision with root package name */
    private final long f38800e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f38801f;

    /* renamed from: g  reason: collision with root package name */
    private final u2 f38802g;

    /* renamed from: h  reason: collision with root package name */
    private final a3 f38803h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f38804i;

    /* renamed from: j  reason: collision with root package name */
    private final Queue<w2> f38805j;

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, b3> f38806k;

    /* renamed from: l  reason: collision with root package name */
    private volatile long f38807l;

    /* renamed from: m  reason: collision with root package name */
    private final ReentrantLock f38808m = new ReentrantLock();

    /* renamed from: n  reason: collision with root package name */
    private final ReentrantLock f38809n = new ReentrantLock();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38819b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In flight trigger requests is empty. Executing any pending trigger events.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38820b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(w2 w2Var) {
            super(0);
            this.f38820b = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "New incoming <" + this.f38820b.d() + ">. Searching for matching triggers.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38821b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(w2 w2Var) {
            super(0);
            this.f38821b = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "No action found for " + this.f38821b.d() + " event, publishing NoMatchingTriggerEvent";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38822b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b3 b3Var) {
            super(0);
            this.f38822b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found potential triggered action for incoming trigger event. Action id " + this.f38822b.getId() + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38823b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(w2 w2Var) {
            super(0);
            this.f38823b = w2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to match triggered action for incoming <" + this.f38823b.d() + ">.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w2 f38824b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<b3> f38825c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(w2 w2Var, Ref.ObjectRef<b3> objectRef) {
            super(0);
            this.f38824b = w2Var;
            this.f38825c = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n     Found best triggered action for incoming trigger event ");
            if (this.f38824b.a() != null) {
                str = JsonUtils.getPrettyPrintedString((JSONObject) this.f38824b.a().forJsonPut());
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(".\n     Matched Action id: ");
            sb2.append(((b3) this.f38825c.element).getId());
            sb2.append(".\n                ");
            return StringsKt__IndentKt.trimIndent(sb2.toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.triggers.managers.TriggerManager$performTriggeredAction$1", f = "TriggerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38826b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b3 f38827c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k6 f38828d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w2 f38829e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f38830f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f38831g;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f38832b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(long j11) {
                super(0);
                this.f38832b = j11;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Performing triggered action after a delay of " + this.f38832b + " ms.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(b3 b3Var, k6 k6Var, w2 w2Var, long j11, long j12, Continuation<? super h> continuation) {
            super(1, continuation);
            this.f38827c = b3Var;
            this.f38828d = k6Var;
            this.f38829e = w2Var;
            this.f38830f = j11;
            this.f38831g = j12;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new h(this.f38827c, this.f38828d, this.f38829e, this.f38830f, this.f38831g, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f38826b == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, k6.f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new a(this.f38831g), 14, (Object) null);
                this.f38827c.a(this.f38828d.f38796a, this.f38828d.f38798c, this.f38829e, this.f38830f);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<b3> f38833b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(List<? extends b3> list) {
            super(0);
            this.f38833b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering " + this.f38833b.size() + " new triggered actions.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38834b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(b3 b3Var) {
            super(0);
            this.f38834b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering triggered action id " + this.f38834b.getId() + ' ';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f38835b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Test triggered actions found, triggering test event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f38836b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No test triggered actions found.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38837b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(0);
            this.f38837b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank serialized triggered action string for action id " + this.f38837b + " from shared preferences. Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38838b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(b3 b3Var) {
            super(0);
            this.f38838b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrieving templated triggered action id " + this.f38838b.getId() + " from local storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f38839b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered unexpected exception while parsing stored triggered actions.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38840b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(b3 b3Var) {
            super(0);
            this.f38840b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger manager received failed triggered action with id: <" + this.f38840b.getId() + ">. Will attempt to perform fallback triggered actions, if present.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final q f38841b = new q();

        public q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action has no trigger metadata and cannot fallback. Doing nothing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f38842b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action has no fallback action to perform. Doing nothing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38843b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(b3 b3Var) {
            super(0);
            this.f38843b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Fallback trigger has expired. Trigger id: ", this.f38843b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38844b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f38845c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(b3 b3Var, long j11) {
            super(0);
            this.f38844b = b3Var;
            this.f38845c = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Performing fallback triggered action with id: <" + this.f38844b.getId() + "> with a delay: " + this.f38845c + " ms";
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.triggers.managers.TriggerManager$retryTriggeredAction$6", f = "TriggerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class u extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f38846b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b3 f38847c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ k6 f38848d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ w2 f38849e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f38850f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(b3 b3Var, k6 k6Var, w2 w2Var, long j11, Continuation<? super u> continuation) {
            super(1, continuation);
            this.f38847c = b3Var;
            this.f38848d = k6Var;
            this.f38849e = w2Var;
            this.f38850f = j11;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((u) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new u(this.f38847c, this.f38848d, this.f38849e, this.f38850f, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f38846b == 0) {
                ResultKt.throwOnFailure(obj);
                this.f38847c.a(this.f38848d.f38796a, this.f38848d.f38798c, this.f38849e, this.f38850f);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final v f38851b = new v();

        public v() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Subscribing to trigger dispatch events.";
        }
    }

    public k6(Context context, b2 b2Var, j2 j2Var, j2 j2Var2, BrazeConfigurationProvider brazeConfigurationProvider, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f38796a = applicationContext;
        this.f38797b = b2Var;
        this.f38798c = j2Var;
        this.f38799d = j2Var2;
        this.f38800e = brazeConfigurationProvider.getTriggerActionMinimumTimeIntervalInSeconds();
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.triggers.actions", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f38801f = sharedPreferences;
        this.f38802g = new c6(context, str2);
        this.f38803h = new n6(context, str, str2);
        this.f38806k = h();
        this.f38804i = new AtomicInteger(0);
        this.f38805j = new ArrayDeque();
        i();
    }

    private final void i() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) v.f38851b, 12, (Object) null);
        this.f38798c.a(new x2.i(this), f6.class);
        this.f38798c.a(new x2.j(this), e6.class);
    }

    public final AtomicInteger c() {
        return this.f38804i;
    }

    public long d() {
        return this.f38807l;
    }

    public final Queue<w2> e() {
        return this.f38805j;
    }

    public a3 f() {
        return this.f38803h;
    }

    public final SharedPreferences g() {
        return this.f38801f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[Catch:{ Exception -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ Exception -> 0x0087 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, bo.app.b3> h() {
        /*
            r15 = this;
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            android.content.SharedPreferences r1 = r15.f38801f
            java.util.Map r1 = r1.getAll()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0018
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            if (r4 == 0) goto L_0x001c
            return r0
        L_0x001c:
            java.util.Set r1 = r1.keySet()
            java.util.Set r1 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(r1)
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0087 }
        L_0x0028:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x0087 }
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0087 }
            android.content.SharedPreferences r5 = r15.f38801f     // Catch:{ Exception -> 0x0087 }
            r6 = 0
            java.lang.String r5 = r5.getString(r4, r6)     // Catch:{ Exception -> 0x0087 }
            if (r5 == 0) goto L_0x0046
            boolean r6 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)     // Catch:{ Exception -> 0x0087 }
            if (r6 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r6 = r2
            goto L_0x0047
        L_0x0046:
            r6 = r3
        L_0x0047:
            if (r6 == 0) goto L_0x005d
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0087 }
            java.lang.String r8 = f38795q     // Catch:{ Exception -> 0x0087 }
            com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0087 }
            r10 = 0
            r11 = 0
            bo.app.k6$m r12 = new bo.app.k6$m     // Catch:{ Exception -> 0x0087 }
            r12.<init>(r4)     // Catch:{ Exception -> 0x0087 }
            r13 = 12
            r14 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (boolean) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0028
        L_0x005d:
            bo.app.m6 r4 = bo.app.m6.f38991a     // Catch:{ Exception -> 0x0087 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0087 }
            r6.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x0087 }
            bo.app.b2 r5 = r15.f38797b     // Catch:{ Exception -> 0x0087 }
            bo.app.b3 r4 = r4.b(r6, r5)     // Catch:{ Exception -> 0x0087 }
            if (r4 != 0) goto L_0x006d
            goto L_0x0028
        L_0x006d:
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0087 }
            java.lang.String r6 = f38795q     // Catch:{ Exception -> 0x0087 }
            r7 = 0
            r8 = 0
            r9 = 0
            bo.app.k6$n r10 = new bo.app.k6$n     // Catch:{ Exception -> 0x0087 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0087 }
            r11 = 14
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x0087 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0028
        L_0x0087:
            r1 = move-exception
            r5 = r1
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = f38795q
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.k6$o r7 = bo.app.k6.o.f38839b
            r6 = 0
            r8 = 8
            r9 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x0098:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.k6.h():java.util.Map");
    }

    public final void b(w2 w2Var) {
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(w2Var), 14, (Object) null);
        b3 c11 = c(w2Var);
        if (c11 != null) {
            b(w2Var, c11);
            return;
        }
        String d11 = w2Var.d();
        if (d11 != null) {
            int hashCode = d11.hashCode();
            if (hashCode != 3417674) {
                if (hashCode != 717572172) {
                    if (hashCode != 1743324417 || !d11.equals("purchase")) {
                        return;
                    }
                } else if (!d11.equals("custom_event")) {
                    return;
                }
            } else if (!d11.equals("open")) {
                return;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(w2Var), 7, (Object) null);
            j2 j2Var = this.f38799d;
            String d12 = w2Var.d();
            Intrinsics.checkNotNullExpressionValue(d12, "triggerEvent.triggerEventType");
            j2Var.a(new NoMatchingTriggerEvent(d12), NoMatchingTriggerEvent.class);
        }
    }

    /* JADX INFO: finally extract failed */
    public final b3 c(w2 w2Var) {
        w2 w2Var2 = w2Var;
        Intrinsics.checkNotNullParameter(w2Var2, "event");
        ReentrantLock reentrantLock = this.f38808m;
        reentrantLock.lock();
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ArrayList arrayList = new ArrayList();
            Iterator<b3> it = this.f38806k.values().iterator();
            int i11 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                T t11 = (b3) it.next();
                if (t11.b(w2Var2) && f().b(t11)) {
                    if (f38793o.a(w2Var, t11, d(), this.f38800e)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(t11), 14, (Object) null);
                        int u11 = t11.f().u();
                        if (u11 > i11) {
                            objectRef.element = t11;
                            i11 = u11;
                        }
                        arrayList.add(t11);
                    }
                }
            }
            T t12 = objectRef.element;
            if (t12 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(w2Var2), 14, (Object) null);
                reentrantLock.unlock();
                return null;
            }
            arrayList.remove(t12);
            ((b3) objectRef.element).a(new l6(arrayList));
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(w2Var2, objectRef), 14, (Object) null);
            b3 b3Var = (b3) objectRef.element;
            reentrantLock.unlock();
            return b3Var;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void a(long j11) {
        this.f38807l = j11;
    }

    /* JADX INFO: finally extract failed */
    public void a(List<? extends b3> list) {
        List<? extends b3> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "triggeredActions");
        z5 z5Var = new z5();
        ReentrantLock reentrantLock = this.f38808m;
        reentrantLock.lock();
        try {
            this.f38806k.clear();
            SharedPreferences.Editor clear = g().edit().clear();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(list2), 14, (Object) null);
            boolean z11 = false;
            for (b3 b3Var : list) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(b3Var), 14, (Object) null);
                this.f38806k.put(b3Var.getId(), b3Var);
                clear.putString(b3Var.getId(), String.valueOf(b3Var.forJsonPut()));
                if (b3Var.b(z5Var)) {
                    z11 = true;
                }
            }
            clear.apply();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            f().a(list2);
            this.f38802g.a(list2);
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) k.f38835b, 12, (Object) null);
                a((w2) z5Var);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) l.f38836b, 14, (Object) null);
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u0012\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\r8\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013¨\u0006\u001a"}, d2 = {"Lbo/app/k6$a;", "", "Lbo/app/w2;", "triggerEvent", "Lbo/app/b3;", "action", "", "lastDisplayTime", "minSecondsIntervalBetweenActions", "", "a", "Lbo/app/b2;", "brazeManager", "", "triggerAnalyticsId", "Lcom/braze/enums/inappmessage/InAppMessageFailureType;", "inAppMessageFailureType", "", "ACTIONS_FILE_PREFIX", "Ljava/lang/String;", "DEFAULT_TIMEOUT_IN_MS", "J", "TAG", "TYPE", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.k6$a$a  reason: collision with other inner class name */
        public static final class C0026a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final C0026a f38810b = new C0026a();

            public C0026a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Ignoring minimum time interval between triggered actions because the trigger event is a test.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f38811b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(int i11) {
                super(0);
                this.f38811b = i11;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Using override minimum display interval: ", Integer.valueOf(this.f38811b));
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f38812b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f38813c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(long j11, long j12) {
                super(0);
                this.f38812b = j11;
                this.f38813c = j12;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Minimum time interval requirement met for matched trigger. Action display time: " + this.f38812b + " . Next viable display time: " + this.f38813c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f38814b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f38815c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f38816d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(long j11, long j12, long j13) {
                super(0);
                this.f38814b = j11;
                this.f38815c = j12;
                this.f38816d = j13;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Minimum time interval requirement and triggered action override time interval requirement of " + this.f38814b + " not met for matched trigger. Returning null. Next viable display time: " + this.f38815c + ". Action display time: " + this.f38816d;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InAppMessageFailureType f38817b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(InAppMessageFailureType inAppMessageFailureType) {
                super(0);
                this.f38817b = inAppMessageFailureType;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Trigger internal timeout exceeded. Attempting to log trigger failure: ", this.f38817b);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ InAppMessageFailureType f38818b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(InAppMessageFailureType inAppMessageFailureType) {
                super(0);
                this.f38818b = inAppMessageFailureType;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Trigger ID is blank. Not logging trigger failure: ", this.f38818b);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(w2 w2Var, b3 b3Var, long j11, long j12) {
            long j13;
            w2 w2Var2 = w2Var;
            Intrinsics.checkNotNullParameter(w2Var2, "triggerEvent");
            Intrinsics.checkNotNullParameter(b3Var, NativeProtocol.WEB_DIALOG_ACTION);
            if (w2Var2 instanceof z5) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, k6.f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) C0026a.f38810b, 14, (Object) null);
                return true;
            }
            long nowInSeconds = DateTimeUtils.nowInSeconds() + ((long) b3Var.f().g());
            int l11 = b3Var.f().l();
            if (l11 != -1) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, k6.f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(l11), 14, (Object) null);
                j13 = j11 + ((long) l11);
            } else {
                j13 = j11 + j12;
            }
            long j14 = j13;
            if (nowInSeconds >= j14) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, k6.f38795q, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(nowInSeconds, j14), 12, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, k6.f38795q, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new d(j12, j14, nowInSeconds), 12, (Object) null);
            return false;
        }

        @JvmStatic
        public final void a(b2 b2Var, String str, InAppMessageFailureType inAppMessageFailureType) {
            Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
            Intrinsics.checkNotNullParameter(str, "triggerAnalyticsId");
            Intrinsics.checkNotNullParameter(inAppMessageFailureType, "inAppMessageFailureType");
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, k6.f38795q, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new e(inAppMessageFailureType), 12, (Object) null);
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                BrazeLogger.brazelog$default(brazeLogger, k6.f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(inAppMessageFailureType), 14, (Object) null);
                return;
            }
            x1 a11 = j.f38653h.a(str, inAppMessageFailureType);
            if (a11 != null) {
                b2Var.a(a11);
            }
        }
    }

    public final void b() {
        ReentrantLock reentrantLock = this.f38809n;
        reentrantLock.lock();
        try {
            if (c().get() <= 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f38795q, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f38819b, 14, (Object) null);
                while (!e().isEmpty()) {
                    w2 poll = e().poll();
                    if (poll != null) {
                        b(poll);
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(w2 w2Var, b3 b3Var) {
        Intrinsics.checkNotNullParameter(w2Var, "event");
        Intrinsics.checkNotNullParameter(b3Var, NativeProtocol.WEB_DIALOG_ACTION);
        b3Var.a(this.f38802g.a(b3Var));
        r2 f11 = b3Var.f();
        long e11 = f11.a() != -1 ? w2Var.e() + ((long) f11.a()) : -1;
        long millis = TimeUnit.SECONDS.toMillis((long) f11.g());
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(millis), (CoroutineContext) null, new h(b3Var, this, w2Var, e11, millis, (Continuation<? super h>) null), 2, (Object) null);
    }

    public void a(w2 w2Var) {
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        ReentrantLock reentrantLock = this.f38809n;
        reentrantLock.lock();
        try {
            e().add(w2Var);
            if (c().get() == 0) {
                b();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(w2 w2Var, b3 b3Var) {
        long j11;
        w2 w2Var2 = w2Var;
        b3 b3Var2 = b3Var;
        Intrinsics.checkNotNullParameter(w2Var2, "triggerEvent");
        Intrinsics.checkNotNullParameter(b3Var2, "failedAction");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str = f38795q;
        BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new p(b3Var2), 14, (Object) null);
        l6 i11 = b3Var.i();
        if (i11 == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) q.f38841b, 14, (Object) null);
            return;
        }
        b3 a11 = i11.a();
        if (a11 == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) r.f38842b, 14, (Object) null);
            return;
        }
        a11.a(i11);
        a11.a(this.f38802g.a(a11));
        long e11 = w2Var.e();
        r2 f11 = a11.f();
        long a12 = (long) f11.a();
        long millis = TimeUnit.SECONDS.toMillis((long) f11.g());
        if (a12 != -1) {
            j11 = a12 + e11;
        } else {
            j11 = e11 + millis + f38794p;
        }
        long j12 = j11;
        if (j12 < DateTimeUtils.nowInMilliseconds()) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new s(a11), 14, (Object) null);
            f38793o.a(this.f38797b, a11.getId(), InAppMessageFailureType.INTERNAL_TIMEOUT_EXCEEDED);
            a(w2Var2, a11);
            return;
        }
        long max = Math.max(0, (millis + e11) - DateTimeUtils.nowInMilliseconds());
        BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new t(a11, max), 14, (Object) null);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(max), (CoroutineContext) null, new u(a11, this, w2Var, j12, (Continuation<? super u>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void a(k6 k6Var, f6 f6Var) {
        Intrinsics.checkNotNullParameter(k6Var, "this$0");
        Intrinsics.checkNotNullParameter(f6Var, "$noName_0");
        k6Var.f38804i.incrementAndGet();
    }

    /* access modifiers changed from: private */
    public static final void a(k6 k6Var, e6 e6Var) {
        Intrinsics.checkNotNullParameter(k6Var, "this$0");
        Intrinsics.checkNotNullParameter(e6Var, "$noName_0");
        k6Var.f38804i.decrementAndGet();
        k6Var.b();
    }
}
