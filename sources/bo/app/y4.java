package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R.\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\n\u0010\f¨\u0006\u0015"}, d2 = {"Lbo/app/y4;", "", "", "toString", "", "hashCode", "other", "", "equals", "signature", "a", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getSignature$annotations", "()V", "Landroid/content/Context;", "context", "userId", "apiKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class y4 {

    /* renamed from: e  reason: collision with root package name */
    public static final a f39600e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f39601a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39602b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39603c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f39604d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/y4$a;", "", "", "CACHED_SIGNATURE_KEY", "Ljava/lang/String;", "FILE_PREFIX", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ String f39605b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(0);
            this.f39605b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Setting signature to: ", this.f39605b);
        }
    }

    public y4(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f39601a = context;
        this.f39602b = str;
        this.f39603c = str2;
        this.f39604d = context.getSharedPreferences(Intrinsics.stringPlus("com.braze.storage.sdk_auth_cache", StringUtils.getCacheFileSuffix(context, str, str2)), 0);
    }

    public final String a() {
        return this.f39604d.getString("auth_signature", (String) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y4)) {
            return false;
        }
        y4 y4Var = (y4) obj;
        return Intrinsics.areEqual((Object) this.f39601a, (Object) y4Var.f39601a) && Intrinsics.areEqual((Object) this.f39602b, (Object) y4Var.f39602b) && Intrinsics.areEqual((Object) this.f39603c, (Object) y4Var.f39603c);
    }

    public int hashCode() {
        int hashCode = this.f39601a.hashCode() * 31;
        String str = this.f39602b;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f39603c;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "SdkAuthenticationCache(context=" + this.f39601a + ", userId=" + this.f39602b + ", apiKey=" + this.f39603c + ')';
    }

    public final void a(String str) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(str), 6, (Object) null);
        this.f39604d.edit().putString("auth_signature", str).apply();
    }
}
