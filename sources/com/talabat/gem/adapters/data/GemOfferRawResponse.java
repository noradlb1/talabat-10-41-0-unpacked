package com.talabat.gem.adapters.data;

import JsonModels.Response.GEMResponse.GemOfferResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/adapters/data/GemOfferRawResponse;", "", "response", "LJsonModels/Response/GEMResponse/GemOfferResponse;", "(LJsonModels/Response/GEMResponse/GemOfferResponse;)V", "getResponse", "()LJsonModels/Response/GEMResponse/GemOfferResponse;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOfferRawResponse {
    @SerializedName("result")
    @Nullable
    private final GemOfferResponse response;

    public GemOfferRawResponse() {
        this((GemOfferResponse) null, 1, (DefaultConstructorMarker) null);
    }

    public GemOfferRawResponse(@Nullable GemOfferResponse gemOfferResponse) {
        this.response = gemOfferResponse;
    }

    public static /* synthetic */ GemOfferRawResponse copy$default(GemOfferRawResponse gemOfferRawResponse, GemOfferResponse gemOfferResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            gemOfferResponse = gemOfferRawResponse.response;
        }
        return gemOfferRawResponse.copy(gemOfferResponse);
    }

    @Nullable
    public final GemOfferResponse component1() {
        return this.response;
    }

    @NotNull
    public final GemOfferRawResponse copy(@Nullable GemOfferResponse gemOfferResponse) {
        return new GemOfferRawResponse(gemOfferResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GemOfferRawResponse) && Intrinsics.areEqual((Object) this.response, (Object) ((GemOfferRawResponse) obj).response);
    }

    @Nullable
    public final GemOfferResponse getResponse() {
        return this.response;
    }

    public int hashCode() {
        GemOfferResponse gemOfferResponse = this.response;
        if (gemOfferResponse == null) {
            return 0;
        }
        return gemOfferResponse.hashCode();
    }

    @NotNull
    public String toString() {
        GemOfferResponse gemOfferResponse = this.response;
        return "GemOfferRawResponse(response=" + gemOfferResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GemOfferRawResponse(GemOfferResponse gemOfferResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : gemOfferResponse);
    }
}
