package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0017J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"Lbo/app/k0;", "Lbo/app/a;", "Lbo/app/j0;", "newDevice", "", "a", "e", "f", "outboundObject", "", "isSuccessful", "Landroid/content/Context;", "context", "", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class k0 extends a<j0> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f38764e = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final BrazeConfigurationProvider f38765b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f38766c;

    /* renamed from: d  reason: collision with root package name */
    private j0 f38767d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/k0$a;", "", "", "CACHED_DEVICE_KEY", "Ljava/lang/String;", "getCACHED_DEVICE_KEY$annotations", "()V", "FILE_PREFIX_V3", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38768b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception confirming and unlocking device cache.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38769b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device object cache cleared.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38770b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception confirming and unlocking Json objects.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f38771b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught json exception creating dirty outbound device on a jsonObject value. Returning the whole device.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38772b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught json exception creating dirty outbound device. Returning the whole device.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f38773b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Sending full device due to NOTIFICATIONS_ENABLED true";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(Context context, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }

    public final void a(j0 j0Var) {
        this.f38767d = j0Var;
    }

    public final void e() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) c.f38769b, 6, (Object) null);
        this.f38766c.edit().clear().apply();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r2.hasNext() == true) goto L_0x004d;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bo.app.j0 d() {
        /*
            r15 = this;
            java.lang.String r0 = "{}"
            bo.app.j0 r1 = r15.f38767d
            r2 = 0
            if (r1 != 0) goto L_0x000a
            r1 = r2
            goto L_0x000e
        L_0x000a:
            org.json.JSONObject r1 = r1.forJsonPut()
        L_0x000e:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026 }
            android.content.SharedPreferences r5 = r15.f38766c     // Catch:{ JSONException -> 0x0026 }
            java.lang.String r6 = "cached_device"
            java.lang.String r5 = r5.getString(r6, r0)     // Catch:{ JSONException -> 0x0026 }
            if (r5 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r5
        L_0x0021:
            r4.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0026 }
            r3 = r4
            goto L_0x0035
        L_0x0026:
            r0 = move-exception
            r7 = r0
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.E
            bo.app.k0$d r9 = bo.app.k0.d.f38770b
            r8 = 0
            r10 = 4
            r11 = 0
            r5 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
        L_0x0035:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r1 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            java.util.Iterator r2 = r1.keys()
        L_0x0041:
            if (r2 != 0) goto L_0x0044
            goto L_0x004c
        L_0x0044:
            boolean r4 = r2.hasNext()
            r5 = 1
            if (r4 != r5) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            if (r5 == 0) goto L_0x00a2
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r1.opt(r4)
            java.lang.Object r6 = r3.opt(r4)
            if (r5 != 0) goto L_0x0060
            goto L_0x0041
        L_0x0060:
            boolean r7 = r5 instanceof org.json.JSONObject
            if (r7 == 0) goto L_0x0087
            if (r6 == 0) goto L_0x0071
            r7 = r5
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0075 }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x0075 }
            boolean r6 = com.braze.support.JsonUtils.areJsonObjectsEqual(r7, r6)     // Catch:{ JSONException -> 0x0075 }
            if (r6 != 0) goto L_0x0041
        L_0x0071:
            r0.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0075 }
            goto L_0x0041
        L_0x0075:
            r0 = move-exception
            r4 = r0
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.k0$e r6 = bo.app.k0.e.f38771b
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            bo.app.j0 r0 = r15.f38767d
            return r0
        L_0x0087:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r6 != 0) goto L_0x0041
            r0.put((java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0041
        L_0x0091:
            r10 = move-exception
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.E
            bo.app.k0$f r12 = bo.app.k0.f.f38772b
            r11 = 0
            r13 = 4
            r14 = 0
            r8 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (boolean) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)
            bo.app.j0 r0 = r15.f38767d
            return r0
        L_0x00a2:
            if (r1 == 0) goto L_0x00c7
            com.appboy.enums.DeviceKey r2 = com.appboy.enums.DeviceKey.NOTIFICATIONS_ENABLED
            java.lang.String r2 = r2.getKey()
            boolean r2 = r0.optBoolean(r2)
            if (r2 == 0) goto L_0x00c7
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.V
            bo.app.k0$g r8 = bo.app.k0.g.f38773b
            r6 = 0
            r7 = 0
            r9 = 6
            r10 = 0
            r4 = r15
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
            bo.app.j0$b r0 = bo.app.j0.f38714m
            com.braze.configuration.BrazeConfigurationProvider r2 = r15.f38765b
            bo.app.j0 r0 = r0.a(r2, r1)
            goto L_0x00cf
        L_0x00c7:
            bo.app.j0$b r1 = bo.app.j0.f38714m
            com.braze.configuration.BrazeConfigurationProvider r2 = r15.f38765b
            bo.app.j0 r0 = r1.a(r2, r0)
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.k0.d():bo.app.j0");
    }

    public k0(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f38765b = new BrazeConfigurationProvider(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.device_cache.v3", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f38766c = sharedPreferences;
    }

    /* renamed from: a */
    public void b(j0 j0Var, boolean z11) {
        String str = "{}";
        Intrinsics.checkNotNullParameter(j0Var, "outboundObject");
        if (z11) {
            try {
                String string = this.f38766c.getString("cached_device", str);
                if (string != null) {
                    str = string;
                }
                JSONObject jSONObject = new JSONObject(str);
                JSONObject w11 = j0Var.forJsonPut();
                SharedPreferences.Editor edit = this.f38766c.edit();
                JSONObject mergeJsonObjects = JsonUtils.mergeJsonObjects(jSONObject, w11);
                edit.putString("cached_device", !(mergeJsonObjects instanceof JSONObject) ? mergeJsonObjects.toString() : JSONObjectInstrumentation.toString(mergeJsonObjects));
                edit.apply();
            } catch (JSONException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f38768b, 4, (Object) null);
            }
        }
    }
}
