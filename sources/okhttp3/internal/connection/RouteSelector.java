package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "address", "Lokhttp3/Address;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "inetSocketAddresses", "", "Ljava/net/InetSocketAddress;", "nextProxyIndex", "", "postponedRoutes", "", "Lokhttp3/Route;", "proxies", "Ljava/net/Proxy;", "hasNext", "", "hasNextProxy", "next", "Lokhttp3/internal/connection/RouteSelector$Selection;", "nextProxy", "resetNextInetSocketAddress", "", "proxy", "resetNextProxy", "url", "Lokhttp3/HttpUrl;", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RouteSelector {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Address address;
    @NotNull
    private final Call call;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private List<? extends InetSocketAddress> inetSocketAddresses = CollectionsKt__CollectionsKt.emptyList();
    private int nextProxyIndex;
    @NotNull
    private final List<Route> postponedRoutes = new ArrayList();
    @NotNull
    private List<? extends Proxy> proxies = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private final RouteDatabase routeDatabase;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress inetSocketAddress) {
            Intrinsics.checkNotNullParameter(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u000bH\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "routes", "", "Lokhttp3/Route;", "(Ljava/util/List;)V", "nextRouteIndex", "", "getRoutes", "()Ljava/util/List;", "hasNext", "", "next", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Selection {
        private int nextRouteIndex;
        @NotNull
        private final List<Route> routes;

        public Selection(@NotNull List<Route> list) {
            Intrinsics.checkNotNullParameter(list, "routes");
            this.routes = list;
        }

        @NotNull
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @NotNull
        public final Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i11 = this.nextRouteIndex;
                this.nextRouteIndex = i11 + 1;
                return list.get(i11);
            }
            throw new NoSuchElementException();
        }
    }

    public RouteSelector(@NotNull Address address2, @NotNull RouteDatabase routeDatabase2, @NotNull Call call2, @NotNull EventListener eventListener2) {
        Intrinsics.checkNotNullParameter(address2, "address");
        Intrinsics.checkNotNullParameter(routeDatabase2, "routeDatabase");
        Intrinsics.checkNotNullParameter(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.address = address2;
        this.routeDatabase = routeDatabase2;
        this.call = call2;
        this.eventListener = eventListener2;
        resetNextProxy(address2.url(), address2.proxy());
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<? extends Proxy> list = this.proxies;
            int i11 = this.nextProxyIndex;
            this.nextProxyIndex = i11 + 1;
            Proxy proxy = (Proxy) list.get(i11);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String str;
        int i11;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.address.url().host();
            i11 = this.address.url().port();
        } else {
            SocketAddress address2 = proxy.address();
            if (address2 instanceof InetSocketAddress) {
                Companion companion = Companion;
                Intrinsics.checkNotNullExpressionValue(address2, "proxyAddress");
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                str = companion.getSocketHost(inetSocketAddress);
                i11 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Proxy.address() is not an InetSocketAddress: ", address2.getClass()).toString());
            }
        }
        boolean z11 = false;
        if (1 <= i11 && i11 < 65536) {
            z11 = true;
        }
        if (!z11) {
            throw new SocketException("No route to " + str + AbstractJsonLexerKt.COLON + i11 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(str, i11));
        } else {
            this.eventListener.dnsStart(this.call, str);
            List<InetAddress> lookup = this.address.dns().lookup(str);
            if (!lookup.isEmpty()) {
                this.eventListener.dnsEnd(this.call, str, lookup);
                for (InetAddress inetSocketAddress2 : lookup) {
                    arrayList.add(new InetSocketAddress(inetSocketAddress2, i11));
                }
                return;
            }
            throw new UnknownHostException(this.address.dns() + " returned no addresses for " + str);
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy) {
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List<Proxy> resetNextProxy$selectProxies = resetNextProxy$selectProxies(proxy, httpUrl, this);
        this.proxies = resetNextProxy$selectProxies;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, resetNextProxy$selectProxies);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy proxy, HttpUrl httpUrl, RouteSelector routeSelector) {
        boolean z11;
        if (proxy != null) {
            return CollectionsKt__CollectionsJVMKt.listOf(proxy);
        }
        URI uri = httpUrl.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        List<Proxy> select = routeSelector.address.proxySelector().select(uri);
        Collection collection = select;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        Intrinsics.checkNotNullExpressionValue(select, "proxiesOrNull");
        return Util.toImmutableList(select);
    }

    public final boolean hasNext() {
        return hasNextProxy() || (this.postponedRoutes.isEmpty() ^ true);
    }

    @NotNull
    public final Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                Proxy nextProxy = nextProxy();
                for (InetSocketAddress route : this.inetSocketAddresses) {
                    Route route2 = new Route(this.address, nextProxy, route);
                    if (this.routeDatabase.shouldPostpone(route2)) {
                        this.postponedRoutes.add(route2);
                    } else {
                        arrayList.add(route2);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }
}
