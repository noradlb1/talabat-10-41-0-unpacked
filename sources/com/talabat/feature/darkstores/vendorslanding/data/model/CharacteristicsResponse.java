package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;", "", "ageLimit", "", "freshnessGuaranteeInDays", "pieceBarcodes", "vatRate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgeLimit", "()Ljava/lang/String;", "getFreshnessGuaranteeInDays", "getPieceBarcodes", "getVatRate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CharacteristicsResponse {
    @Nullable
    private final String ageLimit;
    @Nullable
    private final String freshnessGuaranteeInDays;
    @Nullable
    private final String pieceBarcodes;
    @Nullable
    private final String vatRate;

    public CharacteristicsResponse() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public CharacteristicsResponse(@Nullable @Json(name = "ageLimit") String str, @Nullable @Json(name = "freshnessGuaranteeInDays") String str2, @Nullable @Json(name = "pieceBarcodes") String str3, @Nullable @Json(name = "vatRate") String str4) {
        this.ageLimit = str;
        this.freshnessGuaranteeInDays = str2;
        this.pieceBarcodes = str3;
        this.vatRate = str4;
    }

    public static /* synthetic */ CharacteristicsResponse copy$default(CharacteristicsResponse characteristicsResponse, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = characteristicsResponse.ageLimit;
        }
        if ((i11 & 2) != 0) {
            str2 = characteristicsResponse.freshnessGuaranteeInDays;
        }
        if ((i11 & 4) != 0) {
            str3 = characteristicsResponse.pieceBarcodes;
        }
        if ((i11 & 8) != 0) {
            str4 = characteristicsResponse.vatRate;
        }
        return characteristicsResponse.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.ageLimit;
    }

    @Nullable
    public final String component2() {
        return this.freshnessGuaranteeInDays;
    }

    @Nullable
    public final String component3() {
        return this.pieceBarcodes;
    }

    @Nullable
    public final String component4() {
        return this.vatRate;
    }

    @NotNull
    public final CharacteristicsResponse copy(@Nullable @Json(name = "ageLimit") String str, @Nullable @Json(name = "freshnessGuaranteeInDays") String str2, @Nullable @Json(name = "pieceBarcodes") String str3, @Nullable @Json(name = "vatRate") String str4) {
        return new CharacteristicsResponse(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharacteristicsResponse)) {
            return false;
        }
        CharacteristicsResponse characteristicsResponse = (CharacteristicsResponse) obj;
        return Intrinsics.areEqual((Object) this.ageLimit, (Object) characteristicsResponse.ageLimit) && Intrinsics.areEqual((Object) this.freshnessGuaranteeInDays, (Object) characteristicsResponse.freshnessGuaranteeInDays) && Intrinsics.areEqual((Object) this.pieceBarcodes, (Object) characteristicsResponse.pieceBarcodes) && Intrinsics.areEqual((Object) this.vatRate, (Object) characteristicsResponse.vatRate);
    }

    @Nullable
    public final String getAgeLimit() {
        return this.ageLimit;
    }

    @Nullable
    public final String getFreshnessGuaranteeInDays() {
        return this.freshnessGuaranteeInDays;
    }

    @Nullable
    public final String getPieceBarcodes() {
        return this.pieceBarcodes;
    }

    @Nullable
    public final String getVatRate() {
        return this.vatRate;
    }

    public int hashCode() {
        String str = this.ageLimit;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.freshnessGuaranteeInDays;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pieceBarcodes;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.vatRate;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.ageLimit;
        String str2 = this.freshnessGuaranteeInDays;
        String str3 = this.pieceBarcodes;
        String str4 = this.vatRate;
        return "CharacteristicsResponse(ageLimit=" + str + ", freshnessGuaranteeInDays=" + str2 + ", pieceBarcodes=" + str3 + ", vatRate=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CharacteristicsResponse(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
