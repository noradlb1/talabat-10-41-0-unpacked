package bo.app;

import com.braze.enums.inappmessage.InAppMessageFailureType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0005B1\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u00107\u001a\u000206\u0012\b\u00108\u001a\u0004\u0018\u000102¢\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J \u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0007R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020%8\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u000e8\u0016XD¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006;"}, d2 = {"Lbo/app/w5;", "Lbo/app/r;", "Lbo/app/r2;", "scheduleConfig", "", "a", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/d;", "apiResponse", "", "Lbo/app/q2;", "responseError", "", "x", "Lbo/app/w2;", "triggerEvent", "Lbo/app/w2;", "v", "()Lbo/app/w2;", "templatePayloadExpirationTimestamp", "J", "u", "()J", "Lbo/app/b3;", "triggeredAction", "Lbo/app/b3;", "w", "()Lbo/app/b3;", "Lbo/app/a4;", "outboundRespondWith", "Lbo/app/a4;", "c", "()Lbo/app/a4;", "setOutboundRespondWith", "(Lbo/app/a4;)V", "Lbo/app/d1;", "backoffStateProvider", "Lbo/app/d1;", "t", "()Lbo/app/d1;", "containsNoNewData", "Z", "b", "()Z", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "", "urlBase", "Lbo/app/x5;", "templatedTriggeredAction", "Lbo/app/b2;", "brazeManager", "userId", "<init>", "(Ljava/lang/String;Lbo/app/x5;Lbo/app/w2;Lbo/app/b2;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class w5 extends r {
    public static final a C = new a((DefaultConstructorMarker) null);
    private final d1 A;
    private final boolean B;

    /* renamed from: r  reason: collision with root package name */
    private final x5 f39528r;

    /* renamed from: s  reason: collision with root package name */
    private final w2 f39529s;

    /* renamed from: t  reason: collision with root package name */
    private final b2 f39530t;

    /* renamed from: u  reason: collision with root package name */
    private final String f39531u;

    /* renamed from: v  reason: collision with root package name */
    private final long f39532v;

    /* renamed from: w  reason: collision with root package name */
    private final long f39533w;

    /* renamed from: x  reason: collision with root package name */
    private final long f39534x;

    /* renamed from: y  reason: collision with root package name */
    private final b3 f39535y;

    /* renamed from: z  reason: collision with root package name */
    private a4 f39536z;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lbo/app/w5$a;", "", "", "EVENT_DATA_KEY", "Ljava/lang/String;", "", "EXTRA_DELAY_IN_SECONDS", "I", "TEMPLATE_OBJECT_KEY", "TRIGGER_EVENT_TYPE", "TRIGGER_ID_KEY", "URL_EXTENSION", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f39537b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Template request failed. Attempting to log in-app message template request failure.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39538b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger ID not found. Not logging in-app message template request failure.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39539b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39540b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j11) {
            super(0);
            this.f39540b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Template request has not yet expired. It expires at time: " + this.f39540b + ". Proceeding with retry.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39541b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ w5 f39542c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(long j11, w5 w5Var) {
            super(0);
            this.f39541b = j11;
            this.f39542c = w5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Template request expired at time: " + this.f39541b + " and is not eligible for a response retry. Not retrying or performing any fallback triggers. " + this.f39542c;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w5(java.lang.String r17, bo.app.x5 r18, bo.app.w2 r19, bo.app.b2 r20, java.lang.String r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.lang.String r5 = "urlBase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "templatedTriggeredAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
            java.lang.String r5 = "triggerEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "brazeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            bo.app.v4 r5 = new bo.app.v4
            java.lang.String r6 = "template"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r6)
            r5.<init>((java.lang.String) r1)
            r0.<init>(r5)
            r0.f39528r = r2
            r0.f39529s = r3
            r0.f39530t = r4
            java.lang.String r1 = r18.z()
            r0.f39531u = r1
            bo.app.r2 r1 = r18.f()
            long r3 = r0.a((bo.app.r2) r1)
            r0.f39532v = r3
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MINUTES
            r5 = 1
            long r7 = r1.toMillis(r5)
            long r3 = java.lang.Math.min(r3, r7)
            r0.f39533w = r3
            long r7 = r18.A()
            r0.f39534x = r7
            r0.f39535y = r2
            bo.app.a4$a r1 = new bo.app.a4$a
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 15
            r15 = 0
            r9 = r1
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r2 = r21
            bo.app.a4$a r1 = r1.b((java.lang.String) r2)
            bo.app.a4 r1 = r1.a()
            r0.f39536z = r1
            bo.app.d1 r1 = new bo.app.d1
            int r2 = (int) r3
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            long r3 = r3.toMillis(r5)
            int r3 = (int) r3
            r1.<init>(r2, r3)
            r0.A = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.w5.<init>(java.lang.String, bo.app.x5, bo.app.w2, bo.app.b2, java.lang.String):void");
    }

    public void a(j2 j2Var, j2 j2Var2, d dVar) {
        IInAppMessage iInAppMessage;
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        m().c();
        if (dVar == null) {
            iInAppMessage = null;
        } else {
            iInAppMessage = dVar.i();
        }
        if (iInAppMessage != null) {
            dVar.i().setLocalPrefetchedAssetPaths(this.f39528r.y());
        } else {
            x();
        }
    }

    public boolean b() {
        return this.B;
    }

    public a4 c() {
        return this.f39536z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b A[Catch:{ JSONException -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject l() {
        /*
            r10 = this;
            org.json.JSONObject r0 = super.l()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "trigger_id"
            java.lang.String r4 = r10.f39531u     // Catch:{ JSONException -> 0x005d }
            r2.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x005d }
            java.lang.String r3 = "trigger_event_type"
            bo.app.w2 r4 = r10.f39529s     // Catch:{ JSONException -> 0x005d }
            java.lang.String r4 = r4.d()     // Catch:{ JSONException -> 0x005d }
            r2.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x005d }
            java.lang.String r3 = "data"
            bo.app.w2 r4 = r10.f39529s     // Catch:{ JSONException -> 0x005d }
            bo.app.x1 r4 = r4.a()     // Catch:{ JSONException -> 0x005d }
            if (r4 != 0) goto L_0x002b
            r4 = r1
            goto L_0x0031
        L_0x002b:
            java.lang.Object r4 = r4.forJsonPut()     // Catch:{ JSONException -> 0x005d }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ JSONException -> 0x005d }
        L_0x0031:
            r2.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x005d }
            java.lang.String r3 = "template"
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x005d }
            bo.app.a4 r2 = r10.c()     // Catch:{ JSONException -> 0x005d }
            if (r2 != 0) goto L_0x0040
            goto L_0x0048
        L_0x0040:
            boolean r2 = r2.z()     // Catch:{ JSONException -> 0x005d }
            r3 = 1
            if (r2 != r3) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            if (r3 == 0) goto L_0x005c
            java.lang.String r2 = "respond_with"
            bo.app.a4 r3 = r10.c()     // Catch:{ JSONException -> 0x005d }
            if (r3 != 0) goto L_0x0055
            r3 = r1
            goto L_0x0059
        L_0x0055:
            org.json.JSONObject r3 = r3.forJsonPut()     // Catch:{ JSONException -> 0x005d }
        L_0x0059:
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x005d }
        L_0x005c:
            return r0
        L_0x005d:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            bo.app.w5$d r7 = bo.app.w5.d.f39539b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.w5.l():org.json.JSONObject");
    }

    /* renamed from: t */
    public d1 m() {
        return this.A;
    }

    public final long u() {
        return this.f39534x;
    }

    public final w2 v() {
        return this.f39529s;
    }

    public final b3 w() {
        return this.f39535y;
    }

    public final void x() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) b.f39537b, 6, (Object) null);
        if (StringsKt__StringsJVMKt.isBlank(this.f39531u)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f39538b, 7, (Object) null);
            return;
        }
        try {
            x1 a11 = j.f38653h.a(this.f39531u, InAppMessageFailureType.TEMPLATE_REQUEST);
            if (a11 != null) {
                this.f39530t.a(a11);
            }
        } catch (JSONException e11) {
            this.f39530t.b((Throwable) e11);
        }
    }

    public void a(j2 j2Var, j2 j2Var2, q2 q2Var) {
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(q2Var, "responseError");
        super.a(j2Var, j2Var2, q2Var);
        x();
        if (q2Var instanceof g) {
            j2Var.a(new p6(this.f39529s, this.f39528r), p6.class);
        }
    }

    public boolean a(q2 q2Var) {
        Intrinsics.checkNotNullParameter(q2Var, "responseError");
        if (!(q2Var instanceof s3) && !(q2Var instanceof x4)) {
            return false;
        }
        long e11 = this.f39529s.e() + this.f39532v;
        if (DateTimeUtils.nowInMilliseconds() < e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new e(e11), 6, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(e11, this), 7, (Object) null);
        return false;
    }

    private final long a(r2 r2Var) {
        if (r2Var.a() == -1) {
            return TimeUnit.SECONDS.toMillis((long) (r2Var.g() + 30));
        }
        return (long) r2Var.a();
    }
}
