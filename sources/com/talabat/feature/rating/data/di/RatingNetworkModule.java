package com.talabat.feature.rating.data.di;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.endpoint.GetPastOrdersEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.rating.data.remote.GetPastOrderApi;
import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.data.remote.RatingFeedBackBaseUrl;
import com.talabat.feature.rating.data.remote.SubFeedBackApi;
import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0011\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/rating/data/di/RatingNetworkModule;", "", "()V", "BASE_URL", "", "BASE_URL_FEEDBACK", "provideBaseUrl", "provideBaseUrlForFeedback", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "ratingFeedBackBaseUrl", "Lcom/talabat/feature/rating/data/remote/RatingFeedBackBaseUrl;", "provideGetPastOrderService", "Lcom/talabat/feature/rating/data/remote/GetPastOrdersService;", "getPastOrderApi", "Lcom/talabat/feature/rating/data/remote/GetPastOrderApi;", "providePastOrderApi", "baseUrl", "provideSubFeedBackApi", "Lcom/talabat/feature/rating/data/remote/SubFeedBackApi;", "provideSubmitFeedBackService", "Lcom/talabat/feature/rating/data/remote/SubmitFeedBackService;", "subFeedBackApi", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RatingNetworkModule {
    @NotNull
    private static final String BASE_URL = "baseUrl";
    @NotNull
    private static final String BASE_URL_FEEDBACK = "BASE_URL_FEEDBACK";
    @NotNull
    public static final RatingNetworkModule INSTANCE = new RatingNetworkModule();

    private RatingNetworkModule() {
    }

    @NotNull
    @Provides
    @Named("baseUrl")
    public final String provideBaseUrl() {
        return new GetPastOrdersEndPointProvider((String) null, 1, (DefaultConstructorMarker) null).getBaseUrl();
    }

    @NotNull
    @Provides
    @Named("BASE_URL_FEEDBACK")
    public final String provideBaseUrlForFeedback(@NotNull BaseUrlFactory baseUrlFactory, @NotNull RatingFeedBackBaseUrl ratingFeedBackBaseUrl) {
        Intrinsics.checkNotNullParameter(baseUrlFactory, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(ratingFeedBackBaseUrl, "ratingFeedBackBaseUrl");
        return baseUrlFactory.baseUrl(ratingFeedBackBaseUrl);
    }

    @NotNull
    @Provides
    public final GetPastOrdersService provideGetPastOrderService(@NotNull GetPastOrderApi getPastOrderApi) {
        Intrinsics.checkNotNullParameter(getPastOrderApi, "getPastOrderApi");
        return new GetPastOrdersService(getPastOrderApi);
    }

    @NotNull
    @Provides
    public final GetPastOrderApi providePastOrderApi(@NotNull @Named("baseUrl") String str) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        return (GetPastOrderApi) new TalabatAPIBuilder().createApi(str, GetPastOrderApi.class);
    }

    @NotNull
    @Provides
    public final SubFeedBackApi provideSubFeedBackApi(@NotNull @Named("BASE_URL_FEEDBACK") String str) {
        Intrinsics.checkNotNullParameter(str, BASE_URL);
        return (SubFeedBackApi) new TalabatAPIBuilder().createApi(str, SubFeedBackApi.class);
    }

    @NotNull
    @Provides
    public final SubmitFeedBackService provideSubmitFeedBackService(@NotNull SubFeedBackApi subFeedBackApi) {
        Intrinsics.checkNotNullParameter(subFeedBackApi, "subFeedBackApi");
        return new SubmitFeedBackService(subFeedBackApi);
    }
}
