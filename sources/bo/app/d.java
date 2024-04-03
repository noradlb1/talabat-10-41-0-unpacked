package bo.app;

import com.braze.models.BrazeGeofence;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001%B=\u0012$\u00103\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\t02\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R)\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0002`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR\u0019\u0010'\u001a\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u0019\u0010.\u001a\u0004\u0018\u00010-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u0006:"}, d2 = {"Lbo/app/d;", "", "Lorg/json/JSONObject;", "jsonObject", "Lorg/json/JSONObject;", "g", "()Lorg/json/JSONObject;", "", "", "Lcom/braze/communication/HttpHeaders;", "httpHeaders", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "Lbo/app/z;", "contentCardsResponse", "Lbo/app/z;", "a", "()Lbo/app/z;", "Lcom/braze/models/inappmessage/IInAppMessage;", "templatedInAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "i", "()Lcom/braze/models/inappmessage/IInAppMessage;", "", "Lbo/app/b3;", "triggeredActions", "Ljava/util/List;", "j", "()Ljava/util/List;", "Lbo/app/c5;", "serverConfig", "Lbo/app/c5;", "h", "()Lbo/app/c5;", "Lcom/braze/models/BrazeGeofence;", "geofences", "e", "Lorg/json/JSONArray;", "featureFlagsData", "Lorg/json/JSONArray;", "c", "()Lorg/json/JSONArray;", "feedJson", "d", "Lbo/app/q2;", "error", "Lbo/app/q2;", "b", "()Lbo/app/q2;", "Lkotlin/Pair;", "responseData", "Lbo/app/c2;", "request", "Lbo/app/b2;", "brazeManager", "<init>", "(Lkotlin/Pair;Lbo/app/c2;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* renamed from: k  reason: collision with root package name */
    public static final e f38422k = new e((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f38423a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f38424b;

    /* renamed from: c  reason: collision with root package name */
    private final z f38425c;

    /* renamed from: d  reason: collision with root package name */
    private final IInAppMessage f38426d;

    /* renamed from: e  reason: collision with root package name */
    private final List<b3> f38427e;

    /* renamed from: f  reason: collision with root package name */
    private final c5 f38428f;

    /* renamed from: g  reason: collision with root package name */
    private final List<BrazeGeofence> f38429g;

    /* renamed from: h  reason: collision with root package name */
    private final JSONArray f38430h;

    /* renamed from: i  reason: collision with root package name */
    private final JSONArray f38431i;

    /* renamed from: j  reason: collision with root package name */
    private final q2 f38432j;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f38433b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(0);
            this.f38433b = dVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered Exception processing Content Cards response: ", this.f38433b.g());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f38434b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(0);
            this.f38434b = dVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found " + this.f38434b.j().size() + " triggered actions in server response.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38435b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(JSONObject jSONObject) {
            super(0);
            this.f38435b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Got server config: ", JsonUtils.getPrettyPrintedString(this.f38435b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.d$d  reason: collision with other inner class name */
    public static final class C0020d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f38436b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0020d(JSONObject jSONObject) {
            super(0);
            this.f38436b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered Exception processing server config: ", this.f38436b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Lbo/app/d$e;", "", "Lorg/json/JSONObject;", "jsonObject", "Lbo/app/c2;", "request", "Lbo/app/q2;", "a", "", "CONFIG_KEY", "Ljava/lang/String;", "ERROR_KEY", "FEATURE_FLAGS", "FEED_KEY", "GEOFENCES", "INVALID_API_KEY_ERROR_MESSAGE", "SDK_AUTH_ERROR_CODE_KEY", "SDK_AUTH_ERROR_KEY", "SDK_AUTH_ERROR_REASON_KEY", "TEMPLATED_MESSAGE_KEY", "TRIGGERS_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final q2 a(JSONObject jSONObject, c2 c2Var) {
            Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
            Intrinsics.checkNotNullParameter(c2Var, "request");
            String optionalString = JsonUtils.getOptionalString(jSONObject, "error");
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_error");
            if (optJSONObject != null) {
                return new x4(c2Var, optJSONObject.optInt("error_code", -1), JsonUtils.getOptionalString(optJSONObject, "reason"), optionalString);
            } else if (Intrinsics.areEqual((Object) optionalString, (Object) "invalid_api_key")) {
                return new k3(optionalString, c2Var);
            } else {
                if (optionalString != null) {
                    return new g(optionalString, c2Var);
                }
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0081 A[SYNTHETIC, Splitter:B:14:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(kotlin.Pair<? extends org.json.JSONObject, ? extends java.util.Map<java.lang.String, java.lang.String>> r11, bo.app.c2 r12, bo.app.b2 r13) {
        /*
            r10 = this;
            java.lang.String r0 = "responseData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "brazeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r10.<init>()
            java.lang.Object r0 = r11.getFirst()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r10.f38423a = r0
            java.lang.Object r11 = r11.getSecond()
            java.util.Map r11 = (java.util.Map) r11
            r10.f38424b = r11
            java.lang.String r11 = "feed"
            org.json.JSONArray r11 = r0.optJSONArray(r11)
            r10.f38431i = r11
            bo.app.d$e r11 = f38422k
            bo.app.q2 r11 = r11.a(r0, r12)
            r10.f38432j = r11
            r1 = 0
            if (r11 != 0) goto L_0x0051
            boolean r11 = r12 instanceof bo.app.b0
            if (r11 == 0) goto L_0x0051
            bo.app.z r11 = new bo.app.z     // Catch:{ Exception -> 0x003f }
            r11.<init>((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x003f }
            goto L_0x0052
        L_0x003f:
            r11 = move-exception
            r5 = r11
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            bo.app.d$a r7 = new bo.app.d$a
            r7.<init>(r10)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x0051:
            r11 = r1
        L_0x0052:
            r10.f38425c = r11
            org.json.JSONObject r11 = r10.f38423a
            java.lang.String r12 = "triggers"
            org.json.JSONArray r11 = r11.optJSONArray(r12)
            bo.app.m6 r12 = bo.app.m6.f38991a
            java.util.List r11 = r12.a((org.json.JSONArray) r11, (bo.app.b2) r13)
            r10.f38427e = r11
            if (r11 == 0) goto L_0x0077
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.V
            bo.app.d$b r7 = new bo.app.d$b
            r7.<init>(r10)
            r5 = 0
            r6 = 0
            r8 = 6
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x0077:
            org.json.JSONObject r11 = r10.f38423a
            java.lang.String r12 = "config"
            org.json.JSONObject r11 = r11.optJSONObject(r12)
            if (r11 == 0) goto L_0x00b0
            bo.app.c5 r12 = new bo.app.c5     // Catch:{ Exception -> 0x009b }
            r12.<init>(r11)     // Catch:{ Exception -> 0x009b }
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0098 }
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.V     // Catch:{ Exception -> 0x0098 }
            r5 = 0
            r6 = 0
            bo.app.d$c r7 = new bo.app.d$c     // Catch:{ Exception -> 0x0098 }
            r7.<init>(r11)     // Catch:{ Exception -> 0x0098 }
            r8 = 6
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00b1
        L_0x0098:
            r0 = move-exception
            r5 = r0
            goto L_0x009f
        L_0x009b:
            r12 = move-exception
            r0 = r12
            r5 = r0
            r12 = r1
        L_0x009f:
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.W
            bo.app.d$d r7 = new bo.app.d$d
            r7.<init>(r11)
            r6 = 0
            r8 = 4
            r9 = 0
            r3 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            goto L_0x00b1
        L_0x00b0:
            r12 = r1
        L_0x00b1:
            r10.f38428f = r12
            org.json.JSONObject r11 = r10.f38423a
            java.lang.String r12 = "templated_message"
            org.json.JSONObject r11 = r11.optJSONObject(r12)
            bo.app.m6 r12 = bo.app.m6.f38991a
            com.braze.models.inappmessage.IInAppMessage r11 = r12.a((org.json.JSONObject) r11, (bo.app.b2) r13)
            r10.f38426d = r11
            org.json.JSONObject r11 = r10.f38423a
            java.lang.String r12 = "geofences"
            org.json.JSONArray r11 = r11.optJSONArray(r12)
            if (r11 == 0) goto L_0x00d1
            java.util.List r1 = bo.app.l1.a(r11)
        L_0x00d1:
            r10.f38429g = r1
            org.json.JSONObject r11 = r10.f38423a
            java.lang.String r12 = "feature_flags"
            org.json.JSONArray r11 = r11.optJSONArray(r12)
            r10.f38430h = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.d.<init>(kotlin.Pair, bo.app.c2, bo.app.b2):void");
    }

    public final z a() {
        return this.f38425c;
    }

    public final q2 b() {
        return this.f38432j;
    }

    public final JSONArray c() {
        return this.f38430h;
    }

    public final JSONArray d() {
        return this.f38431i;
    }

    public final List<BrazeGeofence> e() {
        return this.f38429g;
    }

    public final Map<String, String> f() {
        return this.f38424b;
    }

    public final JSONObject g() {
        return this.f38423a;
    }

    public final c5 h() {
        return this.f38428f;
    }

    public final IInAppMessage i() {
        return this.f38426d;
    }

    public final List<b3> j() {
        return this.f38427e;
    }
}
