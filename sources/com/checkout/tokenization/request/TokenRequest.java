package com.checkout.tokenization.request;

import com.checkout.tokenization.entity.AddressEntity;
import com.checkout.tokenization.entity.PhoneEntity;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003Ja\u0010!\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/checkout/tokenization/request/TokenRequest;", "", "type", "", "number", "expiryMonth", "expiryYear", "name", "cvv", "billingAddress", "Lcom/checkout/tokenization/entity/AddressEntity;", "phone", "Lcom/checkout/tokenization/entity/PhoneEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/checkout/tokenization/entity/AddressEntity;Lcom/checkout/tokenization/entity/PhoneEntity;)V", "getBillingAddress", "()Lcom/checkout/tokenization/entity/AddressEntity;", "getCvv", "()Ljava/lang/String;", "getExpiryMonth", "getExpiryYear", "getName", "getNumber", "getPhone", "()Lcom/checkout/tokenization/entity/PhoneEntity;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenRequest {
    @Nullable
    private final AddressEntity billingAddress;
    @Nullable
    private final String cvv;
    @NotNull
    private final String expiryMonth;
    @NotNull
    private final String expiryYear;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f29379name;
    @NotNull
    private final String number;
    @Nullable
    private final PhoneEntity phone;
    @NotNull
    private final String type;

    public TokenRequest(@NotNull @Json(name = "type") String str, @NotNull @Json(name = "number") String str2, @NotNull @Json(name = "expiry_month") String str3, @NotNull @Json(name = "expiry_year") String str4, @Nullable @Json(name = "name") String str5, @Nullable @Json(name = "cvv") String str6, @Nullable @Json(name = "billing_address") AddressEntity addressEntity, @Nullable @Json(name = "phone") PhoneEntity phoneEntity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str4, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        this.type = str;
        this.number = str2;
        this.expiryMonth = str3;
        this.expiryYear = str4;
        this.f29379name = str5;
        this.cvv = str6;
        this.billingAddress = addressEntity;
        this.phone = phoneEntity;
    }

    public static /* synthetic */ TokenRequest copy$default(TokenRequest tokenRequest, String str, String str2, String str3, String str4, String str5, String str6, AddressEntity addressEntity, PhoneEntity phoneEntity, int i11, Object obj) {
        TokenRequest tokenRequest2 = tokenRequest;
        int i12 = i11;
        return tokenRequest.copy((i12 & 1) != 0 ? tokenRequest2.type : str, (i12 & 2) != 0 ? tokenRequest2.number : str2, (i12 & 4) != 0 ? tokenRequest2.expiryMonth : str3, (i12 & 8) != 0 ? tokenRequest2.expiryYear : str4, (i12 & 16) != 0 ? tokenRequest2.f29379name : str5, (i12 & 32) != 0 ? tokenRequest2.cvv : str6, (i12 & 64) != 0 ? tokenRequest2.billingAddress : addressEntity, (i12 & 128) != 0 ? tokenRequest2.phone : phoneEntity);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.number;
    }

    @NotNull
    public final String component3() {
        return this.expiryMonth;
    }

    @NotNull
    public final String component4() {
        return this.expiryYear;
    }

    @Nullable
    public final String component5() {
        return this.f29379name;
    }

    @Nullable
    public final String component6() {
        return this.cvv;
    }

    @Nullable
    public final AddressEntity component7() {
        return this.billingAddress;
    }

    @Nullable
    public final PhoneEntity component8() {
        return this.phone;
    }

    @NotNull
    public final TokenRequest copy(@NotNull @Json(name = "type") String str, @NotNull @Json(name = "number") String str2, @NotNull @Json(name = "expiry_month") String str3, @NotNull @Json(name = "expiry_year") String str4, @Nullable @Json(name = "name") String str5, @Nullable @Json(name = "cvv") String str6, @Nullable @Json(name = "billing_address") AddressEntity addressEntity, @Nullable @Json(name = "phone") PhoneEntity phoneEntity) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str3, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullParameter(str4, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
        return new TokenRequest(str, str2, str3, str4, str5, str6, addressEntity, phoneEntity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenRequest)) {
            return false;
        }
        TokenRequest tokenRequest = (TokenRequest) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) tokenRequest.type) && Intrinsics.areEqual((Object) this.number, (Object) tokenRequest.number) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) tokenRequest.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) tokenRequest.expiryYear) && Intrinsics.areEqual((Object) this.f29379name, (Object) tokenRequest.f29379name) && Intrinsics.areEqual((Object) this.cvv, (Object) tokenRequest.cvv) && Intrinsics.areEqual((Object) this.billingAddress, (Object) tokenRequest.billingAddress) && Intrinsics.areEqual((Object) this.phone, (Object) tokenRequest.phone);
    }

    @Nullable
    public final AddressEntity getBillingAddress() {
        return this.billingAddress;
    }

    @Nullable
    public final String getCvv() {
        return this.cvv;
    }

    @NotNull
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @NotNull
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @Nullable
    public final String getName() {
        return this.f29379name;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    public final PhoneEntity getPhone() {
        return this.phone;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((this.type.hashCode() * 31) + this.number.hashCode()) * 31) + this.expiryMonth.hashCode()) * 31) + this.expiryYear.hashCode()) * 31;
        String str = this.f29379name;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cvv;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AddressEntity addressEntity = this.billingAddress;
        int hashCode4 = (hashCode3 + (addressEntity == null ? 0 : addressEntity.hashCode())) * 31;
        PhoneEntity phoneEntity = this.phone;
        if (phoneEntity != null) {
            i11 = phoneEntity.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.number;
        String str3 = this.expiryMonth;
        String str4 = this.expiryYear;
        String str5 = this.f29379name;
        String str6 = this.cvv;
        AddressEntity addressEntity = this.billingAddress;
        PhoneEntity phoneEntity = this.phone;
        return "TokenRequest(type=" + str + ", number=" + str2 + ", expiryMonth=" + str3 + ", expiryYear=" + str4 + ", name=" + str5 + ", cvv=" + str6 + ", billingAddress=" + addressEntity + ", phone=" + phoneEntity + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TokenRequest(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.checkout.tokenization.entity.AddressEntity r19, com.checkout.tokenization.entity.PhoneEntity r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r17
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r18
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r19
        L_0x001b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0021
            r11 = r2
            goto L_0x0023
        L_0x0021:
            r11 = r20
        L_0x0023:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.request.TokenRequest.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.checkout.tokenization.entity.AddressEntity, com.checkout.tokenization.entity.PhoneEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
