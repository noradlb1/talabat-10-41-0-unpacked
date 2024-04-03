package com.talabat.configuration.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.configuration.location.model.AreaEntity;
import com.talabat.configuration.location.model.CountryEntity;
import com.talabat.configuration.payment.model.TokenizedBankCardEntity;
import com.talabat.domain.address.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\bHÖ\u0001J\t\u00102\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\r\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u00063"}, d2 = {"Lcom/talabat/configuration/remote/model/AppInfoResultEntity;", "", "addresses", "", "Lcom/talabat/domain/address/Address;", "areas", "Lcom/talabat/configuration/location/model/AreaEntity;", "countryId", "", "countries", "Lcom/talabat/configuration/location/model/CountryEntity;", "newAppVersion", "Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "isAddressMicroServiceEnabled", "", "publicKey", "", "tokenizedBankCards", "Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "url", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/talabat/configuration/remote/model/NewAppVersionEntity;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAddresses", "()Ljava/util/List;", "getAreas", "getCountries", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewAppVersion", "()Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "getPublicKey", "()Ljava/lang/String;", "getTokenizedBankCards", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/talabat/configuration/remote/model/NewAppVersionEntity;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/talabat/configuration/remote/model/AppInfoResultEntity;", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoResultEntity {
    @Nullable
    private final List<Address> addresses;
    @Nullable
    private final List<AreaEntity> areas;
    @Nullable
    private final List<CountryEntity> countries;
    @Nullable
    private final Integer countryId;
    @Nullable
    private final Boolean isAddressMicroServiceEnabled;
    @Nullable
    private final NewAppVersionEntity newAppVersion;
    @Nullable
    private final String publicKey;
    @Nullable
    private final List<TokenizedBankCardEntity> tokenizedBankCards;
    @Nullable
    private final String url;

    public AppInfoResultEntity() {
        this((List) null, (List) null, (Integer) null, (List) null, (NewAppVersionEntity) null, (Boolean) null, (String) null, (List) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public AppInfoResultEntity(@Nullable @Json(name = "addresses") List<Address> list, @Nullable @Json(name = "areas") List<AreaEntity> list2, @Nullable @Json(name = "countryId") Integer num, @Nullable @Json(name = "countries") List<CountryEntity> list3, @Nullable @Json(name = "dversion") NewAppVersionEntity newAppVersionEntity, @Nullable @Json(name = "isAddressMicroServiceEnabled") Boolean bool, @Nullable @Json(name = "publicKey") String str, @Nullable @Json(name = "tokens") List<TokenizedBankCardEntity> list4, @Nullable @Json(name = "url") String str2) {
        this.addresses = list;
        this.areas = list2;
        this.countryId = num;
        this.countries = list3;
        this.newAppVersion = newAppVersionEntity;
        this.isAddressMicroServiceEnabled = bool;
        this.publicKey = str;
        this.tokenizedBankCards = list4;
        this.url = str2;
    }

    public static /* synthetic */ AppInfoResultEntity copy$default(AppInfoResultEntity appInfoResultEntity, List list, List list2, Integer num, List list3, NewAppVersionEntity newAppVersionEntity, Boolean bool, String str, List list4, String str2, int i11, Object obj) {
        AppInfoResultEntity appInfoResultEntity2 = appInfoResultEntity;
        int i12 = i11;
        return appInfoResultEntity.copy((i12 & 1) != 0 ? appInfoResultEntity2.addresses : list, (i12 & 2) != 0 ? appInfoResultEntity2.areas : list2, (i12 & 4) != 0 ? appInfoResultEntity2.countryId : num, (i12 & 8) != 0 ? appInfoResultEntity2.countries : list3, (i12 & 16) != 0 ? appInfoResultEntity2.newAppVersion : newAppVersionEntity, (i12 & 32) != 0 ? appInfoResultEntity2.isAddressMicroServiceEnabled : bool, (i12 & 64) != 0 ? appInfoResultEntity2.publicKey : str, (i12 & 128) != 0 ? appInfoResultEntity2.tokenizedBankCards : list4, (i12 & 256) != 0 ? appInfoResultEntity2.url : str2);
    }

    @Nullable
    public final List<Address> component1() {
        return this.addresses;
    }

    @Nullable
    public final List<AreaEntity> component2() {
        return this.areas;
    }

    @Nullable
    public final Integer component3() {
        return this.countryId;
    }

    @Nullable
    public final List<CountryEntity> component4() {
        return this.countries;
    }

    @Nullable
    public final NewAppVersionEntity component5() {
        return this.newAppVersion;
    }

    @Nullable
    public final Boolean component6() {
        return this.isAddressMicroServiceEnabled;
    }

    @Nullable
    public final String component7() {
        return this.publicKey;
    }

    @Nullable
    public final List<TokenizedBankCardEntity> component8() {
        return this.tokenizedBankCards;
    }

    @Nullable
    public final String component9() {
        return this.url;
    }

    @NotNull
    public final AppInfoResultEntity copy(@Nullable @Json(name = "addresses") List<Address> list, @Nullable @Json(name = "areas") List<AreaEntity> list2, @Nullable @Json(name = "countryId") Integer num, @Nullable @Json(name = "countries") List<CountryEntity> list3, @Nullable @Json(name = "dversion") NewAppVersionEntity newAppVersionEntity, @Nullable @Json(name = "isAddressMicroServiceEnabled") Boolean bool, @Nullable @Json(name = "publicKey") String str, @Nullable @Json(name = "tokens") List<TokenizedBankCardEntity> list4, @Nullable @Json(name = "url") String str2) {
        return new AppInfoResultEntity(list, list2, num, list3, newAppVersionEntity, bool, str, list4, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfoResultEntity)) {
            return false;
        }
        AppInfoResultEntity appInfoResultEntity = (AppInfoResultEntity) obj;
        return Intrinsics.areEqual((Object) this.addresses, (Object) appInfoResultEntity.addresses) && Intrinsics.areEqual((Object) this.areas, (Object) appInfoResultEntity.areas) && Intrinsics.areEqual((Object) this.countryId, (Object) appInfoResultEntity.countryId) && Intrinsics.areEqual((Object) this.countries, (Object) appInfoResultEntity.countries) && Intrinsics.areEqual((Object) this.newAppVersion, (Object) appInfoResultEntity.newAppVersion) && Intrinsics.areEqual((Object) this.isAddressMicroServiceEnabled, (Object) appInfoResultEntity.isAddressMicroServiceEnabled) && Intrinsics.areEqual((Object) this.publicKey, (Object) appInfoResultEntity.publicKey) && Intrinsics.areEqual((Object) this.tokenizedBankCards, (Object) appInfoResultEntity.tokenizedBankCards) && Intrinsics.areEqual((Object) this.url, (Object) appInfoResultEntity.url);
    }

    @Nullable
    public final List<Address> getAddresses() {
        return this.addresses;
    }

    @Nullable
    public final List<AreaEntity> getAreas() {
        return this.areas;
    }

    @Nullable
    public final List<CountryEntity> getCountries() {
        return this.countries;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final NewAppVersionEntity getNewAppVersion() {
        return this.newAppVersion;
    }

    @Nullable
    public final String getPublicKey() {
        return this.publicKey;
    }

    @Nullable
    public final List<TokenizedBankCardEntity> getTokenizedBankCards() {
        return this.tokenizedBankCards;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        List<Address> list = this.addresses;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<AreaEntity> list2 = this.areas;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.countryId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<CountryEntity> list3 = this.countries;
        int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        NewAppVersionEntity newAppVersionEntity = this.newAppVersion;
        int hashCode5 = (hashCode4 + (newAppVersionEntity == null ? 0 : newAppVersionEntity.hashCode())) * 31;
        Boolean bool = this.isAddressMicroServiceEnabled;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.publicKey;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        List<TokenizedBankCardEntity> list4 = this.tokenizedBankCards;
        int hashCode8 = (hashCode7 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode8 + i11;
    }

    @Nullable
    public final Boolean isAddressMicroServiceEnabled() {
        return this.isAddressMicroServiceEnabled;
    }

    @NotNull
    public String toString() {
        List<Address> list = this.addresses;
        List<AreaEntity> list2 = this.areas;
        Integer num = this.countryId;
        List<CountryEntity> list3 = this.countries;
        NewAppVersionEntity newAppVersionEntity = this.newAppVersion;
        Boolean bool = this.isAddressMicroServiceEnabled;
        String str = this.publicKey;
        List<TokenizedBankCardEntity> list4 = this.tokenizedBankCards;
        String str2 = this.url;
        return "AppInfoResultEntity(addresses=" + list + ", areas=" + list2 + ", countryId=" + num + ", countries=" + list3 + ", newAppVersion=" + newAppVersionEntity + ", isAddressMicroServiceEnabled=" + bool + ", publicKey=" + str + ", tokenizedBankCards=" + list4 + ", url=" + str2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppInfoResultEntity(java.util.List r11, java.util.List r12, java.lang.Integer r13, java.util.List r14, com.talabat.configuration.remote.model.NewAppVersionEntity r15, java.lang.Boolean r16, java.lang.String r17, java.util.List r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.remote.model.AppInfoResultEntity.<init>(java.util.List, java.util.List, java.lang.Integer, java.util.List, com.talabat.configuration.remote.model.NewAppVersionEntity, java.lang.Boolean, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
