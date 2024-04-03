package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.visa.checkout.Profile;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0005B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0013"}, d2 = {"Lbo/app/x0;", "", "", "eventId", "", "a", "eventKey", "", "b", "Lbo/app/x1;", "event", "", "expiresAt", "Landroid/content/Context;", "context", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class x0 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39545b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final long f39546c = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f39547a;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lbo/app/x0$a;", "", "Lbo/app/x1;", "event", "", "a", "", "CACHE_EXPIRATION", "J", "STORAGE_PREFIX", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            String a11 = k4.f38791j.a(x1Var);
            return x1Var.j() + a11;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map.Entry<String, ? extends Object> f39548b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Map.Entry<String, ? extends Object> entry) {
            super(0);
            this.f39548b = entry;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Failed to get expiration time. Deleting entry: ", this.f39548b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x1 f39549b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(x1 x1Var) {
            super(0);
            this.f39549b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Event already seen in cache. Ignoring duplicate: ", this.f39549b);
        }
    }

    public x0(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str2, Profile.API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.storage.event_data_validator", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f39547a = sharedPreferences;
        a();
    }

    private final boolean b(String str) {
        return this.f39547a.contains(str);
    }

    public boolean a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (x1Var.j() != c1.PUSH_CLICKED) {
            return true;
        }
        a();
        String a11 = f39545b.a(x1Var);
        if (b(a11)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(x1Var), 7, (Object) null);
            return false;
        }
        a(DateTimeUtils.nowInMilliseconds() + f39546c, a11);
        return true;
    }

    private final void a(String str) {
        this.f39547a.edit().remove(str).apply();
    }

    public final void a(long j11, String str) {
        Intrinsics.checkNotNullParameter(str, "eventKey");
        this.f39547a.edit().putLong(str, j11).apply();
    }

    public final void a() {
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        for (Map.Entry next : this.f39547a.getAll().entrySet()) {
            try {
                Object value = next.getValue();
                if (value == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                } else if (nowInMilliseconds >= ((Long) value).longValue()) {
                    Object key = next.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                    a((String) key);
                }
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new b(next), 4, (Object) null);
                Object key2 = next.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "entry.key");
                a((String) key2);
            }
        }
    }
}
