package com.talabat.restaurants.v2.domain.vendors;

import JsonModels.Request.RestaurantReq;
import com.talabat.restaurants.v2.data.vendors.VendorsRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u000022\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0001B\u000f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ?\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/RequestVendorsByAreaUseCase;", "Lkotlin/Function6;", "", "", "", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "vendorsRepository", "Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;)V", "invoke", "isForceUpdate", "areaId", "countryId", "cityId", "latitude", "longitude", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestVendorsByAreaUseCase implements Function6<Boolean, Integer, Integer, Integer, String, String, Single<RestuarntListResponse>> {
    @NotNull
    private final VendorsRepository vendorsRepository;

    public RequestVendorsByAreaUseCase() {
        this((VendorsRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public RequestVendorsByAreaUseCase(@NotNull VendorsRepository vendorsRepository2) {
        Intrinsics.checkNotNullParameter(vendorsRepository2, "vendorsRepository");
        this.vendorsRepository = vendorsRepository2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue(), (String) obj5, (String) obj6);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RequestVendorsByAreaUseCase(com.talabat.restaurants.v2.data.vendors.VendorsRepository r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r6 = this;
            r8 = r8 & 1
            if (r8 == 0) goto L_0x000f
            com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl r7 = new com.talabat.restaurants.v2.data.vendors.VendorsRepositoryImpl
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x000f:
            r6.<init>(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.vendors.RequestVendorsByAreaUseCase.<init>(com.talabat.restaurants.v2.data.vendors.VendorsRepository, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public Single<RestuarntListResponse> invoke(boolean z11, int i11, int i12, int i13, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        RestaurantReq restaurantReq = new RestaurantReq(i11, i13, i12);
        restaurantReq.latitude = str;
        restaurantReq.longitude = str2;
        return this.vendorsRepository.getVendorsByArea(z11, restaurantReq);
    }
}
