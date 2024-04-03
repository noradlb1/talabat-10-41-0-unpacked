package bo.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J&\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004H\u0002¨\u0006\u0016"}, d2 = {"Lbo/app/r1;", "", "Landroid/content/Context;", "context", "", "Lcom/braze/models/BrazeGeofence;", "geofenceList", "Landroid/app/PendingIntent;", "geofenceRequestIntent", "", "b", "pendingIntent", "Lbo/app/z1;", "resultListener", "a", "newGeofencesToRegister", "", "obsoleteGeofenceIds", "Landroid/content/SharedPreferences;", "c", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class r1 {

    /* renamed from: a  reason: collision with root package name */
    public static final r1 f39259a = new r1();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39260b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting registered geofence cache.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39261b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences successfully registered with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39262b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i11) {
            super(0);
            this.f39262b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences not registered with Google Play Services due to GEOFENCE_TOO_MANY_GEOFENCES: ", Integer.valueOf(this.f39262b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39263b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i11) {
            super(0);
            this.f39263b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences not registered with Google Play Services due to GEOFENCE_TOO_MANY_PENDING_INTENTS: ", Integer.valueOf(this.f39263b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39264b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(int i11) {
            super(0);
            this.f39264b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences not registered with Google Play Services due to GEOFENCE_NOT_AVAILABLE: ", Integer.valueOf(this.f39264b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f39265b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received Geofence registration success code in failure block with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39266b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(int i11) {
            super(0);
            this.f39266b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofence pending result returned unknown status code: ", Integer.valueOf(this.f39266b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f39267b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence exception encountered while adding geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<String> f39268b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(List<String> list) {
            super(0);
            this.f39268b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Un-registering " + this.f39268b.size() + " obsolete geofences from Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f39269b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No obsolete geofences need to be unregistered from Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<BrazeGeofence> f39270b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(List<BrazeGeofence> list) {
            super(0);
            this.f39270b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering " + this.f39270b.size() + " new geofences with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f39271b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No new geofences need to be registered with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f39272b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while adding geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39273b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(0);
            this.f39273b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence with id: " + this.f39273b + " removed from shared preferences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f39274b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences successfully un-registered with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39275b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(int i11) {
            super(0);
            this.f39275b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences cannot be un-registered with Google Play Services due to GEOFENCE_TOO_MANY_GEOFENCES: ", Integer.valueOf(this.f39275b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39276b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(int i11) {
            super(0);
            this.f39276b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences cannot be un-registered with Google Play Services due to GEOFENCE_TOO_MANY_PENDING_INTENTS: ", Integer.valueOf(this.f39276b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39277b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(int i11) {
            super(0);
            this.f39277b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofences cannot be un-registered with Google Play Services due to GEOFENCE_NOT_AVAILABLE: ", Integer.valueOf(this.f39277b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class s extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final s f39278b = new s();

        public s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received Geofence un-registration success code in failure block with Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class t extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f39279b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(int i11) {
            super(0);
            this.f39279b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Geofence pending result returned unknown status code: ", Integer.valueOf(this.f39279b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class u extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final u f39280b = new u();

        public u() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence exception encountered while removing geofences.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class v extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final v f39281b = new v();

        public v() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting single location update from Google Play Services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class w extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final w f39282b = new w();

        public w() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Single location request from Google Play services was successful.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class x extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final x f39283b = new x();

        public x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get single location update from Google Play services.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class y extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final y f39284b = new y();

        public y() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to request location update due to exception.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class z extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BrazeGeofence f39285b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(BrazeGeofence brazeGeofence) {
            super(0);
            this.f39285b = brazeGeofence;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence with id: " + this.f39285b.getId() + " added to shared preferences.";
        }
    }

    private r1() {
    }

    @JvmStatic
    public static final void a(Context context, PendingIntent pendingIntent, z1 z1Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pendingIntent, BaseGmsClient.KEY_PENDING_INTENT);
        Intrinsics.checkNotNullParameter(z1Var, "resultListener");
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) v.f39281b, 7, (Object) null);
            LocationRequest create = LocationRequest.create();
            Intrinsics.checkNotNullExpressionValue(create, "create()");
            create.setPriority(100);
            create.setNumUpdates(1);
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(create, pendingIntent).addOnSuccessListener(new x2.t(z1Var)).addOnFailureListener(new x2.u(z1Var));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) y.f39284b, 4, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad A[Catch:{ Exception -> 0x012b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0076 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void b(android.content.Context r13, java.util.List<com.braze.models.BrazeGeofence> r14, android.app.PendingIntent r15) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "geofenceList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "geofenceRequestIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            bo.app.r1 r0 = f39259a     // Catch:{ Exception -> 0x012b }
            android.content.SharedPreferences r0 = r0.b((android.content.Context) r13)     // Catch:{ Exception -> 0x012b }
            java.util.List r0 = bo.app.p1.a((android.content.SharedPreferences) r0)     // Catch:{ Exception -> 0x012b }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x012b }
            r1.<init>()     // Catch:{ Exception -> 0x012b }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x0022:
            boolean r2 = r14.hasNext()     // Catch:{ Exception -> 0x012b }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x006d
            java.lang.Object r2 = r14.next()     // Catch:{ Exception -> 0x012b }
            r5 = r2
            com.braze.models.BrazeGeofence r5 = (com.braze.models.BrazeGeofence) r5     // Catch:{ Exception -> 0x012b }
            boolean r6 = r0 instanceof java.util.Collection     // Catch:{ Exception -> 0x012b }
            if (r6 == 0) goto L_0x003c
            boolean r6 = r0.isEmpty()     // Catch:{ Exception -> 0x012b }
            if (r6 == 0) goto L_0x003c
            goto L_0x0066
        L_0x003c:
            java.util.Iterator r6 = r0.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x0040:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x012b }
            if (r7 == 0) goto L_0x0066
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x012b }
            com.braze.models.BrazeGeofence r7 = (com.braze.models.BrazeGeofence) r7     // Catch:{ Exception -> 0x012b }
            java.lang.String r8 = r7.getId()     // Catch:{ Exception -> 0x012b }
            java.lang.String r9 = r5.getId()     // Catch:{ Exception -> 0x012b }
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x012b }
            if (r8 == 0) goto L_0x0062
            boolean r7 = r7.equivalentServerData(r5)     // Catch:{ Exception -> 0x012b }
            if (r7 == 0) goto L_0x0062
            r7 = r4
            goto L_0x0063
        L_0x0062:
            r7 = r3
        L_0x0063:
            if (r7 == 0) goto L_0x0040
            goto L_0x0067
        L_0x0066:
            r3 = r4
        L_0x0067:
            if (r3 == 0) goto L_0x0022
            r1.add(r2)     // Catch:{ Exception -> 0x012b }
            goto L_0x0022
        L_0x006d:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x012b }
            r14.<init>()     // Catch:{ Exception -> 0x012b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x0076:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x012b }
            if (r2 == 0) goto L_0x00b1
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x012b }
            r5 = r2
            com.braze.models.BrazeGeofence r5 = (com.braze.models.BrazeGeofence) r5     // Catch:{ Exception -> 0x012b }
            boolean r6 = r1.isEmpty()     // Catch:{ Exception -> 0x012b }
            if (r6 == 0) goto L_0x008a
            goto L_0x00aa
        L_0x008a:
            java.util.Iterator r6 = r1.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x008e:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x012b }
            if (r7 == 0) goto L_0x00aa
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x012b }
            com.braze.models.BrazeGeofence r7 = (com.braze.models.BrazeGeofence) r7     // Catch:{ Exception -> 0x012b }
            java.lang.String r7 = r7.getId()     // Catch:{ Exception -> 0x012b }
            java.lang.String r8 = r5.getId()     // Catch:{ Exception -> 0x012b }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x012b }
            if (r7 == 0) goto L_0x008e
            r5 = r3
            goto L_0x00ab
        L_0x00aa:
            r5 = r4
        L_0x00ab:
            if (r5 == 0) goto L_0x0076
            r14.add(r2)     // Catch:{ Exception -> 0x012b }
            goto L_0x0076
        L_0x00b1:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x012b }
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r14, r2)     // Catch:{ Exception -> 0x012b }
            r0.<init>(r2)     // Catch:{ Exception -> 0x012b }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x00c0:
            boolean r2 = r14.hasNext()     // Catch:{ Exception -> 0x012b }
            if (r2 == 0) goto L_0x00d4
            java.lang.Object r2 = r14.next()     // Catch:{ Exception -> 0x012b }
            com.braze.models.BrazeGeofence r2 = (com.braze.models.BrazeGeofence) r2     // Catch:{ Exception -> 0x012b }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x012b }
            r0.add(r2)     // Catch:{ Exception -> 0x012b }
            goto L_0x00c0
        L_0x00d4:
            boolean r14 = r0.isEmpty()     // Catch:{ Exception -> 0x012b }
            r14 = r14 ^ r4
            if (r14 == 0) goto L_0x00f1
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x012b }
            bo.app.r1 r14 = f39259a     // Catch:{ Exception -> 0x012b }
            r7 = 0
            r8 = 0
            r9 = 0
            bo.app.r1$i r10 = new bo.app.r1$i     // Catch:{ Exception -> 0x012b }
            r10.<init>(r0)     // Catch:{ Exception -> 0x012b }
            r11 = 7
            r12 = 0
            r6 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)     // Catch:{ Exception -> 0x012b }
            r14.b(r13, r0)     // Catch:{ Exception -> 0x012b }
            goto L_0x00ff
        L_0x00f1:
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x012b }
            bo.app.r1 r6 = f39259a     // Catch:{ Exception -> 0x012b }
            r7 = 0
            r8 = 0
            r9 = 0
            bo.app.r1$j r10 = bo.app.r1.j.f39269b     // Catch:{ Exception -> 0x012b }
            r11 = 7
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (boolean) r9, (kotlin.jvm.functions.Function0) r10, (int) r11, (java.lang.Object) r12)     // Catch:{ Exception -> 0x012b }
        L_0x00ff:
            boolean r14 = r1.isEmpty()     // Catch:{ Exception -> 0x012b }
            r14 = r14 ^ r4
            if (r14 == 0) goto L_0x011c
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x012b }
            bo.app.r1 r14 = f39259a     // Catch:{ Exception -> 0x012b }
            r4 = 0
            r5 = 0
            r6 = 0
            bo.app.r1$k r7 = new bo.app.r1$k     // Catch:{ Exception -> 0x012b }
            r7.<init>(r1)     // Catch:{ Exception -> 0x012b }
            r8 = 7
            r9 = 0
            r3 = r14
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)     // Catch:{ Exception -> 0x012b }
            r14.a((android.content.Context) r13, (java.util.List<com.braze.models.BrazeGeofence>) r1, (android.app.PendingIntent) r15)     // Catch:{ Exception -> 0x012b }
            goto L_0x013b
        L_0x011c:
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x012b }
            bo.app.r1 r1 = f39259a     // Catch:{ Exception -> 0x012b }
            r2 = 0
            r3 = 0
            r4 = 0
            bo.app.r1$l r5 = bo.app.r1.l.f39271b     // Catch:{ Exception -> 0x012b }
            r6 = 7
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x012b }
            goto L_0x013b
        L_0x012b:
            r13 = move-exception
            r3 = r13
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            bo.app.r1 r1 = f39259a
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            bo.app.r1$m r5 = bo.app.r1.m.f39272b
            r4 = 0
            r6 = 4
            r7 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (boolean) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
        L_0x013b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.r1.b(android.content.Context, java.util.List, android.app.PendingIntent):void");
    }

    private final void c(Context context, List<BrazeGeofence> list) {
        SharedPreferences.Editor edit = b(context).edit();
        for (BrazeGeofence next : list) {
            String id2 = next.getId();
            JSONObject forJsonPut = next.forJsonPut();
            edit.putString(id2, !(forJsonPut instanceof JSONObject) ? forJsonPut.toString() : JSONObjectInstrumentation.toString(forJsonPut));
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new z(next), 6, (Object) null);
        }
        edit.apply();
    }

    /* access modifiers changed from: private */
    public static final void a(z1 z1Var, Void voidR) {
        Intrinsics.checkNotNullParameter(z1Var, "$resultListener");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) w.f39282b, 6, (Object) null);
        z1Var.a(true);
    }

    /* access modifiers changed from: private */
    public static final void a(z1 z1Var, Exception exc) {
        Intrinsics.checkNotNullParameter(z1Var, "$resultListener");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.E, (Throwable) exc, false, (Function0) x.f39283b, 4, (Object) null);
        z1Var.a(false);
    }

    @JvmStatic
    public static final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        r1 r1Var = f39259a;
        BrazeLogger.brazelog$default(brazeLogger, (Object) r1Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) a.f39260b, 7, (Object) null);
        r1Var.b(context).edit().clear().apply();
    }

    /* access modifiers changed from: private */
    public static final void a(Context context, List list, Void voidR) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(list, "$newGeofencesToRegister");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        r1 r1Var = f39259a;
        BrazeLogger.brazelog$default(brazeLogger, (Object) r1Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) b.f39261b, 7, (Object) null);
        r1Var.c(context, list);
    }

    /* access modifiers changed from: private */
    public static final void a(Exception exc) {
        Exception exc2 = exc;
        if (exc2 instanceof ApiException) {
            int statusCode = ((ApiException) exc2).getStatusCode();
            if (statusCode != 0) {
                switch (statusCode) {
                    case 1000:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new e(statusCode), 6, (Object) null);
                        return;
                    case 1001:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new c(statusCode), 6, (Object) null);
                        return;
                    case 1002:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new d(statusCode), 6, (Object) null);
                        return;
                    default:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new g(statusCode), 6, (Object) null);
                        return;
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) f.f39265b, 7, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.E, (Throwable) exc, false, (Function0) h.f39267b, 4, (Object) null);
        }
    }

    private final void a(Context context, List<String> list) {
        SharedPreferences.Editor edit = b(context).edit();
        for (String next : list) {
            edit.remove(next);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new n(next), 6, (Object) null);
        }
        edit.apply();
    }

    private final void b(Context context, List<String> list) {
        LocationServices.getGeofencingClient(context).removeGeofences(list).addOnSuccessListener(new x2.r(context, list)).addOnFailureListener(new x2.s());
    }

    /* access modifiers changed from: private */
    public static final void b(Context context, List list, Void voidR) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(list, "$obsoleteGeofenceIds");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        r1 r1Var = f39259a;
        BrazeLogger.brazelog$default(brazeLogger, (Object) r1Var, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) o.f39274b, 7, (Object) null);
        r1Var.a(context, (List<String>) list);
    }

    private final void a(Context context, List<BrazeGeofence> list, PendingIntent pendingIntent) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (BrazeGeofence geofence : list) {
            arrayList.add(geofence.toGeofence());
        }
        GeofencingRequest build = new GeofencingRequest.Builder().addGeofences(arrayList).setInitialTrigger(0).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .a…r(0)\n            .build()");
        LocationServices.getGeofencingClient(context).addGeofences(build, pendingIntent).addOnSuccessListener(new x2.p(context, list)).addOnFailureListener(new x2.q());
    }

    /* access modifiers changed from: private */
    public static final void b(Exception exc) {
        Exception exc2 = exc;
        if (exc2 instanceof ApiException) {
            int statusCode = ((ApiException) exc2).getStatusCode();
            if (statusCode != 0) {
                switch (statusCode) {
                    case 1000:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new r(statusCode), 6, (Object) null);
                        return;
                    case 1001:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new p(statusCode), 6, (Object) null);
                        return;
                    case 1002:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new q(statusCode), 6, (Object) null);
                        return;
                    default:
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new t(statusCode), 6, (Object) null);
                        return;
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) s.f39278b, 7, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39259a, BrazeLogger.Priority.E, (Throwable) exc, false, (Function0) u.f39280b, 4, (Object) null);
        }
    }

    private final SharedPreferences b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.support.geofences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ON, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }
}
