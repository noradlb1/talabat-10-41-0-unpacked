package com.talabat.searchdiscovery.features.vendorslist.models.responses;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "", "ads", "", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "countryId", "", "language", "", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)V", "getAds", "()Ljava/util/List;", "getCountryId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLanguage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;)Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdsResponse {
    @SerializedName("ads")
    @Nullable
    private final List<Ad> ads;
    @SerializedName("countryId")
    @Nullable
    private final Integer countryId;
    @SerializedName("language")
    @Nullable
    private final String language;

    public InlineAdsResponse(@Nullable List<Ad> list, @Nullable Integer num, @Nullable String str) {
        this.ads = list;
        this.countryId = num;
        this.language = str;
    }

    public static /* synthetic */ InlineAdsResponse copy$default(InlineAdsResponse inlineAdsResponse, List<Ad> list, Integer num, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = inlineAdsResponse.ads;
        }
        if ((i11 & 2) != 0) {
            num = inlineAdsResponse.countryId;
        }
        if ((i11 & 4) != 0) {
            str = inlineAdsResponse.language;
        }
        return inlineAdsResponse.copy(list, num, str);
    }

    @Nullable
    public final List<Ad> component1() {
        return this.ads;
    }

    @Nullable
    public final Integer component2() {
        return this.countryId;
    }

    @Nullable
    public final String component3() {
        return this.language;
    }

    @NotNull
    public final InlineAdsResponse copy(@Nullable List<Ad> list, @Nullable Integer num, @Nullable String str) {
        return new InlineAdsResponse(list, num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InlineAdsResponse)) {
            return false;
        }
        InlineAdsResponse inlineAdsResponse = (InlineAdsResponse) obj;
        return Intrinsics.areEqual((Object) this.ads, (Object) inlineAdsResponse.ads) && Intrinsics.areEqual((Object) this.countryId, (Object) inlineAdsResponse.countryId) && Intrinsics.areEqual((Object) this.language, (Object) inlineAdsResponse.language);
    }

    @Nullable
    public final List<Ad> getAds() {
        return this.ads;
    }

    @Nullable
    public final Integer getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        List<Ad> list = this.ads;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.countryId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.language;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        List<Ad> list = this.ads;
        Integer num = this.countryId;
        String str = this.language;
        return "InlineAdsResponse(ads=" + list + ", countryId=" + num + ", language=" + str + ")";
    }
}
