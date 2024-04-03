package com.talabat.fluid.homescreen.data.remote.component;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "", "data", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Data;", "(Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Data;)V", "getData", "()Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Component", "Configurations", "Data", "Item", "Metadata", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContentApiResponse {
    @SerializedName("data")
    @Nullable
    private final Data data;

    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Configurations;", "", "navigationBarColor", "", "locationHintColor", "locationTitleColor", "locationArrowTintColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocationArrowTintColor", "()Ljava/lang/String;", "getLocationHintColor", "getLocationTitleColor", "getNavigationBarColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Configurations {
        @SerializedName("locationArrowTintColor")
        @NotNull
        private final String locationArrowTintColor;
        @SerializedName("locationHintColor")
        @NotNull
        private final String locationHintColor;
        @SerializedName("locationTitleColor")
        @NotNull
        private final String locationTitleColor;
        @SerializedName("navigationBarColor")
        @NotNull
        private final String navigationBarColor;

        public Configurations(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "navigationBarColor");
            Intrinsics.checkNotNullParameter(str2, "locationHintColor");
            Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
            Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
            this.navigationBarColor = str;
            this.locationHintColor = str2;
            this.locationTitleColor = str3;
            this.locationArrowTintColor = str4;
        }

        public static /* synthetic */ Configurations copy$default(Configurations configurations, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = configurations.navigationBarColor;
            }
            if ((i11 & 2) != 0) {
                str2 = configurations.locationHintColor;
            }
            if ((i11 & 4) != 0) {
                str3 = configurations.locationTitleColor;
            }
            if ((i11 & 8) != 0) {
                str4 = configurations.locationArrowTintColor;
            }
            return configurations.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return this.navigationBarColor;
        }

        @NotNull
        public final String component2() {
            return this.locationHintColor;
        }

        @NotNull
        public final String component3() {
            return this.locationTitleColor;
        }

        @NotNull
        public final String component4() {
            return this.locationArrowTintColor;
        }

        @NotNull
        public final Configurations copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "navigationBarColor");
            Intrinsics.checkNotNullParameter(str2, "locationHintColor");
            Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
            Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
            return new Configurations(str, str2, str3, str4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configurations)) {
                return false;
            }
            Configurations configurations = (Configurations) obj;
            return Intrinsics.areEqual((Object) this.navigationBarColor, (Object) configurations.navigationBarColor) && Intrinsics.areEqual((Object) this.locationHintColor, (Object) configurations.locationHintColor) && Intrinsics.areEqual((Object) this.locationTitleColor, (Object) configurations.locationTitleColor) && Intrinsics.areEqual((Object) this.locationArrowTintColor, (Object) configurations.locationArrowTintColor);
        }

        @NotNull
        public final String getLocationArrowTintColor() {
            return this.locationArrowTintColor;
        }

        @NotNull
        public final String getLocationHintColor() {
            return this.locationHintColor;
        }

        @NotNull
        public final String getLocationTitleColor() {
            return this.locationTitleColor;
        }

        @NotNull
        public final String getNavigationBarColor() {
            return this.navigationBarColor;
        }

        public int hashCode() {
            return (((((this.navigationBarColor.hashCode() * 31) + this.locationHintColor.hashCode()) * 31) + this.locationTitleColor.hashCode()) * 31) + this.locationArrowTintColor.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.navigationBarColor;
            String str2 = this.locationHintColor;
            String str3 = this.locationTitleColor;
            String str4 = this.locationArrowTintColor;
            return "Configurations(navigationBarColor=" + str + ", locationHintColor=" + str2 + ", locationTitleColor=" + str3 + ", locationArrowTintColor=" + str4 + ")";
        }
    }

    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0003j\u0002`\u0005\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0014\u001a\u00060\u0003j\u0002`\u0005HÆ\u0003J\r\u0010\u0015\u001a\u00060\u0003j\u0002`\u0007HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J_\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0003j\u0002`\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0003j\u0002`\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0006\u001a\u00060\u0003j\u0002`\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0004\u001a\u00060\u0003j\u0002`\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Item;", "", "id", "", "templateId", "Lcom/deliveryhero/fluid/template/TemplateId;", "templateHash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "properties", "", "metadata", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getProperties", "getTemplateHash", "getTemplateId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Item {
        @SerializedName("id")
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f59697id;
        @SerializedName("metadata")
        @Nullable
        private final Map<String, String> metadata;
        @SerializedName("properties")
        @Nullable
        private final Map<String, String> properties;
        @SerializedName("template_hash")
        @NotNull
        private final String templateHash;
        @SerializedName("template_id")
        @NotNull
        private final String templateId;

        public Item(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "templateId");
            Intrinsics.checkNotNullParameter(str3, "templateHash");
            this.f59697id = str;
            this.templateId = str2;
            this.templateHash = str3;
            this.properties = map;
            this.metadata = map2;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, Map<String, String> map, Map<String, String> map2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = item.f59697id;
            }
            if ((i11 & 2) != 0) {
                str2 = item.templateId;
            }
            String str4 = str2;
            if ((i11 & 4) != 0) {
                str3 = item.templateHash;
            }
            String str5 = str3;
            if ((i11 & 8) != 0) {
                map = item.properties;
            }
            Map<String, String> map3 = map;
            if ((i11 & 16) != 0) {
                map2 = item.metadata;
            }
            return item.copy(str, str4, str5, map3, map2);
        }

        @NotNull
        public final String component1() {
            return this.f59697id;
        }

        @NotNull
        public final String component2() {
            return this.templateId;
        }

        @NotNull
        public final String component3() {
            return this.templateHash;
        }

        @Nullable
        public final Map<String, String> component4() {
            return this.properties;
        }

        @Nullable
        public final Map<String, String> component5() {
            return this.metadata;
        }

        @NotNull
        public final Item copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "templateId");
            Intrinsics.checkNotNullParameter(str3, "templateHash");
            return new Item(str, str2, str3, map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual((Object) this.f59697id, (Object) item.f59697id) && Intrinsics.areEqual((Object) this.templateId, (Object) item.templateId) && Intrinsics.areEqual((Object) this.templateHash, (Object) item.templateHash) && Intrinsics.areEqual((Object) this.properties, (Object) item.properties) && Intrinsics.areEqual((Object) this.metadata, (Object) item.metadata);
        }

        @NotNull
        public final String getId() {
            return this.f59697id;
        }

        @Nullable
        public final Map<String, String> getMetadata() {
            return this.metadata;
        }

        @Nullable
        public final Map<String, String> getProperties() {
            return this.properties;
        }

        @NotNull
        public final String getTemplateHash() {
            return this.templateHash;
        }

        @NotNull
        public final String getTemplateId() {
            return this.templateId;
        }

        public int hashCode() {
            int hashCode = ((((this.f59697id.hashCode() * 31) + this.templateId.hashCode()) * 31) + this.templateHash.hashCode()) * 31;
            Map<String, String> map = this.properties;
            int i11 = 0;
            int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
            Map<String, String> map2 = this.metadata;
            if (map2 != null) {
                i11 = map2.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.f59697id;
            String str2 = this.templateId;
            String str3 = this.templateHash;
            Map<String, String> map = this.properties;
            Map<String, String> map2 = this.metadata;
            return "Item(id=" + str + ", templateId=" + str2 + ", templateHash=" + str3 + ", properties=" + map + ", metadata=" + map2 + ")";
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Metadata;", "", "clearVoucherCache", "", "(Z)V", "getClearVoucherCache", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Metadata {
        @SerializedName("clear_voucher_cache")
        private final boolean clearVoucherCache;

        public Metadata(boolean z11) {
            this.clearVoucherCache = z11;
        }

        public static /* synthetic */ Metadata copy$default(Metadata metadata, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = metadata.clearVoucherCache;
            }
            return metadata.copy(z11);
        }

        public final boolean component1() {
            return this.clearVoucherCache;
        }

        @NotNull
        public final Metadata copy(boolean z11) {
            return new Metadata(z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Metadata) && this.clearVoucherCache == ((Metadata) obj).clearVoucherCache;
        }

        public final boolean getClearVoucherCache() {
            return this.clearVoucherCache;
        }

        public int hashCode() {
            boolean z11 = this.clearVoucherCache;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.clearVoucherCache;
            return "Metadata(clearVoucherCache=" + z11 + ")";
        }
    }

    public ContentApiResponse() {
        this((Data) null, 1, (DefaultConstructorMarker) null);
    }

    public ContentApiResponse(@Nullable Data data2) {
        this.data = data2;
    }

    public static /* synthetic */ ContentApiResponse copy$default(ContentApiResponse contentApiResponse, Data data2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            data2 = contentApiResponse.data;
        }
        return contentApiResponse.copy(data2);
    }

    @Nullable
    public final Data component1() {
        return this.data;
    }

    @NotNull
    public final ContentApiResponse copy(@Nullable Data data2) {
        return new ContentApiResponse(data2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ContentApiResponse) && Intrinsics.areEqual((Object) this.data, (Object) ((ContentApiResponse) obj).data);
    }

    @Nullable
    public final Data getData() {
        return this.data;
    }

    public int hashCode() {
        Data data2 = this.data;
        if (data2 == null) {
            return 0;
        }
        return data2.hashCode();
    }

    @NotNull
    public String toString() {
        Data data2 = this.data;
        return "ContentApiResponse(data=" + data2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ContentApiResponse(Data data2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : data2);
    }

    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Data;", "", "components", "", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Component;", "configurations", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Configurations;", "metadata", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Metadata;", "(Ljava/util/List;Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Configurations;Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Metadata;)V", "getComponents", "()Ljava/util/List;", "getConfigurations", "()Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Configurations;", "getMetadata", "()Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Metadata;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data {
        @SerializedName("components")
        @Nullable
        private final List<Component> components;
        @SerializedName("configurations")
        @Nullable
        private final Configurations configurations;
        @SerializedName("metadata")
        @Nullable
        private final Metadata metadata;

        public Data() {
            this((List) null, (Configurations) null, (Metadata) null, 7, (DefaultConstructorMarker) null);
        }

        public Data(@Nullable List<Component> list, @Nullable Configurations configurations2, @Nullable Metadata metadata2) {
            this.components = list;
            this.configurations = configurations2;
            this.metadata = metadata2;
        }

        public static /* synthetic */ Data copy$default(Data data, List<Component> list, Configurations configurations2, Metadata metadata2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = data.components;
            }
            if ((i11 & 2) != 0) {
                configurations2 = data.configurations;
            }
            if ((i11 & 4) != 0) {
                metadata2 = data.metadata;
            }
            return data.copy(list, configurations2, metadata2);
        }

        @Nullable
        public final List<Component> component1() {
            return this.components;
        }

        @Nullable
        public final Configurations component2() {
            return this.configurations;
        }

        @Nullable
        public final Metadata component3() {
            return this.metadata;
        }

        @NotNull
        public final Data copy(@Nullable List<Component> list, @Nullable Configurations configurations2, @Nullable Metadata metadata2) {
            return new Data(list, configurations2, metadata2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            return Intrinsics.areEqual((Object) this.components, (Object) data.components) && Intrinsics.areEqual((Object) this.configurations, (Object) data.configurations) && Intrinsics.areEqual((Object) this.metadata, (Object) data.metadata);
        }

        @Nullable
        public final List<Component> getComponents() {
            return this.components;
        }

        @Nullable
        public final Configurations getConfigurations() {
            return this.configurations;
        }

        @Nullable
        public final Metadata getMetadata() {
            return this.metadata;
        }

        public int hashCode() {
            List<Component> list = this.components;
            int i11 = 0;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            Configurations configurations2 = this.configurations;
            int hashCode2 = (hashCode + (configurations2 == null ? 0 : configurations2.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            if (metadata2 != null) {
                i11 = metadata2.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            List<Component> list = this.components;
            Configurations configurations2 = this.configurations;
            Metadata metadata2 = this.metadata;
            return "Data(components=" + list + ", configurations=" + configurations2 + ", metadata=" + metadata2 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(List list, Configurations configurations2, Metadata metadata2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : configurations2, (i11 & 4) != 0 ? null : metadata2);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0003j\u0002`\u0005\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0019\u001a\u00060\u0003j\u0002`\u0005HÆ\u0003J\r\u0010\u001a\u001a\u00060\u0003j\u0002`\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003Jq\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0003j\u0002`\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0003j\u0002`\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0006\u001a\u00060\u0003j\u0002`\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0004\u001a\u00060\u0003j\u0002`\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006%"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Component;", "", "id", "", "templateId", "Lcom/deliveryhero/fluid/template/TemplateId;", "templateHash", "Lcom/deliveryhero/fluid/template/sources/TemplateHash;", "items", "", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse$Item;", "metadata", "", "properties", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMetadata", "()Ljava/util/Map;", "getProperties", "getTemplateHash", "getTemplateId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Component {
        @SerializedName("id")
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f59696id;
        @SerializedName("items")
        @Nullable
        private final List<Item> items;
        @SerializedName("metadata")
        @Nullable
        private final Map<String, String> metadata;
        @SerializedName("properties")
        @Nullable
        private final Map<String, String> properties;
        @SerializedName("template_hash")
        @NotNull
        private final String templateHash;
        @SerializedName("template_id")
        @NotNull
        private final String templateId;

        public Component(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<Item> list, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "templateId");
            Intrinsics.checkNotNullParameter(str3, "templateHash");
            this.f59696id = str;
            this.templateId = str2;
            this.templateHash = str3;
            this.items = list;
            this.metadata = map;
            this.properties = map2;
        }

        public static /* synthetic */ Component copy$default(Component component, String str, String str2, String str3, List<Item> list, Map<String, String> map, Map<String, String> map2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = component.f59696id;
            }
            if ((i11 & 2) != 0) {
                str2 = component.templateId;
            }
            String str4 = str2;
            if ((i11 & 4) != 0) {
                str3 = component.templateHash;
            }
            String str5 = str3;
            if ((i11 & 8) != 0) {
                list = component.items;
            }
            List<Item> list2 = list;
            if ((i11 & 16) != 0) {
                map = component.metadata;
            }
            Map<String, String> map3 = map;
            if ((i11 & 32) != 0) {
                map2 = component.properties;
            }
            return component.copy(str, str4, str5, list2, map3, map2);
        }

        @NotNull
        public final String component1() {
            return this.f59696id;
        }

        @NotNull
        public final String component2() {
            return this.templateId;
        }

        @NotNull
        public final String component3() {
            return this.templateHash;
        }

        @Nullable
        public final List<Item> component4() {
            return this.items;
        }

        @Nullable
        public final Map<String, String> component5() {
            return this.metadata;
        }

        @Nullable
        public final Map<String, String> component6() {
            return this.properties;
        }

        @NotNull
        public final Component copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<Item> list, @Nullable Map<String, String> map, @Nullable Map<String, String> map2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "templateId");
            Intrinsics.checkNotNullParameter(str3, "templateHash");
            return new Component(str, str2, str3, list, map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Component)) {
                return false;
            }
            Component component = (Component) obj;
            return Intrinsics.areEqual((Object) this.f59696id, (Object) component.f59696id) && Intrinsics.areEqual((Object) this.templateId, (Object) component.templateId) && Intrinsics.areEqual((Object) this.templateHash, (Object) component.templateHash) && Intrinsics.areEqual((Object) this.items, (Object) component.items) && Intrinsics.areEqual((Object) this.metadata, (Object) component.metadata) && Intrinsics.areEqual((Object) this.properties, (Object) component.properties);
        }

        @NotNull
        public final String getId() {
            return this.f59696id;
        }

        @Nullable
        public final List<Item> getItems() {
            return this.items;
        }

        @Nullable
        public final Map<String, String> getMetadata() {
            return this.metadata;
        }

        @Nullable
        public final Map<String, String> getProperties() {
            return this.properties;
        }

        @NotNull
        public final String getTemplateHash() {
            return this.templateHash;
        }

        @NotNull
        public final String getTemplateId() {
            return this.templateId;
        }

        public int hashCode() {
            int hashCode = ((((this.f59696id.hashCode() * 31) + this.templateId.hashCode()) * 31) + this.templateHash.hashCode()) * 31;
            List<Item> list = this.items;
            int i11 = 0;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            Map<String, String> map = this.metadata;
            int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
            Map<String, String> map2 = this.properties;
            if (map2 != null) {
                i11 = map2.hashCode();
            }
            return hashCode3 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.f59696id;
            String str2 = this.templateId;
            String str3 = this.templateHash;
            List<Item> list = this.items;
            Map<String, String> map = this.metadata;
            Map<String, String> map2 = this.properties;
            return "Component(id=" + str + ", templateId=" + str2 + ", templateHash=" + str3 + ", items=" + list + ", metadata=" + map + ", properties=" + map2 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Component(String str, String str2, String str3, List list, Map map, Map map2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 16) != 0 ? null : map, (i11 & 32) != 0 ? null : map2);
        }
    }
}
