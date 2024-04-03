package com.talabat.talabatcommon.views.bottomsheet;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/views/bottomsheet/MultipleFeesDescriptionDisplayModel;", "Ljava/io/Serializable;", "howFeesWork", "Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "deliveryFee", "serviceFee", "smallOrderFee", "(Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;)V", "getDeliveryFee", "()Lcom/talabat/talabatcommon/views/bottomsheet/FeesDescriptionDisplayModel;", "getHowFeesWork", "getServiceFee", "getSmallOrderFee", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultipleFeesDescriptionDisplayModel implements Serializable {
    @Nullable
    private final FeesDescriptionDisplayModel deliveryFee;
    @NotNull
    private final FeesDescriptionDisplayModel howFeesWork;
    @Nullable
    private final FeesDescriptionDisplayModel serviceFee;
    @Nullable
    private final FeesDescriptionDisplayModel smallOrderFee;

    public MultipleFeesDescriptionDisplayModel(@NotNull FeesDescriptionDisplayModel feesDescriptionDisplayModel, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel2, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel3, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel4) {
        Intrinsics.checkNotNullParameter(feesDescriptionDisplayModel, "howFeesWork");
        this.howFeesWork = feesDescriptionDisplayModel;
        this.deliveryFee = feesDescriptionDisplayModel2;
        this.serviceFee = feesDescriptionDisplayModel3;
        this.smallOrderFee = feesDescriptionDisplayModel4;
    }

    public static /* synthetic */ MultipleFeesDescriptionDisplayModel copy$default(MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel, FeesDescriptionDisplayModel feesDescriptionDisplayModel, FeesDescriptionDisplayModel feesDescriptionDisplayModel2, FeesDescriptionDisplayModel feesDescriptionDisplayModel3, FeesDescriptionDisplayModel feesDescriptionDisplayModel4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            feesDescriptionDisplayModel = multipleFeesDescriptionDisplayModel.howFeesWork;
        }
        if ((i11 & 2) != 0) {
            feesDescriptionDisplayModel2 = multipleFeesDescriptionDisplayModel.deliveryFee;
        }
        if ((i11 & 4) != 0) {
            feesDescriptionDisplayModel3 = multipleFeesDescriptionDisplayModel.serviceFee;
        }
        if ((i11 & 8) != 0) {
            feesDescriptionDisplayModel4 = multipleFeesDescriptionDisplayModel.smallOrderFee;
        }
        return multipleFeesDescriptionDisplayModel.copy(feesDescriptionDisplayModel, feesDescriptionDisplayModel2, feesDescriptionDisplayModel3, feesDescriptionDisplayModel4);
    }

    @NotNull
    public final FeesDescriptionDisplayModel component1() {
        return this.howFeesWork;
    }

    @Nullable
    public final FeesDescriptionDisplayModel component2() {
        return this.deliveryFee;
    }

    @Nullable
    public final FeesDescriptionDisplayModel component3() {
        return this.serviceFee;
    }

    @Nullable
    public final FeesDescriptionDisplayModel component4() {
        return this.smallOrderFee;
    }

    @NotNull
    public final MultipleFeesDescriptionDisplayModel copy(@NotNull FeesDescriptionDisplayModel feesDescriptionDisplayModel, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel2, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel3, @Nullable FeesDescriptionDisplayModel feesDescriptionDisplayModel4) {
        Intrinsics.checkNotNullParameter(feesDescriptionDisplayModel, "howFeesWork");
        return new MultipleFeesDescriptionDisplayModel(feesDescriptionDisplayModel, feesDescriptionDisplayModel2, feesDescriptionDisplayModel3, feesDescriptionDisplayModel4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultipleFeesDescriptionDisplayModel)) {
            return false;
        }
        MultipleFeesDescriptionDisplayModel multipleFeesDescriptionDisplayModel = (MultipleFeesDescriptionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.howFeesWork, (Object) multipleFeesDescriptionDisplayModel.howFeesWork) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) multipleFeesDescriptionDisplayModel.deliveryFee) && Intrinsics.areEqual((Object) this.serviceFee, (Object) multipleFeesDescriptionDisplayModel.serviceFee) && Intrinsics.areEqual((Object) this.smallOrderFee, (Object) multipleFeesDescriptionDisplayModel.smallOrderFee);
    }

    @Nullable
    public final FeesDescriptionDisplayModel getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final FeesDescriptionDisplayModel getHowFeesWork() {
        return this.howFeesWork;
    }

    @Nullable
    public final FeesDescriptionDisplayModel getServiceFee() {
        return this.serviceFee;
    }

    @Nullable
    public final FeesDescriptionDisplayModel getSmallOrderFee() {
        return this.smallOrderFee;
    }

    public int hashCode() {
        int hashCode = this.howFeesWork.hashCode() * 31;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel = this.deliveryFee;
        int i11 = 0;
        int hashCode2 = (hashCode + (feesDescriptionDisplayModel == null ? 0 : feesDescriptionDisplayModel.hashCode())) * 31;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel2 = this.serviceFee;
        int hashCode3 = (hashCode2 + (feesDescriptionDisplayModel2 == null ? 0 : feesDescriptionDisplayModel2.hashCode())) * 31;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel3 = this.smallOrderFee;
        if (feesDescriptionDisplayModel3 != null) {
            i11 = feesDescriptionDisplayModel3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        FeesDescriptionDisplayModel feesDescriptionDisplayModel = this.howFeesWork;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel2 = this.deliveryFee;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel3 = this.serviceFee;
        FeesDescriptionDisplayModel feesDescriptionDisplayModel4 = this.smallOrderFee;
        return "MultipleFeesDescriptionDisplayModel(howFeesWork=" + feesDescriptionDisplayModel + ", deliveryFee=" + feesDescriptionDisplayModel2 + ", serviceFee=" + feesDescriptionDisplayModel3 + ", smallOrderFee=" + feesDescriptionDisplayModel4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultipleFeesDescriptionDisplayModel(FeesDescriptionDisplayModel feesDescriptionDisplayModel, FeesDescriptionDisplayModel feesDescriptionDisplayModel2, FeesDescriptionDisplayModel feesDescriptionDisplayModel3, FeesDescriptionDisplayModel feesDescriptionDisplayModel4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(feesDescriptionDisplayModel, (i11 & 2) != 0 ? null : feesDescriptionDisplayModel2, (i11 & 4) != 0 ? null : feesDescriptionDisplayModel3, (i11 & 8) != 0 ? null : feesDescriptionDisplayModel4);
    }
}
