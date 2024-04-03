package bo.app;

import com.braze.support.BrazeLogger;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Instrumented
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lbo/app/s6;", "", "Ljava/net/URL;", "url", "Ljava/net/HttpURLConnection;", "a", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class s6 {

    /* renamed from: a  reason: collision with root package name */
    public static final s6 f39358a = new s6();

    /* renamed from: b  reason: collision with root package name */
    private static v5 f39359b;

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final a f39360b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception initializing static TLS socket factory.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final b f39361b = new b();

        public b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception setting TLS socket factory on url connection.";
        }
    }

    static {
        try {
            f39359b = new v5();
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) f39358a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) a.f39360b, 4, (Object) null);
        }
    }

    private s6() {
    }

    public final HttpURLConnection a(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection()));
        if (Intrinsics.areEqual((Object) url.getProtocol(), (Object) "https")) {
            if (uRLConnection != null) {
                try {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                    v5 v5Var = f39359b;
                    if (v5Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("socketFactory");
                        v5Var = null;
                    }
                    httpsURLConnection.setSSLSocketFactory(v5Var);
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) b.f39361b, 4, (Object) null);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            }
        }
        if (uRLConnection != null) {
            return (HttpURLConnection) uRLConnection;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
    }
}
