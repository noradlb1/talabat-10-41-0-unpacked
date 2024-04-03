package com.talabat.sdsquad.data.vendorslist.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bc\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001bJz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u000f\u0010\u001b¨\u0006,"}, d2 = {"Lcom/talabat/sdsquad/data/vendorslist/response/Result;", "", "city", "Lcom/talabat/sdsquad/data/vendorslist/response/City;", "collections", "", "Lcom/talabat/sdsquad/data/vendorslist/response/Collections;", "country", "Lcom/talabat/sdsquad/data/vendorslist/response/Country;", "cuisines", "Lcom/talabat/sdsquad/data/vendorslist/response/Cuisine;", "filters", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "gemTiers", "Lcom/talabat/sdsquad/data/vendorslist/response/GemTier;", "isGemArea", "", "(Lcom/talabat/sdsquad/data/vendorslist/response/City;Ljava/util/List;Lcom/talabat/sdsquad/data/vendorslist/response/Country;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)V", "getCity", "()Lcom/talabat/sdsquad/data/vendorslist/response/City;", "getCollections", "()Ljava/util/List;", "getCountry", "()Lcom/talabat/sdsquad/data/vendorslist/response/Country;", "getCuisines", "getFilters", "getGemTiers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/talabat/sdsquad/data/vendorslist/response/City;Ljava/util/List;Lcom/talabat/sdsquad/data/vendorslist/response/Country;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;)Lcom/talabat/sdsquad/data/vendorslist/response/Result;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @SerializedName("city")
    @Nullable
    private final City city;
    @SerializedName("collections")
    @Nullable
    private final List<Collections> collections;
    @SerializedName("country")
    @Nullable
    private final Country country;
    @SerializedName("cuisines")
    @Nullable
    private final List<Cuisine> cuisines;
    @SerializedName("filters")
    @Nullable
    private final List<Filter> filters;
    @SerializedName("gemTiers")
    @Nullable
    private final List<GemTier> gemTiers;
    @SerializedName("isGemArea")
    @Nullable
    private final Boolean isGemArea;

    public Result(@Nullable City city2, @Nullable List<Collections> list, @Nullable Country country2, @Nullable List<Cuisine> list2, @Nullable List<Filter> list3, @Nullable List<GemTier> list4, @Nullable Boolean bool) {
        this.city = city2;
        this.collections = list;
        this.country = country2;
        this.cuisines = list2;
        this.filters = list3;
        this.gemTiers = list4;
        this.isGemArea = bool;
    }

    public static /* synthetic */ Result copy$default(Result result, City city2, List<Collections> list, Country country2, List<Cuisine> list2, List<Filter> list3, List<GemTier> list4, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            city2 = result.city;
        }
        if ((i11 & 2) != 0) {
            list = result.collections;
        }
        List<Collections> list5 = list;
        if ((i11 & 4) != 0) {
            country2 = result.country;
        }
        Country country3 = country2;
        if ((i11 & 8) != 0) {
            list2 = result.cuisines;
        }
        List<Cuisine> list6 = list2;
        if ((i11 & 16) != 0) {
            list3 = result.filters;
        }
        List<Filter> list7 = list3;
        if ((i11 & 32) != 0) {
            list4 = result.gemTiers;
        }
        List<GemTier> list8 = list4;
        if ((i11 & 64) != 0) {
            bool = result.isGemArea;
        }
        return result.copy(city2, list5, country3, list6, list7, list8, bool);
    }

    @Nullable
    public final City component1() {
        return this.city;
    }

    @Nullable
    public final List<Collections> component2() {
        return this.collections;
    }

    @Nullable
    public final Country component3() {
        return this.country;
    }

    @Nullable
    public final List<Cuisine> component4() {
        return this.cuisines;
    }

    @Nullable
    public final List<Filter> component5() {
        return this.filters;
    }

    @Nullable
    public final List<GemTier> component6() {
        return this.gemTiers;
    }

    @Nullable
    public final Boolean component7() {
        return this.isGemArea;
    }

    @NotNull
    public final Result copy(@Nullable City city2, @Nullable List<Collections> list, @Nullable Country country2, @Nullable List<Cuisine> list2, @Nullable List<Filter> list3, @Nullable List<GemTier> list4, @Nullable Boolean bool) {
        return new Result(city2, list, country2, list2, list3, list4, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Intrinsics.areEqual((Object) this.city, (Object) result.city) && Intrinsics.areEqual((Object) this.collections, (Object) result.collections) && Intrinsics.areEqual((Object) this.country, (Object) result.country) && Intrinsics.areEqual((Object) this.cuisines, (Object) result.cuisines) && Intrinsics.areEqual((Object) this.filters, (Object) result.filters) && Intrinsics.areEqual((Object) this.gemTiers, (Object) result.gemTiers) && Intrinsics.areEqual((Object) this.isGemArea, (Object) result.isGemArea);
    }

    @Nullable
    public final City getCity() {
        return this.city;
    }

    @Nullable
    public final List<Collections> getCollections() {
        return this.collections;
    }

    @Nullable
    public final Country getCountry() {
        return this.country;
    }

    @Nullable
    public final List<Cuisine> getCuisines() {
        return this.cuisines;
    }

    @Nullable
    public final List<Filter> getFilters() {
        return this.filters;
    }

    @Nullable
    public final List<GemTier> getGemTiers() {
        return this.gemTiers;
    }

    public int hashCode() {
        City city2 = this.city;
        int i11 = 0;
        int hashCode = (city2 == null ? 0 : city2.hashCode()) * 31;
        List<Collections> list = this.collections;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Country country2 = this.country;
        int hashCode3 = (hashCode2 + (country2 == null ? 0 : country2.hashCode())) * 31;
        List<Cuisine> list2 = this.cuisines;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Filter> list3 = this.filters;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<GemTier> list4 = this.gemTiers;
        int hashCode6 = (hashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Boolean bool = this.isGemArea;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode6 + i11;
    }

    @Nullable
    public final Boolean isGemArea() {
        return this.isGemArea;
    }

    @NotNull
    public String toString() {
        City city2 = this.city;
        List<Collections> list = this.collections;
        Country country2 = this.country;
        List<Cuisine> list2 = this.cuisines;
        List<Filter> list3 = this.filters;
        List<GemTier> list4 = this.gemTiers;
        Boolean bool = this.isGemArea;
        return "Result(city=" + city2 + ", collections=" + list + ", country=" + country2 + ", cuisines=" + list2 + ", filters=" + list3 + ", gemTiers=" + list4 + ", isGemArea=" + bool + ")";
    }
}
