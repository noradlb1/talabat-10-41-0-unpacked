package bo.app;

import com.appboy.events.FeedUpdatedEvent;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.models.BrazeGeofence;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import java.util.List;
import java.util.Map;
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
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007BG\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fH\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\u0015\u001a\u00020\u0006J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¨\u0006+"}, d2 = {"Lbo/app/s;", "", "Lorg/json/JSONArray;", "feedJson", "", "userId", "", "a", "Lbo/app/z;", "contentCardsResponse", "Lbo/app/c5;", "serverConfig", "", "Lbo/app/b3;", "triggeredActions", "b", "Lcom/braze/models/BrazeGeofence;", "geofences", "featureFlagsData", "Lcom/braze/models/inappmessage/IInAppMessage;", "templatedInAppMessage", "c", "Lbo/app/d;", "apiResponse", "Lbo/app/q2;", "responseError", "Lbo/app/c2;", "request", "Lbo/app/k2;", "httpConnector", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/j1;", "feedStorageProvider", "Lbo/app/b2;", "brazeManager", "Lbo/app/e5;", "serverConfigStorage", "Lbo/app/a0;", "contentCardsStorage", "<init>", "(Lbo/app/c2;Lbo/app/k2;Lbo/app/j2;Lbo/app/j2;Lbo/app/j1;Lbo/app/b2;Lbo/app/e5;Lbo/app/a0;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class s {

    /* renamed from: j  reason: collision with root package name */
    public static final a f39299j = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String f39300k = BrazeLogger.getBrazeLogTag((Class<?>) s.class);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c2 f39301a;

    /* renamed from: b  reason: collision with root package name */
    private final k2 f39302b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j2 f39303c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final j2 f39304d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final j1 f39305e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b2 f39306f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final e5 f39307g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final a0 f39308h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f39309i;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0005\u001a\u00020\u0003*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lbo/app/s$a;", "", "Lkotlin/Function0;", "", "block", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.s$a$a  reason: collision with other inner class name */
        public static final class C0033a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f39310b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0033a(Object obj) {
                super(0);
                this.f39310b = obj;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Encountered exception while parsing server response for ", this.f39310b);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void a(Object obj, Function0<Unit> function0) {
            try {
                function0.invoke();
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, obj, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new C0033a(obj), 4, (Object) null);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ v4 f39311b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(v4 v4Var) {
            super(0);
            this.f39311b = v4Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not parse request parameters for POST request to " + this.f39311b + ", cancelling request.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f39312b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Exception exc) {
            super(0);
            this.f39312b = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Experienced network communication exception processing API response. Sending network error event. ", this.f39312b.getMessage());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39313b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced exception processing API response. Failing task.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39314b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ z f39315c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f39316d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(s sVar, z zVar, String str) {
            super(0);
            this.f39314b = sVar;
            this.f39315c = zVar;
            this.f39316d = str;
        }

        public final void a() {
            ContentCardsUpdatedEvent a11 = this.f39314b.f39308h.a(this.f39315c, this.f39316d);
            if (a11 != null) {
                this.f39314b.f39304d.a(a11, ContentCardsUpdatedEvent.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39317b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONArray f39318c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(s sVar, JSONArray jSONArray) {
            super(0);
            this.f39317b = sVar;
            this.f39318c = jSONArray;
        }

        public final void a() {
            this.f39317b.f39303c.a(new f1(this.f39318c), f1.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39319b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONArray f39320c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f39321d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(s sVar, JSONArray jSONArray, String str) {
            super(0);
            this.f39319b = sVar;
            this.f39320c = jSONArray;
            this.f39321d = str;
        }

        public final void a() {
            FeedUpdatedEvent a11 = this.f39319b.f39305e.a(this.f39320c, this.f39321d);
            if (a11 != null) {
                this.f39319b.f39304d.a(a11, FeedUpdatedEvent.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39322b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List<BrazeGeofence> f39323c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(s sVar, List<BrazeGeofence> list) {
            super(0);
            this.f39322b = sVar;
            this.f39323c = list;
        }

        public final void a() {
            this.f39322b.f39303c.a(new q1(this.f39323c), q1.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39324b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c5 f39325c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(s sVar, c5 c5Var) {
            super(0);
            this.f39324b = sVar;
            this.f39325c = c5Var;
        }

        public final void a() {
            this.f39324b.f39307g.b(this.f39325c);
            this.f39324b.f39303c.a(new d5(this.f39325c), d5.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39326b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ IInAppMessage f39327c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f39328d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(s sVar, IInAppMessage iInAppMessage, String str) {
            super(0);
            this.f39326b = sVar;
            this.f39327c = iInAppMessage;
            this.f39328d = str;
        }

        public final void a() {
            if (this.f39326b.f39301a instanceof w5) {
                this.f39327c.setExpirationTimestamp(((w5) this.f39326b.f39301a).u());
                this.f39326b.f39303c.a(new g3(((w5) this.f39326b.f39301a).v(), ((w5) this.f39326b.f39301a).w(), this.f39327c, this.f39328d), g3.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<Unit> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39329b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List<b3> f39330c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(s sVar, List<? extends b3> list) {
            super(0);
            this.f39329b = sVar;
            this.f39330c = list;
        }

        public final void a() {
            this.f39329b.f39303c.a(new r6(this.f39330c), r6.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39331b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(0);
            this.f39331b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Processing server response payload for user with id: ", this.f39331b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q2 f39332b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(q2 q2Var) {
            super(0);
            this.f39332b = q2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Received server error from request: ", this.f39332b.a());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f39333b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f39334c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(s sVar, int i11) {
            super(0);
            this.f39333b = sVar;
            this.f39334c = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrying request: " + this.f39333b.f39301a + " after delay of " + this.f39334c + " ms";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.braze.requests.BrazeRequestTask$processResponseError$3", f = "BrazeRequestTask.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: b  reason: collision with root package name */
        int f39335b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f39336c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s f39337d;

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ s f39338b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(s sVar) {
                super(0);
                this.f39338b = sVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Adding retried request to dispatch: ", this.f39338b.f39301a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(int i11, s sVar, Continuation<? super o> continuation) {
            super(2, continuation);
            this.f39336c = i11;
            this.f39337d = sVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new o(this.f39336c, this.f39337d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f39335b;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                this.f39335b = 1;
                if (DelayKt.delay((long) this.f39336c, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, s.f39300k, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(this.f39337d), 12, (Object) null);
            this.f39337d.f39306f.a(this.f39337d.f39301a);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f39339b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Api response was null, failing task.";
        }
    }

    public s(c2 c2Var, k2 k2Var, j2 j2Var, j2 j2Var2, j1 j1Var, b2 b2Var, e5 e5Var, a0 a0Var) {
        Intrinsics.checkNotNullParameter(c2Var, "request");
        Intrinsics.checkNotNullParameter(k2Var, "httpConnector");
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(j1Var, "feedStorageProvider");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorage");
        Intrinsics.checkNotNullParameter(a0Var, "contentCardsStorage");
        this.f39301a = c2Var;
        this.f39302b = k2Var;
        this.f39303c = j2Var;
        this.f39304d = j2Var2;
        this.f39305e = j1Var;
        this.f39306f = b2Var;
        this.f39307g = e5Var;
        this.f39308h = a0Var;
        Map<String, String> a11 = s4.a();
        this.f39309i = a11;
        c2Var.a(a11);
    }

    public final d b() {
        try {
            v4 h11 = this.f39301a.h();
            JSONObject l11 = this.f39301a.l();
            if (l11 != null) {
                return new d(this.f39302b.a(h11, this.f39309i, l11), this.f39301a, this.f39306f);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new b(h11), 6, (Object) null);
            return null;
        } catch (Exception e11) {
            if (e11 instanceof r3) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new c(e11), 4, (Object) null);
                this.f39303c.a(new t4(this.f39301a), t4.class);
                this.f39304d.a(new BrazeNetworkFailureEvent(e11, this.f39301a), BrazeNetworkFailureEvent.class);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f39313b, 4, (Object) null);
            return null;
        }
    }

    public final void c() {
        d b11 = b();
        Class<p0> cls = p0.class;
        if (b11 != null) {
            a(b11);
            this.f39303c.a(new u4(this.f39301a), u4.class);
            if (b11.b() instanceof x4) {
                this.f39303c.a(new p0(this.f39301a), cls);
            } else {
                this.f39303c.a(new r0(this.f39301a), r0.class);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) p.f39339b, 6, (Object) null);
            s3 s3Var = new s3("An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.", this.f39301a);
            this.f39301a.a(this.f39303c, this.f39304d, (q2) s3Var);
            this.f39303c.a(new p0(this.f39301a), cls);
            a((q2) s3Var);
        }
        this.f39301a.b(this.f39303c);
    }

    public final void a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "apiResponse");
        if (dVar.b() == null) {
            this.f39301a.a(this.f39303c, this.f39304d, dVar);
        } else {
            a(dVar.b());
            this.f39301a.a(this.f39303c, this.f39304d, dVar.b());
        }
        b(dVar);
    }

    public final void a(q2 q2Var) {
        q2 q2Var2 = q2Var;
        Intrinsics.checkNotNullParameter(q2Var2, "responseError");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new m(q2Var2), 6, (Object) null);
        this.f39303c.a(new g5(q2Var2), g5.class);
        if (this.f39301a.a(q2Var2)) {
            int a11 = this.f39301a.m().a();
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new n(this, a11), 7, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new o(a11, this, (Continuation<? super o>) null), 3, (Object) null);
            return;
        }
        c2 c2Var = this.f39301a;
        if (c2Var instanceof w5) {
            j2 j2Var = this.f39304d;
            String d11 = ((w5) c2Var).v().d();
            Intrinsics.checkNotNullExpressionValue(d11, "request.triggerEvent.triggerEventType");
            j2Var.a(new NoMatchingTriggerEvent(d11), NoMatchingTriggerEvent.class);
        }
    }

    public final void b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "apiResponse");
        String a11 = this.f39306f.a();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new l(a11), 6, (Object) null);
        a(dVar.d(), a11);
        a(dVar.a(), a11);
        a(dVar.h());
        b((List<? extends b3>) dVar.j());
        a(dVar.e());
        a(dVar.c());
        a(dVar.i(), a11);
    }

    private final void a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            f39299j.a(jSONArray, new g(this, jSONArray, str));
        }
    }

    private final void a(z zVar, String str) {
        if (zVar != null) {
            f39299j.a(zVar, new e(this, zVar, str));
        }
    }

    private final void a(c5 c5Var) {
        if (c5Var != null) {
            f39299j.a(c5Var, new i(this, c5Var));
        }
    }

    private final void a(List<BrazeGeofence> list) {
        if (list != null) {
            f39299j.a(list, new h(this, list));
        }
    }

    private final void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            f39299j.a(jSONArray, new f(this, jSONArray));
        }
    }

    private final void b(List<? extends b3> list) {
        if (list != null) {
            f39299j.a(list, new k(this, list));
        }
    }

    private final void a(IInAppMessage iInAppMessage, String str) {
        if (iInAppMessage != null) {
            f39299j.a(iInAppMessage, new j(this, iInAppMessage, str));
        }
    }
}
