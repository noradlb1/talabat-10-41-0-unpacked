package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lbo/app/z4;", "", "", "isDisabled", "a", "()Z", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class z4 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f39633b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f39634a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lbo/app/z4$a;", "", "", "PREFS_NAME", "Ljava/lang/String;", "SDK_DISABLED_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ boolean f39635b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(boolean z11) {
            super(0);
            this.f39635b = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Setting Braze SDK disabled to: ", Boolean.valueOf(this.f39635b));
        }
    }

    public z4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f39634a = new e(context, "persistent.com.appboy.storage.sdk_enabled_cache");
    }

    public final boolean a() {
        return this.f39634a.getBoolean("appboy_sdk_disabled", false);
    }

    public final void a(boolean z11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new b(z11), 6, (Object) null);
        this.f39634a.edit().putBoolean("appboy_sdk_disabled", z11).apply();
    }
}
