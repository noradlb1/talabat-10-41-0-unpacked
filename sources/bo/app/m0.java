package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lbo/app/m0;", "Lbo/app/g2;", "", "generatedDeviceId", "", "a", "", "getDeviceId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class m0 implements g2 {

    /* renamed from: b  reason: collision with root package name */
    public static final a f38964b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f38965a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\n\u0010\t\u0012\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lbo/app/m0$a;", "", "", "a", "()Ljava/lang/String;", "getPersistentDeviceId$annotations", "()V", "persistentDeviceId", "DEVICE_ID_KEY", "Ljava/lang/String;", "PERSISTENT_DEVICE_ID_KEY", "getPERSISTENT_DEVICE_ID_KEY$annotations", "SHARED_PREFS_FILENAME", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return String.valueOf(722989291);
        }
    }

    public m0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.device", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f38965a = sharedPreferences;
    }

    private final void a(String str) {
        this.f38965a.edit().putString("device_id", str).putString("persistent_device_id", f38964b.a()).apply();
    }

    public String getDeviceId() {
        String str = null;
        String string = this.f38965a.getString("device_id", (String) null);
        if (!a()) {
            str = string;
        }
        if (str == null) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            a(uuid);
            return uuid;
        } else if (this.f38965a.contains("persistent_device_id")) {
            return str;
        } else {
            a(str);
            return str;
        }
    }

    private final boolean a() {
        if (this.f38965a.contains("persistent_device_id")) {
            if (!Intrinsics.areEqual((Object) f38964b.a(), (Object) this.f38965a.getString("persistent_device_id", ""))) {
                return true;
            }
        }
        return false;
    }
}
