package com.talabat.restaurants;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.restaurants.factory.RestaurantListInteractorFactory;
import com.talabat.restaurants.v1.IRestaurantsListPresenterRefactor;
import com.talabat.restaurants.v1.RestaurantListViewRefactor;
import com.talabat.restaurants.v1.RestaurantsListPresenterRefactor;
import com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated;
import com.talabat.restaurants.v2.data.vendors.VendorsPaginatedDataSourceImpl;
import com.talabat.restaurants.v2.domain.swimlane.GetSwimlaneGaUseCase;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCaseImpl;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.ShouldUsePolygonApiUseCase;
import com.talabat.restaurants.v2.ui.viewmodels.CollectionTracker;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import io.reactivex.functions.BiFunction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/restaurants/PresenterInitializer;", "Lio/reactivex/functions/BiFunction;", "Lcom/talabat/restaurants/v1/RestaurantListViewRefactor;", "", "Lcom/talabat/restaurants/v1/IRestaurantsListPresenterRefactor;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "apply", "activity", "verticalId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PresenterInitializer implements BiFunction<RestaurantListViewRefactor, Integer, IRestaurantsListPresenterRefactor> {
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public PresenterInitializer(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) {
        return apply((RestaurantListViewRefactor) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public IRestaurantsListPresenterRefactor apply(@NotNull RestaurantListViewRefactor restaurantListViewRefactor, int i11) {
        Intrinsics.checkNotNullParameter(restaurantListViewRefactor, "activity");
        PagedUsedCaseImpl pagedUsedCaseImpl = new PagedUsedCaseImpl(new VendorsPaginatedDataSourceImpl((VendorsApiPaginated) NetworkBuilder.Companion.getService(VendorEndPointProvider.INSTANCE.getBaseUrl(), VendorsApiPaginated.class)), (GetExternalExperimentsUseCase) null, (TimeTrackerImplementation) null, 6, (DefaultConstructorMarker) null);
        if (i11 == 0) {
            RestaurantListInteractorFactory restaurantListInteractorFactory = RestaurantListInteractorFactory.INSTANCE;
            SharedPreferencesManager instance = SharedPreferencesManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            RestaurantListInteractorFactory restaurantListInteractorFactory2 = restaurantListInteractorFactory;
            return new RestaurantsListPresenterRefactor(restaurantListViewRefactor, restaurantListInteractorFactory2.makeRestaurantInteractor(instance, i11, pagedUsedCaseImpl, this.talabatFeatureFlag, this.locationConfigurationRepository), i11, new GetSwimlaneGaUseCase(this.talabatFeatureFlag, pagedUsedCaseImpl.getGetSwimlanes()), pagedUsedCaseImpl.getGetVendors(), TalabatExperiment.INSTANCE, new CollectionTracker((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null));
        }
        GetVendorsUseCase getVendorsUseCase = new GetVendorsUseCase(this.talabatFeatureFlag, new RequestVendorsUseCase((Function6) null, (Function5) null, new ShouldUsePolygonApiUseCase(this.locationConfigurationRepository, (Function0) null, 2, (DefaultConstructorMarker) null), 3, (DefaultConstructorMarker) null));
        RestaurantListInteractorFactory restaurantListInteractorFactory3 = RestaurantListInteractorFactory.INSTANCE;
        SharedPreferencesManager instance2 = SharedPreferencesManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "getInstance()");
        RestaurantListInteractorFactory restaurantListInteractorFactory4 = restaurantListInteractorFactory3;
        return new RestaurantsListPresenterRefactor(restaurantListViewRefactor, restaurantListInteractorFactory4.makeRestaurantInteractor(instance2, i11, pagedUsedCaseImpl, this.talabatFeatureFlag, this.locationConfigurationRepository), i11, new GetSwimlaneGaUseCase(this.talabatFeatureFlag, (Function6) null, 2, (DefaultConstructorMarker) null), getVendorsUseCase, TalabatExperiment.INSTANCE, new CollectionTracker((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null));
    }
}
