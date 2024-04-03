package com.talabat.feature.darkstores.vendorslanding.data.repository;

import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequest;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequestV2;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstores.vendorslanding.data.remote.VendorLandingApi;
import com.talabat.mapper.ModelMapper;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yl.a;
import yl.b;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/repository/VendorLandingRepositoryImpl;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "vendorLandingApi", "Lcom/talabat/feature/darkstores/vendorslanding/data/remote/VendorLandingApi;", "vendorLandingMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "vendorLandingMapperV2", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponseV2;", "(Lcom/talabat/feature/darkstores/vendorslanding/data/remote/VendorLandingApi;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "getVendorLandingResponse", "Lio/reactivex/Single;", "vendorLandingRequest", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequest;", "getVendorLandingResponseV2", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequestV2;", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingRepositoryImpl implements VendorLandingRepository {
    @NotNull
    private final VendorLandingApi vendorLandingApi;
    @NotNull
    private final ModelMapper<VendorLandingResponse, VendorLanding> vendorLandingMapper;
    @NotNull
    private final ModelMapper<VendorLandingResponseV2, VendorLanding> vendorLandingMapperV2;

    @Inject
    public VendorLandingRepositoryImpl(@NotNull VendorLandingApi vendorLandingApi2, @NotNull ModelMapper<VendorLandingResponse, VendorLanding> modelMapper, @NotNull ModelMapper<VendorLandingResponseV2, VendorLanding> modelMapper2) {
        Intrinsics.checkNotNullParameter(vendorLandingApi2, "vendorLandingApi");
        Intrinsics.checkNotNullParameter(modelMapper, "vendorLandingMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "vendorLandingMapperV2");
        this.vendorLandingApi = vendorLandingApi2;
        this.vendorLandingMapper = modelMapper;
        this.vendorLandingMapperV2 = modelMapper2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorLandingResponse$lambda-0  reason: not valid java name */
    public static final VendorLanding m10150getVendorLandingResponse$lambda0(VendorLandingRepositoryImpl vendorLandingRepositoryImpl, VendorLandingResponse vendorLandingResponse) {
        Intrinsics.checkNotNullParameter(vendorLandingRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorLandingResponse, "it");
        return vendorLandingRepositoryImpl.vendorLandingMapper.apply(vendorLandingResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorLandingResponseV2$lambda-1  reason: not valid java name */
    public static final VendorLanding m10151getVendorLandingResponseV2$lambda1(VendorLandingRepositoryImpl vendorLandingRepositoryImpl, VendorLandingResponseV2 vendorLandingResponseV2) {
        Intrinsics.checkNotNullParameter(vendorLandingRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(vendorLandingResponseV2, "it");
        return vendorLandingRepositoryImpl.vendorLandingMapperV2.apply(vendorLandingResponseV2);
    }

    @NotNull
    public Single<VendorLanding> getVendorLandingResponse(@NotNull VendorLandingRequest vendorLandingRequest) {
        Intrinsics.checkNotNullParameter(vendorLandingRequest, "vendorLandingRequest");
        Single<R> map = this.vendorLandingApi.getVendor(vendorLandingRequest.getCountryCode(), vendorLandingRequest.getVendorCode(), vendorLandingRequest.getTalabatBranchId(), vendorLandingRequest.isDarkstore()).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "vendorLandingApi.getVend…apper.apply(it)\n        }");
        return map;
    }

    @NotNull
    public Single<VendorLanding> getVendorLandingResponseV2(@NotNull VendorLandingRequestV2 vendorLandingRequestV2) {
        Intrinsics.checkNotNullParameter(vendorLandingRequestV2, "vendorLandingRequest");
        Single<R> map = this.vendorLandingApi.getVendorV2(vendorLandingRequestV2.getCountryCode(), vendorLandingRequestV2.getVendorCode(), vendorLandingRequestV2.isDarkstore(), vendorLandingRequestV2.getLatitude(), vendorLandingRequestV2.getLongitude()).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "vendorLandingApi.getVend…ndingMapperV2.apply(it) }");
        return map;
    }
}
