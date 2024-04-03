package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.IntentUtils;
import com.braze.support.WebContentUtils;
import com.visa.checkout.Profile;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\nH\u0007R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f8AX\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0015"}, d2 = {"Lbo/app/c6;", "Lbo/app/u2;", "", "Lbo/app/b3;", "triggeredActions", "", "a", "triggeredAction", "", "", "Lbo/app/o4;", "remotePath", "", "remoteToLocalAssetsMap", "Ljava/util/Map;", "()Ljava/util/Map;", "Landroid/content/Context;", "context", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class c6 implements u2 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f38383e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f38384a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f38385b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f38386c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private final File f38387d;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38404a;

        static {
            int[] iArr = new int[p4.values().length];
            iArr[p4.ZIP.ordinal()] = 1;
            iArr[p4.f39180c.ordinal()] = 2;
            iArr[p4.FILE.ordinal()] = 3;
            f38404a = iArr;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38405b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38406c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, String str2) {
            super(0);
            this.f38405b = str;
            this.f38406c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storing local triggered action html zip asset at local path " + this.f38405b + " for remote path " + this.f38406c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38407b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(0);
            this.f38407b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to store html zip asset for remote path " + this.f38407b + ". Not storing local asset";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38408b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38408b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not download ", this.f38408b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38409b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map<String, String> f38410c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str, Map<String, String> map) {
            super(0);
            this.f38409b = str;
            this.f38410c = map;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not caching " + this.f38409b + " due to headers " + this.f38410c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f38411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38412c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Uri uri, String str) {
            super(0);
            this.f38411b = uri;
            this.f38412c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storing local triggered action asset at local path " + this.f38411b.getPath() + " for remote path " + this.f38412c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38413b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.f38413b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to store asset for remote path " + this.f38413b + ". Not storing local asset";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38414b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b3 b3Var) {
            super(0);
            this.f38414b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Prefetch is turned off for this triggered action. Not retrieving local asset paths. Action id: ", this.f38414b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38415b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38416c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str, String str2) {
            super(0);
            this.f38415b = str;
            this.f38416c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found local asset at path " + this.f38415b + " for remote asset at path: " + this.f38416c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38417b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str) {
            super(0);
            this.f38417b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Could not find local asset for remote path ", this.f38417b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f38418b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b3 b3Var) {
            super(0);
            this.f38418b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("No local assets found for action id: ", this.f38418b.getId());
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38419b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38420c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str, String str2) {
            super(0);
            this.f38419b = str;
            this.f38420c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding new local path '" + this.f38419b + "' for remote path '" + this.f38420c + "' to cache.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38421b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f38421b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to add new local path for remote path ", this.f38421b);
        }
    }

    public c6(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.triggers.local_assets.", str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.f38384a = sharedPreferences;
        this.f38385b = f38383e.a(sharedPreferences);
        this.f38387d = new File(Intrinsics.stringPlus(context.getCacheDir().getPath(), "/ab_triggers"));
    }

    public final Map<String, String> a() {
        return this.f38385b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<? extends bo.app.b3> r13) {
        /*
            r12 = this;
            java.lang.String r0 = "triggeredActions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            bo.app.c6$a r0 = f38383e
            kotlin.Pair r13 = r0.a((java.util.List<? extends bo.app.b3>) r13)
            java.lang.Object r1 = r13.component1()
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r13 = r13.component2()
            java.util.Set r13 = (java.util.Set) r13
            android.content.SharedPreferences r2 = r12.f38384a
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "localAssetEditor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.util.Map<java.lang.String, java.lang.String> r3 = r12.f38385b
            java.util.Map<java.lang.String, java.lang.String> r4 = r12.f38386c
            r0.a(r2, r3, r13, r4)
            java.io.File r13 = r12.f38387d
            java.util.Map<java.lang.String, java.lang.String> r3 = r12.f38385b
            java.util.Map<java.lang.String, java.lang.String> r4 = r12.f38386c
            r0.a(r13, r3, r4)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r0 = r1.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()
            r3 = r1
            bo.app.o4 r3 = (bo.app.o4) r3
            java.util.Map r4 = r12.a()
            java.lang.String r3 = r3.b()
            boolean r3 = r4.containsKey(r3)
            if (r3 != 0) goto L_0x003b
            r13.add(r1)
            goto L_0x003b
        L_0x005a:
            java.util.Iterator r13 = r13.iterator()
        L_0x005e:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x00ae
            java.lang.Object r0 = r13.next()
            bo.app.o4 r0 = (bo.app.o4) r0
            java.lang.String r1 = r0.b()
            java.lang.String r0 = r12.a((bo.app.o4) r0)     // Catch:{ Exception -> 0x009b }
            if (r0 == 0) goto L_0x007d
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)     // Catch:{ Exception -> 0x009b }
            if (r3 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r3 = 0
            goto L_0x007e
        L_0x007d:
            r3 = 1
        L_0x007e:
            if (r3 != 0) goto L_0x005e
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x009b }
            r6 = 0
            r7 = 0
            r8 = 0
            bo.app.c6$m r9 = new bo.app.c6$m     // Catch:{ Exception -> 0x009b }
            r9.<init>(r0, r1)     // Catch:{ Exception -> 0x009b }
            r10 = 7
            r11 = 0
            r5 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (boolean) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x009b }
            java.util.Map r3 = r12.a()     // Catch:{ Exception -> 0x009b }
            r3.put(r1, r0)     // Catch:{ Exception -> 0x009b }
            r2.putString(r1, r0)     // Catch:{ Exception -> 0x009b }
            goto L_0x005e
        L_0x009b:
            r0 = move-exception
            r6 = r0
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.E
            bo.app.c6$n r8 = new bo.app.c6$n
            r8.<init>(r1)
            r7 = 0
            r9 = 4
            r10 = 0
            r4 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (boolean) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
            goto L_0x005e
        L_0x00ae:
            r2.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.c6.a(java.util.List):void");
    }

    @Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J8\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0007J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007JF\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0007J.\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b0\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0007J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0007R\u0014\u0010\u001f\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006%"}, d2 = {"Lbo/app/c6$a;", "", "Landroid/content/Context;", "context", "", "a", "Ljava/io/File;", "triggeredAssetDirectory", "", "", "remoteToLocalAssetsMap", "preservedLocalAssetMap", "Landroid/content/SharedPreferences;", "storagePrefs", "", "Landroid/content/SharedPreferences$Editor;", "editor", "localAssetPaths", "", "newRemotePathStrings", "preservedLocalAssetPathMap", "path", "", "", "Lbo/app/b3;", "triggeredActions", "Lkotlin/Pair;", "", "Lbo/app/o4;", "remoteAssetUrl", "b", "EXPIRES_HEADER", "Ljava/lang/String;", "LOCAL_ASSETS_FILE_PREFIX", "TRIGGERS_ASSETS_FOLDER", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.c6$a$a  reason: collision with other inner class name */
        public static final class C0018a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File[] f38388b;

            @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/io/File;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/io/File;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
            /* renamed from: bo.app.c6$a$a$a  reason: collision with other inner class name */
            public static final class C0019a extends Lambda implements Function1<File, CharSequence> {

                /* renamed from: b  reason: collision with root package name */
                public static final C0019a f38389b = new C0019a();

                public C0019a() {
                    super(1);
                }

                /* renamed from: a */
                public final CharSequence invoke(File file) {
                    String name2 = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                    return name2;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0018a(File[] fileArr) {
                super(0);
                this.f38388b = fileArr;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Local triggered asset directory contains files: ", ArraysKt___ArraysKt.joinToString$default((Object[]) this.f38388b, (CharSequence) " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) C0019a.f38389b, 30, (Object) null));
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f38390b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(File file) {
                super(0);
                this.f38390b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Deleting obsolete asset '" + this.f38390b.getPath() + "' from filesystem.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class c extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            public static final c f38391b = new c();

            public c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while deleting obsolete assets from filesystem.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class d extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38392b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str) {
                super(0);
                this.f38392b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Not removing local path for remote path " + this.f38392b + " from cache because it is being preserved until the end of the app run.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class e extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38393b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38394c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(String str, String str2) {
                super(0);
                this.f38393b = str;
                this.f38394c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Removing obsolete local path " + this.f38393b + " for obsolete remote path " + this.f38394c + " from cache.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class f extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ File f38395b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(File file) {
                super(0);
                this.f38395b = file;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Deleting triggers directory at: ", this.f38395b.getAbsolutePath());
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class g extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<String> f38396b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38397c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public g(Ref.ObjectRef<String> objectRef, String str) {
                super(0);
                this.f38396b = objectRef;
                this.f38397c = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Using file extension " + ((String) this.f38396b.element) + " for remote asset url: " + this.f38397c;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class h extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38398b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38399c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public h(String str, String str2) {
                super(0);
                this.f38398b = str;
                this.f38399c = str2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Retrieving trigger local asset path '" + this.f38398b + "' from local storage for remote path '" + this.f38399c + '\'';
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class i extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f38400b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public i(String str) {
                super(0);
                this.f38400b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Encountered unexpected exception while parsing stored triggered action local assets on remote asset '" + this.f38400b + '\'';
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class j extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b3 f38401b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public j(b3 b3Var) {
                super(0);
                this.f38401b = b3Var;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Pre-fetch off for triggered action " + this.f38401b.getId() + ". Not pre-fetching assets.";
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class k extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b3 f38402b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f38403c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public k(b3 b3Var, String str) {
                super(0);
                this.f38402b = b3Var;
                this.f38403c = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received new remote path for triggered action " + this.f38402b.getId() + " at " + this.f38403c + '.';
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getCacheDir(), "ab_triggers");
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new f(file), 6, (Object) null);
            BrazeFileUtils.deleteFileOrDirectory(file);
        }

        public final String b(String str) {
            boolean z11;
            int lastIndexOf$default;
            Intrinsics.checkNotNullParameter(str, "remoteAssetUrl");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String lastPathSegment = parse.getLastPathSegment();
                if (lastPathSegment == null || lastPathSegment.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11 && (lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) lastPathSegment, '.', 0, false, 6, (Object) null)) > -1) {
                    T substring = lastPathSegment.substring(lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    objectRef.element = substring;
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) c6.f38383e, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new g(objectRef, str), 6, (Object) null);
                }
            }
            return IntentUtils.getRequestCode() + ((String) objectRef.element);
        }

        public final void a(File file, Map<String, String> map, Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(file, "triggeredAssetDirectory");
            Intrinsics.checkNotNullParameter(map, "remoteToLocalAssetsMap");
            Intrinsics.checkNotNullParameter(map2, "preservedLocalAssetMap");
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new C0018a(listFiles), 6, (Object) null);
                try {
                    ArrayList arrayList = new ArrayList();
                    int length = listFiles.length;
                    int i11 = 0;
                    while (i11 < length) {
                        File file2 = listFiles[i11];
                        i11++;
                        if (!map.containsValue(file2.getPath())) {
                            arrayList.add(file2);
                        }
                    }
                    ArrayList<File> arrayList2 = new ArrayList<>();
                    for (Object next : arrayList) {
                        if (!map2.containsValue(((File) next).getPath())) {
                            arrayList2.add(next);
                        }
                    }
                    for (File file3 : arrayList2) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) c6.f38383e, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(file3), 7, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(file3, "obsoleteFile");
                        BrazeFileUtils.deleteFileOrDirectory(file3);
                    }
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) c.f38391b, 4, (Object) null);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[Catch:{ Exception -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0029 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.Map<java.lang.String, java.lang.String> a(android.content.SharedPreferences r17) {
            /*
                r16 = this;
                r1 = r17
                java.lang.String r0 = "storagePrefs"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                j$.util.concurrent.ConcurrentHashMap r2 = new j$.util.concurrent.ConcurrentHashMap
                r2.<init>()
                java.util.Map r0 = r17.getAll()
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L_0x001d
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r5 = r3
                goto L_0x001e
            L_0x001d:
                r5 = r4
            L_0x001e:
                if (r5 == 0) goto L_0x0021
                return r2
            L_0x0021:
                java.util.Set r0 = r0.keySet()
                java.util.Iterator r5 = r0.iterator()
            L_0x0029:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0077
                java.lang.Object r0 = r5.next()
                r6 = r0
                java.lang.String r6 = (java.lang.String) r6
                r0 = 0
                java.lang.String r0 = r1.getString(r6, r0)     // Catch:{ Exception -> 0x0063 }
                if (r0 == 0) goto L_0x0046
                boolean r7 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)     // Catch:{ Exception -> 0x0063 }
                if (r7 == 0) goto L_0x0044
                goto L_0x0046
            L_0x0044:
                r7 = r3
                goto L_0x0047
            L_0x0046:
                r7 = r4
            L_0x0047:
                if (r7 != 0) goto L_0x0029
                com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0063 }
                r10 = 0
                r11 = 0
                r12 = 0
                bo.app.c6$a$h r13 = new bo.app.c6$a$h     // Catch:{ Exception -> 0x0063 }
                r13.<init>(r0, r6)     // Catch:{ Exception -> 0x0063 }
                r14 = 7
                r15 = 0
                r9 = r16
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.Object) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)     // Catch:{ Exception -> 0x0063 }
                java.lang.String r7 = "remoteAssetKey"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ Exception -> 0x0063 }
                r2.put(r6, r0)     // Catch:{ Exception -> 0x0063 }
                goto L_0x0029
            L_0x0063:
                r0 = move-exception
                r11 = r0
                com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r10 = com.braze.support.BrazeLogger.Priority.E
                bo.app.c6$a$i r13 = new bo.app.c6$a$i
                r13.<init>(r6)
                r12 = 0
                r14 = 4
                r15 = 0
                r9 = r16
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.Object) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (boolean) r12, (kotlin.jvm.functions.Function0) r13, (int) r14, (java.lang.Object) r15)
                goto L_0x0029
            L_0x0077:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.c6.a.a(android.content.SharedPreferences):java.util.Map");
        }

        public final void a(SharedPreferences.Editor editor, Map<String, String> map, Set<String> set, Map<String, String> map2) {
            SharedPreferences.Editor editor2 = editor;
            Map<String, String> map3 = map;
            Set<String> set2 = set;
            Map<String, String> map4 = map2;
            Intrinsics.checkNotNullParameter(editor2, "editor");
            Intrinsics.checkNotNullParameter(map3, "localAssetPaths");
            Intrinsics.checkNotNullParameter(set2, "newRemotePathStrings");
            Intrinsics.checkNotNullParameter(map4, "preservedLocalAssetPathMap");
            Iterator it = new HashSet(map.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (map4.containsKey(str)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(str), 7, (Object) null);
                } else if (!set2.contains(str)) {
                    map3.remove(str);
                    editor2.remove(str);
                    String str2 = map3.get(str);
                    if (!(str2 == null || StringsKt__StringsJVMKt.isBlank(str2))) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(str2, str), 7, (Object) null);
                        BrazeFileUtils.deleteFileOrDirectory(new File(str2));
                    }
                }
            }
        }

        public final boolean a(String str) {
            Intrinsics.checkNotNullParameter(str, "path");
            return new File(str).exists();
        }

        public final Pair<Set<o4>, Set<String>> a(List<? extends b3> list) {
            Intrinsics.checkNotNullParameter(list, "triggeredActions");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            for (b3 b3Var : list) {
                if (!b3Var.m()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(b3Var), 7, (Object) null);
                } else {
                    for (o4 next : b3Var.b()) {
                        String b11 = next.b();
                        if (!StringsKt__StringsJVMKt.isBlank(b11)) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new k(b3Var, b11), 7, (Object) null);
                            linkedHashSet.add(next);
                            linkedHashSet2.add(b11);
                        }
                    }
                }
            }
            return new Pair<>(linkedHashSet, linkedHashSet2);
        }
    }

    public Map<String, String> a(b3 b3Var) {
        Intrinsics.checkNotNullParameter(b3Var, "triggeredAction");
        if (!b3Var.m()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(b3Var), 7, (Object) null);
            return MapsKt__MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (o4 b11 : b3Var.b()) {
            String b12 = b11.b();
            String str = this.f38385b.get(b12);
            if (str == null || !f38383e.a(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new k(b12), 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(str, b12), 7, (Object) null);
                this.f38386c.put(b12, str);
                linkedHashMap.put(b12, str);
            }
        }
        if (linkedHashMap.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new l(b3Var), 6, (Object) null);
        }
        return linkedHashMap;
    }

    public final String a(o4 o4Var) {
        Long a11;
        Intrinsics.checkNotNullParameter(o4Var, "remotePath");
        String b11 = o4Var.b();
        int i11 = b.f38404a[o4Var.a().ordinal()];
        boolean z11 = true;
        if (i11 == 1) {
            String localHtmlUrlFromRemoteUrl = WebContentUtils.getLocalHtmlUrlFromRemoteUrl(this.f38387d, b11);
            if (localHtmlUrlFromRemoteUrl != null && !StringsKt__StringsJVMKt.isBlank(localHtmlUrlFromRemoteUrl)) {
                z11 = false;
            }
            if (!z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(localHtmlUrlFromRemoteUrl, b11), 6, (Object) null);
                return localHtmlUrlFromRemoteUrl;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(b11), 7, (Object) null);
            return null;
        } else if (i11 == 2 || i11 == 3) {
            String b12 = f38383e.b(b11);
            try {
                String file = this.f38387d.toString();
                Intrinsics.checkNotNullExpressionValue(file, "triggeredAssetDirectory.toString()");
                Pair downloadFileToPath$default = BrazeFileUtils.downloadFileToPath$default(file, b11, b12, (String) null, 8, (Object) null);
                File file2 = (File) downloadFileToPath$default.component1();
                Map map = (Map) downloadFileToPath$default.component2();
                String str = (String) map.get("expires");
                if (str == null || (a11 = v1.a(str)) == null || a11.longValue() > 0) {
                    Uri fromFile = Uri.fromFile(file2);
                    if (fromFile != null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new g(fromFile, b11), 6, (Object) null);
                        return fromFile.getPath();
                    }
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(b11), 7, (Object) null);
                    return null;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(b11, map), 7, (Object) null);
                return null;
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new e(b11), 4, (Object) null);
                return null;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
