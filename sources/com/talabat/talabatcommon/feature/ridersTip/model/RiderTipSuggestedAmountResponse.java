package com.talabat.talabatcommon.feature.ridersTip.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "", "result", "", "Lcom/talabat/talabatcommon/feature/ridersTip/model/SuggestedAmountModel;", "(Ljava/util/List;)V", "getResult", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipSuggestedAmountResponse {
    @SerializedName("Result")
    @Nullable
    private final List<SuggestedAmountModel> result;

    public RiderTipSuggestedAmountResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public RiderTipSuggestedAmountResponse(@Nullable List<SuggestedAmountModel> list) {
        this.result = list;
    }

    public static /* synthetic */ RiderTipSuggestedAmountResponse copy$default(RiderTipSuggestedAmountResponse riderTipSuggestedAmountResponse, List<SuggestedAmountModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = riderTipSuggestedAmountResponse.result;
        }
        return riderTipSuggestedAmountResponse.copy(list);
    }

    @Nullable
    public final List<SuggestedAmountModel> component1() {
        return this.result;
    }

    @NotNull
    public final RiderTipSuggestedAmountResponse copy(@Nullable List<SuggestedAmountModel> list) {
        return new RiderTipSuggestedAmountResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RiderTipSuggestedAmountResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((RiderTipSuggestedAmountResponse) obj).result);
    }

    @Nullable
    public final List<SuggestedAmountModel> getResult() {
        return this.result;
    }

    public int hashCode() {
        List<SuggestedAmountModel> list = this.result;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<SuggestedAmountModel> list = this.result;
        return "RiderTipSuggestedAmountResponse(result=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RiderTipSuggestedAmountResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
