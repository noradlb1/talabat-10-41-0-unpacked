package bo.app;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.content.pm.PackageInfoCompat;
import bo.app.j0;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0007R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010!\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0013\u0010%\u001a\u0004\u0018\u00010\t8G¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00060"}, d2 = {"Lbo/app/l0;", "Lbo/app/f2;", "", "k", "l", "Ljava/util/Locale;", "m", "Ljava/util/TimeZone;", "n", "", "j", "i", "googleAdvertisingId", "", "a", "googleAdvertisingLimitAdTrackingEnabled", "f", "Landroid/content/pm/PackageInfo;", "g", "()Landroid/content/pm/PackageInfo;", "packageInfo", "hostAppVersion", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hostAppSemanticVersionCode", "Lbo/app/j0;", "d", "()Lbo/app/j0;", "device", "b", "dirtyDevice", "getDeviceId", "deviceId", "e", "h", "()Ljava/lang/Boolean;", "isAdTrackingEnabled", "Landroid/content/Context;", "context", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/g2;", "deviceIdProvider", "Lbo/app/k0;", "deviceCache", "<init>", "(Landroid/content/Context;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/g2;Lbo/app/k0;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l0 implements f2 {

    /* renamed from: g  reason: collision with root package name */
    public static final a f38896g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Context f38897a;

    /* renamed from: b  reason: collision with root package name */
    private final BrazeConfigurationProvider f38898b;

    /* renamed from: c  reason: collision with root package name */
    private final g2 f38899c;

    /* renamed from: d  reason: collision with root package name */
    private final k0 f38900d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38901e;

    /* renamed from: f  reason: collision with root package name */
    public final SharedPreferences f38902f;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f38903b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to read notifications enabled state from NotificationManagerCompat.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38904b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "App version code could not be read. Returning null";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f38905b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to collect background restriction information from Activity Manager";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38906b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(0);
            this.f38906b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to inspect package [" + this.f38906b + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38907b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while reading the phone carrier name.";
        }
    }

    public l0(Context context, BrazeConfigurationProvider brazeConfigurationProvider, g2 g2Var, k0 k0Var) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(g2Var, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(k0Var, "deviceCache");
        this.f38897a = context;
        this.f38898b = brazeConfigurationProvider;
        this.f38899c = g2Var;
        this.f38900d = k0Var;
        PackageInfo g11 = g();
        if (g11 == null) {
            str = null;
        } else {
            str = g11.versionName;
        }
        this.f38901e = str;
        SharedPreferences sharedPreferences = this.f38897a.getSharedPreferences("com.appboy.managers.device_data_provider", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f38902f = sharedPreferences;
    }

    private final PackageInfo g() {
        String packageName = this.f38897a.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                return this.f38897a.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0));
            }
            return this.f38897a.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new e(packageName), 4, (Object) null);
            ApplicationInfo applicationInfo = this.f38897a.getApplicationInfo();
            if (Build.VERSION.SDK_INT >= 33) {
                return this.f38897a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, PackageManager.PackageInfoFlags.of(0));
            }
            return this.f38897a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, 0);
        }
    }

    private final boolean i() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            Object systemService = this.f38897a.getSystemService("activity");
            if (systemService != null) {
                return ((ActivityManager) systemService).isBackgroundRestricted();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) d.f38905b, 4, (Object) null);
            return false;
        }
    }

    private final boolean j() {
        return this.f38897a.getResources().getConfiguration().orientation == 2;
    }

    private final String k() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    private final String l() {
        try {
            Object systemService = this.f38897a.getSystemService("phone");
            if (systemService != null) {
                return ((TelephonyManager) systemService).getNetworkOperatorName();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) f.f38907b, 4, (Object) null);
            return null;
        }
    }

    private final Locale m() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    private final TimeZone n() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        return timeZone;
    }

    public String a() {
        long j11;
        PackageInfo g11 = g();
        if (g11 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                j11 = g11.getLongVersionCode();
            } else {
                j11 = PackageInfoCompat.getLongVersionCode(g11);
            }
            return j11 + ".0.0.0";
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c.f38904b, 7, (Object) null);
        return null;
    }

    public j0 b() {
        this.f38900d.a(d());
        return (j0) this.f38900d.a();
    }

    public String c() {
        return this.f38901e;
    }

    public j0 d() {
        j0.a e11 = new j0.a(this.f38898b).a(k()).b(l()).e(Build.MODEL);
        a aVar = f38896g;
        return e11.d(aVar.a(m())).g(n().getID()).f(aVar.a(this.f38897a, j())).c(Boolean.valueOf(f())).b(Boolean.valueOf(i())).c(e()).a(h()).a();
    }

    public final String e() {
        return this.f38902f.getString("google_ad_id", (String) null);
    }

    public final boolean f() {
        Object a11;
        Method a12;
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = this.f38897a.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (systemService != null) {
                return ((NotificationManager) systemService).areNotificationsEnabled();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        try {
            Method b11 = n4.b("androidx.core.app.NotificationManagerCompat", "from", Context.class);
            if (b11 == null || (a11 = n4.a((Object) null, b11, this.f38897a)) == null || (a12 = n4.a(a11.getClass(), "areNotificationsEnabled", (Class<?>[]) new Class[0])) == null) {
                return true;
            }
            Object a13 = n4.a(a11, a12, new Object[0]);
            if (a13 instanceof Boolean) {
                return ((Boolean) a13).booleanValue();
            }
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f38903b, 4, (Object) null);
            return true;
        }
    }

    public String getDeviceId() {
        return this.f38899c.getDeviceId();
    }

    public final Boolean h() {
        if (!this.f38902f.contains("ad_tracking_enabled")) {
            return null;
        }
        return Boolean.valueOf(this.f38902f.getBoolean("ad_tracking_enabled", true));
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "googleAdvertisingId");
        this.f38902f.edit().putString("google_ad_id", str).apply();
    }

    public void a(boolean z11) {
        this.f38902f.edit().putBoolean("ad_tracking_enabled", !z11).apply();
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lbo/app/l0$a;", "", "Landroid/content/Context;", "context", "", "isRotated", "", "a", "Ljava/util/Locale;", "locale", "STORAGE_AD_TRACKING_ENABLED", "Ljava/lang/String;", "STORAGE_FILENAME", "STORAGE_GOOGLE_ADVERTISING_ID_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(Context context, boolean z11) {
            int i11;
            int i12;
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                WindowManager windowManager = (WindowManager) systemService;
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect a11 = windowManager.getCurrentWindowMetrics().getBounds();
                    Intrinsics.checkNotNullExpressionValue(a11, "windowManager.currentWindowMetrics.bounds");
                    i12 = a11.width();
                    i11 = a11.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    int i13 = displayMetrics.widthPixels;
                    int i14 = displayMetrics.heightPixels;
                    i12 = i13;
                    i11 = i14;
                }
                if (z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('x');
                    sb2.append(i12);
                    return sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i12);
                sb3.append('x');
                sb3.append(i11);
                return sb3.toString();
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }

        @JvmStatic
        public final String a(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            String locale2 = locale.toString();
            Intrinsics.checkNotNullExpressionValue(locale2, "locale.toString()");
            return locale2;
        }
    }
}
