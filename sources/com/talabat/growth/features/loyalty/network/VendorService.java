package com.talabat.growth.features.loyalty.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/talabat/growth/features/loyalty/network/VendorService;", "Lcom/talabat/growth/features/loyalty/network/VendorApi;", "apiBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/growth/features/loyalty/network/VendorApi;", "api$delegate", "Lkotlin/Lazy;", "getVendors", "Lretrofit2/Call;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "latitude", "", "longitude", "pageNumber", "", "pageSize", "vendorIds", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorService implements VendorApi {
    @NotNull
    private final Lazy api$delegate;

    public VendorService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "apiBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VendorService$api$2(talabatAPIBuilder));
    }

    private final VendorApi getApi() {
        return (VendorApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<RestaurantListResponsePaginated> getVendors(double d11, double d12, int i11, int i12, @NotNull List<Integer> list) {
        List<Integer> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "vendorIds");
        return getApi().getVendors(d11, d12, i11, i12, list2);
    }
}
