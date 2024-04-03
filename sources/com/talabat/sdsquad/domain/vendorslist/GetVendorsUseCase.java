package com.talabat.sdsquad.domain.vendorslist;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.vendorslist.VendorRepository;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.data.vendorslist.response.VendorsListResponse;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import du.f;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u0011B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "requestValues", "b", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "mVendorRepository", "Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "mDisplayMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "<init>", "(Lcom/talabat/sdsquad/data/vendorslist/VendorRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetVendorsUseCase extends UseCase<RequestValues, Flowable<List<? extends VendorDisplayModel>>> {
    @NotNull
    private final DisplayModelMapper<VendorDisplayModel, Vendor> mDisplayMapper;
    @NotNull
    private final VendorRepository mVendorRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/domain/vendorslist/GetVendorsUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "isForceUpdate", "", "latitude", "", "longitude", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getLatitude", "()Ljava/lang/String;", "getLongitude", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        private final boolean isForceUpdate;
        @NotNull
        private final String latitude;
        @NotNull
        private final String longitude;

        public RequestValues(boolean z11, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            this.isForceUpdate = z11;
            this.latitude = str;
            this.longitude = str2;
        }

        @NotNull
        public final String getLatitude() {
            return this.latitude;
        }

        @NotNull
        public final String getLongitude() {
            return this.longitude;
        }

        public final boolean isForceUpdate() {
            return this.isForceUpdate;
        }
    }

    public GetVendorsUseCase(@NotNull VendorRepository vendorRepository, @NotNull DisplayModelMapper<VendorDisplayModel, ? super Vendor> displayModelMapper) {
        Intrinsics.checkNotNullParameter(vendorRepository, "mVendorRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mDisplayMapper");
        this.mVendorRepository = vendorRepository;
        this.mDisplayMapper = displayModelMapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final List m10794executeUseCase$lambda2$lambda1(GetVendorsUseCase getVendorsUseCase, VendorsListResponse vendorsListResponse) {
        Intrinsics.checkNotNullParameter(getVendorsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(vendorsListResponse, "t");
        if (vendorsListResponse.getResult() == null) {
            throw new RuntimeException("null list");
        } else if (vendorsListResponse.getResult().getVendors() != null) {
            Iterable<Vendor> vendors = vendorsListResponse.getResult().getVendors();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(vendors, 10));
            for (Vendor vendor : vendors) {
                DisplayModelMapper<VendorDisplayModel, Vendor> displayModelMapper = getVendorsUseCase.mDisplayMapper;
                Intrinsics.checkNotNull(vendor);
                arrayList.add(displayModelMapper.mapToView(vendor));
            }
            return arrayList;
        } else {
            throw new RuntimeException("null list");
        }
    }

    @NotNull
    /* renamed from: b */
    public Flowable<List<VendorDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Flowable<R> map = this.mVendorRepository.getVendors(requestValues.isForceUpdate(), requestValues.getLatitude(), requestValues.getLongitude()).map(new f(this));
            Intrinsics.checkNotNullExpressionValue(map, "mVendorRepository.getVen…or!!) }\n                }");
            return map;
        }
        throw new RuntimeException("request value can not be null");
    }
}
