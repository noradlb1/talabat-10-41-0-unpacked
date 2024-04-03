package com.talabat.gem.adapters.data;

import JsonModels.GemAcceptResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/adapters/data/GemAcceptRawResponse;", "", "result", "LJsonModels/GemAcceptResponse;", "(LJsonModels/GemAcceptResponse;)V", "getResult", "()LJsonModels/GemAcceptResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemAcceptRawResponse {
    @SerializedName("result")
    @Nullable
    private final GemAcceptResponse result;

    public GemAcceptRawResponse(@Nullable GemAcceptResponse gemAcceptResponse) {
        this.result = gemAcceptResponse;
    }

    public static /* synthetic */ GemAcceptRawResponse copy$default(GemAcceptRawResponse gemAcceptRawResponse, GemAcceptResponse gemAcceptResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gemAcceptResponse = gemAcceptRawResponse.result;
        }
        return gemAcceptRawResponse.copy(gemAcceptResponse);
    }

    @Nullable
    public final GemAcceptResponse component1() {
        return this.result;
    }

    @NotNull
    public final GemAcceptRawResponse copy(@Nullable GemAcceptResponse gemAcceptResponse) {
        return new GemAcceptRawResponse(gemAcceptResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemAcceptRawResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((GemAcceptRawResponse) obj).result);
    }

    @Nullable
    public final GemAcceptResponse getResult() {
        return this.result;
    }

    public int hashCode() {
        GemAcceptResponse gemAcceptResponse = this.result;
        if (gemAcceptResponse == null) {
            return 0;
        }
        return gemAcceptResponse.hashCode();
    }

    @NotNull
    public String toString() {
        GemAcceptResponse gemAcceptResponse = this.result;
        return "GemAcceptRawResponse(result=" + gemAcceptResponse + ")";
    }
}
