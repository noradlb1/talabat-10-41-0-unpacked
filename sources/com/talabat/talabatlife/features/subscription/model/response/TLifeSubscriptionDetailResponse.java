package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResponse;", "", "result", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResult;", "errors", "", "", "(Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResult;Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "getResult", "()Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionDetailResponse {
    @SerializedName("errors")
    @Nullable
    private final List<String> errors;
    @SerializedName("result")
    @Nullable
    private final TLifeSubscriptionDetailResult result;

    public TLifeSubscriptionDetailResponse() {
        this((TLifeSubscriptionDetailResult) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public TLifeSubscriptionDetailResponse(@Nullable TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult, @Nullable List<String> list) {
        this.result = tLifeSubscriptionDetailResult;
        this.errors = list;
    }

    public static /* synthetic */ TLifeSubscriptionDetailResponse copy$default(TLifeSubscriptionDetailResponse tLifeSubscriptionDetailResponse, TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            tLifeSubscriptionDetailResult = tLifeSubscriptionDetailResponse.result;
        }
        if ((i11 & 2) != 0) {
            list = tLifeSubscriptionDetailResponse.errors;
        }
        return tLifeSubscriptionDetailResponse.copy(tLifeSubscriptionDetailResult, list);
    }

    @Nullable
    public final TLifeSubscriptionDetailResult component1() {
        return this.result;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @NotNull
    public final TLifeSubscriptionDetailResponse copy(@Nullable TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult, @Nullable List<String> list) {
        return new TLifeSubscriptionDetailResponse(tLifeSubscriptionDetailResult, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TLifeSubscriptionDetailResponse)) {
            return false;
        }
        TLifeSubscriptionDetailResponse tLifeSubscriptionDetailResponse = (TLifeSubscriptionDetailResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) tLifeSubscriptionDetailResponse.result) && Intrinsics.areEqual((Object) this.errors, (Object) tLifeSubscriptionDetailResponse.errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @Nullable
    public final TLifeSubscriptionDetailResult getResult() {
        return this.result;
    }

    public int hashCode() {
        TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult = this.result;
        int i11 = 0;
        int hashCode = (tLifeSubscriptionDetailResult == null ? 0 : tLifeSubscriptionDetailResult.hashCode()) * 31;
        List<String> list = this.errors;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult = this.result;
        List<String> list = this.errors;
        return "TLifeSubscriptionDetailResponse(result=" + tLifeSubscriptionDetailResult + ", errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TLifeSubscriptionDetailResponse(TLifeSubscriptionDetailResult tLifeSubscriptionDetailResult, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : tLifeSubscriptionDetailResult, (i11 & 2) != 0 ? null : list);
    }
}
