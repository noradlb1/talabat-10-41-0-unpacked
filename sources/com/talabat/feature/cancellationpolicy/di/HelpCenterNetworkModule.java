package com.talabat.feature.cancellationpolicy.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyApi;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyBaseUrl;
import com.talabat.feature.cancellationpolicy.remote.CancellationPolicyService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/di/HelpCenterNetworkModule;", "", "()V", "BASE_URL_CANCELLATION_POLICY", "", "provideBaseUrlCancellationPolicy", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "cancellationPolicyBaseUrl", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyBaseUrl;", "provideCancellationApi", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyApi;", "baseUrl", "provideCancellationService", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyService;", "cancellationPolicyApi", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class HelpCenterNetworkModule {
    @NotNull
    private static final String BASE_URL_CANCELLATION_POLICY = "baseUrl";
    @NotNull
    public static final HelpCenterNetworkModule INSTANCE = new HelpCenterNetworkModule();

    private HelpCenterNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrlCancellationPolicy(@NotNull BaseUrlFactory baseUrlFactory, @NotNull CancellationPolicyBaseUrl cancellationPolicyBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(cancellationPolicyBaseUrl, "cancellationPolicyBaseUrl");
        return baseUrlFactory.baseUrl(cancellationPolicyBaseUrl);
    }

    @NotNull
    @Provides
    public final CancellationPolicyApi provideCancellationApi(@NotNull @Named("baseUrl") String str) {
        Intrinsics.checkNotNullParameter(str, BASE_URL_CANCELLATION_POLICY);
        return (CancellationPolicyApi) new TalabatAPIBuilder().createApi(str, CancellationPolicyApi.class);
    }

    @NotNull
    @Provides
    public final CancellationPolicyService provideCancellationService(@NotNull CancellationPolicyApi cancellationPolicyApi) {
        Intrinsics.checkNotNullParameter(cancellationPolicyApi, "cancellationPolicyApi");
        return new CancellationPolicyService(cancellationPolicyApi);
    }
}
