package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.events.FeatureFlagsUpdatedEvent;
import com.braze.models.FeatureFlag;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB'\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0012¨\u0006\u001d"}, d2 = {"Lbo/app/e1;", "", "", "b", "d", "c", "()V", "Lorg/json/JSONArray;", "featureFlagsData", "Lcom/braze/events/FeatureFlagsUpdatedEvent;", "a", "(Lorg/json/JSONArray;)Lcom/braze/events/FeatureFlagsUpdatedEvent;", "", "id", "", "Lcom/braze/models/FeatureFlag;", "(Ljava/lang/String;)Ljava/util/List;", "", "()J", "timestampLastRefresh", "Landroid/content/Context;", "context", "apiKey", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/b2;", "brazeManager", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/e5;Lbo/app/b2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class e1 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f38467f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final e5 f38468a;

    /* renamed from: b  reason: collision with root package name */
    private final b2 f38469b;

    /* renamed from: c  reason: collision with root package name */
    private List<FeatureFlag> f38470c = CollectionsKt__CollectionsKt.emptyList();

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f38471d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f38472e;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u0012\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lbo/app/e1$a;", "", "", "FEATURE_FLAGS_ELIGIBILITY_SHARED_PREFS", "Ljava/lang/String;", "FEATURE_FLAGS_STORAGE_SHARED_PREFS", "LAST_REFRESH_IN_SECONDS", "getLAST_REFRESH_IN_SECONDS$annotations", "()V", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        public static final b f38473b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did not find stored feature flags.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38474b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to find stored feature flag keys.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38475b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f38475b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank serialized feature flag string for feature flag id " + this.f38475b + " from shared preferences. Not parsing.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38476b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38476b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Encountered unexpected exception while parsing stored feature flags: ", this.f38476b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38477b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not enough time has passed since last feature flags refresh. Not refreshing feature flags.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeatureFlag f38478b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(FeatureFlag featureFlag) {
            super(0);
            this.f38478b = featureFlag;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error storing feature flag: " + this.f38478b + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38479b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Added new feature flags to local storage.";
        }
    }

    public e1(Context context, String str, e5 e5Var, b2 b2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        this.f38468a = e5Var;
        this.f38469b = b2Var;
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.braze.managers.featureflags.eligibility.", str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f38471d = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(Intrinsics.stringPlus("com.braze.managers.featureflags.storage.", str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f38472e = sharedPreferences2;
        b();
    }

    private final long a() {
        return this.f38471d.getLong("last_refresh", 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A[Catch:{ Exception -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[Catch:{ Exception -> 0x0074 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b() {
        /*
            r16 = this;
            r9 = r16
            android.content.SharedPreferences r0 = r9.f38472e
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Map r11 = r0.getAll()
            r12 = 0
            r13 = 1
            if (r11 == 0) goto L_0x001a
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = r12
            goto L_0x001b
        L_0x001a:
            r0 = r13
        L_0x001b:
            if (r0 == 0) goto L_0x0032
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.e1$b r6 = bo.app.e1.b.f38473b
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r2 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r9.f38470c = r0
            return
        L_0x0032:
            java.util.Set r0 = r11.keySet()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0052
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.e1$c r6 = bo.app.e1.c.f38474b
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r9.f38470c = r0
            return
        L_0x0052:
            java.util.Iterator r14 = r0.iterator()
        L_0x0056:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r0 = r14.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r11.get(r0)
            r15 = r1
            java.lang.String r15 = (java.lang.String) r15
            if (r15 == 0) goto L_0x0077
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r15)     // Catch:{ Exception -> 0x0074 }
            if (r1 == 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            r1 = r12
            goto L_0x0078
        L_0x0074:
            r0 = move-exception
            r4 = r0
            goto L_0x009f
        L_0x0077:
            r1 = r13
        L_0x0078:
            if (r1 == 0) goto L_0x008d
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0074 }
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0074 }
            r4 = 0
            r5 = 0
            bo.app.e1$d r6 = new bo.app.e1$d     // Catch:{ Exception -> 0x0074 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x0074 }
            r7 = 6
            r8 = 0
            r2 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0056
        L_0x008d:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0074 }
            r0.<init>((java.lang.String) r15)     // Catch:{ Exception -> 0x0074 }
            bo.app.h1 r1 = bo.app.h1.f38603a     // Catch:{ Exception -> 0x0074 }
            com.braze.models.FeatureFlag r0 = r1.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x0074 }
            if (r0 != 0) goto L_0x009b
            goto L_0x0056
        L_0x009b:
            r10.add(r0)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0056
        L_0x009f:
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.e1$e r6 = new bo.app.e1$e
            r6.<init>(r15)
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r16
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            goto L_0x0056
        L_0x00b1:
            r9.f38470c = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.e1.b():void");
    }

    public final void c() {
        this.f38471d.edit().putLong("last_refresh", DateTimeUtils.nowInSeconds()).apply();
        this.f38469b.refreshFeatureFlags();
    }

    public final void d() {
        if (DateTimeUtils.nowInSeconds() - a() < ((long) this.f38468a.f())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) f.f38477b, 6, (Object) null);
            return;
        }
        c();
    }

    public final FeatureFlagsUpdatedEvent a(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsData");
        this.f38470c = h1.f38603a.a(jSONArray);
        SharedPreferences.Editor edit = this.f38472e.edit();
        edit.clear();
        for (FeatureFlag next : this.f38470c) {
            try {
                String id2 = next.getId();
                JSONObject forJsonPut = next.forJsonPut();
                edit.putString(id2, !(forJsonPut instanceof JSONObject) ? forJsonPut.toString() : JSONObjectInstrumentation.toString(forJsonPut));
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new g(next), 4, (Object) null);
            }
        }
        edit.apply();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f38479b, 7, (Object) null);
        List<FeatureFlag> list = this.f38470c;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (FeatureFlag deepcopy$android_sdk_base_release : list) {
            arrayList.add(deepcopy$android_sdk_base_release.deepcopy$android_sdk_base_release());
        }
        return new FeatureFlagsUpdatedEvent(arrayList);
    }

    public static /* synthetic */ List a(e1 e1Var, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return e1Var.a(str);
    }

    public final List<FeatureFlag> a(String str) {
        List<FeatureFlag> list;
        if (str != null) {
            List<FeatureFlag> list2 = this.f38470c;
            list = new ArrayList<>();
            for (FeatureFlag next : list2) {
                if (Intrinsics.areEqual((Object) next.getId(), (Object) str)) {
                    list.add(next);
                }
            }
        } else {
            list = this.f38470c;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (FeatureFlag deepcopy$android_sdk_base_release : list) {
            arrayList.add(deepcopy$android_sdk_base_release.deepcopy$android_sdk_base_release());
        }
        return arrayList;
    }
}
