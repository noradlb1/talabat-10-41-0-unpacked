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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001$BS\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JW\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest;", "", "config", "", "query", "vendors", "", "Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest$Vendor;", "countryCode", "brand", "isDarkstore", "", "languageCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getConfig", "getCountryCode", "()Z", "getLanguageCode", "getQuery", "getVendors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Vendor", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchCategoryRequest {
    @NotNull
    private final String brand;
    @NotNull
    private final String config;
    @NotNull
    private final String countryCode;
    private final boolean isDarkstore;
    @NotNull
    private final String languageCode;
    @Nullable
    private final String query;
    @NotNull
    private final List<Vendor> vendors;

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/data/search/model/SearchCategoryRequest$Vendor;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Vendor {
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f56216id;

        public Vendor(@NotNull @Json(name = "id") String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.f56216id = str;
        }

        public static /* synthetic */ Vendor copy$default(Vendor vendor, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = vendor.f56216id;
            }
            return vendor.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.f56216id;
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
            return (obj instanceof Vendor) && Intrinsics.areEqual((Object) this.f56216id, (Object) ((Vendor) obj).f56216id);
        }

        @NotNull
        public final String getId() {
            return this.f56216id;
        }

        public int hashCode() {
            return this.f56216id.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f56216id;
            return "Vendor(id=" + str + ")";
        }
    }

    public SearchCategoryRequest(@NotNull @Json(name = "config") String str, @Nullable @Json(name = "query") String str2, @NotNull @Json(name = "vendors") List<Vendor> list, @NotNull @Json(name = "country_code") String str3, @NotNull @Json(name = "brand") String str4, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "language_code") String str5) {
        Intrinsics.checkNotNullParameter(str, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, ScreenNames.SCREEN_TYPE_BRAND);
        Intrinsics.checkNotNullParameter(str5, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.config = str;
        this.query = str2;
        this.vendors = list;
        this.countryCode = str3;
        this.brand = str4;
        this.isDarkstore = z11;
        this.languageCode = str5;
    }

    public static /* synthetic */ SearchCategoryRequest copy$default(SearchCategoryRequest searchCategoryRequest, String str, String str2, List<Vendor> list, String str3, String str4, boolean z11, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = searchCategoryRequest.config;
        }
        if ((i11 & 2) != 0) {
            str2 = searchCategoryRequest.query;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            list = searchCategoryRequest.vendors;
        }
        List<Vendor> list2 = list;
        if ((i11 & 8) != 0) {
            str3 = searchCategoryRequest.countryCode;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = searchCategoryRequest.brand;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            z11 = searchCategoryRequest.isDarkstore;
        }
        boolean z12 = z11;
        if ((i11 & 64) != 0) {
            str5 = searchCategoryRequest.languageCode;
        }
        return searchCategoryRequest.copy(str, str6, list2, str7, str8, z12, str5);
    }

    @NotNull
    public final String component1() {
        return this.config;
    }

    @Nullable
    public final String component2() {
        return this.query;
    }

    @NotNull
    public final List<Vendor> component3() {
        return this.vendors;
    }

    @NotNull
    public final String component4() {
        return this.countryCode;
    }

    @NotNull
    public final String component5() {
        return this.brand;
    }

    public final boolean component6() {
        return this.isDarkstore;
    }

    @NotNull
    public final String component7() {
        return this.languageCode;
    }

    @NotNull
    public final SearchCategoryRequest copy(@NotNull @Json(name = "config") String str, @Nullable @Json(name = "query") String str2, @NotNull @Json(name = "vendors") List<Vendor> list, @NotNull @Json(name = "country_code") String str3, @NotNull @Json(name = "brand") String str4, @Json(name = "is_darkstore") boolean z11, @NotNull @Json(name = "language_code") String str5) {
        Intrinsics.checkNotNullParameter(str, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(list, "vendors");
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        Intrinsics.checkNotNullParameter(str4, ScreenNames.SCREEN_TYPE_BRAND);
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        return new SearchCategoryRequest(str, str2, list, str3, str4, z11, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchCategoryRequest)) {
            return false;
        }
        SearchCategoryRequest searchCategoryRequest = (SearchCategoryRequest) obj;
        return Intrinsics.areEqual((Object) this.config, (Object) searchCategoryRequest.config) && Intrinsics.areEqual((Object) this.query, (Object) searchCategoryRequest.query) && Intrinsics.areEqual((Object) this.vendors, (Object) searchCategoryRequest.vendors) && Intrinsics.areEqual((Object) this.countryCode, (Object) searchCategoryRequest.countryCode) && Intrinsics.areEqual((Object) this.brand, (Object) searchCategoryRequest.brand) && this.isDarkstore == searchCategoryRequest.isDarkstore && Intrinsics.areEqual((Object) this.languageCode, (Object) searchCategoryRequest.languageCode);
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
    public final String getLanguageCode() {
        return this.languageCode;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @NotNull
    public final List<Vendor> getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        int hashCode = this.config.hashCode() * 31;
        String str = this.query;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.vendors.hashCode()) * 31) + this.countryCode.hashCode()) * 31) + this.brand.hashCode()) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((hashCode2 + (z11 ? 1 : 0)) * 31) + this.languageCode.hashCode();
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.config;
        String str2 = this.query;
        List<Vendor> list = this.vendors;
        String str3 = this.countryCode;
        String str4 = this.brand;
        boolean z11 = this.isDarkstore;
        String str5 = this.languageCode;
        return "SearchCategoryRequest(config=" + str + ", query=" + str2 + ", vendors=" + list + ", countryCode=" + str3 + ", brand=" + str4 + ", isDarkstore=" + z11 + ", languageCode=" + str5 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchCategoryRequest(String str, String str2, List list, String str3, String str4, boolean z11, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, str3, str4, z11, str5);
    }
}
