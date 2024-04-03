package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity;

import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "", "binsDetails", "", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBin;", "qPayBinDeflectionExpiryDate", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBinsDetails", "()Ljava/util/List;", "getQPayBinDeflectionExpiryDate", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayDeflectionBinDetail {
    @NotNull
    private final List<QPayDeflectionBin> binsDetails;
    @NotNull
    private final String qPayBinDeflectionExpiryDate;

    public QPayDeflectionBinDetail() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public QPayDeflectionBinDetail(@NotNull List<QPayDeflectionBin> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "binsDetails");
        Intrinsics.checkNotNullParameter(str, "qPayBinDeflectionExpiryDate");
        this.binsDetails = list;
        this.qPayBinDeflectionExpiryDate = str;
    }

    public static /* synthetic */ QPayDeflectionBinDetail copy$default(QPayDeflectionBinDetail qPayDeflectionBinDetail, List<QPayDeflectionBin> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = qPayDeflectionBinDetail.binsDetails;
        }
        if ((i11 & 2) != 0) {
            str = qPayDeflectionBinDetail.qPayBinDeflectionExpiryDate;
        }
        return qPayDeflectionBinDetail.copy(list, str);
    }

    @NotNull
    public final List<QPayDeflectionBin> component1() {
        return this.binsDetails;
    }

    @NotNull
    public final String component2() {
        return this.qPayBinDeflectionExpiryDate;
    }

    @NotNull
    public final QPayDeflectionBinDetail copy(@NotNull List<QPayDeflectionBin> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "binsDetails");
        Intrinsics.checkNotNullParameter(str, "qPayBinDeflectionExpiryDate");
        return new QPayDeflectionBinDetail(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayDeflectionBinDetail)) {
            return false;
        }
        QPayDeflectionBinDetail qPayDeflectionBinDetail = (QPayDeflectionBinDetail) obj;
        return Intrinsics.areEqual((Object) this.binsDetails, (Object) qPayDeflectionBinDetail.binsDetails) && Intrinsics.areEqual((Object) this.qPayBinDeflectionExpiryDate, (Object) qPayDeflectionBinDetail.qPayBinDeflectionExpiryDate);
    }

    @NotNull
    public final List<QPayDeflectionBin> getBinsDetails() {
        return this.binsDetails;
    }

    @NotNull
    public final String getQPayBinDeflectionExpiryDate() {
        return this.qPayBinDeflectionExpiryDate;
    }

    public int hashCode() {
        return (this.binsDetails.hashCode() * 31) + this.qPayBinDeflectionExpiryDate.hashCode();
    }

    @NotNull
    public String toString() {
        List<QPayDeflectionBin> list = this.binsDetails;
        String str = this.qPayBinDeflectionExpiryDate;
        return "QPayDeflectionBinDetail(binsDetails=" + list + ", qPayBinDeflectionExpiryDate=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QPayDeflectionBinDetail(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
