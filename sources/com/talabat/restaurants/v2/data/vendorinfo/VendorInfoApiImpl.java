package com.talabat.restaurants.v2.data.vendorinfo;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.restaurants.v2.data.vendorinfo.VendorsInfoApi;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendorinfo/VendorInfoApiImpl;", "Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "getVendorsInfo", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "apiVersion", "", "latitude", "", "longitude", "verticalIds", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoApiImpl implements VendorsInfoApi {
    @NotNull
    private final TalabatAPIBuilder talabatAPIBuilder;

    public VendorInfoApiImpl() {
        this((TalabatAPIBuilder) null, 1, (DefaultConstructorMarker) null);
    }

    public VendorInfoApiImpl(@NotNull TalabatAPIBuilder talabatAPIBuilder2) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder2, "talabatAPIBuilder");
        this.talabatAPIBuilder = talabatAPIBuilder2;
    }

    @NotNull
    public Single<RestuarntListResponse> getVendorsInfo(int i11, @NotNull String str, @NotNull String str2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Intrinsics.checkNotNullParameter(list, "verticalIds");
        return VendorsInfoApi.DefaultImpls.getVendorsInfo$default((VendorsInfoApi) this.talabatAPIBuilder.createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), VendorsInfoApi.class), 0, str, str2, list, 1, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorInfoApiImpl(TalabatAPIBuilder talabatAPIBuilder2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new TalabatAPIBuilder() : talabatAPIBuilder2);
    }
}
