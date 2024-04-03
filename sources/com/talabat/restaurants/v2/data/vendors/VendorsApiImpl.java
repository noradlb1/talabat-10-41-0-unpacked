package com.talabat.restaurants.v2.data.vendors;

import JsonModels.Request.RestaurantReq;
import com.talabat.core.network.endpoint.TalabatEndPointProvider;
import com.talabat.core.network.endpoint.VendorEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.restaurants.v2.data.vendors.VendorsApi;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016JR\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsApiImpl;", "Lcom/talabat/restaurants/v2/data/vendors/VendorsApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "getVendorsByArea", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "apiVersion", "", "restaurantReq", "LJsonModels/Request/RestaurantReq;", "getVendorsByPolygons", "latitude", "", "longitude", "experimentDynamicWeightsVertical", "personalApiExperiment", "externalExperiments", "verticalIds", "weightSet", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsApiImpl implements VendorsApi {
    @NotNull
    private final TalabatAPIBuilder talabatAPIBuilder;

    public VendorsApiImpl() {
        this((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null);
    }

    public VendorsApiImpl(@NotNull TalabatAPIBuilder talabatAPIBuilder2) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder2, "talabatAPIBuilder");
        this.talabatAPIBuilder = talabatAPIBuilder2;
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsByArea(int i11, @NotNull RestaurantReq restaurantReq) {
        Intrinsics.checkNotNullParameter(restaurantReq, "restaurantReq");
        return VendorsApi.DefaultImpls.getVendorsByArea$default((VendorsApi) this.talabatAPIBuilder.createApi(TalabatEndPointProvider.INSTANCE.getBaseUrl(), VendorsApi.class), 0, restaurantReq, 1, (Object) null);
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsByPolygons(int i11, @NotNull String str, @NotNull String str2, int i12, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(str3, "personalApiExperiment");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, VendorsUrlConstantsKt.WEIGHT_SET);
        return ((VendorsApi) this.talabatAPIBuilder.createApi(VendorEndPointProvider.INSTANCE.getBaseUrl(), VendorsApi.class)).getVendorsByPolygons(i11, str, str2, i12, str3, str4, str5, str7);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorsApiImpl(TalabatAPIBuilder talabatAPIBuilder2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new TalabatAPIBuilder() : talabatAPIBuilder2);
    }
}
