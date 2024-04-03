package com.checkout.tokenization.model;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003JÓ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0007HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001c¨\u0006G"}, d2 = {"Lcom/checkout/tokenization/model/TokenDetails;", "", "type", "", "token", "expiresOn", "expiryMonth", "", "expiryYear", "scheme", "schemeLocal", "last4", "bin", "cardType", "cardCategory", "issuer", "issuerCountry", "productId", "productType", "billingAddress", "Lcom/checkout/tokenization/model/Address;", "phone", "Lcom/checkout/tokenization/model/Phone;", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/checkout/tokenization/model/Address;Lcom/checkout/tokenization/model/Phone;Ljava/lang/String;)V", "getBillingAddress", "()Lcom/checkout/tokenization/model/Address;", "getBin", "()Ljava/lang/String;", "getCardCategory", "getCardType", "getExpiresOn", "getExpiryMonth", "()I", "getExpiryYear", "getIssuer", "getIssuerCountry", "getLast4", "getName", "getPhone", "()Lcom/checkout/tokenization/model/Phone;", "getProductId", "getProductType", "getScheme", "getSchemeLocal", "getToken", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenDetails {
    @Nullable
    private final Address billingAddress;
    @NotNull
    private final String bin;
    @Nullable
    private final String cardCategory;
    @Nullable
    private final String cardType;
    @NotNull
    private final String expiresOn;
    private final int expiryMonth;
    private final int expiryYear;
    @Nullable
    private final String issuer;
    @Nullable
    private final String issuerCountry;
    @NotNull
    private final String last4;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f29378name;
    @Nullable
    private final Phone phone;
    @Nullable
    private final String productId;
    @Nullable
    private final String productType;
    @Nullable
    private final String scheme;
    @Nullable
    private final String schemeLocal;
    @NotNull
    private final String token;
    @NotNull
    private final String type;

    public TokenDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, int i12, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable Address address, @Nullable Phone phone2, @Nullable String str14) {
        String str15 = str7;
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str3, "expiresOn");
        Intrinsics.checkNotNullParameter(str6, "last4");
        Intrinsics.checkNotNullParameter(str15, "bin");
        this.type = str;
        this.token = str2;
        this.expiresOn = str3;
        this.expiryMonth = i11;
        this.expiryYear = i12;
        this.scheme = str4;
        this.schemeLocal = str5;
        this.last4 = str6;
        this.bin = str15;
        this.cardType = str8;
        this.cardCategory = str9;
        this.issuer = str10;
        this.issuerCountry = str11;
        this.productId = str12;
        this.productType = str13;
        this.billingAddress = address;
        this.phone = phone2;
        this.f29378name = str14;
    }

    public static /* synthetic */ TokenDetails copy$default(TokenDetails tokenDetails, String str, String str2, String str3, int i11, int i12, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Address address, Phone phone2, String str14, int i13, Object obj) {
        TokenDetails tokenDetails2 = tokenDetails;
        int i14 = i13;
        return tokenDetails.copy((i14 & 1) != 0 ? tokenDetails2.type : str, (i14 & 2) != 0 ? tokenDetails2.token : str2, (i14 & 4) != 0 ? tokenDetails2.expiresOn : str3, (i14 & 8) != 0 ? tokenDetails2.expiryMonth : i11, (i14 & 16) != 0 ? tokenDetails2.expiryYear : i12, (i14 & 32) != 0 ? tokenDetails2.scheme : str4, (i14 & 64) != 0 ? tokenDetails2.schemeLocal : str5, (i14 & 128) != 0 ? tokenDetails2.last4 : str6, (i14 & 256) != 0 ? tokenDetails2.bin : str7, (i14 & 512) != 0 ? tokenDetails2.cardType : str8, (i14 & 1024) != 0 ? tokenDetails2.cardCategory : str9, (i14 & 2048) != 0 ? tokenDetails2.issuer : str10, (i14 & 4096) != 0 ? tokenDetails2.issuerCountry : str11, (i14 & 8192) != 0 ? tokenDetails2.productId : str12, (i14 & 16384) != 0 ? tokenDetails2.productType : str13, (i14 & 32768) != 0 ? tokenDetails2.billingAddress : address, (i14 & 65536) != 0 ? tokenDetails2.phone : phone2, (i14 & 131072) != 0 ? tokenDetails2.f29378name : str14);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component10() {
        return this.cardType;
    }

    @Nullable
    public final String component11() {
        return this.cardCategory;
    }

    @Nullable
    public final String component12() {
        return this.issuer;
    }

    @Nullable
    public final String component13() {
        return this.issuerCountry;
    }

    @Nullable
    public final String component14() {
        return this.productId;
    }

    @Nullable
    public final String component15() {
        return this.productType;
    }

    @Nullable
    public final Address component16() {
        return this.billingAddress;
    }

    @Nullable
    public final Phone component17() {
        return this.phone;
    }

    @Nullable
    public final String component18() {
        return this.f29378name;
    }

    @NotNull
    public final String component2() {
        return this.token;
    }

    @NotNull
    public final String component3() {
        return this.expiresOn;
    }

    public final int component4() {
        return this.expiryMonth;
    }

    public final int component5() {
        return this.expiryYear;
    }

    @Nullable
    public final String component6() {
        return this.scheme;
    }

    @Nullable
    public final String component7() {
        return this.schemeLocal;
    }

    @NotNull
    public final String component8() {
        return this.last4;
    }

    @NotNull
    public final String component9() {
        return this.bin;
    }

    @NotNull
    public final TokenDetails copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, int i12, @Nullable String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable Address address, @Nullable Phone phone2, @Nullable String str14) {
        String str15 = str;
        Intrinsics.checkNotNullParameter(str15, "type");
        Intrinsics.checkNotNullParameter(str2, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str3, "expiresOn");
        Intrinsics.checkNotNullParameter(str6, "last4");
        Intrinsics.checkNotNullParameter(str7, "bin");
        return new TokenDetails(str15, str2, str3, i11, i12, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, address, phone2, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenDetails)) {
            return false;
        }
        TokenDetails tokenDetails = (TokenDetails) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) tokenDetails.type) && Intrinsics.areEqual((Object) this.token, (Object) tokenDetails.token) && Intrinsics.areEqual((Object) this.expiresOn, (Object) tokenDetails.expiresOn) && this.expiryMonth == tokenDetails.expiryMonth && this.expiryYear == tokenDetails.expiryYear && Intrinsics.areEqual((Object) this.scheme, (Object) tokenDetails.scheme) && Intrinsics.areEqual((Object) this.schemeLocal, (Object) tokenDetails.schemeLocal) && Intrinsics.areEqual((Object) this.last4, (Object) tokenDetails.last4) && Intrinsics.areEqual((Object) this.bin, (Object) tokenDetails.bin) && Intrinsics.areEqual((Object) this.cardType, (Object) tokenDetails.cardType) && Intrinsics.areEqual((Object) this.cardCategory, (Object) tokenDetails.cardCategory) && Intrinsics.areEqual((Object) this.issuer, (Object) tokenDetails.issuer) && Intrinsics.areEqual((Object) this.issuerCountry, (Object) tokenDetails.issuerCountry) && Intrinsics.areEqual((Object) this.productId, (Object) tokenDetails.productId) && Intrinsics.areEqual((Object) this.productType, (Object) tokenDetails.productType) && Intrinsics.areEqual((Object) this.billingAddress, (Object) tokenDetails.billingAddress) && Intrinsics.areEqual((Object) this.phone, (Object) tokenDetails.phone) && Intrinsics.areEqual((Object) this.f29378name, (Object) tokenDetails.f29378name);
    }

    @Nullable
    public final Address getBillingAddress() {
        return this.billingAddress;
    }

    @NotNull
    public final String getBin() {
        return this.bin;
    }

    @Nullable
    public final String getCardCategory() {
        return this.cardCategory;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @NotNull
    public final String getExpiresOn() {
        return this.expiresOn;
    }

    public final int getExpiryMonth() {
        return this.expiryMonth;
    }

    public final int getExpiryYear() {
        return this.expiryYear;
    }

    @Nullable
    public final String getIssuer() {
        return this.issuer;
    }

    @Nullable
    public final String getIssuerCountry() {
        return this.issuerCountry;
    }

    @NotNull
    public final String getLast4() {
        return this.last4;
    }

    @Nullable
    public final String getName() {
        return this.f29378name;
    }

    @Nullable
    public final Phone getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    public final String getProductType() {
        return this.productType;
    }

    @Nullable
    public final String getScheme() {
        return this.scheme;
    }

    @Nullable
    public final String getSchemeLocal() {
        return this.schemeLocal;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((((this.type.hashCode() * 31) + this.token.hashCode()) * 31) + this.expiresOn.hashCode()) * 31) + this.expiryMonth) * 31) + this.expiryYear) * 31;
        String str = this.scheme;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.schemeLocal;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.last4.hashCode()) * 31) + this.bin.hashCode()) * 31;
        String str3 = this.cardType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardCategory;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.issuer;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.issuerCountry;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.productId;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.productType;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Address address = this.billingAddress;
        int hashCode10 = (hashCode9 + (address == null ? 0 : address.hashCode())) * 31;
        Phone phone2 = this.phone;
        int hashCode11 = (hashCode10 + (phone2 == null ? 0 : phone2.hashCode())) * 31;
        String str9 = this.f29378name;
        if (str9 != null) {
            i11 = str9.hashCode();
        }
        return hashCode11 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.token;
        String str3 = this.expiresOn;
        int i11 = this.expiryMonth;
        int i12 = this.expiryYear;
        String str4 = this.scheme;
        String str5 = this.schemeLocal;
        String str6 = this.last4;
        String str7 = this.bin;
        String str8 = this.cardType;
        String str9 = this.cardCategory;
        String str10 = this.issuer;
        String str11 = this.issuerCountry;
        String str12 = this.productId;
        String str13 = this.productType;
        Address address = this.billingAddress;
        Phone phone2 = this.phone;
        String str14 = this.f29378name;
        return "TokenDetails(type=" + str + ", token=" + str2 + ", expiresOn=" + str3 + ", expiryMonth=" + i11 + ", expiryYear=" + i12 + ", scheme=" + str4 + ", schemeLocal=" + str5 + ", last4=" + str6 + ", bin=" + str7 + ", cardType=" + str8 + ", cardCategory=" + str9 + ", issuer=" + str10 + ", issuerCountry=" + str11 + ", productId=" + str12 + ", productType=" + str13 + ", billingAddress=" + address + ", phone=" + phone2 + ", name=" + str14 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TokenDetails(java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, int r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, com.checkout.tokenization.model.Address r38, com.checkout.tokenization.model.Phone r39, java.lang.String r40, int r41, kotlin.jvm.internal.DefaultConstructorMarker r42) {
        /*
            r22 = this;
            r0 = r41
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r17 = r2
            goto L_0x000c
        L_0x000a:
            r17 = r36
        L_0x000c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0013
            r18 = r2
            goto L_0x0015
        L_0x0013:
            r18 = r37
        L_0x0015:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x001e
            r19 = r2
            goto L_0x0020
        L_0x001e:
            r19 = r38
        L_0x0020:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0028
            r20 = r2
            goto L_0x002a
        L_0x0028:
            r20 = r39
        L_0x002a:
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r16 = r35
            r21 = r40
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.model.TokenDetails.<init>(java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.checkout.tokenization.model.Address, com.checkout.tokenization.model.Phone, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
