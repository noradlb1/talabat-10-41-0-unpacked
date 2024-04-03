package com.talabat.feature.fees.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import com.talabat.feature.fees.domain.model.FeeDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/fees/presentation/displaymodel/FeesDescriptionsDisplayModel;", "", "howFeesWork", "Lcom/talabat/feature/fees/domain/model/FeeDescription;", "deliveryFee", "serviceFee", "smallOrderFee", "(Lcom/talabat/feature/fees/domain/model/FeeDescription;Lcom/talabat/feature/fees/domain/model/FeeDescription;Lcom/talabat/feature/fees/domain/model/FeeDescription;Lcom/talabat/feature/fees/domain/model/FeeDescription;)V", "getDeliveryFee", "()Lcom/talabat/feature/fees/domain/model/FeeDescription;", "getHowFeesWork", "getServiceFee", "getSmallOrderFee", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesDescriptionsDisplayModel {
    public static final int $stable = 8;
    @Nullable
    private final FeeDescription deliveryFee;
    @Nullable
    private final FeeDescription howFeesWork;
    @Nullable
    private final FeeDescription serviceFee;
    @Nullable
    private final FeeDescription smallOrderFee;

    public FeesDescriptionsDisplayModel() {
        this((FeeDescription) null, (FeeDescription) null, (FeeDescription) null, (FeeDescription) null, 15, (DefaultConstructorMarker) null);
    }

    public FeesDescriptionsDisplayModel(@Nullable FeeDescription feeDescription, @Nullable FeeDescription feeDescription2, @Nullable FeeDescription feeDescription3, @Nullable FeeDescription feeDescription4) {
        this.howFeesWork = feeDescription;
        this.deliveryFee = feeDescription2;
        this.serviceFee = feeDescription3;
        this.smallOrderFee = feeDescription4;
    }

    public static /* synthetic */ FeesDescriptionsDisplayModel copy$default(FeesDescriptionsDisplayModel feesDescriptionsDisplayModel, FeeDescription feeDescription, FeeDescription feeDescription2, FeeDescription feeDescription3, FeeDescription feeDescription4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            feeDescription = feesDescriptionsDisplayModel.howFeesWork;
        }
        if ((i11 & 2) != 0) {
            feeDescription2 = feesDescriptionsDisplayModel.deliveryFee;
        }
        if ((i11 & 4) != 0) {
            feeDescription3 = feesDescriptionsDisplayModel.serviceFee;
        }
        if ((i11 & 8) != 0) {
            feeDescription4 = feesDescriptionsDisplayModel.smallOrderFee;
        }
        return feesDescriptionsDisplayModel.copy(feeDescription, feeDescription2, feeDescription3, feeDescription4);
    }

    @Nullable
    public final FeeDescription component1() {
        return this.howFeesWork;
    }

    @Nullable
    public final FeeDescription component2() {
        return this.deliveryFee;
    }

    @Nullable
    public final FeeDescription component3() {
        return this.serviceFee;
    }

    @Nullable
    public final FeeDescription component4() {
        return this.smallOrderFee;
    }

    @NotNull
    public final FeesDescriptionsDisplayModel copy(@Nullable FeeDescription feeDescription, @Nullable FeeDescription feeDescription2, @Nullable FeeDescription feeDescription3, @Nullable FeeDescription feeDescription4) {
        return new FeesDescriptionsDisplayModel(feeDescription, feeDescription2, feeDescription3, feeDescription4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeesDescriptionsDisplayModel)) {
            return false;
        }
        FeesDescriptionsDisplayModel feesDescriptionsDisplayModel = (FeesDescriptionsDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.howFeesWork, (Object) feesDescriptionsDisplayModel.howFeesWork) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) feesDescriptionsDisplayModel.deliveryFee) && Intrinsics.areEqual((Object) this.serviceFee, (Object) feesDescriptionsDisplayModel.serviceFee) && Intrinsics.areEqual((Object) this.smallOrderFee, (Object) feesDescriptionsDisplayModel.smallOrderFee);
    }

    @Nullable
    public final FeeDescription getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final FeeDescription getHowFeesWork() {
        return this.howFeesWork;
    }

    @Nullable
    public final FeeDescription getServiceFee() {
        return this.serviceFee;
    }

    @Nullable
    public final FeeDescription getSmallOrderFee() {
        return this.smallOrderFee;
    }

    public int hashCode() {
        FeeDescription feeDescription = this.howFeesWork;
        int i11 = 0;
        int hashCode = (feeDescription == null ? 0 : feeDescription.hashCode()) * 31;
        FeeDescription feeDescription2 = this.deliveryFee;
        int hashCode2 = (hashCode + (feeDescription2 == null ? 0 : feeDescription2.hashCode())) * 31;
        FeeDescription feeDescription3 = this.serviceFee;
        int hashCode3 = (hashCode2 + (feeDescription3 == null ? 0 : feeDescription3.hashCode())) * 31;
        FeeDescription feeDescription4 = this.smallOrderFee;
        if (feeDescription4 != null) {
            i11 = feeDescription4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        FeeDescription feeDescription = this.howFeesWork;
        FeeDescription feeDescription2 = this.deliveryFee;
        FeeDescription feeDescription3 = this.serviceFee;
        FeeDescription feeDescription4 = this.smallOrderFee;
        return "FeesDescriptionsDisplayModel(howFeesWork=" + feeDescription + ", deliveryFee=" + feeDescription2 + ", serviceFee=" + feeDescription3 + ", smallOrderFee=" + feeDescription4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeesDescriptionsDisplayModel(FeeDescription feeDescription, FeeDescription feeDescription2, FeeDescription feeDescription3, FeeDescription feeDescription4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : feeDescription, (i11 & 2) != 0 ? null : feeDescription2, (i11 & 4) != 0 ? null : feeDescription3, (i11 & 8) != 0 ? null : feeDescription4);
    }
}
