package com.talabat.feature.swimlanevoucherslist.data.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/model/VouchersSwimLaneResponse;", "", "possibleCustomerVouchers", "", "Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "(Ljava/util/List;)V", "getPossibleCustomerVouchers", "()Ljava/util/List;", "setPossibleCustomerVouchers", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersSwimLaneResponse {
    @Nullable
    private List<QCSwimLaneVouchers> possibleCustomerVouchers;

    public VouchersSwimLaneResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public VouchersSwimLaneResponse(@Nullable @Json(name = "qcSwimlaneVouchers") List<QCSwimLaneVouchers> list) {
        this.possibleCustomerVouchers = list;
    }

    public static /* synthetic */ VouchersSwimLaneResponse copy$default(VouchersSwimLaneResponse vouchersSwimLaneResponse, List<QCSwimLaneVouchers> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = vouchersSwimLaneResponse.possibleCustomerVouchers;
        }
        return vouchersSwimLaneResponse.copy(list);
    }

    @Nullable
    public final List<QCSwimLaneVouchers> component1() {
        return this.possibleCustomerVouchers;
    }

    @NotNull
    public final VouchersSwimLaneResponse copy(@Nullable @Json(name = "qcSwimlaneVouchers") List<QCSwimLaneVouchers> list) {
        return new VouchersSwimLaneResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VouchersSwimLaneResponse) && Intrinsics.areEqual((Object) this.possibleCustomerVouchers, (Object) ((VouchersSwimLaneResponse) obj).possibleCustomerVouchers);
    }

    @Nullable
    public final List<QCSwimLaneVouchers> getPossibleCustomerVouchers() {
        return this.possibleCustomerVouchers;
    }

    public int hashCode() {
        List<QCSwimLaneVouchers> list = this.possibleCustomerVouchers;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setPossibleCustomerVouchers(@Nullable List<QCSwimLaneVouchers> list) {
        this.possibleCustomerVouchers = list;
    }

    @NotNull
    public String toString() {
        List<QCSwimLaneVouchers> list = this.possibleCustomerVouchers;
        return "VouchersSwimLaneResponse(possibleCustomerVouchers=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VouchersSwimLaneResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
