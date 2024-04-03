package com.talabat.feature.rating.data.di;

import android.content.Context;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ApplicationContext;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.feature.rating.data.GetPastOrdersRepositoryImpl;
import com.talabat.feature.rating.data.RatingSessionImpl;
import com.talabat.feature.rating.data.SubmitFeedBackRepositoryImpl;
import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/rating/data/di/RatingUserDataModule;", "", "()V", "COUNTRY_ID", "", "provideCountryId", "", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "provideExperimentProvider", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "provideGetPastOrderRepository", "Lcom/talabat/feature/rating/domain/repo/GetPastOrdersRepository;", "getPastOrdersService", "Lcom/talabat/feature/rating/data/remote/GetPastOrdersService;", "provideGetPastOrdersRequestParams", "Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParamsProvider;", "countryId", "provideRatingSession", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "context", "Landroid/content/Context;", "encryptedStorageProvider", "Lcom/talabat/authentication/token/data/local/EncryptedStorageProvider;", "provideSubmitFeedBackRepository", "Lcom/talabat/feature/rating/domain/repo/SubmitFeedBackRepository;", "submitFeedBackService", "Lcom/talabat/feature/rating/data/remote/SubmitFeedBackService;", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class RatingUserDataModule {
    @NotNull
    private static final String COUNTRY_ID = "countryId";
    @NotNull
    public static final RatingUserDataModule INSTANCE = new RatingUserDataModule();

    private RatingUserDataModule() {
    }

    @Provides
    @Named("countryId")
    public final int provideCountryId(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi, "configurationLocalCoreLibApi");
        return configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId();
    }

    @NotNull
    @Provides
    public final ITalabatExperiment provideExperimentProvider() {
        return TalabatExperiment.INSTANCE;
    }

    @NotNull
    @Provides
    public final GetPastOrdersRepository provideGetPastOrderRepository(@NotNull GetPastOrdersService getPastOrdersService) {
        Intrinsics.checkNotNullParameter(getPastOrdersService, "getPastOrdersService");
        return new GetPastOrdersRepositoryImpl(getPastOrdersService, Dispatchers.getIO());
    }

    @NotNull
    @Provides
    public final GetPastOrdersRequestParamsProvider provideGetPastOrdersRequestParams(@Named("countryId") int i11) {
        return new GetPastOrdersRequestParamsProvider(i11);
    }

    @NotNull
    @Provides
    public final RatingSession provideRatingSession(@NotNull @ApplicationContext Context context, @NotNull EncryptedStorageProvider encryptedStorageProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encryptedStorageProvider, "encryptedStorageProvider");
        return new RatingSessionImpl(context, encryptedStorageProvider);
    }

    @NotNull
    @Provides
    public final SubmitFeedBackRepository provideSubmitFeedBackRepository(@NotNull SubmitFeedBackService submitFeedBackService) {
        Intrinsics.checkNotNullParameter(submitFeedBackService, "submitFeedBackService");
        return new SubmitFeedBackRepositoryImpl(submitFeedBackService, Dispatchers.getIO());
    }
}
