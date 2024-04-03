package com.talabat.sdsquad.domain.vendorslist;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepository;
import com.talabat.sdsquad.data.vendorslist.requests.VendorInfoRequest;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import du.e;
import io.reactivex.Flowable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0010B#\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorInfo;", "requestValues", "b", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "mVendorsInfoRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/VendorsInfoResponse;", "mDisplayMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsInfoRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetVendorsInfoUseCase extends UseCase<RequestValues, Flowable<VendorInfo>> {
    @NotNull
    private final DisplayModelMapper<VendorInfo, VendorsInfoResponse> mDisplayMapper;
    @NotNull
    private final VendorsInfoRepository mVendorsInfoRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsInfoUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "isForceUpdate", "", "vendorInfoRequest", "Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "(ZLcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;)V", "()Z", "getVendorInfoRequest", "()Lcom/talabat/sdsquad/data/vendorslist/requests/VendorInfoRequest;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final boolean isForceUpdate;
        @NotNull
        private final VendorInfoRequest vendorInfoRequest;

        public RequestValues(boolean z11, @NotNull VendorInfoRequest vendorInfoRequest2) {
            Intrinsics.checkNotNullParameter(vendorInfoRequest2, "vendorInfoRequest");
            this.isForceUpdate = z11;
            this.vendorInfoRequest = vendorInfoRequest2;
        }

        @NotNull
        public final VendorInfoRequest getVendorInfoRequest() {
            return this.vendorInfoRequest;
        }

        public final boolean isForceUpdate() {
            return this.isForceUpdate;
        }
    }

    public GetVendorsInfoUseCase(@NotNull VendorsInfoRepository vendorsInfoRepository, @NotNull DisplayModelMapper<VendorInfo, ? super VendorsInfoResponse> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorsInfoRepository, "mVendorsInfoRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mDisplayMapper");
        this.mVendorsInfoRepository = vendorsInfoRepository;
        this.mDisplayMapper = displayModelMapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final VendorInfo m10793executeUseCase$lambda1$lambda0(GetVendorsInfoUseCase getVendorsInfoUseCase, VendorsInfoResponse vendorsInfoResponse) {
        Intrinsics.checkNotNullParameter(getVendorsInfoUseCase, "this$0");
        Intrinsics.checkNotNullParameter(vendorsInfoResponse, "t");
        return getVendorsInfoUseCase.mDisplayMapper.mapToView(vendorsInfoResponse);
    }

    @NotNull
    /* renamed from: b */
    public Flowable<VendorInfo> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Flowable<R> map = this.mVendorsInfoRepository.getVendorInfo(requestValues.isForceUpdate(), requestValues.getVendorInfoRequest()).map(new e(this));
            Intrinsics.checkNotNullExpressionValue(map, "mVendorsInfoRepository.g…View(t)\n                }");
            return map;
        }
        throw new RuntimeException("request value can not be null");
    }
}
