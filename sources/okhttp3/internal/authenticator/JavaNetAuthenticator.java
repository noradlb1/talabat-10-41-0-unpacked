package okhttp3.internal.authenticator;

import com.google.common.net.HttpHeaders;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "defaultDns", "Lokhttp3/Dns;", "(Lokhttp3/Dns;)V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lokhttp3/HttpUrl;", "dns", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JavaNetAuthenticator implements Authenticator {
    @NotNull
    private final Dns defaultDns;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JavaNetAuthenticator() {
        this((Dns) null, 1, (DefaultConstructorMarker) null);
    }

    public JavaNetAuthenticator(@NotNull Dns dns) {
        Intrinsics.checkNotNullParameter(dns, "defaultDns");
        this.defaultDns = dns;
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl, Dns dns) throws IOException {
        int i11;
        Proxy.Type type = proxy.type();
        if (type == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        }
        if (i11 == 1) {
            return (InetAddress) CollectionsKt___CollectionsKt.first(dns.lookup(httpUrl.host()));
        }
        SocketAddress address = proxy.address();
        if (address != null) {
            InetAddress address2 = ((InetSocketAddress) address).getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "address() as InetSocketAddress).address");
            return address2;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    }

    @Nullable
    public Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException {
        boolean z11;
        Proxy proxy;
        Dns dns;
        PasswordAuthentication passwordAuthentication;
        String str;
        Address address;
        Intrinsics.checkNotNullParameter(response, "response");
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        if (response.code() == 407) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (route == null) {
            proxy = null;
        } else {
            proxy = route.proxy();
        }
        if (proxy == null) {
            proxy = Proxy.NO_PROXY;
        }
        for (Challenge next : challenges) {
            if (StringsKt__StringsJVMKt.equals("Basic", next.scheme(), true)) {
                if (route == null || (address = route.address()) == null) {
                    dns = null;
                } else {
                    dns = address.dns();
                }
                if (dns == null) {
                    dns = this.defaultDns;
                }
                if (z11) {
                    SocketAddress address2 = proxy.address();
                    if (address2 != null) {
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                        String hostName = inetSocketAddress.getHostName();
                        Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                        passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(hostName, connectToInetAddress(proxy, url, dns), inetSocketAddress.getPort(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                } else {
                    String host = url.host();
                    Intrinsics.checkNotNullExpressionValue(proxy, "proxy");
                    passwordAuthentication = java.net.Authenticator.requestPasswordAuthentication(host, connectToInetAddress(proxy, url, dns), url.port(), url.scheme(), next.realm(), next.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    if (z11) {
                        str = HttpHeaders.PROXY_AUTHORIZATION;
                    } else {
                        str = "Authorization";
                    }
                    String userName = passwordAuthentication.getUserName();
                    Intrinsics.checkNotNullExpressionValue(userName, "auth.userName");
                    char[] password = passwordAuthentication.getPassword();
                    Intrinsics.checkNotNullExpressionValue(password, "auth.password");
                    Request.Builder header = request.newBuilder().header(str, Credentials.basic(userName, new String(password), next.charset()));
                    if (!(header instanceof Request.Builder)) {
                        return header.build();
                    }
                    return OkHttp3Instrumentation.build(header);
                }
            }
        }
        return null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaNetAuthenticator(Dns dns, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dns.SYSTEM : dns);
    }
}
