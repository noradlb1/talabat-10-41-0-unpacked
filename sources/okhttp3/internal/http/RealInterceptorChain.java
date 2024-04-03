package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010J\b\u0010\u0002\u001a\u00020\u001cH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "call", "Lokhttp3/internal/connection/RealCall;", "interceptors", "", "Lokhttp3/Interceptor;", "index", "", "exchange", "Lokhttp3/internal/connection/Exchange;", "request", "Lokhttp3/Request;", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "calls", "getConnectTimeoutMillis$okhttp", "()I", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getReadTimeoutMillis$okhttp", "getRequest$okhttp", "()Lokhttp3/Request;", "getWriteTimeoutMillis$okhttp", "Lokhttp3/Call;", "connection", "Lokhttp3/Connection;", "copy", "copy$okhttp", "proceed", "Lokhttp3/Response;", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {
    @NotNull
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    @Nullable
    private final Exchange exchange;
    private final int index;
    @NotNull
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    @NotNull
    private final Request request;
    private final int writeTimeoutMillis;

    public RealInterceptorChain(@NotNull RealCall realCall, @NotNull List<? extends Interceptor> list, int i11, @Nullable Exchange exchange2, @NotNull Request request2, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(request2, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i11;
        this.exchange = exchange2;
        this.request = request2;
        this.connectTimeoutMillis = i12;
        this.readTimeoutMillis = i13;
        this.writeTimeoutMillis = i14;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i11, Exchange exchange2, Request request2, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = realInterceptorChain.index;
        }
        if ((i15 & 2) != 0) {
            exchange2 = realInterceptorChain.exchange;
        }
        Exchange exchange3 = exchange2;
        if ((i15 & 4) != 0) {
            request2 = realInterceptorChain.request;
        }
        Request request3 = request2;
        if ((i15 & 8) != 0) {
            i12 = realInterceptorChain.connectTimeoutMillis;
        }
        int i16 = i12;
        if ((i15 & 16) != 0) {
            i13 = realInterceptorChain.readTimeoutMillis;
        }
        int i17 = i13;
        if ((i15 & 32) != 0) {
            i14 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i11, exchange3, request3, i16, i17, i14);
    }

    @NotNull
    public Call call() {
        return this.call;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Nullable
    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 == null) {
            return null;
        }
        return exchange2.getConnection$okhttp();
    }

    @NotNull
    public final RealInterceptorChain copy$okhttp(int i11, @Nullable Exchange exchange2, @NotNull Request request2, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(request2, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i11, exchange2, request2, i12, i13, i14);
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    @Nullable
    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    @NotNull
    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @NotNull
    public Response proceed(@NotNull Request request2) throws IOException {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(request2, "request");
        boolean z14 = false;
        if (this.index < this.interceptors.size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                if (exchange2.getFinder$okhttp().sameHostAndPort(request2.url())) {
                    if (this.calls == 1) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z13) {
                        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
                }
            }
            RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, (Exchange) null, request2, 0, 0, 0, 58, (Object) null);
            Interceptor interceptor = this.interceptors.get(this.index);
            Response intercept = interceptor.intercept(copy$okhttp$default);
            if (intercept != null) {
                if (this.exchange != null) {
                    if (this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.body() != null) {
                    z14 = true;
                }
                if (z14) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @NotNull
    public Request request() {
        return this.request;
    }

    @NotNull
    public Interceptor.Chain withConnectTimeout(int i11, @NotNull TimeUnit timeUnit) {
        boolean z11;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, Util.checkDuration("connectTimeout", (long) i11, timeUnit), 0, 0, 55, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @NotNull
    public Interceptor.Chain withReadTimeout(int i11, @NotNull TimeUnit timeUnit) {
        boolean z11;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, Util.checkDuration("readTimeout", (long) i11, timeUnit), 0, 47, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @NotNull
    public Interceptor.Chain withWriteTimeout(int i11, @NotNull TimeUnit timeUnit) {
        boolean z11;
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return copy$okhttp$default(this, 0, (Exchange) null, (Request) null, 0, 0, Util.checkDuration("writeTimeout", (long) i11, timeUnit), 31, (Object) null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
