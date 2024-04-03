package com.talabat.sdsquad.domain.darkstores;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.darkstors.DarkStoreRepository;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\u0014B#\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002XD¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "requestValues", "a", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "mDarkStoreRepository", "Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "mDisplayMapper", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "", "DARK_STORE_POSITION", "I", "<init>", "(Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;Lcom/talabat/sdsquad/core/DisplayModelMapper;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class AddDarkStoreUseCase extends UseCase<RequestValues, Flowable<List<? extends VendorDisplayModel>>> {
    private final int DARK_STORE_POSITION = 5;
    @NotNull
    private final DarkStoreRepository mDarkStoreRepository;
    @NotNull
    private final DisplayModelMapper<VendorDisplayModel, Vendor> mDisplayMapper;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/domain/darkstores/AddDarkStoreUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "vendorsList", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "baseUrl", "", "decimalCount", "", "(Ljava/util/List;Ljava/lang/String;I)V", "getBaseUrl", "()Ljava/lang/String;", "getDecimalCount", "()I", "getVendorsList", "()Ljava/util/List;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @Nullable
        private final String baseUrl;
        private final int decimalCount;
        @NotNull
        private final List<VendorDisplayModel> vendorsList;

        public RequestValues(@NotNull List<VendorDisplayModel> list, @Nullable String str, int i11) {
            Intrinsics.checkNotNullParameter(list, "vendorsList");
            this.vendorsList = list;
            this.baseUrl = str;
            this.decimalCount = i11;
        }

        @Nullable
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        public final int getDecimalCount() {
            return this.decimalCount;
        }

        @NotNull
        public final List<VendorDisplayModel> getVendorsList() {
            return this.vendorsList;
        }
    }

    public AddDarkStoreUseCase(@NotNull DarkStoreRepository darkStoreRepository, @NotNull DisplayModelMapper<VendorDisplayModel, ? super Vendor> displayModelMapper) {
        Intrinsics.checkNotNullParameter(darkStoreRepository, "mDarkStoreRepository");
        Intrinsics.checkNotNullParameter(displayModelMapper, "mDisplayMapper");
        this.mDarkStoreRepository = darkStoreRepository;
        this.mDisplayMapper = displayModelMapper;
    }

    @NotNull
    /* renamed from: a */
    public Flowable<List<VendorDisplayModel>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Vendor darkStoreObject = this.mDarkStoreRepository.getDarkStoreObject();
            if (darkStoreObject != null) {
                VendorDisplayModel mapToView = this.mDisplayMapper.mapToView(darkStoreObject);
                String baseUrl = requestValues.getBaseUrl();
                if (baseUrl == null) {
                    baseUrl = "";
                }
                mapToView.setBaseUrl(baseUrl);
                mapToView.setDecimalCount(requestValues.getDecimalCount());
                List mutableList = CollectionsKt___CollectionsKt.toMutableList(requestValues.getVendorsList());
                int size = mutableList.size();
                int i11 = this.DARK_STORE_POSITION;
                if (size > i11) {
                    mutableList.add(i11, mapToView);
                } else {
                    mutableList.add(mapToView);
                }
                Flowable<List<VendorDisplayModel>> just = Flowable.just(mutableList);
                Intrinsics.checkNotNullExpressionValue(just, "just(list)");
                return just;
            }
            Flowable<List<VendorDisplayModel>> just2 = Flowable.just(requestValues.getVendorsList());
            Intrinsics.checkNotNullExpressionValue(just2, "just(requestValues.vendorsList)");
            return just2;
        }
        throw new RuntimeException("Request value cannot be null");
    }
}
