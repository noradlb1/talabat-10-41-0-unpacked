package com.talabat.restaurants.v2.domain.vendorinfo;

import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.restaurants.v2.data.vendorinfo.VendorInfoRepositoryImpl;
import com.talabat.restaurants.v2.data.vendorinfo.VendorsInfoApi;
import com.talabat.restaurants.v2.data.vendorinfo.VendorsInfoRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b2\u000b\u0010\t\u001a\u00070\n¢\u0006\u0002\b\b2\u000b\u0010\u000b\u001a\u00070\n¢\u0006\u0002\b\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendorinfo/RequestVendorInfoUseCase;", "", "vendorsInfoRepository", "Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoRepository;", "(Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoRepository;)V", "invoke", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "Lorg/jetbrains/annotations/NotNull;", "latitude", "", "longitude", "verticalId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RequestVendorInfoUseCase {
    @NotNull
    private final VendorsInfoRepository vendorsInfoRepository;

    public RequestVendorInfoUseCase() {
        this((VendorsInfoRepository) null, 1, (DefaultConstructorMarker) null);
    }

    public RequestVendorInfoUseCase(@NotNull VendorsInfoRepository vendorsInfoRepository2) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepository2, "vendorsInfoRepository");
        this.vendorsInfoRepository = vendorsInfoRepository2;
    }

    @NotNull
    public final Single<RestuarntListResponse> invoke(@NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        return this.vendorsInfoRepository.getVendorsInfo(str, str2, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestVendorInfoUseCase(VendorsInfoRepository vendorsInfoRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new VendorInfoRepositoryImpl((VendorsInfoApi) null, (TimeTrackerImplementation) null, 3, (DefaultConstructorMarker) null) : vendorsInfoRepository2);
    }
}
