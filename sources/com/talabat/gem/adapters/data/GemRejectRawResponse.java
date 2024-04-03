package com.talabat.gem.adapters.data;

import JsonModels.GemRejectResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/adapters/data/GemRejectRawResponse;", "", "result", "LJsonModels/GemRejectResponse;", "(LJsonModels/GemRejectResponse;)V", "getResult", "()LJsonModels/GemRejectResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemRejectRawResponse {
    @SerializedName("result")
    @Nullable
    private final GemRejectResponse result;

    public GemRejectRawResponse(@Nullable GemRejectResponse gemRejectResponse) {
        this.result = gemRejectResponse;
    }

    public static /* synthetic */ GemRejectRawResponse copy$default(GemRejectRawResponse gemRejectRawResponse, GemRejectResponse gemRejectResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gemRejectResponse = gemRejectRawResponse.result;
        }
        return gemRejectRawResponse.copy(gemRejectResponse);
    }

    @Nullable
    public final GemRejectResponse component1() {
        return this.result;
    }

    @NotNull
    public final GemRejectRawResponse copy(@Nullable GemRejectResponse gemRejectResponse) {
        return new GemRejectRawResponse(gemRejectResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemRejectRawResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((GemRejectRawResponse) obj).result);
    }

    @Nullable
    public final GemRejectResponse getResult() {
        return this.result;
    }

    public int hashCode() {
        GemRejectResponse gemRejectResponse = this.result;
        if (gemRejectResponse == null) {
            return 0;
        }
        return gemRejectResponse.hashCode();
    }

    @NotNull
    public String toString() {
        GemRejectResponse gemRejectResponse = this.result;
        return "GemRejectRawResponse(result=" + gemRejectResponse + ")";
    }
}
