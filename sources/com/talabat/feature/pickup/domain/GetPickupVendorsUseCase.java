package com.talabat.feature.pickup.domain;

import com.facebook.internal.NativeProtocol;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.search.SearchFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListExperimentsKeys;
import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import com.talabat.feature.pickup.domain.entity.PickupVendor;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase;", "", "pickupRepository", "Lcom/talabat/feature/pickup/domain/PickupRepository;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/feature/pickup/domain/PickupRepository;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getAPIVersionNumber", "", "getSwimlanes", "Lio/reactivex/Observable;", "", "Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "incrementScreenVisits", "", "incrementValuePropBannerVisits", "isFirstPickupOrder", "", "isRevampedBlockingModalShouldAppear", "run", "Lio/reactivex/Single;", "Lcom/talabat/feature/pickup/domain/entity/PickupVendor;", "params", "Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase$Params;", "shouldShowConfirmationPopup", "swimlanesExperiment", "", "vendorTags", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "Companion", "Params", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPickupVendorsUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String HIDE_SWIMLANES_EXPERIMENT_VARIATION = "Control";
    public static final int PICKUP_API_V1 = 1;
    public static final int PICKUP_API_V2 = 2;
    @NotNull
    public static final String SHOW_REVAMPED_CONFIRMATION_DIALOG_IN_VL_VARIATION = "Control";
    @NotNull
    private final ITalabatExperiment experiment;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final PickupRepository pickupRepository;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase$Companion;", "", "()V", "HIDE_SWIMLANES_EXPERIMENT_VARIATION", "", "PICKUP_API_V1", "", "PICKUP_API_V2", "SHOW_REVAMPED_CONFIRMATION_DIALOG_IN_VL_VARIATION", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/pickup/domain/GetPickupVendorsUseCase$Params;", "", "pageNumber", "", "cuisineIds", "", "(ILjava/util/List;)V", "getCuisineIds", "()Ljava/util/List;", "getPageNumber", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_pickup_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Params {
        @Nullable
        private final List<Integer> cuisineIds;
        private final int pageNumber;

        public Params(int i11, @Nullable List<Integer> list) {
            this.pageNumber = i11;
            this.cuisineIds = list;
        }

        public static /* synthetic */ Params copy$default(Params params, int i11, List<Integer> list, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = params.pageNumber;
            }
            if ((i12 & 2) != 0) {
                list = params.cuisineIds;
            }
            return params.copy(i11, list);
        }

        public final int component1() {
            return this.pageNumber;
        }

        @Nullable
        public final List<Integer> component2() {
            return this.cuisineIds;
        }

        @NotNull
        public final Params copy(int i11, @Nullable List<Integer> list) {
            return new Params(i11, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.pageNumber == params.pageNumber && Intrinsics.areEqual((Object) this.cuisineIds, (Object) params.cuisineIds);
        }

        @Nullable
        public final List<Integer> getCuisineIds() {
            return this.cuisineIds;
        }

        public final int getPageNumber() {
            return this.pageNumber;
        }

        public int hashCode() {
            int i11 = this.pageNumber * 31;
            List<Integer> list = this.cuisineIds;
            return i11 + (list == null ? 0 : list.hashCode());
        }

        @NotNull
        public String toString() {
            int i11 = this.pageNumber;
            List<Integer> list = this.cuisineIds;
            return "Params(pageNumber=" + i11 + ", cuisineIds=" + list + ")";
        }
    }

    @Inject
    public GetPickupVendorsUseCase(@NotNull PickupRepository pickupRepository2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(pickupRepository2, "pickupRepository");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.pickupRepository = pickupRepository2;
        this.experiment = iTalabatExperiment;
        this.featureFlag = iTalabatFeatureFlag;
    }

    private final int getAPIVersionNumber() {
        if (this.featureFlag.getFeatureFlag(SearchFeatureFlagsKeys.SEARCH_ENABLE_PICKUP_DIFFERENTIAL_DISCOUNTS, false)) {
            return 2;
        }
        return 1;
    }

    private final boolean isRevampedBlockingModalShouldAppear() {
        return Intrinsics.areEqual((Object) this.experiment.getStringVariant(VendorListExperimentsKeys.PICKUP_BLOCKING_MODAL_REVAMP, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control");
    }

    private final String swimlanesExperiment() {
        return this.experiment.getStringVariant(VendorListExperimentsKeys.PICKUP_SWIMLANES, "Control", TalabatExperimentDataSourceStrategy.FWF);
    }

    @NotNull
    public final Observable<List<PickupSwimlane>> getSwimlanes() {
        if (!Intrinsics.areEqual((Object) swimlanesExperiment(), (Object) "Control")) {
            return this.pickupRepository.getSwimlanes();
        }
        Observable<List<PickupSwimlane>> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "empty()");
        return empty;
    }

    public final void incrementScreenVisits() {
        this.pickupRepository.incrementPickupVlScreenVisits();
    }

    public final void incrementValuePropBannerVisits() {
        this.pickupRepository.incrementValuePropBannerVisits();
    }

    public final boolean isFirstPickupOrder() {
        return this.pickupRepository.isFirstPickupOrder();
    }

    @NotNull
    public final Single<PickupVendor> run(@NotNull Params params) {
        Intrinsics.checkNotNullParameter(params, NativeProtocol.WEB_DIALOG_PARAMS);
        return this.pickupRepository.getPickupVendors(params.getPageNumber(), params.getCuisineIds(), getAPIVersionNumber());
    }

    public final boolean shouldShowConfirmationPopup() {
        if (!this.pickupRepository.isFirstPickupOrder() || !isRevampedBlockingModalShouldAppear()) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Single<VendorTagsResponse> vendorTags() {
        return this.pickupRepository.getVendorTags();
    }
}
