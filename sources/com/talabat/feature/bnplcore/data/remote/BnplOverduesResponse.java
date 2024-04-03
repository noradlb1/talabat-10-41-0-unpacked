package com.talabat.feature.bnplcore.data.remote;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.bnplcore.domain.model.Overdues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/bnplcore/data/remote/BnplOverduesResponse;", "", "result", "Lcom/talabat/feature/bnplcore/data/remote/BnplOverduesResponseResult;", "(Lcom/talabat/feature/bnplcore/data/remote/BnplOverduesResponseResult;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toOverdues", "Lcom/talabat/feature/bnplcore/domain/model/Overdues;", "toString", "", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplOverduesResponse {
    @NotNull
    private final BnplOverduesResponseResult result;

    public BnplOverduesResponse(@NotNull @Json(name = "result") BnplOverduesResponseResult bnplOverduesResponseResult) {
        Intrinsics.checkNotNullParameter(bnplOverduesResponseResult, "result");
        this.result = bnplOverduesResponseResult;
    }

    private final BnplOverduesResponseResult component1() {
        return this.result;
    }

    public static /* synthetic */ BnplOverduesResponse copy$default(BnplOverduesResponse bnplOverduesResponse, BnplOverduesResponseResult bnplOverduesResponseResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bnplOverduesResponseResult = bnplOverduesResponse.result;
        }
        return bnplOverduesResponse.copy(bnplOverduesResponseResult);
    }

    @NotNull
    public final BnplOverduesResponse copy(@NotNull @Json(name = "result") BnplOverduesResponseResult bnplOverduesResponseResult) {
        Intrinsics.checkNotNullParameter(bnplOverduesResponseResult, "result");
        return new BnplOverduesResponse(bnplOverduesResponseResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BnplOverduesResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((BnplOverduesResponse) obj).result);
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @NotNull
    public final Overdues toOverdues() {
        return new Overdues(this.result.getCount(), this.result.getTotalAmount());
    }

    @NotNull
    public String toString() {
        BnplOverduesResponseResult bnplOverduesResponseResult = this.result;
        return "BnplOverduesResponse(result=" + bnplOverduesResponseResult + ")";
    }
}
