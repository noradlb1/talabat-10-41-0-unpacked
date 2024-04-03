package bo.app;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.braze.support.BrazeLogger;
import com.huawei.hms.support.api.entity.core.CommonCode;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\f"}, d2 = {"Lbo/app/v;", "", "Landroid/content/Intent;", "intent", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lbo/app/t3;", "a", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f39493a = new v();

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f39494b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f39494b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unexpected system broadcast received [" + this.f39494b + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39495b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get active network information. Ensure the permission android.permission.ACCESS_NETWORK_STATE is defined in your AndroidManifest.xml";
        }
    }

    private v() {
    }

    @JvmStatic
    public static final t3 a(Intent intent, ConnectivityManager connectivityManager) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        Intrinsics.checkNotNullParameter(connectivityManager, "connectivityManager");
        String action = intent.getAction();
        if (Intrinsics.areEqual((Object) ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION, (Object) action)) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
                if (activeNetworkInfo == null || booleanExtra) {
                    return t3.f39409b;
                }
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype == 3) {
                        return t3.GOOD;
                    }
                    if (subtype == 13 || subtype == 20) {
                        return t3.GREAT;
                    }
                    return t3.BAD;
                } else if (type == 1 || type == 6) {
                    return t3.GREAT;
                } else {
                    if (type != 9) {
                        return t3.f39409b;
                    }
                    return t3.GOOD;
                }
            } catch (SecurityException e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39493a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f39495b, 4, (Object) null);
                return t3.f39409b;
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39493a, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new a(action), 6, (Object) null);
            return t3.f39409b;
        }
    }

    @JvmStatic
    public static final t3 a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return t3.f39409b;
        }
        int min = Math.min(networkCapabilities.getLinkDownstreamBandwidthKbps(), networkCapabilities.getLinkUpstreamBandwidthKbps());
        if (min > 14000) {
            return t3.GREAT;
        }
        if (min > 4000) {
            return t3.GOOD;
        }
        return t3.BAD;
    }
}
