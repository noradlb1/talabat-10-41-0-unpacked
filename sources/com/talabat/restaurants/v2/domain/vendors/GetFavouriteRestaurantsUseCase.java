package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.network.data.endpoint.DefaultBaseUrlFactory;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.v2.data.vendors.AreaParams;
import com.talabat.restaurants.v2.data.vendors.VendorByIdDataSource;
import com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated;
import com.talabat.restaurants.v2.data.vendors.VendorsBaseUrl;
import com.talabat.restaurants.v2.data.vendors.VendorsByIdDataSourceImpl;
import com.talabat.restaurants.v2.domain.utils.GetExternalExperimentsUseCase;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/GetFavouriteRestaurantsUseCase;", "Lkotlin/Function0;", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "externalExperimentsUseCase", "Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;", "vendorByIdDataSource", "Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;", "(Lcom/talabat/restaurants/v2/domain/utils/GetExternalExperimentsUseCase;Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;)V", "invoke", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFavouriteRestaurantsUseCase implements Function0<Single<List<? extends Restaurant>>> {
    @NotNull
    private final GetExternalExperimentsUseCase externalExperimentsUseCase;
    @NotNull
    private final VendorByIdDataSource vendorByIdDataSource;

    public GetFavouriteRestaurantsUseCase() {
        this((GetExternalExperimentsUseCase) null, (VendorByIdDataSource) null, 3, (DefaultConstructorMarker) null);
    }

    public GetFavouriteRestaurantsUseCase(@NotNull GetExternalExperimentsUseCase getExternalExperimentsUseCase, @NotNull VendorByIdDataSource vendorByIdDataSource2) {
        Intrinsics.checkNotNullParameter(getExternalExperimentsUseCase, "externalExperimentsUseCase");
        Intrinsics.checkNotNullParameter(vendorByIdDataSource2, "vendorByIdDataSource");
        this.externalExperimentsUseCase = getExternalExperimentsUseCase;
        this.vendorByIdDataSource = vendorByIdDataSource2;
    }

    @NotNull
    public Single<List<Restaurant>> invoke() {
        HashSet<Integer> favouriteVendorIds = SharedPreferencesManager.getInstance().getFavouriteVendorIds();
        Intrinsics.checkNotNullExpressionValue(favouriteVendorIds, "getInstance().favouriteVendorIds");
        List list = CollectionsKt___CollectionsKt.toList(favouriteVendorIds);
        if (list.isEmpty()) {
            Single<List<Restaurant>> just = Single.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "just(emptyList())");
            return just;
        }
        AreaParams areaParams = new AreaParams(String.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), String.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()), GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedCountryId);
        return VendorByIdDataSource.DefaultImpls.getVendorById$default(this.vendorByIdDataSource, areaParams, list, this.externalExperimentsUseCase.invoke(((Number) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_BOOST_RANKING, Double.valueOf(0.0d), (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).doubleValue(), (String) Experiments.withSafeExperiment$default(TalabatExperimentConstants.VL_DYNAMIC_RANKING, "", (ITalabatExperiment) null, (Function1) null, 12, (Object) null)), (String) null, (String) null, 24, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetFavouriteRestaurantsUseCase(GetExternalExperimentsUseCase getExternalExperimentsUseCase, VendorByIdDataSource vendorByIdDataSource2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new GetExternalExperimentsUseCase() : getExternalExperimentsUseCase, (i11 & 2) != 0 ? new VendorsByIdDataSourceImpl((VendorsApiPaginated) NetworkBuilder.Companion.getService(new DefaultBaseUrlFactory().baseUrl(new VendorsBaseUrl()), VendorsApiPaginated.class)) : vendorByIdDataSource2);
    }
}
