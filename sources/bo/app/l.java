package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.google.android.gms.location.LocationServices;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.visa.checkout.Profile;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bB7\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001e\u0010\b\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0017\u0010\u001c\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\b\u0010\u001e¨\u0006("}, d2 = {"Lbo/app/l;", "", "Lbo/app/z1;", "", "b", "Landroid/content/Context;", "context", "", "a", "reRegisterGeofences", "c", "Landroid/app/PendingIntent;", "geofenceRequestIntent", "", "geofenceId", "Lbo/app/o1;", "geofenceTransitionType", "Lcom/braze/models/BrazeGeofence;", "transitionType", "Lbo/app/a2;", "location", "ignoreRateLimit", "Lbo/app/c5;", "serverConfig", "", "geofenceList", "isSuccessful", "Lbo/app/b2;", "brazeManager", "Lbo/app/b2;", "()Lbo/app/b2;", "apiKey", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/j2;", "internalIEventMessenger", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/b2;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/e5;Lbo/app/j2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l implements z1 {

    /* renamed from: n  reason: collision with root package name */
    public static final a f38852n = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final b2 f38853a;

    /* renamed from: b  reason: collision with root package name */
    private final BrazeConfigurationProvider f38854b;

    /* renamed from: c  reason: collision with root package name */
    private final e5 f38855c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f38856d;

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f38857e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    public final SharedPreferences f38858f;

    /* renamed from: g  reason: collision with root package name */
    public final List<BrazeGeofence> f38859g;

    /* renamed from: h  reason: collision with root package name */
    public final PendingIntent f38860h;

    /* renamed from: i  reason: collision with root package name */
    public final PendingIntent f38861i;

    /* renamed from: j  reason: collision with root package name */
    public m f38862j;

    /* renamed from: k  reason: collision with root package name */
    public a2 f38863k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f38864l;

    /* renamed from: m  reason: collision with root package name */
    public int f38865m;

    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lbo/app/l$a;", "", "", "apiKey", "a", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "GEOFENCE_STORAGE_SHARED_PREFS_LOCATION", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String a(String str) {
            Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
            return Intrinsics.stringPlus("com.appboy.managers.geofences.storage.", str);
        }

        @JvmStatic
        public final boolean a(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            return brazeConfigurationProvider.isGeofencesEnabled();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a0 f38866b = new a0();

        public a0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unregistering any Braze geofences from Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f38867b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(boolean z11) {
            super(0);
            this.f38867b = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled server config value " + this.f38867b + " received.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b0 f38868b = new b0();

        public b0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting locally stored geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f38869b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(l lVar) {
            super(0);
            this.f38869b = lVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled status newly set to " + this.f38869b.f38864l + " during server config update.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c0 f38870b = new c0();

        public c0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not un-registering geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f38871b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(boolean z11) {
            super(0);
            this.f38871b = z11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled status " + this.f38871b + " unchanged during server config update.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d0 extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d0 f38872b = new d0();

        public d0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tearing down all geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f38873b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(l lVar) {
            super(0);
            this.f38873b = lVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Max number to register newly set to " + this.f38873b.f38865m + " via server config.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f38874b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request to set up geofences received.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f38875b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Geofences on initialization due to configuration.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f38876b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze Geofences disabled or Braze location collection disabled in local configuration. Geofences not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f38877b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Fine grained location permissions not found. Geofences not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f38878b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Background location access permission not found. Geofences not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f38879b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services not available. Geofences not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.l$l  reason: collision with other inner class name */
    public static final class C0027l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final C0027l f38880b = new C0027l();

        public C0027l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services Location API not found. Geofences not enabled.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f38881b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location permissions granted and Google Play Services available. Braze Geofencing enabled via config.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f38882b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Single location request was successful, storing last updated time.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f38883b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Single location request was unsuccessful, not storing last updated time.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f38884b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not posting geofence report.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38885b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o1 f38886c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(String str, o1 o1Var) {
            super(0);
            this.f38885b = str;
            this.f38886c = o1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to record geofence " + this.f38885b + " transition with transition type " + this.f38886c + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final r f38887b = new r();

        public r() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not adding new geofences to local storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<BrazeGeofence> f38888b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(List<BrazeGeofence> list) {
            super(0);
            this.f38888b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Received new geofence list of size: ", Integer.valueOf(this.f38888b.size()));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f38889b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(l lVar) {
            super(0);
            this.f38889b = lVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Reached maximum number of new geofences: ", Integer.valueOf(this.f38889b.f38865m));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BrazeGeofence f38890b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(BrazeGeofence brazeGeofence) {
            super(0);
            this.f38890b = brazeGeofence;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Adding new geofence to local storage: ", this.f38890b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f38891b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(l lVar) {
            super(0);
            this.f38891b = lVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Added " + this.f38891b.f38859g.size() + " new geofences to local storage.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final w f38892b = new w();

        public w() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not requesting geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final x f38893b = new x();

        public x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not requesting geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final y f38894b = new y();

        public y() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Geofences not set up.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final z f38895b = new z();

        public z() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tearing down geofences.";
        }
    }

    public l(Context context, String str, b2 b2Var, BrazeConfigurationProvider brazeConfigurationProvider, e5 e5Var, j2 j2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(b2Var, "brazeManager");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(j2Var, "internalIEventMessenger");
        this.f38853a = b2Var;
        this.f38854b = brazeConfigurationProvider;
        this.f38855c = e5Var;
        boolean z11 = true;
        c(true);
        this.f38856d = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(f38852n.a(str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f38858f = sharedPreferences;
        this.f38859g = CollectionsKt___CollectionsKt.toMutableList(p1.a(sharedPreferences));
        this.f38860h = p1.b(context);
        this.f38861i = p1.a(context);
        this.f38862j = new m(context, str, e5Var, j2Var);
        this.f38864l = (!p1.a(e5Var) || !a(context)) ? false : z11;
        this.f38865m = p1.b(e5Var);
    }

    public final b2 a() {
        return this.f38853a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r9 = this;
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.l$f r5 = bo.app.l.f.f38874b
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r0 = r8
            r1 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            bo.app.e5 r0 = r9.f38855c
            boolean r0 = bo.app.p1.a((bo.app.e5) r0)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            android.content.Context r0 = r9.f38856d
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r9.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x0026
            r0 = r1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            r9.f38864l = r0
            com.braze.configuration.BrazeConfigurationProvider r0 = r9.f38854b
            boolean r0 = r0.isAutomaticGeofenceRequestsEnabled()
            if (r0 == 0) goto L_0x0035
            r9.b((boolean) r1)
            goto L_0x0041
        L_0x0035:
            bo.app.l$g r5 = bo.app.l.g.f38875b
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = 7
            r7 = 0
            r0 = r8
            r1 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.l.b():void");
    }

    public final void c(boolean z11) {
        if (!this.f38864l) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) y.f38894b, 7, (Object) null);
        } else if (z11) {
            ReentrantLock reentrantLock = this.f38857e;
            reentrantLock.lock();
            try {
                a(this.f38859g, this.f38860h);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!f38852n.a(this.f38854b)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) h.f38876b, 7, (Object) null);
            return false;
        } else if (!PermissionUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) i.f38877b, 6, (Object) null);
            return false;
        } else if (Build.VERSION.SDK_INT >= 29 && !PermissionUtils.hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) j.f38878b, 6, (Object) null);
            return false;
        } else if (!s1.a(context)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) k.f38879b, 7, (Object) null);
            return false;
        } else {
            try {
                Class.forName("com.google.android.gms.location.LocationServices", false, l.class.getClassLoader());
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) m.f38881b, 7, (Object) null);
                return true;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) C0027l.f38880b, 7, (Object) null);
                return false;
            }
        }
    }

    public final void b(PendingIntent pendingIntent) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) z.f38895b, 7, (Object) null);
        if (pendingIntent != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a0.f38866b, 7, (Object) null);
            LocationServices.getGeofencingClient(this.f38856d).removeGeofences(pendingIntent);
        }
        ReentrantLock reentrantLock = this.f38857e;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b0.f38868b, 7, (Object) null);
            this.f38858f.edit().clear().apply();
            this.f38859g.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void c() {
        if (!this.f38864l) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) c0.f38870b, 7, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) d0.f38872b, 7, (Object) null);
        b(this.f38860h);
    }

    public final boolean a(String str, o1 o1Var) {
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(o1Var, "geofenceTransitionType");
        ReentrantLock reentrantLock = this.f38857e;
        reentrantLock.lock();
        try {
            BrazeGeofence a11 = a(str);
            if (a11 != null) {
                if (o1Var == o1.ENTER) {
                    return a11.getAnalyticsEnabledEnter();
                }
                if (o1Var == o1.EXIT) {
                    boolean analyticsEnabledExit = a11.getAnalyticsEnabledExit();
                    reentrantLock.unlock();
                    return analyticsEnabledExit;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r9.f38862j.a(com.braze.support.DateTimeUtils.nowInSeconds(), r1, r11) == true) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r10, bo.app.o1 r11) {
        /*
            r9 = this;
            java.lang.String r0 = "geofenceId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "transitionType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r9.f38864l
            if (r0 != 0) goto L_0x001d
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.W
            bo.app.l$p r6 = bo.app.l.p.f38884b
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            return
        L_0x001d:
            bo.app.j$a r0 = bo.app.j.f38653h
            java.lang.String r1 = r11.toString()
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            bo.app.x1 r0 = r0.c(r10, r1)
            if (r0 != 0) goto L_0x003b
            r0 = 0
            goto L_0x0069
        L_0x003b:
            boolean r1 = r9.a((java.lang.String) r10, (bo.app.o1) r11)
            if (r1 == 0) goto L_0x0048
            bo.app.b2 r1 = r9.a()
            r1.a((bo.app.x1) r0)
        L_0x0048:
            com.braze.models.BrazeGeofence r1 = r9.a((java.lang.String) r10)
            if (r1 != 0) goto L_0x004f
            goto L_0x005d
        L_0x004f:
            bo.app.m r2 = r9.f38862j
            long r3 = com.braze.support.DateTimeUtils.nowInSeconds()
            boolean r1 = r2.a(r3, r1, r11)
            r2 = 1
            if (r1 != r2) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 == 0) goto L_0x0067
            bo.app.b2 r1 = r9.a()
            r1.b((bo.app.x1) r0)
        L_0x0067:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0069:
            if (r0 != 0) goto L_0x007c
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.l$q r6 = new bo.app.l$q
            r6.<init>(r10, r11)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r9
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.l.b(java.lang.String, bo.app.o1):void");
    }

    public final BrazeGeofence a(String str) {
        T t11;
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        ReentrantLock reentrantLock = this.f38857e;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f38859g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it.next();
                if (Intrinsics.areEqual((Object) ((BrazeGeofence) t11).getId(), (Object) str)) {
                    break;
                }
            }
            return (BrazeGeofence) t11;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "location");
        if (!this.f38864l) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) w.f38892b, 7, (Object) null);
            return;
        }
        this.f38863k = a2Var;
        if (a2Var != null) {
            a().a(a2Var);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(bo.app.c5 r13) {
        /*
            r12 = this;
            java.lang.String r0 = "serverConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = r13.h()
            com.braze.support.BrazeLogger r9 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.l$b r6 = new bo.app.l$b
            r6.<init>(r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r1 = r9
            r2 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            r10 = 1
            r11 = 0
            if (r0 == 0) goto L_0x002d
            android.content.Context r0 = r12.f38856d
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r12.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x002d
            r0 = r10
            goto L_0x002e
        L_0x002d:
            r0 = r11
        L_0x002e:
            boolean r1 = r12.f38864l
            if (r0 == r1) goto L_0x005d
            r12.f38864l = r0
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            bo.app.l$c r6 = new bo.app.l$c
            r6.<init>(r12)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r1 = r9
            r2 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            boolean r0 = r12.f38864l
            if (r0 == 0) goto L_0x0057
            r12.c(r11)
            com.braze.configuration.BrazeConfigurationProvider r0 = r12.f38854b
            boolean r0 = r0.isAutomaticGeofenceRequestsEnabled()
            if (r0 == 0) goto L_0x006c
            r12.b((boolean) r10)
            goto L_0x006c
        L_0x0057:
            android.app.PendingIntent r0 = r12.f38860h
            r12.b((android.app.PendingIntent) r0)
            goto L_0x006c
        L_0x005d:
            bo.app.l$d r6 = new bo.app.l$d
            r6.<init>(r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 7
            r8 = 0
            r1 = r9
            r2 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
        L_0x006c:
            int r0 = r13.j()
            if (r0 < 0) goto L_0x0084
            r12.f38865m = r0
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            bo.app.l$e r6 = new bo.app.l$e
            r6.<init>(r12)
            r4 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r1 = r9
            r2 = r12
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
        L_0x0084:
            bo.app.m r0 = r12.f38862j
            r0.a((bo.app.c5) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.l.a(bo.app.c5):void");
    }

    public void b(boolean z11) {
        if (!this.f38864l) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) x.f38893b, 7, (Object) null);
        } else if (this.f38862j.a(z11, DateTimeUtils.nowInSeconds())) {
            a(this.f38861i);
        }
    }

    /* JADX INFO: finally extract failed */
    public void a(List<BrazeGeofence> list) {
        Intrinsics.checkNotNullParameter(list, "geofenceList");
        List<BrazeGeofence> mutableList = CollectionsKt___CollectionsKt.toMutableList(list);
        if (!this.f38864l) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) r.f38887b, 6, (Object) null);
            return;
        }
        if (this.f38863k != null) {
            for (BrazeGeofence brazeGeofence : mutableList) {
                a2 a2Var = this.f38863k;
                if (a2Var != null) {
                    brazeGeofence.setDistanceFromGeofenceRefresh(l3.a(a2Var.getLatitude(), a2Var.getLongitude(), brazeGeofence.getLatitude(), brazeGeofence.getLongitude()));
                }
            }
            CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
        }
        ReentrantLock reentrantLock = this.f38857e;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new s(mutableList), 7, (Object) null);
            SharedPreferences.Editor edit = this.f38858f.edit();
            edit.clear();
            this.f38859g.clear();
            Iterator it = mutableList.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BrazeGeofence brazeGeofence2 = (BrazeGeofence) it.next();
                if (i11 == this.f38865m) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new t(this), 7, (Object) null);
                    break;
                }
                this.f38859g.add(brazeGeofence2);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new u(brazeGeofence2), 7, (Object) null);
                String id2 = brazeGeofence2.getId();
                JSONObject forJsonPut = brazeGeofence2.forJsonPut();
                edit.putString(id2, !(forJsonPut instanceof JSONObject) ? forJsonPut.toString() : JSONObjectInstrumentation.toString(forJsonPut));
                i11++;
            }
            edit.apply();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new v(this), 7, (Object) null);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.f38862j.a(mutableList);
            c(true);
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void a(boolean z11) {
        if (z11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) n.f38882b, 7, (Object) null);
            this.f38862j.a(DateTimeUtils.nowInSeconds());
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) o.f38883b, 7, (Object) null);
    }

    public final void a(PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "geofenceRequestIntent");
        Context context = this.f38856d;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        r1.a(context, pendingIntent, (z1) this);
    }

    public final void a(List<BrazeGeofence> list, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(list, "geofenceList");
        Intrinsics.checkNotNullParameter(pendingIntent, "geofenceRequestIntent");
        Context context = this.f38856d;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        r1.b(context, list, pendingIntent);
    }
}
