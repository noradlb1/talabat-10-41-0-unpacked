package bo.app;

import android.app.Activity;
import android.content.Context;
import bo.app.a4;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.visa.checkout.Profile;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
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
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fBa\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010)\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u00107\u001a\u00020\u001e\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010!\u001a\u00020 H\u0016J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0004H\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0007R\u001c\u0010)\u001a\u0004\u0018\u00010\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u000f\u0010+R\"\u0010,\u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.\"\u0004\b\u0010\u0010/R\u0016\u00103\u001a\u0004\u0018\u0001008VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R$\u00104\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010.\"\u0004\b\u000f\u0010/¨\u0006H"}, d2 = {"Lbo/app/p;", "Lbo/app/b2;", "", "throwable", "", "c", "", "d", "Landroid/app/Activity;", "activity", "openSession", "closeSession", "e", "Lbo/app/x1;", "event", "a", "b", "Lbo/app/a4$a;", "respondWithBuilder", "Lbo/app/a2;", "location", "refreshFeatureFlags", "Lbo/app/c2;", "request", "geofenceEvent", "Lbo/app/x5;", "templatedTriggeredAction", "Lbo/app/w2;", "triggerEvent", "", "", "deviceLogs", "", "creationTime", "lastCardUpdatedAt", "lastFullSyncAt", "", "retryCount", "shouldPersistError", "Lbo/app/k4;", "notificationTrackingBrazeEvent", "userId", "Ljava/lang/String;", "()Ljava/lang/String;", "isOutboundNetworkRequestsOffline", "Z", "()Z", "(Z)V", "Lbo/app/j5;", "f", "()Lbo/app/j5;", "currentSessionId", "shouldRequestTriggersInNextRequest", "Landroid/content/Context;", "context", "apiKey", "Lbo/app/t;", "sessionManager", "Lbo/app/j2;", "internalEventPublisher", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/b1;", "eventStorageManager", "Lbo/app/q;", "messagingSessionManager", "Lbo/app/z4;", "sdkEnablementProvider", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lbo/app/t;Lbo/app/j2;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/e5;Lbo/app/b1;ZLbo/app/q;Lbo/app/z4;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class p implements b2 {

    /* renamed from: s  reason: collision with root package name */
    public static final a f39122s = new a((DefaultConstructorMarker) null);

    /* renamed from: t  reason: collision with root package name */
    private static final String[] f39123t = {"android.os.deadsystemexception"};

    /* renamed from: a  reason: collision with root package name */
    private final String f39124a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final t f39125b;

    /* renamed from: c  reason: collision with root package name */
    private final j2 f39126c;

    /* renamed from: d  reason: collision with root package name */
    private final BrazeConfigurationProvider f39127d;

    /* renamed from: e  reason: collision with root package name */
    private final e5 f39128e;

    /* renamed from: f  reason: collision with root package name */
    private final b1 f39129f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f39130g;

    /* renamed from: h  reason: collision with root package name */
    private final q f39131h;

    /* renamed from: i  reason: collision with root package name */
    private final z4 f39132i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicInteger f39133j = new AtomicInteger(0);

    /* renamed from: k  reason: collision with root package name */
    private final AtomicInteger f39134k = new AtomicInteger(0);

    /* renamed from: l  reason: collision with root package name */
    private final ReentrantLock f39135l = new ReentrantLock();

    /* renamed from: m  reason: collision with root package name */
    private final ReentrantLock f39136m = new ReentrantLock();

    /* renamed from: n  reason: collision with root package name */
    private Job f39137n = JobKt.Job$default((Job) null, 1, (Object) null);

    /* renamed from: o  reason: collision with root package name */
    private final x0 f39138o;

    /* renamed from: p  reason: collision with root package name */
    private volatile String f39139p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final AtomicBoolean f39140q;

    /* renamed from: r  reason: collision with root package name */
    private Class<? extends Activity> f39141r;

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lbo/app/p$a;", "", "", "isSessionInBackground", "Lbo/app/x1;", "event", "a", "", "INACTIVE_SESSION_DELAY_MILLIS", "J", "", "", "INTERNAL_ERROR_DENYLIST", "[Ljava/lang/String;", "", "MAX_CONSECUTIVE_ERRORS", "I", "MAX_ERRORS", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean a(boolean z11, x1 x1Var) {
            if (!z11) {
                return false;
            }
            if (x1Var.j() == c1.PUSH_ACTION_BUTTON_CLICKED) {
                return !((h4) x1Var).x();
            }
            if (x1Var.j() == c1.PUSH_CLICKED || x1Var.j() == c1.PUSH_STORY_PAGE_CLICK) {
                return true;
            }
            return false;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39142b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not adding request to dispatch.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39143b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not closing session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f39144b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Activity activity) {
            super(0);
            this.f39144b = activity;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Closed session with activity: ", this.f39144b.getLocalClassName());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39145b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not force closing session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable f39146b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Throwable th2) {
            super(0);
            this.f39146b = th2;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Not logging duplicate error: ", this.f39146b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f39147b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log error.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39148b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(x1 x1Var) {
            super(0);
            this.f39148b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("SDK is disabled. Not logging event: ", this.f39148b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39149b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(x1 x1Var) {
            super(0);
            this.f39149b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Not processing event after validation failed: ", this.f39149b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39150b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(x1 x1Var) {
            super(0);
            this.f39150b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Not adding session id to event: ", JsonUtils.getPrettyPrintedString((JSONObject) this.f39150b.forJsonPut()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39151b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(x1 x1Var) {
            super(0);
            this.f39151b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Not adding user id to event: ", JsonUtils.getPrettyPrintedString((JSONObject) this.f39151b.forJsonPut()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39152b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(x1 x1Var) {
            super(0);
            this.f39152b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Attempting to log event: ", JsonUtils.getPrettyPrintedString((JSONObject) this.f39152b.forJsonPut()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f39153b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Publishing an internal push body clicked event for any awaiting triggers.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f39154b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding push click to dispatcher pending list";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.managers.BrazeManager$logEvent$3", f = "BrazeManager.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39155b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f39156c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(p pVar, Continuation<? super o> continuation) {
            super(2, continuation);
            this.f39156c = pVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new o(this.f39156c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f39155b;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                this.f39155b = 1;
                if (DelayKt.delay(1000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f39156c.b();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.p$p  reason: collision with other inner class name */
    public static final class C0031p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final C0031p f39157b = new C0031p();

        public C0031p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not opening session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f39158b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(p pVar) {
            super(0);
            this.f39158b = pVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Completed the openSession call. Starting or continuing session ", this.f39158b.f39125b.g());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f39159b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "SDK is disabled. Not opening session.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f39160b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(Activity activity) {
            super(0);
            this.f39160b = activity;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Opened session with activity: ", this.f39160b.getLocalClassName());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final t f39161b = new t();

        public t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get local class name for activity when opening session";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final u f39162b = new u();

        public u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting geofence report for geofence event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final v f39163b = new v();

        public v() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting feature flags refresh request.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final w f39164b = new w();

        public w() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Posting geofence request for location.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f39165b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(p pVar) {
            super(0);
            this.f39165b = pVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Updated shouldRequestTriggersInNextRequest to: ", this.f39165b.f39140q);
        }
    }

    public p(Context context, String str, String str2, t tVar, j2 j2Var, BrazeConfigurationProvider brazeConfigurationProvider, e5 e5Var, b1 b1Var, boolean z11, q qVar, z4 z4Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(tVar, "sessionManager");
        Intrinsics.checkNotNullParameter(j2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(b1Var, "eventStorageManager");
        Intrinsics.checkNotNullParameter(qVar, "messagingSessionManager");
        Intrinsics.checkNotNullParameter(z4Var, "sdkEnablementProvider");
        this.f39124a = str;
        this.f39125b = tVar;
        this.f39126c = j2Var;
        this.f39127d = brazeConfigurationProvider;
        this.f39128e = e5Var;
        this.f39129f = b1Var;
        this.f39130g = z11;
        this.f39131h = qVar;
        this.f39132i = z4Var;
        this.f39138o = new x0(context, a(), str2);
        this.f39139p = "";
        this.f39140q = new AtomicBoolean(false);
    }

    public boolean c() {
        return this.f39140q.get();
    }

    public void closeSession(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) c.f39143b, 6, (Object) null);
        } else if (this.f39141r == null || Intrinsics.areEqual((Object) activity.getClass(), (Object) this.f39141r)) {
            this.f39131h.c();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new d(activity), 6, (Object) null);
            this.f39125b.o();
        }
    }

    public void d() {
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) C0031p.f39157b, 6, (Object) null);
            return;
        }
        this.f39125b.m();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new q(this), 6, (Object) null);
    }

    public void e() {
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) e.f39145b, 6, (Object) null);
            return;
        }
        this.f39141r = null;
        this.f39125b.l();
    }

    public j5 f() {
        return this.f39125b.g();
    }

    public void openSession(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) r.f39159b, 6, (Object) null);
            return;
        }
        d();
        this.f39141r = activity.getClass();
        this.f39131h.b();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new s(activity), 6, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) t.f39161b, 4, (Object) null);
        }
    }

    public void refreshFeatureFlags() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) v.f39163b, 7, (Object) null);
        a((c2) new g1(this.f39127d.getBaseUrlForRequests()));
    }

    /* JADX INFO: finally extract failed */
    private final boolean c(Throwable th2) {
        ReentrantLock reentrantLock = this.f39136m;
        reentrantLock.lock();
        try {
            this.f39133j.getAndIncrement();
            if (!Intrinsics.areEqual((Object) this.f39139p, (Object) th2.getMessage()) || this.f39134k.get() <= 3 || this.f39133j.get() >= 100) {
                if (Intrinsics.areEqual((Object) this.f39139p, (Object) th2.getMessage())) {
                    this.f39134k.getAndIncrement();
                } else {
                    this.f39134k.set(0);
                }
                if (this.f39133j.get() >= 100) {
                    this.f39133j.set(0);
                }
                this.f39139p = th2.getMessage();
                reentrantLock.unlock();
                return false;
            }
            reentrantLock.unlock();
            return true;
        } catch (Throwable th3) {
            reentrantLock.unlock();
            throw th3;
        }
    }

    public String a() {
        return this.f39124a;
    }

    public void b(boolean z11) {
        this.f39130g = z11;
    }

    public void a(boolean z11) {
        this.f39140q.set(z11);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new x(this), 6, (Object) null);
    }

    public void b(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        a(th2, true);
    }

    public void b() {
        a(new a4.a((String) null, (Boolean) null, (Boolean) null, (z3) null, 15, (DefaultConstructorMarker) null));
    }

    public boolean a(x1 x1Var) {
        boolean z11;
        x1 x1Var2 = x1Var;
        Intrinsics.checkNotNullParameter(x1Var2, "event");
        boolean z12 = false;
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new h(x1Var2), 6, (Object) null);
            return false;
        }
        ReentrantLock reentrantLock = this.f39135l;
        reentrantLock.lock();
        try {
            if (!this.f39138o.a(x1Var2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new i(x1Var2), 6, (Object) null);
                return false;
            }
            if (this.f39125b.j() || this.f39125b.g() == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(x1Var2), 7, (Object) null);
                z11 = true;
            } else {
                x1Var2.a(this.f39125b.g());
                z11 = false;
            }
            String a11 = a();
            if (a11 == null || a11.length() == 0) {
                z12 = true;
            }
            if (!z12) {
                x1Var2.a(a());
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new k(x1Var2), 7, (Object) null);
            }
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new l(x1Var2), 6, (Object) null);
            if (x1Var.j() == c1.PUSH_CLICKED) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) m.f39153b, 7, (Object) null);
                a((k4) x1Var2);
            }
            if (!x1Var.d()) {
                this.f39129f.a(x1Var2);
            }
            Class<o0> cls = o0.class;
            if (f39122s.a(z11, x1Var2)) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) n.f39154b, 7, (Object) null);
                this.f39126c.a(o0.f39083e.b(x1Var2), cls);
            } else {
                this.f39126c.a(o0.f39083e.a(x1Var2), cls);
            }
            if (x1Var.j() == c1.SESSION_START) {
                this.f39126c.a(o0.f39083e.a(x1Var.n()), cls);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (z11) {
                Job.DefaultImpls.cancel$default(this.f39137n, (CancellationException) null, 1, (Object) null);
                this.f39137n = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new o(this, (Continuation<? super o>) null), 3, (Object) null);
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "geofenceEvent");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) u.f39162b, 7, (Object) null);
        a((c2) new n1(this.f39127d.getBaseUrlForRequests(), x1Var));
    }

    public void a(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        a(th2, false);
    }

    public void a(a4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "respondWithBuilder");
        Pair<Long, Boolean> a11 = this.f39128e.a();
        if (a11 != null) {
            aVar.a(new z3(a11.getFirst().longValue(), a11.getSecond().booleanValue()));
        }
        if (this.f39140q.get()) {
            aVar.c();
        }
        aVar.a(a());
        a((c2) new i0(this.f39127d.getBaseUrlForRequests(), aVar.a()));
        this.f39140q.set(false);
    }

    public void a(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "location");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) w.f39164b, 7, (Object) null);
        a((c2) new m1(this.f39127d.getBaseUrlForRequests(), a2Var));
    }

    public void a(c2 c2Var) {
        Intrinsics.checkNotNullParameter(c2Var, "request");
        if (this.f39132i.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) b.f39142b, 6, (Object) null);
            return;
        }
        this.f39126c.a(o0.f39083e.a(c2Var), o0.class);
    }

    public void a(x5 x5Var, w2 w2Var) {
        Intrinsics.checkNotNullParameter(x5Var, "templatedTriggeredAction");
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        a((c2) new w5(this.f39127d.getBaseUrlForRequests(), x5Var, w2Var, this, a()));
    }

    public void a(w2 w2Var) {
        Intrinsics.checkNotNullParameter(w2Var, "triggerEvent");
        this.f39126c.a(new i6(w2Var), i6.class);
    }

    public void a(List<String> list, long j11) {
        Intrinsics.checkNotNullParameter(list, "deviceLogs");
        a((c2) new a6(this.f39127d.getBaseUrlForRequests(), list, j11, a()));
    }

    public void a(long j11, long j12, int i11) {
        a((c2) new b0(this.f39127d.getBaseUrlForRequests(), j11, j12, a(), i11));
    }

    public final void a(Throwable th2, boolean z11) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        try {
            if (c(th2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new f(th2), 6, (Object) null);
                return;
            }
            String th3 = th2.toString();
            String[] strArr = f39123t;
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                String str = strArr[i11];
                i11++;
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                String lowerCase = th3.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str, false, 2, (Object) null)) {
                    return;
                }
            }
            x1 a11 = j.f38653h.a(th2, f(), z11);
            if (a11 != null) {
                a(a11);
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) g.f39147b, 4, (Object) null);
        }
    }

    public final void a(k4 k4Var) {
        Intrinsics.checkNotNullParameter(k4Var, "notificationTrackingBrazeEvent");
        String optString = k4Var.k().optString("cid", "");
        j2 j2Var = this.f39126c;
        Intrinsics.checkNotNullExpressionValue(optString, "campaignId");
        j2Var.a(new g6(optString, k4Var), g6.class);
    }
}
