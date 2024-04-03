package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\b\u0010\n¨\u0006\u0011"}, d2 = {"Lbo/app/l4;", "Lbo/app/m2;", "", "b", "()Z", "isAutomaticRegistrationEnabled", "", "pushToken", "a", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "<init>", "(Landroid/content/Context;Lcom/braze/configuration/BrazeConfigurationProvider;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class l4 implements m2 {

    /* renamed from: c  reason: collision with root package name */
    public static final a f38913c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final BrazeConfigurationProvider f38914a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f38915b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\u000b"}, d2 = {"Lbo/app/l4$a;", "", "", "PUSH_SHARED_PREFERENCES_FILENAME", "Ljava/lang/String;", "PUSH_SHARED_PREFERENCES_PERSISTENT_DEVICE_ID", "getPUSH_SHARED_PREFERENCES_PERSISTENT_DEVICE_ID$annotations", "()V", "PUSH_SHARED_PREFERENCES_REGISTRATION_ID_KEY", "PUSH_SHARED_PREFERENCES_VERSION_CODE", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
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
        final /* synthetic */ int f38916b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f38917c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i11, int i12) {
            super(0);
            this.f38916b = i11;
            this.f38917c = i12;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Stored push registration ID version code " + this.f38916b + " does not match live version code " + this.f38917c + ". Not returning saved registration ID.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final c f38918b = new c();

        public c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device identifier differs from saved device identifier. Returning null token.";
        }
    }

    public l4(Context context, BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.f38914a = brazeConfigurationProvider;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.push_registration", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f38915b = sharedPreferences;
    }

    private final boolean b() {
        if (this.f38914a.isFirebaseCloudMessagingRegistrationEnabled() || this.f38914a.isAdmMessagingRegistrationEnabled()) {
            return true;
        }
        return false;
    }

    public synchronized String a() {
        int versionCode;
        int i11;
        if (!b() || !this.f38915b.contains("version_code") || (versionCode = this.f38914a.getVersionCode()) == (i11 = this.f38915b.getInt("version_code", Integer.MIN_VALUE))) {
            if (this.f38915b.contains("device_identifier")) {
                if (!Intrinsics.areEqual((Object) m0.f38964b.a(), (Object) this.f38915b.getString("device_identifier", ""))) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) c.f38918b, 6, (Object) null);
                    return null;
                }
            }
            return this.f38915b.getString("registration_id", (String) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new b(i11, versionCode), 6, (Object) null);
        return null;
    }

    public synchronized void a(String str) {
        if (str != null) {
            this.f38915b.edit().putString("registration_id", str).putInt("version_code", this.f38914a.getVersionCode()).putString("device_identifier", m0.f38964b.a()).apply();
        } else {
            throw new NullPointerException("Provided push token is null. Cannot set null push token.");
        }
    }
}
