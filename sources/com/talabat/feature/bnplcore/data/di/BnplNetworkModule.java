package com.talabat.feature.bnplcore.data.di;

import android.content.Context;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.flutter.channels.domain.PlatformChannel;
import com.talabat.core.flutter.channels.domain.config.GlobalChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.observability.ObservabilityChannelFlutterDomain;
import com.talabat.core.flutter.channels.domain.secrets.SecretsChannelFlutterDomain;
import com.talabat.core.network.domain.MoshiRetrofit;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.feature.bnplcore.data.remote.BnplApi;
import com.talabat.feature.bnplcore.data.remote.BnplCoreFeatureBaseUrl;
import com.talabat.feature.bnplcore.domain.usecase.impl.BNPLCoreFlutterChannel;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u00100\fH\u0007J\u0012\u0010\u0011\u001a\u00020\n2\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0007J*\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/bnplcore/data/di/BnplNetworkModule;", "", "()V", "provideBNPLApi", "Lcom/talabat/feature/bnplcore/data/remote/BnplApi;", "retrofit", "Lretrofit2/Retrofit;", "provideBNPLCoreFlutterChannel", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/BNPLCoreFlutterChannel;", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "channels", "", "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/talabat/core/flutter/channels/domain/PlatformChannel;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideFlutterEngine", "context", "Landroid/content/Context;", "provideRetrofit", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "okHttpClient", "Lokhttp3/OkHttpClient;", "bnplCoreFeatureBaseUrl", "Lcom/talabat/feature/bnplcore/data/remote/BnplCoreFeatureBaseUrl;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class BnplNetworkModule {
    @NotNull
    public static final BnplNetworkModule INSTANCE = new BnplNetworkModule();

    private BnplNetworkModule() {
    }

    @JvmStatic
    @NotNull
    @Reusable
    @Provides
    public static final BnplApi provideBNPLApi(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(BnplApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "retrofit.create(BnplApi::class.java)");
        return (BnplApi) create;
    }

    @JvmStatic
    @NotNull
    @Reusable
    @Provides
    public static final BNPLCoreFlutterChannel provideBNPLCoreFlutterChannel(@NotNull FlutterEngine flutterEngine, @NotNull Map<Class<?>, Provider<PlatformChannel>> map) {
        PlatformChannel platformChannel;
        GlobalChannelFlutterDomain globalChannelFlutterDomain;
        PlatformChannel platformChannel2;
        ObservabilityChannelFlutterDomain observabilityChannelFlutterDomain;
        PlatformChannel platformChannel3;
        SecretsChannelFlutterDomain secretsChannelFlutterDomain;
        PlatformChannel platformChannel4;
        ExperimentChannelFlutterDomain experimentChannelFlutterDomain;
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        Intrinsics.checkNotNullParameter(map, "channels");
        Provider provider = map.get(GlobalChannelFlutterDomain.class);
        if (provider != null) {
            platformChannel = (PlatformChannel) provider.get();
        } else {
            platformChannel = null;
        }
        if (platformChannel instanceof GlobalChannelFlutterDomain) {
            globalChannelFlutterDomain = (GlobalChannelFlutterDomain) platformChannel;
        } else {
            globalChannelFlutterDomain = null;
        }
        Provider provider2 = map.get(ObservabilityChannelFlutterDomain.class);
        if (provider2 != null) {
            platformChannel2 = (PlatformChannel) provider2.get();
        } else {
            platformChannel2 = null;
        }
        if (platformChannel2 instanceof ObservabilityChannelFlutterDomain) {
            observabilityChannelFlutterDomain = (ObservabilityChannelFlutterDomain) platformChannel2;
        } else {
            observabilityChannelFlutterDomain = null;
        }
        Provider provider3 = map.get(SecretsChannelFlutterDomain.class);
        if (provider3 != null) {
            platformChannel3 = (PlatformChannel) provider3.get();
        } else {
            platformChannel3 = null;
        }
        if (platformChannel3 instanceof SecretsChannelFlutterDomain) {
            secretsChannelFlutterDomain = (SecretsChannelFlutterDomain) platformChannel3;
        } else {
            secretsChannelFlutterDomain = null;
        }
        Provider provider4 = map.get(ExperimentChannelFlutterDomain.class);
        if (provider4 != null) {
            platformChannel4 = (PlatformChannel) provider4.get();
        } else {
            platformChannel4 = null;
        }
        if (platformChannel4 instanceof ExperimentChannelFlutterDomain) {
            experimentChannelFlutterDomain = (ExperimentChannelFlutterDomain) platformChannel4;
        } else {
            experimentChannelFlutterDomain = null;
        }
        return new BNPLCoreFlutterChannel(flutterEngine, globalChannelFlutterDomain, observabilityChannelFlutterDomain, secretsChannelFlutterDomain, experimentChannelFlutterDomain, new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.talabat.flutter/bnpl-core"));
    }

    @JvmStatic
    @NotNull
    @Reusable
    @Provides
    public static final FlutterEngine provideFlutterEngine(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FlutterEngine flutterEngine = new FlutterEngine(context);
        flutterEngine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), "main"));
        return flutterEngine;
    }

    @JvmStatic
    @NotNull
    @Reusable
    @Provides
    public static final Retrofit provideRetrofit(@NotNull @MoshiRetrofit Retrofit.Builder builder, @NotNull OkHttpClient okHttpClient, @NotNull BnplCoreFeatureBaseUrl bnplCoreFeatureBaseUrl, @NotNull BaseUrlFactory baseUrlFactory) {
        Intrinsics.checkNotNullParameter(builder, "retrofitBuilder");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(bnplCoreFeatureBaseUrl, "bnplCoreFeatureBaseUrl");
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Retrofit build = builder.client(okHttpClient).baseUrl(baseUrlFactory.baseUrl(bnplCoreFeatureBaseUrl)).build();
        Intrinsics.checkNotNullExpressionValue(build, "retrofitBuilder.client(o…eFeatureBaseUrl)).build()");
        return build;
    }
}
