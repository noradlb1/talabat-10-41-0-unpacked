package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.models.BrazeGeofence;
import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import net.bytebuddy.utility.JavaConstant;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0006B)\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001e\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¨\u0006\u001f"}, d2 = {"Lbo/app/m;", "", "", "Lcom/braze/models/BrazeGeofence;", "brazeGeofenceList", "", "a", "", "nowInSeconds", "geofence", "Lbo/app/o1;", "transitionType", "", "ignoreRateLimit", "", "reEligibilityId", "geofenceId", "Lbo/app/c5;", "serverConfig", "Landroid/content/SharedPreferences;", "sharedPreferences", "", "Landroid/content/Context;", "context", "apiKey", "Lbo/app/e5;", "serverConfigStorageProvider", "Lbo/app/j2;", "internalIEventMessenger", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/e5;Lbo/app/j2;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m {

    /* renamed from: i  reason: collision with root package name */
    public static final a f38924i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f38925a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f38926b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Long> f38927c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f38928d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public long f38929e;

    /* renamed from: f  reason: collision with root package name */
    public long f38930f;

    /* renamed from: g  reason: collision with root package name */
    public int f38931g;

    /* renamed from: h  reason: collision with root package name */
    public int f38932h;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u0012\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\t\u0010\u0004\u0012\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\r"}, d2 = {"Lbo/app/m$a;", "", "", "GEOFENCE_GLOBAL_ELIGIBILITY_SHARED_PREFS_LOCATION", "Ljava/lang/String;", "GEOFENCE_INDIVIDUAL_ELIGIBILITY_SHARED_PREFS_LOCATION", "LAST_REPORT_GLOBAL", "getLAST_REPORT_GLOBAL$annotations", "()V", "LAST_REQUEST_GLOBAL", "getLAST_REQUEST_GLOBAL$annotations", "SEPARATOR", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ int f38933b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i11) {
            super(0);
            this.f38933b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Min time since last geofence request reset via server configuration: " + this.f38933b + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f38934b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i11) {
            super(0);
            this.f38934b = i11;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Min time since last geofence report reset via server configuration: " + this.f38934b + '.';
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ m f38935b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f38936c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(m mVar, String str) {
            super(0);
            this.f38935b = mVar;
            this.f38936c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Retrieving geofence id ");
            m mVar = this.f38935b;
            String str = this.f38936c;
            Intrinsics.checkNotNullExpressionValue(str, "reEligibilityId");
            sb2.append(mVar.a(str));
            sb2.append(" eligibility information from local storage.");
            return sb2.toString();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38937b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f38938c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f38939d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long j11, m mVar, String str) {
            super(0);
            this.f38937b = j11;
            this.f38938c = mVar;
            this.f38939d = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report suppressed since only " + this.f38937b + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.f38938c.f38932h + "). id:" + this.f38939d;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38940b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f38941c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f38942d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ o1 f38943e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(long j11, int i11, String str, o1 o1Var) {
            super(0);
            this.f38940b = j11;
            this.f38941c = i11;
            this.f38942d = str;
            this.f38943e = o1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report suppressed since only " + this.f38940b + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.f38941c + "). id:" + this.f38942d + " transition:" + this.f38943e;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38944b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f38945c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f38946d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ o1 f38947e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(long j11, int i11, String str, o1 o1Var) {
            super(0);
            this.f38944b = j11;
            this.f38945c = i11;
            this.f38946d = str;
            this.f38947e = o1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f38944b + " seconds have passed since the last time this geofence/transition combination was reported (minimum interval: " + this.f38945c + "). id:" + this.f38946d + " transition:" + this.f38947e;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38948b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o1 f38949c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str, o1 o1Var) {
            super(0);
            this.f38948b = str;
            this.f38949c = o1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report eligible since this geofence/transition combination has never been reported.id:" + this.f38948b + " transition:" + this.f38949c;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38950b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f38951c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f38952d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(long j11, m mVar, String str) {
            super(0);
            this.f38950b = j11;
            this.f38951c = mVar;
            this.f38952d = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence report eligible since " + this.f38950b + " seconds have passed since the last time geofences were reported globally (minimum interval: " + this.f38951c.f38932h + "). id:" + this.f38952d;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38953b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f38954c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(long j11, m mVar) {
            super(0);
            this.f38953b = j11;
            this.f38954c = mVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofence request suppressed since only " + this.f38953b + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f38954c.f38931g + ").";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38955b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(long j11) {
            super(0);
            this.f38955b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Ignoring rate limit for this geofence request. Elapsed time since last request:", Long.valueOf(this.f38955b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f38957c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(long j11, m mVar) {
            super(0);
            this.f38956b = j11;
            this.f38957c = mVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f38956b + " seconds have passed since the last time geofences were requested (minimum interval: " + this.f38957c.f38931g + ").";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: bo.app.m$m  reason: collision with other inner class name */
    public static final class C0028m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final C0028m f38958b = new C0028m();

        public C0028m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences have not been requested for the current session yet. Request is eligible.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f38959b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences have already been requested for the current session. Geofence request not eligible.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38960b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str) {
            super(0);
            this.f38960b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Exception trying to parse re-eligibility id: ", this.f38960b);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38961b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(String str) {
            super(0);
            this.f38961b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting outdated id " + this.f38961b + " from re-eligibility list.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f38962b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(String str) {
            super(0);
            this.f38962b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retaining id " + this.f38962b + " in re-eligibility list.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class r extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f38963b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(long j11) {
            super(0);
            this.f38963b = j11;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Updating the last successful location request time to: ", Long.valueOf(this.f38963b));
        }
    }

    public m(Context context, String str, e5 e5Var, j2 j2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, Profile.API_KEY);
        Intrinsics.checkNotNullParameter(e5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(j2Var, "internalIEventMessenger");
        j2Var.a(new x2.m(this), i5.class);
        SharedPreferences sharedPreferences = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.managers.geofences.eligibility.global.", str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f38925a = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(Intrinsics.stringPlus("com.appboy.managers.geofences.eligibility.individual.", str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.f38926b = sharedPreferences2;
        this.f38927c = a(sharedPreferences2);
        this.f38929e = sharedPreferences.getLong("last_request_global", 0);
        this.f38930f = sharedPreferences.getLong("last_report_global", 0);
        this.f38931g = e5Var.j();
        this.f38932h = e5Var.i();
    }

    /* access modifiers changed from: private */
    public static final void a(m mVar, i5 i5Var) {
        Intrinsics.checkNotNullParameter(mVar, "this$0");
        mVar.f38928d.set(false);
    }

    public final void a(List<BrazeGeofence> list) {
        Intrinsics.checkNotNullParameter(list, "brazeGeofenceList");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (BrazeGeofence id2 : list) {
            linkedHashSet.add(id2.getId());
        }
        HashSet hashSet = new HashSet(this.f38927c.keySet());
        SharedPreferences.Editor edit = this.f38926b.edit();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Intrinsics.checkNotNullExpressionValue(str, "reEligibilityId");
            if (!linkedHashSet.contains(a(str))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new p(str), 7, (Object) null);
                this.f38927c.remove(str);
                edit.remove(str);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new q(str), 7, (Object) null);
            }
        }
        edit.apply();
    }

    public final boolean a(long j11, BrazeGeofence brazeGeofence, o1 o1Var) {
        long j12 = j11;
        o1 o1Var2 = o1Var;
        Intrinsics.checkNotNullParameter(brazeGeofence, "geofence");
        Intrinsics.checkNotNullParameter(o1Var2, "transitionType");
        String id2 = brazeGeofence.getId();
        long j13 = j12 - this.f38930f;
        if (((long) this.f38932h) > j13) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new e(j13, this, id2), 7, (Object) null);
            return false;
        }
        String a11 = a(id2, o1Var2);
        int cooldownEnterSeconds = o1Var2 == o1.ENTER ? brazeGeofence.getCooldownEnterSeconds() : brazeGeofence.getCooldownExitSeconds();
        if (this.f38927c.containsKey(a11)) {
            Long l11 = this.f38927c.get(a11);
            if (l11 != null) {
                long longValue = j12 - l11.longValue();
                if (((long) cooldownEnterSeconds) > longValue) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new f(longValue, cooldownEnterSeconds, id2, o1Var), 7, (Object) null);
                    return false;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new g(longValue, cooldownEnterSeconds, id2, o1Var), 7, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new h(id2, o1Var2), 7, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new i(j13, this, id2), 7, (Object) null);
        this.f38927c.put(a11, Long.valueOf(j11));
        this.f38926b.edit().putLong(a11, j12).apply();
        this.f38930f = j12;
        this.f38925a.edit().putLong("last_report_global", j12).apply();
        return true;
    }

    public final boolean a(boolean z11, long j11) {
        long j12 = j11 - this.f38929e;
        if (z11 || ((long) this.f38931g) <= j12) {
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new k(j12), 7, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new l(j12, this), 7, (Object) null);
            }
            if (this.f38928d.compareAndSet(false, true)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) C0028m.f38958b, 7, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) n.f38959b, 7, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new j(j12, this), 7, (Object) null);
        return false;
    }

    public final void a(long j11) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new r(j11), 7, (Object) null);
        this.f38929e = j11;
        this.f38925a.edit().putLong("last_request_global", this.f38929e).apply();
    }

    public final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "reEligibilityId");
        try {
            return new Regex(JavaConstant.Dynamic.DEFAULT_NAME).split(str, 2).get(1);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new o(str), 4, (Object) null);
            return null;
        }
    }

    public final String a(String str, o1 o1Var) {
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(o1Var, "transitionType");
        StringBuilder sb2 = new StringBuilder();
        String str2 = o1Var.toString();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
        String lowerCase = str2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb2.append(lowerCase);
        sb2.append('_');
        sb2.append(str);
        return sb2.toString();
    }

    public final void a(c5 c5Var) {
        Intrinsics.checkNotNullParameter(c5Var, "serverConfig");
        int m11 = c5Var.m();
        if (m11 >= 0) {
            this.f38931g = m11;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new b(m11), 6, (Object) null);
        }
        int l11 = c5Var.l();
        if (l11 >= 0) {
            this.f38932h = l11;
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new c(l11), 6, (Object) null);
        }
    }

    public final Map<String, Long> a(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.isEmpty()) {
            return concurrentHashMap;
        }
        Set<String> keySet = all.keySet();
        if (keySet.isEmpty()) {
            return concurrentHashMap;
        }
        for (String next : keySet) {
            long j11 = sharedPreferences.getLong(next, 0);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new d(this, next), 7, (Object) null);
            Intrinsics.checkNotNullExpressionValue(next, "reEligibilityId");
            concurrentHashMap.put(next, Long.valueOf(j11));
        }
        return concurrentHashMap;
    }
}
