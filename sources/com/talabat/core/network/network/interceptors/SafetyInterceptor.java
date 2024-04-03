package com.talabat.core.network.network.interceptors;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/network/network/interceptors/SafetyInterceptor;", "Lokhttp3/Interceptor;", "()V", "installationPath", "", "getInstallationPath", "()Ljava/lang/String;", "installationPath$delegate", "Lkotlin/Lazy;", "packageName", "getPackageName", "packageName$delegate", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafetyInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_PACKAGE_NAME = "X-Talabat-Android-Package-Name";
    @NotNull
    private static final String KEY_PATH = "X-Talabat-Android-Installation-Path";
    @NotNull
    private final Lazy installationPath$delegate;
    @NotNull
    private final Lazy packageName$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/network/interceptors/SafetyInterceptor$Companion;", "", "()V", "KEY_PACKAGE_NAME", "", "KEY_PATH", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafetyInterceptor() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.packageName$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SafetyInterceptor$packageName$2.INSTANCE);
        this.installationPath$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SafetyInterceptor$installationPath$2.INSTANCE);
    }

    private final String getInstallationPath() {
        return (String) this.installationPath$delegate.getValue();
    }

    private final String getPackageName() {
        return (String) this.packageName$delegate.getValue();
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder header = chain.request().newBuilder().header(KEY_PATH, getInstallationPath()).header(KEY_PACKAGE_NAME, getPackageName());
        if (!(header instanceof Request.Builder)) {
            request = header.build();
        } else {
            request = OkHttp3Instrumentation.build(header);
        }
        return chain.proceed(request);
    }
}
