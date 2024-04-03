package com.talabat.feature.incentiveautoapplydiscounts.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountResponse;", "", "error", "", "", "result", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountItemResponse;", "(Ljava/util/List;Ljava/util/List;)V", "getError", "()Ljava/util/List;", "getResult", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoApplyDiscountResponse {
    @Nullable
    private final List<String> error;
    @Nullable
    private final List<AutoApplyDiscountItemResponse> result;

    public AutoApplyDiscountResponse() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public AutoApplyDiscountResponse(@Nullable @Json(name = "error") List<String> list, @Nullable @Json(name = "result") List<AutoApplyDiscountItemResponse> list2) {
        this.error = list;
        this.result = list2;
    }

    public static /* synthetic */ AutoApplyDiscountResponse copy$default(AutoApplyDiscountResponse autoApplyDiscountResponse, List<String> list, List<AutoApplyDiscountItemResponse> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = autoApplyDiscountResponse.error;
        }
        if ((i11 & 2) != 0) {
            list2 = autoApplyDiscountResponse.result;
        }
        return autoApplyDiscountResponse.copy(list, list2);
    }

    @Nullable
    public final List<String> component1() {
        return this.error;
    }

    @Nullable
    public final List<AutoApplyDiscountItemResponse> component2() {
        return this.result;
    }

    @NotNull
    public final AutoApplyDiscountResponse copy(@Nullable @Json(name = "error") List<String> list, @Nullable @Json(name = "result") List<AutoApplyDiscountItemResponse> list2) {
        return new AutoApplyDiscountResponse(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutoApplyDiscountResponse)) {
            return false;
        }
        AutoApplyDiscountResponse autoApplyDiscountResponse = (AutoApplyDiscountResponse) obj;
        return Intrinsics.areEqual((Object) this.error, (Object) autoApplyDiscountResponse.error) && Intrinsics.areEqual((Object) this.result, (Object) autoApplyDiscountResponse.result);
    }

    @Nullable
    public final List<String> getError() {
        return this.error;
    }

    @Nullable
    public final List<AutoApplyDiscountItemResponse> getResult() {
        return this.result;
    }

    public int hashCode() {
        List<String> list = this.error;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<AutoApplyDiscountItemResponse> list2 = this.result;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        List<String> list = this.error;
        List<AutoApplyDiscountItemResponse> list2 = this.result;
        return "AutoApplyDiscountResponse(error=" + list + ", result=" + list2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoApplyDiscountResponse(List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : list2);
    }
}
