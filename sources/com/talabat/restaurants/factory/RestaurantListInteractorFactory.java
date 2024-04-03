package com.talabat.restaurants.factory;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.restaurants.v1.IRestaurantsListInteractorRefactor;
import com.talabat.restaurants.v1.RestaurantListInteractorPaginated;
import com.talabat.restaurants.v1.RestaurantsListInteractorRefactor;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import com.talabat.restaurants.v2.data.vendorinfo.VendorsInfoRepository;
import com.talabat.restaurants.v2.domain.swimlane.RequestSwimlanesUseCase;
import com.talabat.restaurants.v2.domain.utils.GetVerticalsUseCase;
import com.talabat.restaurants.v2.domain.vendorinfo.RequestVendorInfoUseCase;
import com.talabat.restaurants.v2.domain.vendors.PagedUsedCase;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.ShouldUsePolygonApiUseCase;
import com.talabat.talabatcommon.feature.vendorTags.data.VendorTagsRepository;
import com.talabat.talabatcommon.feature.vendorTags.domain.RequestVendorTagsUseCase;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/restaurants/factory/RestaurantListInteractorFactory;", "", "()V", "makeRestaurantInteractor", "Lcom/talabat/restaurants/v1/IRestaurantsListInteractorRefactor;", "sharedPreferencesManager", "Llibrary/talabat/SharedPreferencesManager;", "verticalId", "", "pagedUsedCase", "Lcom/talabat/restaurants/v2/domain/vendors/PagedUsedCase;", "talabaFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantListInteractorFactory {
    @NotNull
    public static final RestaurantListInteractorFactory INSTANCE = new RestaurantListInteractorFactory();

    private RestaurantListInteractorFactory() {
    }

    @NotNull
    public final IRestaurantsListInteractorRefactor makeRestaurantInteractor(@NotNull SharedPreferencesManager sharedPreferencesManager, int i11, @NotNull PagedUsedCase pagedUsedCase, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        boolean z11;
        SharedPreferencesManager sharedPreferencesManager2 = sharedPreferencesManager;
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        Intrinsics.checkNotNullParameter(sharedPreferencesManager2, "sharedPreferencesManager");
        Intrinsics.checkNotNullParameter(pagedUsedCase, "pagedUsedCase");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "talabaFeatureFlag");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new RestaurantListInteractorPaginated(pagedUsedCase, new RequestVendorTagsUseCase((VendorTagsRepository) null, 1, (DefaultConstructorMarker) null), new GetVerticalsUseCase(sharedPreferencesManager2, iTalabatFeatureFlag2), (Scheduler) null, (Scheduler) null, 24, (DefaultConstructorMarker) null);
        }
        ShouldUsePolygonApiUseCase shouldUsePolygonApiUseCase = new ShouldUsePolygonApiUseCase(locationConfigurationRepository2, (Function0) null, 2, (DefaultConstructorMarker) null);
        return new RestaurantsListInteractorRefactor(new RequestVendorInfoUseCase((VendorsInfoRepository) null, 1, (DefaultConstructorMarker) null), new RequestSwimlanesUseCase((SwimlaneRepository) null, 1, (DefaultConstructorMarker) null), new RequestVendorsUseCase((Function6) null, (Function5) null, shouldUsePolygonApiUseCase, 3, (DefaultConstructorMarker) null), shouldUsePolygonApiUseCase, iTalabatFeatureFlag);
    }
}
