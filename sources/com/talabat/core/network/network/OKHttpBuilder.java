package com.talabat.core.network.network;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.okhttplogger.InstabugOkhttpInterceptor;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.network.midas.MidasHttpInterceptor;
import com.talabat.core.network.network.interceptors.SafetyInterceptor;
import com.talabat.core.network.network.interceptors.TrackingInterceptor;
import com.talabat.core.network.testutils.IsMockServerTestingKt;
import com.talabat.core.network.testutils.OkHttpIdlingResource;
import com.talabat.core.observabilityNew.domain.RequestResponseObservability;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\r\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dJ\"\u0010\u001e\u001a\u00020\u00062\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007J$\u0010!\u001a\u00020\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0007J\u0006\u0010\"\u001a\u00020\u0006J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\"\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/core/network/network/OKHttpBuilder;", "", "()V", "REQUEST_TIMEOUT", "", "baseOkHttpClient", "Lokhttp3/OkHttpClient;", "fwfObservabilityManager", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "logInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClientWithTalabatInterceptors", "requestResponseObservability", "Lcom/talabat/core/observabilityNew/domain/RequestResponseObservability;", "trackingInterceptor", "Lcom/talabat/core/network/network/interceptors/TrackingInterceptor;", "trackingManager", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "addInterceptorsAndTimeoutsTo", "Lokhttp3/OkHttpClient$Builder;", "okHttpClientBuilder", "extraInterceptors", "", "Lokhttp3/Interceptor;", "requestTimeoutInSeconds", "applyTalabatInterceptors", "okHttpBuilder", "clear", "", "clear$com_talabat_core_network_data_data", "getBaseHttpClient", "withInterceptors", "withRequestTimeoutInSeconds", "getDefaultHttpClient", "getOkHttpClient", "initBaseClient", "initOkHttpClientWithTalabatInterceptors", "setTrackingAndObservability", "observability", "tracker", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OKHttpBuilder {
    @NotNull
    public static final OKHttpBuilder INSTANCE = new OKHttpBuilder();
    private static final long REQUEST_TIMEOUT = 60;
    private static OkHttpClient baseOkHttpClient;
    @Nullable
    private static FunWithFlagsObservabilityPort fwfObservabilityManager;
    @NotNull
    private static final HttpLoggingInterceptor logInterceptor;
    private static OkHttpClient okHttpClientWithTalabatInterceptors;
    @Nullable
    private static RequestResponseObservability requestResponseObservability;
    @Nullable
    private static TrackingInterceptor trackingInterceptor;
    @Nullable
    private static FunWithFlagsTrackingPort trackingManager;

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
        logInterceptor = httpLoggingInterceptor;
    }

    private OKHttpBuilder() {
    }

    private final OkHttpClient.Builder addInterceptorsAndTimeoutsTo(OkHttpClient.Builder builder, List<? extends Interceptor> list, long j11) {
        for (Interceptor addInterceptor : list) {
            builder.addInterceptor(addInterceptor);
        }
        if (j11 != 60) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(j11, timeUnit).readTimeout(j11, timeUnit).writeTimeout(j11, timeUnit);
        }
        return builder;
    }

    private final OkHttpClient.Builder applyTalabatInterceptors(OkHttpClient.Builder builder) {
        return builder.addInterceptor(new TalabatHttpInterceptor(requestResponseObservability)).addInterceptor(MidasHttpInterceptor.INSTANCE).addInterceptor(new SafetyInterceptor()).authenticator(new TalabatAuthenticator(requestResponseObservability));
    }

    public static /* synthetic */ OkHttpClient getBaseHttpClient$default(OKHttpBuilder oKHttpBuilder, List list, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i11 & 2) != 0) {
            j11 = 60;
        }
        return oKHttpBuilder.getBaseHttpClient(list, j11);
    }

    public static /* synthetic */ OkHttpClient getDefaultHttpClient$default(OKHttpBuilder oKHttpBuilder, List list, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = null;
        }
        if ((i11 & 2) != 0) {
            j11 = 60;
        }
        return oKHttpBuilder.getDefaultHttpClient(list, j11);
    }

    private final void initBaseClient() {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = newBuilder.connectTimeout(60, timeUnit).readTimeout(60, timeUnit).writeTimeout(60, timeUnit).addInterceptor(logInterceptor).addInterceptor(new InstabugOkhttpInterceptor());
        TrackingInterceptor trackingInterceptor2 = trackingInterceptor;
        if (trackingInterceptor2 != null) {
            addInterceptor.addInterceptor(trackingInterceptor2);
        }
        OkHttpClient build = addInterceptor.build();
        if (IsMockServerTestingKt.isIdlingResourceRequired()) {
            OkHttpIdlingResource.register(build);
        }
        baseOkHttpClient = build;
    }

    private final void initOkHttpClientWithTalabatInterceptors() {
        if (baseOkHttpClient == null) {
            initBaseClient();
        }
        OkHttpClient okHttpClient = baseOkHttpClient;
        if (okHttpClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseOkHttpClient");
            okHttpClient = null;
        }
        okHttpClientWithTalabatInterceptors = applyTalabatInterceptors(okHttpClient.newBuilder()).build();
    }

    public static /* synthetic */ void setTrackingAndObservability$default(OKHttpBuilder oKHttpBuilder, FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, FunWithFlagsTrackingPort funWithFlagsTrackingPort, RequestResponseObservability requestResponseObservability2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            requestResponseObservability2 = null;
        }
        oKHttpBuilder.setTrackingAndObservability(funWithFlagsObservabilityPort, funWithFlagsTrackingPort, requestResponseObservability2);
    }

    @VisibleForTesting
    public final void clear$com_talabat_core_network_data_data() {
        fwfObservabilityManager = null;
        trackingInterceptor = null;
        trackingManager = null;
        requestResponseObservability = null;
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getBaseHttpClient() {
        return getBaseHttpClient$default(this, (List) null, 0, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getBaseHttpClient(@NotNull List<? extends Interceptor> list) {
        Intrinsics.checkNotNullParameter(list, "withInterceptors");
        return getBaseHttpClient$default(this, list, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getBaseHttpClient(@NotNull List<? extends Interceptor> list, long j11) {
        Intrinsics.checkNotNullParameter(list, "withInterceptors");
        if (baseOkHttpClient == null) {
            initBaseClient();
        }
        OkHttpClient okHttpClient = null;
        if (!list.isEmpty() || j11 != 60) {
            OkHttpClient okHttpClient2 = baseOkHttpClient;
            if (okHttpClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseOkHttpClient");
            } else {
                okHttpClient = okHttpClient2;
            }
            return addInterceptorsAndTimeoutsTo(okHttpClient.newBuilder(), list, j11).build();
        }
        OkHttpClient okHttpClient3 = baseOkHttpClient;
        if (okHttpClient3 != null) {
            return okHttpClient3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseOkHttpClient");
        return null;
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getDefaultHttpClient() {
        return getDefaultHttpClient$default(this, (List) null, 0, 3, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getDefaultHttpClient(@Nullable List<? extends Interceptor> list) {
        return getDefaultHttpClient$default(this, list, 0, 2, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final OkHttpClient getDefaultHttpClient(@Nullable List<? extends Interceptor> list, long j11) {
        if (okHttpClientWithTalabatInterceptors == null) {
            initOkHttpClientWithTalabatInterceptors();
        }
        OkHttpClient okHttpClient = null;
        if (list == null && j11 == 60) {
            OkHttpClient okHttpClient2 = okHttpClientWithTalabatInterceptors;
            if (okHttpClient2 != null) {
                return okHttpClient2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("okHttpClientWithTalabatInterceptors");
            return null;
        }
        OkHttpClient okHttpClient3 = okHttpClientWithTalabatInterceptors;
        if (okHttpClient3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("okHttpClientWithTalabatInterceptors");
        } else {
            okHttpClient = okHttpClient3;
        }
        OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return addInterceptorsAndTimeoutsTo(newBuilder, list, j11).build();
    }

    @NotNull
    public final OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder addInterceptor = builder.readTimeout(120, timeUnit).connectTimeout(120, timeUnit).addInterceptor(logInterceptor);
        TrackingInterceptor trackingInterceptor2 = trackingInterceptor;
        if (trackingInterceptor2 != null) {
            addInterceptor.addInterceptor(trackingInterceptor2);
        }
        return applyTalabatInterceptors(addInterceptor).build();
    }

    public final void setTrackingAndObservability(@NotNull FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, @NotNull FunWithFlagsTrackingPort funWithFlagsTrackingPort, @Nullable RequestResponseObservability requestResponseObservability2) {
        Intrinsics.checkNotNullParameter(funWithFlagsObservabilityPort, "observability");
        Intrinsics.checkNotNullParameter(funWithFlagsTrackingPort, "tracker");
        fwfObservabilityManager = funWithFlagsObservabilityPort;
        trackingManager = funWithFlagsTrackingPort;
        requestResponseObservability = requestResponseObservability2;
        trackingInterceptor = new TrackingInterceptor(funWithFlagsObservabilityPort, funWithFlagsTrackingPort);
    }
}
