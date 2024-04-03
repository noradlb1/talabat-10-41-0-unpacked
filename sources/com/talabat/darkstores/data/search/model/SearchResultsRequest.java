package com.talabat.darkstores.data.search.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\b\u0018\u00002\u00020\u0001:\u000289B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0001\u00102\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u000fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "", "brand", "", "config", "countryCode", "isDarkstore", "", "languageCode", "vendors", "", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Vendor;", "filters", "Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;", "limit", "", "offset", "query", "customerId", "talabatBranchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getConfig", "getCountryCode", "getCustomerId", "getFilters", "()Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;", "()Z", "getLanguageCode", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getQuery", "getTalabatBranchId", "getVendors", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/darkstores/data/search/model/SearchResultsRequest;", "equals", "other", "hashCode", "toString", "Filters", "Vendor", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsRequest {
    @NotNull
    private final String brand;
    @NotNull
    private final String config;
    @NotNull
    private final String countryCode;
    @NotNull
    private final String customerId;
    @Nullable
    private final Filters filters;
    private final boolean isDarkstore;
    @NotNull
    private final String languageCode;
    @Nullable
    private final Integer limit;
    @Nullable
    private final Integer offset;
    @Nullable
    private final String query;
    @Nullable
    private final String talabatBranchId;
    @NotNull
    private final List<Vendor> vendors;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Vendor;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Vendor {
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f56217id;

        public Vendor(@NotNull @Json(name = "id") String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.f56217id = str;
        }

        public static /* synthetic */ Vendor copy$default(Vendor vendor, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = vendor.f56217id;
            }
            return vendor.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.f56217id;
        }

        @NotNull
        public final Vendor copy(@NotNull @Json(name = "id") String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Vendor(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Vendor) && Intrinsics.areEqual((Object) this.f56217id, (Object) ((Vendor) obj).f56217id);
        }

        @NotNull
        public final String getId() {
            return this.f56217id;
        }

        public int hashCode() {
            return this.f56217id.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f56217id;
            return "Vendor(id=" + str + ")";
        }
    }

    public SearchResultsRequest(@NotNull @Json(name = "brand") String str, @NotNull @Json(name = "config") String str2, @NotNull @Json(name = "country_code") String str3, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "language_code") String str4, @NotNull @Json(name = "vendors") List<Vendor> list, @Nullable @Json(name = "filters") Filters filters2, @Nullable @Json(name = "limit") Integer num, @Nullable @Json(name = "offset") Integer num2, @Nullable @Json(name = "query") String str5, @NotNull @Json(name = "customer_id") String str6, @Nullable @Json(name = "talabatBranchId") String str7) {
        Intrinsics.checkNotNullParameter(str, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(str6, "customerId");
        this.brand = str;
        this.config = str2;
        this.countryCode = str3;
        this.isDarkstore = z11;
        this.languageCode = str4;
        this.vendors = list;
        this.filters = filters2;
        this.limit = num;
        this.offset = num2;
        this.query = str5;
        this.customerId = str6;
        this.talabatBranchId = str7;
    }

    public static /* synthetic */ SearchResultsRequest copy$default(SearchResultsRequest searchResultsRequest, String str, String str2, String str3, boolean z11, String str4, List list, Filters filters2, Integer num, Integer num2, String str5, String str6, String str7, int i11, Object obj) {
        SearchResultsRequest searchResultsRequest2 = searchResultsRequest;
        int i12 = i11;
        return searchResultsRequest.copy((i12 & 1) != 0 ? searchResultsRequest2.brand : str, (i12 & 2) != 0 ? searchResultsRequest2.config : str2, (i12 & 4) != 0 ? searchResultsRequest2.countryCode : str3, (i12 & 8) != 0 ? searchResultsRequest2.isDarkstore : z11, (i12 & 16) != 0 ? searchResultsRequest2.languageCode : str4, (i12 & 32) != 0 ? searchResultsRequest2.vendors : list, (i12 & 64) != 0 ? searchResultsRequest2.filters : filters2, (i12 & 128) != 0 ? searchResultsRequest2.limit : num, (i12 & 256) != 0 ? searchResultsRequest2.offset : num2, (i12 & 512) != 0 ? searchResultsRequest2.query : str5, (i12 & 1024) != 0 ? searchResultsRequest2.customerId : str6, (i12 & 2048) != 0 ? searchResultsRequest2.talabatBranchId : str7);
    }

    @NotNull
    public final String component1() {
        return this.brand;
    }

    @Nullable
    public final String component10() {
        return this.query;
    }

    @NotNull
    public final String component11() {
        return this.customerId;
    }

    @Nullable
    public final String component12() {
        return this.talabatBranchId;
    }

    @NotNull
    public final String component2() {
        return this.config;
    }

    @NotNull
    public final String component3() {
        return this.countryCode;
    }

    public final boolean component4() {
        return this.isDarkstore;
    }

    @NotNull
    public final String component5() {
        return this.languageCode;
    }

    @NotNull
    public final List<Vendor> component6() {
        return this.vendors;
    }

    @Nullable
    public final Filters component7() {
        return this.filters;
    }

    @Nullable
    public final Integer component8() {
        return this.limit;
    }

    @Nullable
    public final Integer component9() {
        return this.offset;
    }

    @NotNull
    public final SearchResultsRequest copy(@NotNull @Json(name = "brand") String str, @NotNull @Json(name = "config") String str2, @NotNull @Json(name = "country_code") String str3, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "language_code") String str4, @NotNull @Json(name = "vendors") List<Vendor> list, @Nullable @Json(name = "filters") Filters filters2, @Nullable @Json(name = "limit") Integer num, @Nullable @Json(name = "offset") Integer num2, @Nullable @Json(name = "query") String str5, @NotNull @Json(name = "customer_id") String str6, @Nullable @Json(name = "talabatBranchId") String str7) {
        Intrinsics.checkNotNullParameter(str, ScreenNames.SCREEN_TYPE_BRAND);
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "countryCode");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        List<Vendor> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "vendors");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "customerId");
        return new SearchResultsRequest(str, str8, str9, z11, str10, list2, filters2, num, num2, str5, str11, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultsRequest)) {
            return false;
        }
        SearchResultsRequest searchResultsRequest = (SearchResultsRequest) obj;
        return Intrinsics.areEqual((Object) this.brand, (Object) searchResultsRequest.brand) && Intrinsics.areEqual((Object) this.config, (Object) searchResultsRequest.config) && Intrinsics.areEqual((Object) this.countryCode, (Object) searchResultsRequest.countryCode) && this.isDarkstore == searchResultsRequest.isDarkstore && Intrinsics.areEqual((Object) this.languageCode, (Object) searchResultsRequest.languageCode) && Intrinsics.areEqual((Object) this.vendors, (Object) searchResultsRequest.vendors) && Intrinsics.areEqual((Object) this.filters, (Object) searchResultsRequest.filters) && Intrinsics.areEqual((Object) this.limit, (Object) searchResultsRequest.limit) && Intrinsics.areEqual((Object) this.offset, (Object) searchResultsRequest.offset) && Intrinsics.areEqual((Object) this.query, (Object) searchResultsRequest.query) && Intrinsics.areEqual((Object) this.customerId, (Object) searchResultsRequest.customerId) && Intrinsics.areEqual((Object) this.talabatBranchId, (Object) searchResultsRequest.talabatBranchId);
    }

    @NotNull
    public final String getBrand() {
        return this.brand;
    }

    @NotNull
    public final String getConfig() {
        return this.config;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final Filters getFilters() {
        return this.filters;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final String getTalabatBranchId() {
        return this.talabatBranchId;
    }

    @NotNull
    public final List<Vendor> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        int hashCode = ((((this.brand.hashCode() * 31) + this.config.hashCode()) * 31) + this.countryCode.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((hashCode + (z11 ? 1 : 0)) * 31) + this.languageCode.hashCode()) * 31) + this.vendors.hashCode()) * 31;
        Filters filters2 = this.filters;
        int i11 = 0;
        int hashCode3 = (hashCode2 + (filters2 == null ? 0 : filters2.hashCode())) * 31;
        Integer num = this.limit;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.offset;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.query;
        int hashCode6 = (((hashCode5 + (str == null ? 0 : str.hashCode())) * 31) + this.customerId.hashCode()) * 31;
        String str2 = this.talabatBranchId;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode6 + i11;
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.brand;
        String str2 = this.config;
        String str3 = this.countryCode;
        boolean z11 = this.isDarkstore;
        String str4 = this.languageCode;
        List<Vendor> list = this.vendors;
        Filters filters2 = this.filters;
        Integer num = this.limit;
        Integer num2 = this.offset;
        String str5 = this.query;
        String str6 = this.customerId;
        String str7 = this.talabatBranchId;
        return "SearchResultsRequest(brand=" + str + ", config=" + str2 + ", countryCode=" + str3 + ", isDarkstore=" + z11 + ", languageCode=" + str4 + ", vendors=" + list + ", filters=" + filters2 + ", limit=" + num + ", offset=" + num2 + ", query=" + str5 + ", customerId=" + str6 + ", talabatBranchId=" + str7 + ")";
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchResultsRequest$Filters;", "", "categoryIds", "", "", "variant", "", "(Ljava/util/List;I)V", "getCategoryIds", "()Ljava/util/List;", "getVariant", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Filters {
        @Nullable
        private final List<String> categoryIds;
        private final int variant;

        public Filters(@Nullable @Json(name = "category_ids") List<String> list, @Json(name = "variant") int i11) {
            this.categoryIds = list;
            this.variant = i11;
        }

        public static /* synthetic */ Filters copy$default(Filters filters, List<String> list, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                list = filters.categoryIds;
            }
            if ((i12 & 2) != 0) {
                i11 = filters.variant;
            }
            return filters.copy(list, i11);
        }

        @Nullable
        public final List<String> component1() {
            return this.categoryIds;
        }

        public final int component2() {
            return this.variant;
        }

        @NotNull
        public final Filters copy(@Nullable @Json(name = "category_ids") List<String> list, @Json(name = "variant") int i11) {
            return new Filters(list, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Filters)) {
                return false;
            }
            Filters filters = (Filters) obj;
            return Intrinsics.areEqual((Object) this.categoryIds, (Object) filters.categoryIds) && this.variant == filters.variant;
        }

        @Nullable
        public final List<String> getCategoryIds() {
            return this.categoryIds;
        }

        public final int getVariant() {
            return this.variant;
        }

        public int hashCode() {
            List<String> list = this.categoryIds;
            return ((list == null ? 0 : list.hashCode()) * 31) + this.variant;
        }

        @NotNull
        public String toString() {
            List<String> list = this.categoryIds;
            int i11 = this.variant;
            return "Filters(categoryIds=" + list + ", variant=" + i11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Filters(List list, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? null : list, i11);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SearchResultsRequest(java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, java.lang.String r20, java.util.List r21, com.talabat.darkstores.data.search.model.SearchResultsRequest.Filters r22, java.lang.Integer r23, java.lang.Integer r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r8 = r1
            goto L_0x000e
        L_0x000c:
            r8 = r21
        L_0x000e:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r9 = r2
            goto L_0x0017
        L_0x0015:
            r9 = r22
        L_0x0017:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001d
            r10 = r2
            goto L_0x001f
        L_0x001d:
            r10 = r23
        L_0x001f:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0025
            r11 = r2
            goto L_0x0027
        L_0x0025:
            r11 = r24
        L_0x0027:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x002d
            r12 = r2
            goto L_0x002f
        L_0x002d:
            r12 = r25
        L_0x002f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0035
            r14 = r2
            goto L_0x0037
        L_0x0035:
            r14 = r27
        L_0x0037:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r13 = r26
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.data.search.model.SearchResultsRequest.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.util.List, com.talabat.darkstores.data.search.model.SearchResultsRequest$Filters, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
