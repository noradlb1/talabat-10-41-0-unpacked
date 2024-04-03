package bo.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.braze.support.BrazeLogger;
import com.google.android.gms.common.GoogleApiAvailability;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lbo/app/s1;", "", "Landroid/content/Context;", "context", "", "a", "b", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public static final s1 f39344a = new s1();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39345b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services Availability API not found. Google Play Services not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39346b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services is available.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39347b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i11) {
            super(0);
            this.f39347b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Google Play Services is unavailable. Connection result: ", Integer.valueOf(this.f39347b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39348b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unexpected exception while checking for com.google.android.gsf";
        }
    }

    private s1() {
    }

    @JvmStatic
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable == 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39344a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f39346b, 7, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39344a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new c(isGooglePlayServicesAvailable), 7, (Object) null);
        return false;
    }

    @JvmStatic
    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", PackageManager.PackageInfoFlags.of(0));
            } else {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39344a, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) d.f39348b, 4, (Object) null);
            return false;
        }
    }
}
