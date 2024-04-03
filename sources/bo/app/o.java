package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.CancellationSignal;
import com.appboy.enums.LocationProviderName;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.receivers.BrazeActionReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.IntentUtils;
import com.braze.support.PermissionUtils;
import com.google.android.exoplayer2.C;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import j$.util.function.Consumer;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;
import x2.n;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0005\u001a\u00020\bH\u0017R\u0014\u0010\u000b\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lbo/app/o;", "Lbo/app/l2;", "", "provider", "", "a", "Lbo/app/a2;", "location", "", "c", "()Z", "isLocationCollectionEnabled", "Landroid/content/Context;", "context", "Lbo/app/b2;", "brazeManager", "Lcom/braze/configuration/BrazeConfigurationProvider;", "appConfigurationProvider", "<init>", "(Landroid/content/Context;Lbo/app/b2;Lcom/braze/configuration/BrazeConfigurationProvider;)V", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class o implements l2 {

    /* renamed from: f  reason: collision with root package name */
    public static final b f39062f = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final long f39063g = TimeUnit.MINUTES.toMillis(10);

    /* renamed from: a  reason: collision with root package name */
    private final Context f39064a;

    /* renamed from: b  reason: collision with root package name */
    private final b2 f39065b;

    /* renamed from: c  reason: collision with root package name */
    private final BrazeConfigurationProvider f39066c;

    /* renamed from: d  reason: collision with root package name */
    private final LocationManager f39067d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EnumSet<LocationProviderName> f39068e;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ o f39069b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(o oVar) {
            super(0);
            this.f39069b = oVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Using location providers: ", this.f39069b.f39068e);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f39072b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location collection enabled via sdk configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f39073b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location collection disabled via sdk configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f39074b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to log location recorded event.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39075b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did not request single location update. Location collection is disabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f39076b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Did not request single location update. Neither fine nor coarse location permissions found.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Location f39077b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Location location) {
            super(0);
            this.f39077b = location;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Setting user location to last known GPS location: ", this.f39077b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f39078b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not request single location update. Could not find suitable location provider.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39079b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(0);
            this.f39079b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Requesting single location update with provider: ", this.f39079b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Location f39080b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Location location) {
            super(0);
            this.f39080b = location;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Location manager getCurrentLocation got location: ", this.f39080b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f39081b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request single location update due to security exception from insufficient permissions.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f39082b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request single location update due to exception.";
        }
    }

    public o(Context context, b2 b2Var, BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "appConfigurationProvider");
        this.f39064a = context;
        this.f39065b = b2Var;
        this.f39066c = brazeConfigurationProvider;
        Object systemService = context.getSystemService("location");
        if (systemService != null) {
            this.f39067d = (LocationManager) systemService;
            this.f39068e = EnumSet.of(LocationProviderName.PASSIVE, LocationProviderName.NETWORK);
            if (!brazeConfigurationProvider.getCustomLocationProviderNames().isEmpty()) {
                this.f39068e = brazeConfigurationProvider.getCustomLocationProviderNames();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(this), 6, (Object) null);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    private final boolean c() {
        if (this.f39066c.isLocationCollectionEnabled()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f39072b, 6, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) d.f39073b, 6, (Object) null);
        return false;
    }

    public boolean a(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "location");
        try {
            x1 a11 = j.f38653h.a(a2Var);
            if (a11 != null) {
                this.f39065b.a(a11);
            }
            return true;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) e.f39074b, 4, (Object) null);
            return false;
        }
    }

    public boolean a() {
        Location a11;
        if (!c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) f.f39075b, 6, (Object) null);
            return false;
        }
        boolean hasPermission = PermissionUtils.hasPermission(this.f39064a, "android.permission.ACCESS_FINE_LOCATION");
        boolean hasPermission2 = PermissionUtils.hasPermission(this.f39064a, "android.permission.ACCESS_COARSE_LOCATION");
        if (!hasPermission2 && !hasPermission) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) g.f39076b, 6, (Object) null);
            return false;
        } else if (!hasPermission || (a11 = f39062f.a(this.f39067d)) == null) {
            b bVar = f39062f;
            LocationManager locationManager = this.f39067d;
            EnumSet<LocationProviderName> enumSet = this.f39068e;
            Intrinsics.checkNotNullExpressionValue(enumSet, "allowedLocationProviders");
            String a12 = bVar.a(locationManager, enumSet, hasPermission, hasPermission2);
            if (a12 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) i.f39078b, 7, (Object) null);
                return false;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(a12), 7, (Object) null);
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    this.f39067d.getCurrentLocation(a12, (CancellationSignal) null, ExecutorsKt.asExecutor(Dispatchers.getIO()), Consumer.Wrapper.convert(new n(this)));
                } else {
                    a(a12);
                }
                return true;
            } catch (SecurityException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) l.f39081b, 4, (Object) null);
                return false;
            } catch (Exception e12) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e12, false, (Function0) m.f39082b, 4, (Object) null);
                return false;
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(a11), 7, (Object) null);
            a((a2) new n(a11));
            return true;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lbo/app/o$b;", "", "Landroid/location/LocationManager;", "locationManager", "Ljava/util/EnumSet;", "Lcom/appboy/enums/LocationProviderName;", "allowedProviders", "", "hasFinePermission", "hasCoarsePermission", "", "a", "Landroid/location/Location;", "", "LAST_KNOWN_GPS_LOCATION_MAX_AGE_MS", "J", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        public static final class a extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f39070b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(long j11) {
                super(0);
                this.f39070b = j11;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Last known GPS location is too old and will not be used. Age ms: ", Long.valueOf(this.f39070b));
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: bo.app.o$b$b  reason: collision with other inner class name */
        public static final class C0029b extends Lambda implements Function0<String> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Location f39071b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0029b(Location location) {
                super(0);
                this.f39071b = location;
            }

            /* renamed from: a */
            public final String invoke() {
                return Intrinsics.stringPlus("Using last known GPS location: ", this.f39071b);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(LocationManager locationManager, EnumSet<LocationProviderName> enumSet, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(locationManager, "locationManager");
            Intrinsics.checkNotNullParameter(enumSet, "allowedProviders");
            if (z11 && enumSet.contains(LocationProviderName.GPS) && locationManager.isProviderEnabled("gps")) {
                return "gps";
            }
            if ((z12 || z11) && enumSet.contains(LocationProviderName.NETWORK) && locationManager.isProviderEnabled(SDKCoreEvent.Network.TYPE_NETWORK)) {
                return SDKCoreEvent.Network.TYPE_NETWORK;
            }
            if (!z11 || !enumSet.contains(LocationProviderName.PASSIVE) || !locationManager.isProviderEnabled("passive")) {
                return null;
            }
            return "passive";
        }

        @JvmStatic
        public final Location a(LocationManager locationManager) {
            Location lastKnownLocation;
            LocationManager locationManager2 = locationManager;
            Intrinsics.checkNotNullParameter(locationManager2, "locationManager");
            if (!locationManager2.isProviderEnabled("gps") || (lastKnownLocation = locationManager2.getLastKnownLocation("gps")) == null) {
                return null;
            }
            long nowInMilliseconds = DateTimeUtils.nowInMilliseconds() - lastKnownLocation.getTime();
            if (nowInMilliseconds > o.f39063g) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new a(nowInMilliseconds), 6, (Object) null);
                return null;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new C0029b(lastKnownLocation), 7, (Object) null);
            return lastKnownLocation;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(o oVar, Location location) {
        Intrinsics.checkNotNullParameter(oVar, "this$0");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) oVar, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new k(location), 7, (Object) null);
        if (location != null) {
            oVar.a((a2) new n(location));
        }
    }

    private final void a(String str) {
        Intent intent = new Intent("com.appboy.action.receiver.SINGLE_LOCATION_UPDATE").setClass(this.f39064a, BrazeActionReceiver.class);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(Constants.BRAZE_A…tionReceiver::class.java)");
        this.f39067d.requestSingleUpdate(str, PendingIntent.getBroadcast(this.f39064a, 0, intent, IntentUtils.getMutablePendingIntentFlags() | C.BUFFER_FLAG_FIRST_SAMPLE));
    }
}
