package com.talabat.location;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.helpers.BASEURLS;
import com.talabat.location.area.data.api.AreaApi;
import com.talabat.location.area.data.impl.AreaRepositoryImpl;
import com.talabat.location.area.domain.repository.AreaRepository;
import com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase;
import com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/location/LocationDependencyProvider;", "", "()V", "provideAreaApi", "Lcom/talabat/location/area/data/api/AreaApi;", "provideAreaRepository", "Lcom/talabat/location/area/domain/repository/AreaRepository;", "areaApi", "provideUpdateAreaOfSelectedAddressIfChangedUseCase", "Lcom/talabat/location/area/domain/usecases/UpdateAreaOfSelectedAddressIfChangedUseCase;", "context", "Landroid/content/Context;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationDependencyProvider {
    @NotNull
    public static final LocationDependencyProvider INSTANCE = new LocationDependencyProvider();

    private LocationDependencyProvider() {
    }

    @NotNull
    public final AreaApi provideAreaApi() {
        TalabatAPIBuilder talabatAPIBuilder = new TalabatAPIBuilder();
        String buildUserLocationBaseURL = BASEURLS.buildUserLocationBaseURL("release");
        Intrinsics.checkNotNullExpressionValue(buildUserLocationBaseURL, "buildUserLocationBaseURL(BuildConfig.BUILD_TYPE)");
        return (AreaApi) talabatAPIBuilder.createApi(buildUserLocationBaseURL, AreaApi.class);
    }

    @NotNull
    public final AreaRepository provideAreaRepository(@NotNull AreaApi areaApi) {
        Intrinsics.checkNotNullParameter(areaApi, "areaApi");
        return new AreaRepositoryImpl(areaApi);
    }

    @NotNull
    public final UpdateAreaOfSelectedAddressIfChangedUseCase provideUpdateAreaOfSelectedAddressIfChangedUseCase(@NotNull Context context, @NotNull AppVersionProvider appVersionProvider, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        AreaRepository provideAreaRepository = provideAreaRepository(provideAreaApi());
        Customer instance = Customer.getInstance();
        CustomerAddressesRepository provideCustomerAddressesRepository = AddressesDependencyProvider.INSTANCE.provideCustomerAddressesRepository(iTalabatFeatureFlag);
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        LocationDependencyProvider$provideUpdateAreaOfSelectedAddressIfChangedUseCase$1 locationDependencyProvider$provideUpdateAreaOfSelectedAddressIfChangedUseCase$1 = new LocationDependencyProvider$provideUpdateAreaOfSelectedAddressIfChangedUseCase$1(iTalabatFeatureFlag);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new UpdateAreaOfSelectedAddressIfChangedUseCaseImpl(context, appVersionProvider, provideAreaRepository, locationDependencyProvider$provideUpdateAreaOfSelectedAddressIfChangedUseCase$1, instance, (Function1) null, talabatExperiment, provideCustomerAddressesRepository, 32, (DefaultConstructorMarker) null);
    }
}
