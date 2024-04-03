package com.talabat.splash.domain.entity;

import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.domain.address.Address;
import datamodels.Area;
import datamodels.Country;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003Jz\u0010)\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\fHÖ\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\t\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001d¨\u00060"}, d2 = {"Lcom/talabat/splash/domain/entity/AppInitResponseEntity;", "", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Ldatamodels/Area;", "countries", "Ldatamodels/Country;", "isAddressMicroServiceEnabled", "", "publicKey", "", "tokens", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "url", "([Lcom/talabat/domain/address/Address;[Ldatamodels/Area;[Ldatamodels/Country;Ljava/lang/Boolean;Ljava/lang/String;[Lbuisnessmodels/tokenisation/TokenisationCreditCard;Ljava/lang/String;)V", "getAddresses", "()[Lcom/talabat/domain/address/Address;", "[Lcom/talabat/domain/address/Address;", "getAreas", "()[Ldatamodels/Area;", "[Ldatamodels/Area;", "getCountries", "()[Ldatamodels/Country;", "[Ldatamodels/Country;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPublicKey", "()Ljava/lang/String;", "getTokens", "()[Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "[Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "([Lcom/talabat/domain/address/Address;[Ldatamodels/Area;[Ldatamodels/Country;Ljava/lang/Boolean;Ljava/lang/String;[Lbuisnessmodels/tokenisation/TokenisationCreditCard;Ljava/lang/String;)Lcom/talabat/splash/domain/entity/AppInitResponseEntity;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInitResponseEntity {
    @SerializedName("addresses")
    @Nullable
    private final Address[] addresses;
    @SerializedName("areas")
    @Nullable
    private final Area[] areas;
    @SerializedName("countries")
    @Nullable
    private final Country[] countries;
    @SerializedName("isAddressMicroServiceEnabled")
    @Nullable
    private final Boolean isAddressMicroServiceEnabled;
    @SerializedName("publicKey")
    @Nullable
    private final String publicKey;
    @SerializedName("tokens")
    @Nullable
    private final TokenisationCreditCard[] tokens;
    @SerializedName("url")
    @Nullable
    private final String url;

    public AppInitResponseEntity() {
        this((Address[]) null, (Area[]) null, (Country[]) null, (Boolean) null, (String) null, (TokenisationCreditCard[]) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public AppInitResponseEntity(@Nullable @Json(name = "addresses") Address[] addressArr, @Nullable @Json(name = "areas") Area[] areaArr, @Nullable @Json(name = "countries") Country[] countryArr, @Nullable @Json(name = "isAddressMicroServiceEnabled") Boolean bool, @Nullable @Json(name = "publicKey") String str, @Nullable @Json(name = "tokens") TokenisationCreditCard[] tokenisationCreditCardArr, @Nullable @Json(name = "url") String str2) {
        this.addresses = addressArr;
        this.areas = areaArr;
        this.countries = countryArr;
        this.isAddressMicroServiceEnabled = bool;
        this.publicKey = str;
        this.tokens = tokenisationCreditCardArr;
        this.url = str2;
    }

    public static /* synthetic */ AppInitResponseEntity copy$default(AppInitResponseEntity appInitResponseEntity, Address[] addressArr, Area[] areaArr, Country[] countryArr, Boolean bool, String str, TokenisationCreditCard[] tokenisationCreditCardArr, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            addressArr = appInitResponseEntity.addresses;
        }
        if ((i11 & 2) != 0) {
            areaArr = appInitResponseEntity.areas;
        }
        Area[] areaArr2 = areaArr;
        if ((i11 & 4) != 0) {
            countryArr = appInitResponseEntity.countries;
        }
        Country[] countryArr2 = countryArr;
        if ((i11 & 8) != 0) {
            bool = appInitResponseEntity.isAddressMicroServiceEnabled;
        }
        Boolean bool2 = bool;
        if ((i11 & 16) != 0) {
            str = appInitResponseEntity.publicKey;
        }
        String str3 = str;
        if ((i11 & 32) != 0) {
            tokenisationCreditCardArr = appInitResponseEntity.tokens;
        }
        TokenisationCreditCard[] tokenisationCreditCardArr2 = tokenisationCreditCardArr;
        if ((i11 & 64) != 0) {
            str2 = appInitResponseEntity.url;
        }
        return appInitResponseEntity.copy(addressArr, areaArr2, countryArr2, bool2, str3, tokenisationCreditCardArr2, str2);
    }

    @Nullable
    public final Address[] component1() {
        return this.addresses;
    }

    @Nullable
    public final Area[] component2() {
        return this.areas;
    }

    @Nullable
    public final Country[] component3() {
        return this.countries;
    }

    @Nullable
    public final Boolean component4() {
        return this.isAddressMicroServiceEnabled;
    }

    @Nullable
    public final String component5() {
        return this.publicKey;
    }

    @Nullable
    public final TokenisationCreditCard[] component6() {
        return this.tokens;
    }

    @Nullable
    public final String component7() {
        return this.url;
    }

    @NotNull
    public final AppInitResponseEntity copy(@Nullable @Json(name = "addresses") Address[] addressArr, @Nullable @Json(name = "areas") Area[] areaArr, @Nullable @Json(name = "countries") Country[] countryArr, @Nullable @Json(name = "isAddressMicroServiceEnabled") Boolean bool, @Nullable @Json(name = "publicKey") String str, @Nullable @Json(name = "tokens") TokenisationCreditCard[] tokenisationCreditCardArr, @Nullable @Json(name = "url") String str2) {
        return new AppInitResponseEntity(addressArr, areaArr, countryArr, bool, str, tokenisationCreditCardArr, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInitResponseEntity)) {
            return false;
        }
        AppInitResponseEntity appInitResponseEntity = (AppInitResponseEntity) obj;
        return Intrinsics.areEqual((Object) this.addresses, (Object) appInitResponseEntity.addresses) && Intrinsics.areEqual((Object) this.areas, (Object) appInitResponseEntity.areas) && Intrinsics.areEqual((Object) this.countries, (Object) appInitResponseEntity.countries) && Intrinsics.areEqual((Object) this.isAddressMicroServiceEnabled, (Object) appInitResponseEntity.isAddressMicroServiceEnabled) && Intrinsics.areEqual((Object) this.publicKey, (Object) appInitResponseEntity.publicKey) && Intrinsics.areEqual((Object) this.tokens, (Object) appInitResponseEntity.tokens) && Intrinsics.areEqual((Object) this.url, (Object) appInitResponseEntity.url);
    }

    @Nullable
    public final Address[] getAddresses() {
        return this.addresses;
    }

    @Nullable
    public final Area[] getAreas() {
        return this.areas;
    }

    @Nullable
    public final Country[] getCountries() {
        return this.countries;
    }

    @Nullable
    public final String getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final TokenisationCreditCard[] getTokens() {
        return this.tokens;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Address[] addressArr = this.addresses;
        int i11 = 0;
        int hashCode = (addressArr == null ? 0 : Arrays.hashCode(addressArr)) * 31;
        Area[] areaArr = this.areas;
        int hashCode2 = (hashCode + (areaArr == null ? 0 : Arrays.hashCode(areaArr))) * 31;
        Country[] countryArr = this.countries;
        int hashCode3 = (hashCode2 + (countryArr == null ? 0 : Arrays.hashCode(countryArr))) * 31;
        Boolean bool = this.isAddressMicroServiceEnabled;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.publicKey;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        TokenisationCreditCard[] tokenisationCreditCardArr = this.tokens;
        int hashCode6 = (hashCode5 + (tokenisationCreditCardArr == null ? 0 : Arrays.hashCode(tokenisationCreditCardArr))) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode6 + i11;
    }

    @Nullable
    public final Boolean isAddressMicroServiceEnabled() {
        return this.isAddressMicroServiceEnabled;
    }

    @NotNull
    public String toString() {
        String arrays = Arrays.toString(this.addresses);
        String arrays2 = Arrays.toString(this.areas);
        String arrays3 = Arrays.toString(this.countries);
        Boolean bool = this.isAddressMicroServiceEnabled;
        String str = this.publicKey;
        String arrays4 = Arrays.toString(this.tokens);
        String str2 = this.url;
        return "AppInitResponseEntity(addresses=" + arrays + ", areas=" + arrays2 + ", countries=" + arrays3 + ", isAddressMicroServiceEnabled=" + bool + ", publicKey=" + str + ", tokens=" + arrays4 + ", url=" + str2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppInitResponseEntity(com.talabat.domain.address.Address[] r7, datamodels.Area[] r8, datamodels.Country[] r9, java.lang.Boolean r10, java.lang.String r11, buisnessmodels.tokenisation.TokenisationCreditCard[] r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
        L_0x001c:
            r3 = r10
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.entity.AppInitResponseEntity.<init>(com.talabat.domain.address.Address[], datamodels.Area[], datamodels.Country[], java.lang.Boolean, java.lang.String, buisnessmodels.tokenisation.TokenisationCreditCard[], java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
