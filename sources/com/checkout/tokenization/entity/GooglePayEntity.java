package com.checkout.tokenization.entity;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/checkout/tokenization/entity/GooglePayEntity;", "", "signature", "", "protocolVersion", "signedMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProtocolVersion", "()Ljava/lang/String;", "setProtocolVersion", "(Ljava/lang/String;)V", "getSignature", "setSignature", "getSignedMessage", "setSignedMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GooglePayEntity {
    @Nullable
    private String protocolVersion;
    @Nullable
    private String signature;
    @Nullable
    private String signedMessage;

    public GooglePayEntity() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public GooglePayEntity(@Nullable @Json(name = "signature") String str, @Nullable @Json(name = "protocolVersion") String str2, @Nullable @Json(name = "signedMessage") String str3) {
        this.signature = str;
        this.protocolVersion = str2;
        this.signedMessage = str3;
    }

    public static /* synthetic */ GooglePayEntity copy$default(GooglePayEntity googlePayEntity, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = googlePayEntity.signature;
        }
        if ((i11 & 2) != 0) {
            str2 = googlePayEntity.protocolVersion;
        }
        if ((i11 & 4) != 0) {
            str3 = googlePayEntity.signedMessage;
        }
        return googlePayEntity.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.signature;
    }

    @Nullable
    public final String component2() {
        return this.protocolVersion;
    }

    @Nullable
    public final String component3() {
        return this.signedMessage;
    }

    @NotNull
    public final GooglePayEntity copy(@Nullable @Json(name = "signature") String str, @Nullable @Json(name = "protocolVersion") String str2, @Nullable @Json(name = "signedMessage") String str3) {
        return new GooglePayEntity(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayEntity)) {
            return false;
        }
        GooglePayEntity googlePayEntity = (GooglePayEntity) obj;
        return Intrinsics.areEqual((Object) this.signature, (Object) googlePayEntity.signature) && Intrinsics.areEqual((Object) this.protocolVersion, (Object) googlePayEntity.protocolVersion) && Intrinsics.areEqual((Object) this.signedMessage, (Object) googlePayEntity.signedMessage);
    }

    @Nullable
    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    @Nullable
    public final String getSignature() {
        return this.signature;
    }

    @Nullable
    public final String getSignedMessage() {
        return this.signedMessage;
    }

    public int hashCode() {
        String str = this.signature;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.protocolVersion;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.signedMessage;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setProtocolVersion(@Nullable String str) {
        this.protocolVersion = str;
    }

    public final void setSignature(@Nullable String str) {
        this.signature = str;
    }

    public final void setSignedMessage(@Nullable String str) {
        this.signedMessage = str;
    }

    @NotNull
    public String toString() {
        String str = this.signature;
        String str2 = this.protocolVersion;
        String str3 = this.signedMessage;
        return "GooglePayEntity(signature=" + str + ", protocolVersion=" + str2 + ", signedMessage=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GooglePayEntity(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
