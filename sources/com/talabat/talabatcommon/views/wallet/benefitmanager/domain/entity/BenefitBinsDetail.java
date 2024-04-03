package com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity;

import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "", "binsDetails", "", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBin;", "benefitCardDeflectionExpiryDate", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBenefitCardDeflectionExpiryDate", "()Ljava/lang/String;", "getBinsDetails", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitBinsDetail {
    @NotNull
    private final String benefitCardDeflectionExpiryDate;
    @NotNull
    private final List<BenefitBin> binsDetails;

    public BenefitBinsDetail() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public BenefitBinsDetail(@NotNull List<BenefitBin> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "binsDetails");
        Intrinsics.checkNotNullParameter(str, "benefitCardDeflectionExpiryDate");
        this.binsDetails = list;
        this.benefitCardDeflectionExpiryDate = str;
    }

    public static /* synthetic */ BenefitBinsDetail copy$default(BenefitBinsDetail benefitBinsDetail, List<BenefitBin> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = benefitBinsDetail.binsDetails;
        }
        if ((i11 & 2) != 0) {
            str = benefitBinsDetail.benefitCardDeflectionExpiryDate;
        }
        return benefitBinsDetail.copy(list, str);
    }

    @NotNull
    public final List<BenefitBin> component1() {
        return this.binsDetails;
    }

    @NotNull
    public final String component2() {
        return this.benefitCardDeflectionExpiryDate;
    }

    @NotNull
    public final BenefitBinsDetail copy(@NotNull List<BenefitBin> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "binsDetails");
        Intrinsics.checkNotNullParameter(str, "benefitCardDeflectionExpiryDate");
        return new BenefitBinsDetail(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BenefitBinsDetail)) {
            return false;
        }
        BenefitBinsDetail benefitBinsDetail = (BenefitBinsDetail) obj;
        return Intrinsics.areEqual((Object) this.binsDetails, (Object) benefitBinsDetail.binsDetails) && Intrinsics.areEqual((Object) this.benefitCardDeflectionExpiryDate, (Object) benefitBinsDetail.benefitCardDeflectionExpiryDate);
    }

    @NotNull
    public final String getBenefitCardDeflectionExpiryDate() {
        return this.benefitCardDeflectionExpiryDate;
    }

    @NotNull
    public final List<BenefitBin> getBinsDetails() {
        return this.binsDetails;
    }

    public int hashCode() {
        return (this.binsDetails.hashCode() * 31) + this.benefitCardDeflectionExpiryDate.hashCode();
    }

    @NotNull
    public String toString() {
        List<BenefitBin> list = this.binsDetails;
        String str = this.benefitCardDeflectionExpiryDate;
        return "BenefitBinsDetail(binsDetails=" + list + ", benefitCardDeflectionExpiryDate=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BenefitBinsDetail(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
