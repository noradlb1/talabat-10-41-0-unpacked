package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.visa.checkout.Profile;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0016\u0010\u0005\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u0014"}, d2 = {"Lbo/app/n6;", "Lbo/app/a3;", "", "", "", "a", "", "Lbo/app/b3;", "triggeredActions", "", "triggeredAction", "", "b", "eventTimeInSeconds", "Landroid/content/Context;", "context", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class n6 implements a3 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f39046c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f39047a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f39048b = a();

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lbo/app/n6$a;", "", "", "RE_ELIGIBILITY_FILE_PREFIX", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ b3 f39049b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(b3 b3Var) {
            super(0);
            this.f39049b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.f39049b.getId() + " always eligible via configuration. Returning true for eligibility status";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f39050b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b3 b3Var) {
            super(0);
            this.f39050b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.f39050b.getId() + " always eligible via never having been triggered. Returning true for eligibility status";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f39051b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b3 b3Var) {
            super(0);
            this.f39051b = b3Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action id " + this.f39051b.getId() + " no longer eligible due to having been triggered in the past and is only eligible once.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39052b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n2 f39053c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j11, n2 n2Var) {
            super(0);
            this.f39052b = j11;
            this.f39053c = n2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger action is re-eligible for display since " + (DateTimeUtils.nowInSeconds() - this.f39052b) + " seconds have passed since the last time it was triggered (minimum interval: " + this.f39053c.q() + ").";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f39054b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ n2 f39055c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(long j11, n2 n2Var) {
            super(0);
            this.f39054b = j11;
            this.f39055c = n2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger action is not re-eligible for display since only " + (DateTimeUtils.nowInSeconds() - this.f39054b) + " seconds have passed since the last time it was triggered (minimum interval: " + this.f39055c.q() + ").";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b3 f39056b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f39057c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b3 b3Var, long j11) {
            super(0);
            this.f39056b = b3Var;
            this.f39057c = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Updating re-eligibility for action Id " + this.f39056b.getId() + " to time " + this.f39057c + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39058b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(0);
            this.f39058b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting outdated triggered action id " + this.f39058b + " from stored re-eligibility list. In-memory re-eligibility list is unchanged.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39059b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(0);
            this.f39059b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retaining triggered action " + this.f39059b + " in re-eligibility list.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39060b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(0);
            this.f39060b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrieving triggered action id " + this.f39060b + " eligibility information from local storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f39061b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered unexpected exception while parsing stored re-eligibility information.";
        }
    }

    public n6(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.triggers.re_eligibility", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f39047a = sharedPreferences;
    }

    public void a(b3 b3Var, long j11) {
        Intrinsics.checkNotNullParameter(b3Var, "triggeredAction");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(b3Var, j11), 7, (Object) null);
        this.f39048b.put(b3Var.getId(), Long.valueOf(j11));
        this.f39047a.edit().putLong(b3Var.getId(), j11).apply();
    }

    public boolean b(b3 b3Var) {
        long j11;
        int i11;
        Intrinsics.checkNotNullParameter(b3Var, "triggeredAction");
        n2 t11 = b3Var.f().t();
        if (t11.o()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new b(b3Var), 7, (Object) null);
            return true;
        } else if (!this.f39048b.containsKey(b3Var.getId())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(b3Var), 7, (Object) null);
            return true;
        } else if (t11.s()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(b3Var), 7, (Object) null);
            return false;
        } else {
            Long l11 = this.f39048b.get(b3Var.getId());
            if (l11 == null) {
                j11 = 0;
            } else {
                j11 = l11.longValue();
            }
            long nowInSeconds = DateTimeUtils.nowInSeconds() + ((long) b3Var.f().g());
            Integer q11 = t11.q();
            if (q11 == null) {
                i11 = 0;
            } else {
                i11 = q11.intValue();
            }
            if (nowInSeconds >= ((long) i11) + j11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(j11, t11), 7, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(j11, t11), 7, (Object) null);
            return false;
        }
    }

    private final Map<String, Long> a() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            for (String next : this.f39047a.getAll().keySet()) {
                long j11 = this.f39047a.getLong(next, 0);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(next), 7, (Object) null);
                Intrinsics.checkNotNullExpressionValue(next, "actionId");
                concurrentHashMap.put(next, Long.valueOf(j11));
            }
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) k.f39061b, 4, (Object) null);
        }
        return concurrentHashMap;
    }

    public void a(List<? extends b3> list) {
        Intrinsics.checkNotNullParameter(list, "triggeredActions");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (b3 id2 : list) {
            arrayList.add(id2.getId());
        }
        SharedPreferences.Editor edit = this.f39047a.edit();
        for (String str : CollectionsKt___CollectionsKt.toSet(this.f39048b.keySet())) {
            if (!arrayList.contains(str)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(str), 7, (Object) null);
                edit.remove(str);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(str), 7, (Object) null);
            }
        }
        edit.apply();
    }
}
