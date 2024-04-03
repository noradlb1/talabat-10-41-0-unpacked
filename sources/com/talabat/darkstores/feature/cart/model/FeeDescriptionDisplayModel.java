package com.talabat.darkstores.feature.cart.model;

import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/FeeDescriptionDisplayModel;", "", "deliveryFeeDescription", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "serviceFeeDescription", "disclaimerBannerDescription", "genericFeeDescription", "(Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;)V", "getDeliveryFeeDescription", "()Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "getDisclaimerBannerDescription", "getGenericFeeDescription", "getServiceFeeDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeDescriptionDisplayModel {
    @Nullable
    private final FeeDescription deliveryFeeDescription;
    @Nullable
    private final FeeDescription disclaimerBannerDescription;
    @Nullable
    private final FeeDescription genericFeeDescription;
    @Nullable
    private final FeeDescription serviceFeeDescription;

    public FeeDescriptionDisplayModel(@Nullable FeeDescription feeDescription, @Nullable FeeDescription feeDescription2, @Nullable FeeDescription feeDescription3, @Nullable FeeDescription feeDescription4) {
        this.deliveryFeeDescription = feeDescription;
        this.serviceFeeDescription = feeDescription2;
        this.disclaimerBannerDescription = feeDescription3;
        this.genericFeeDescription = feeDescription4;
    }

    public static /* synthetic */ FeeDescriptionDisplayModel copy$default(FeeDescriptionDisplayModel feeDescriptionDisplayModel, FeeDescription feeDescription, FeeDescription feeDescription2, FeeDescription feeDescription3, FeeDescription feeDescription4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            feeDescription = feeDescriptionDisplayModel.deliveryFeeDescription;
        }
        if ((i11 & 2) != 0) {
            feeDescription2 = feeDescriptionDisplayModel.serviceFeeDescription;
        }
        if ((i11 & 4) != 0) {
            feeDescription3 = feeDescriptionDisplayModel.disclaimerBannerDescription;
        }
        if ((i11 & 8) != 0) {
            feeDescription4 = feeDescriptionDisplayModel.genericFeeDescription;
        }
        return feeDescriptionDisplayModel.copy(feeDescription, feeDescription2, feeDescription3, feeDescription4);
    }

    @Nullable
    public final FeeDescription component1() {
        return this.deliveryFeeDescription;
    }

    @Nullable
    public final FeeDescription component2() {
        return this.serviceFeeDescription;
    }

    @Nullable
    public final FeeDescription component3() {
        return this.disclaimerBannerDescription;
    }

    @Nullable
    public final FeeDescription component4() {
        return this.genericFeeDescription;
    }

    @NotNull
    public final FeeDescriptionDisplayModel copy(@Nullable FeeDescription feeDescription, @Nullable FeeDescription feeDescription2, @Nullable FeeDescription feeDescription3, @Nullable FeeDescription feeDescription4) {
        return new FeeDescriptionDisplayModel(feeDescription, feeDescription2, feeDescription3, feeDescription4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeDescriptionDisplayModel)) {
            return false;
        }
        FeeDescriptionDisplayModel feeDescriptionDisplayModel = (FeeDescriptionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.deliveryFeeDescription, (Object) feeDescriptionDisplayModel.deliveryFeeDescription) && Intrinsics.areEqual((Object) this.serviceFeeDescription, (Object) feeDescriptionDisplayModel.serviceFeeDescription) && Intrinsics.areEqual((Object) this.disclaimerBannerDescription, (Object) feeDescriptionDisplayModel.disclaimerBannerDescription) && Intrinsics.areEqual((Object) this.genericFeeDescription, (Object) feeDescriptionDisplayModel.genericFeeDescription);
    }

    @Nullable
    public final FeeDescription getDeliveryFeeDescription() {
        return this.deliveryFeeDescription;
    }

    @Nullable
    public final FeeDescription getDisclaimerBannerDescription() {
        return this.disclaimerBannerDescription;
    }

    @Nullable
    public final FeeDescription getGenericFeeDescription() {
        return this.genericFeeDescription;
    }

    @Nullable
    public final FeeDescription getServiceFeeDescription() {
        return this.serviceFeeDescription;
    }

    public int hashCode() {
        FeeDescription feeDescription = this.deliveryFeeDescription;
        int i11 = 0;
        int hashCode = (feeDescription == null ? 0 : feeDescription.hashCode()) * 31;
        FeeDescription feeDescription2 = this.serviceFeeDescription;
        int hashCode2 = (hashCode + (feeDescription2 == null ? 0 : feeDescription2.hashCode())) * 31;
        FeeDescription feeDescription3 = this.disclaimerBannerDescription;
        int hashCode3 = (hashCode2 + (feeDescription3 == null ? 0 : feeDescription3.hashCode())) * 31;
        FeeDescription feeDescription4 = this.genericFeeDescription;
        if (feeDescription4 != null) {
            i11 = feeDescription4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        FeeDescription feeDescription = this.deliveryFeeDescription;
        FeeDescription feeDescription2 = this.serviceFeeDescription;
        FeeDescription feeDescription3 = this.disclaimerBannerDescription;
        FeeDescription feeDescription4 = this.genericFeeDescription;
        return "FeeDescriptionDisplayModel(deliveryFeeDescription=" + feeDescription + ", serviceFeeDescription=" + feeDescription2 + ", disclaimerBannerDescription=" + feeDescription3 + ", genericFeeDescription=" + feeDescription4 + ")";
    }
}
