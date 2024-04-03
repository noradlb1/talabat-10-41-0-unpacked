package com.talabat.feature.ridertips.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/ridertips/data/remote/dto/RiderTipDto;", "", "title", "", "subtitle", "tip", "Lcom/talabat/feature/ridertips/data/remote/dto/TipDto;", "terms", "Lcom/talabat/feature/ridertips/data/remote/dto/TermsDto;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/ridertips/data/remote/dto/TipDto;Lcom/talabat/feature/ridertips/data/remote/dto/TermsDto;)V", "getSubtitle", "()Ljava/lang/String;", "getTerms", "()Lcom/talabat/feature/ridertips/data/remote/dto/TermsDto;", "getTip", "()Lcom/talabat/feature/ridertips/data/remote/dto/TipDto;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipDto {
    @Nullable
    private final String subtitle;
    @Nullable
    private final TermsDto terms;
    @Nullable
    private final TipDto tip;
    @Nullable
    private final String title;

    public RiderTipDto(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "sub_title") String str2, @Nullable @Json(name = "tip") TipDto tipDto, @Nullable @Json(name = "terms_conditions") TermsDto termsDto) {
        this.title = str;
        this.subtitle = str2;
        this.tip = tipDto;
        this.terms = termsDto;
    }

    public static /* synthetic */ RiderTipDto copy$default(RiderTipDto riderTipDto, String str, String str2, TipDto tipDto, TermsDto termsDto, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = riderTipDto.title;
        }
        if ((i11 & 2) != 0) {
            str2 = riderTipDto.subtitle;
        }
        if ((i11 & 4) != 0) {
            tipDto = riderTipDto.tip;
        }
        if ((i11 & 8) != 0) {
            termsDto = riderTipDto.terms;
        }
        return riderTipDto.copy(str, str2, tipDto, termsDto);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    @Nullable
    public final TipDto component3() {
        return this.tip;
    }

    @Nullable
    public final TermsDto component4() {
        return this.terms;
    }

    @NotNull
    public final RiderTipDto copy(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "sub_title") String str2, @Nullable @Json(name = "tip") TipDto tipDto, @Nullable @Json(name = "terms_conditions") TermsDto termsDto) {
        return new RiderTipDto(str, str2, tipDto, termsDto);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderTipDto)) {
            return false;
        }
        RiderTipDto riderTipDto = (RiderTipDto) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) riderTipDto.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) riderTipDto.subtitle) && Intrinsics.areEqual((Object) this.tip, (Object) riderTipDto.tip) && Intrinsics.areEqual((Object) this.terms, (Object) riderTipDto.terms);
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final TermsDto getTerms() {
        return this.terms;
    }

    @Nullable
    public final TipDto getTip() {
        return this.tip;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        TipDto tipDto = this.tip;
        int hashCode3 = (hashCode2 + (tipDto == null ? 0 : tipDto.hashCode())) * 31;
        TermsDto termsDto = this.terms;
        if (termsDto != null) {
            i11 = termsDto.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        TipDto tipDto = this.tip;
        TermsDto termsDto = this.terms;
        return "RiderTipDto(title=" + str + ", subtitle=" + str2 + ", tip=" + tipDto + ", terms=" + termsDto + ")";
    }
}
