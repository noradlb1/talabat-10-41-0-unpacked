package com.checkout.tokenization.request;

import com.checkout.tokenization.entity.GooglePayEntity;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/tokenization/request/GooglePayTokenNetworkRequest;", "", "type", "", "tokenData", "Lcom/checkout/tokenization/entity/GooglePayEntity;", "(Ljava/lang/String;Lcom/checkout/tokenization/entity/GooglePayEntity;)V", "getTokenData", "()Lcom/checkout/tokenization/entity/GooglePayEntity;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GooglePayTokenNetworkRequest {
    @NotNull
    private final GooglePayEntity tokenData;
    @NotNull
    private final String type;

    public GooglePayTokenNetworkRequest(@NotNull @Json(name = "type") String str, @NotNull @Json(name = "token_data") GooglePayEntity googlePayEntity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(googlePayEntity, "tokenData");
        this.type = str;
        this.tokenData = googlePayEntity;
    }

    public static /* synthetic */ GooglePayTokenNetworkRequest copy$default(GooglePayTokenNetworkRequest googlePayTokenNetworkRequest, String str, GooglePayEntity googlePayEntity, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = googlePayTokenNetworkRequest.type;
        }
        if ((i11 & 2) != 0) {
            googlePayEntity = googlePayTokenNetworkRequest.tokenData;
        }
        return googlePayTokenNetworkRequest.copy(str, googlePayEntity);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final GooglePayEntity component2() {
        return this.tokenData;
    }

    @NotNull
    public final GooglePayTokenNetworkRequest copy(@NotNull @Json(name = "type") String str, @NotNull @Json(name = "token_data") GooglePayEntity googlePayEntity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(googlePayEntity, "tokenData");
        return new GooglePayTokenNetworkRequest(str, googlePayEntity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayTokenNetworkRequest)) {
            return false;
        }
        GooglePayTokenNetworkRequest googlePayTokenNetworkRequest = (GooglePayTokenNetworkRequest) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) googlePayTokenNetworkRequest.type) && Intrinsics.areEqual((Object) this.tokenData, (Object) googlePayTokenNetworkRequest.tokenData);
    }

    @NotNull
    public final GooglePayEntity getTokenData() {
        return this.tokenData;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.tokenData.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.type;
        GooglePayEntity googlePayEntity = this.tokenData;
        return "GooglePayTokenNetworkRequest(type=" + str + ", tokenData=" + googlePayEntity + ")";
    }
}
