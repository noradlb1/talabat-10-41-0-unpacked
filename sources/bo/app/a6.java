package bo.app;

import com.braze.support.BrazeLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB/\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\f\"\u0004\b\b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u000e8\u0016XD¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lbo/app/a6;", "Lbo/app/r;", "Lbo/app/j2;", "internalPublisher", "externalPublisher", "Lbo/app/d;", "apiResponse", "", "a", "", "userId", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "", "b", "()Z", "containsNoNewData", "doesSendOptionalData", "Z", "g", "Lorg/json/JSONObject;", "l", "()Lorg/json/JSONObject;", "payload", "urlBase", "", "deviceLogs", "", "logCreationTime", "<init>", "(Ljava/lang/String;Ljava/util/List;JLjava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class a6 extends r {

    /* renamed from: v  reason: collision with root package name */
    public static final a f38279v = new a((DefaultConstructorMarker) null);

    /* renamed from: r  reason: collision with root package name */
    private final List<String> f38280r;

    /* renamed from: s  reason: collision with root package name */
    private final long f38281s;

    /* renamed from: t  reason: collision with root package name */
    private String f38282t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f38283u = true;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lbo/app/a6$a;", "", "", "DEVICE_LOGS_CREATION_TIME_KEY", "Ljava/lang/String;", "DEVICE_LOGS_DATA_KEY", "DEVICE_LOGS_USER_ID_KEY", "TEST_USER_DATA_OBJECT_KEY", "URL_EXTENSION", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38284b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "TestUserDeviceLog executed successfully.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38285b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced JSONException while retrieving parameters. Returning null.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a6(String str, List<String> list, long j11, String str2) {
        super(new v4(Intrinsics.stringPlus(str, "data")));
        Intrinsics.checkNotNullParameter(str, "urlBase");
        Intrinsics.checkNotNullParameter(list, "deviceLogs");
        this.f38280r = list;
        this.f38281s = j11;
        this.f38282t = str2;
    }

    public String a() {
        return this.f38282t;
    }

    public boolean b() {
        return this.f38280r.isEmpty() && super.b();
    }

    public boolean g() {
        return this.f38283u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[Catch:{ JSONException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A[Catch:{ JSONException -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject l() {
        /*
            r10 = this;
            org.json.JSONObject r0 = super.l()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0051 }
            r2.<init>()     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r3 = "time"
            long r4 = r10.f38281s     // Catch:{ JSONException -> 0x0051 }
            r2.put((java.lang.String) r3, (long) r4)     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r3 = r10.a()     // Catch:{ JSONException -> 0x0051 }
            if (r3 == 0) goto L_0x0023
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r3)     // Catch:{ JSONException -> 0x0051 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r3 = 0
            goto L_0x0024
        L_0x0023:
            r3 = 1
        L_0x0024:
            if (r3 != 0) goto L_0x002f
            java.lang.String r3 = "user_id"
            java.lang.String r4 = r10.a()     // Catch:{ JSONException -> 0x0051 }
            r2.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x0051 }
        L_0x002f:
            java.util.List<java.lang.String> r3 = r10.f38280r     // Catch:{ JSONException -> 0x0051 }
            boolean r3 = r3.isEmpty()     // Catch:{ JSONException -> 0x0051 }
            if (r3 != 0) goto L_0x0043
            java.lang.String r3 = "device_logs"
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0051 }
            java.util.List<java.lang.String> r5 = r10.f38280r     // Catch:{ JSONException -> 0x0051 }
            r4.<init>((java.util.Collection<?>) r5)     // Catch:{ JSONException -> 0x0051 }
            r2.put((java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ JSONException -> 0x0051 }
        L_0x0043:
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0051 }
            r3.<init>()     // Catch:{ JSONException -> 0x0051 }
            r3.put((java.lang.Object) r2)     // Catch:{ JSONException -> 0x0051 }
            java.lang.String r2 = "test_user_data"
            r0.put((java.lang.String) r2, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0051 }
            return r0
        L_0x0051:
            r0 = move-exception
            r5 = r0
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.a6$c r7 = bo.app.a6.c.f38285b
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.a6.l():org.json.JSONObject");
    }

    public void a(String str) {
        this.f38282t = str;
    }

    public void a(j2 j2Var, j2 j2Var2, d dVar) {
        Intrinsics.checkNotNullParameter(j2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(j2Var2, "externalPublisher");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f38284b, 7, (Object) null);
    }
}
