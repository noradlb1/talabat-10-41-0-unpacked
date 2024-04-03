package com.talabat.fluid.homescreen.presentation.mapper;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bJ*\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0010\b\u0000\u0010\u000b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u000b0\f2\u0006\u0010\r\u001a\u00020\tH\b¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "apply", "Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "metadata", "", "", "getCheckedValue", "T", "", "type", "(Ljava/lang/String;)Ljava/lang/Enum;", "getTileItemResponse", "Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper$TilesResult$TileItemResponse;", "getVerticalItem", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem;", "TilesResult", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalItemViewEntityMapper {
    @NotNull
    private final Gson gson;

    public VerticalItemViewEntityMapper() {
        this((Gson) null, 1, (DefaultConstructorMarker) null);
    }

    public VerticalItemViewEntityMapper(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    private final /* synthetic */ <T extends Enum<T>> T getCheckedValue(String str) {
        Intrinsics.reifiedOperationMarker(5, "T");
        return null;
    }

    private final TilesResult.TileItemResponse getTileItemResponse(String str) {
        boolean z11;
        Object obj;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        Gson gson2 = this.gson;
        Class cls = TilesResult.TileItemResponse.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(str, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, str, cls);
        }
        return (TilesResult.TileItemResponse) obj;
    }

    @NotNull
    public final EntryPointItem apply(@NotNull Map<String, String> map) {
        int i11;
        int i12;
        List<Integer> list;
        String str;
        String str2;
        String str3;
        String deeplink;
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        TilesResult.TileItemResponse tileItemResponse = getTileItemResponse(map.get(VerticalItemViewEntityMapperKt.VERTICAL_ITEM_KEY));
        String str4 = map.get(VerticalItemViewEntityMapperKt.ITEM_POSITION_KEY);
        if (str4 != null) {
            i11 = Integer.parseInt(str4);
        } else {
            i11 = 0;
        }
        if (tileItemResponse != null) {
            i12 = tileItemResponse.getId();
        } else {
            i12 = 0;
        }
        if (tileItemResponse == null || (list = tileItemResponse.getVerticalIds()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> list2 = list;
        if (tileItemResponse == null || (deeplink = tileItemResponse.getDeeplink()) == null) {
            str = "";
        } else {
            str = deeplink;
        }
        String str5 = map.get("shopName");
        if (str5 == null) {
            str5 = "N/A";
        }
        if (tileItemResponse != null) {
            str2 = tileItemResponse.getName();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        return new EntryPointItem(i11, i12, list2, str, str5, str3);
    }

    @Nullable
    public final VerticalItem getVerticalItem(@Nullable String str) {
        String str2;
        String str3;
        TilesResult.TileItemResponse tileItemResponse = getTileItemResponse(str);
        VerticalItem.WidthType widthType = null;
        if (tileItemResponse == null) {
            return null;
        }
        int id2 = tileItemResponse.getId();
        String name2 = tileItemResponse.getName();
        String widthType2 = tileItemResponse.getWidthType();
        if (widthType2 == null) {
            widthType2 = "";
        }
        VerticalItem.WidthType[] values = VerticalItem.WidthType.values();
        int length = values.length;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            VerticalItem.WidthType widthType3 = values[i11];
            if (StringsKt__StringsJVMKt.equals(widthType3.name(), widthType2, true)) {
                widthType = widthType3;
                break;
            }
            i11++;
        }
        if (widthType == null) {
            widthType = VerticalItem.WidthType.HALF;
        }
        String colorCode = tileItemResponse.getColorCode();
        if (colorCode == null) {
            colorCode = "#3F51B5";
        }
        String str4 = colorCode;
        String imageUrl = tileItemResponse.getImageUrl();
        if (imageUrl == null) {
            str2 = "";
        } else {
            str2 = imageUrl;
        }
        Boolean isNew = tileItemResponse.isNew();
        if (isNew != null) {
            z11 = isNew.booleanValue();
        }
        String deeplink = tileItemResponse.getDeeplink();
        if (deeplink == null) {
            str3 = "";
        } else {
            str3 = deeplink;
        }
        List<Integer> verticalIds = tileItemResponse.getVerticalIds();
        if (verticalIds == null) {
            verticalIds = CollectionsKt__CollectionsKt.emptyList();
        }
        return new VerticalItem(id2, name2, widthType, str4, str2, z11, str3, 0, 0, verticalIds, (Function0) null, 1408, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerticalItemViewEntityMapper(Gson gson2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new Gson() : gson2);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper$TilesResult;", "", "items", "", "Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper$TilesResult$TileItemResponse;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TileItemResponse", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TilesResult {
        @SerializedName("tiles")
        @NotNull
        private final List<TileItemResponse> items;

        public TilesResult(@NotNull List<TileItemResponse> list) {
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            this.items = list;
        }

        public static /* synthetic */ TilesResult copy$default(TilesResult tilesResult, List<TileItemResponse> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = tilesResult.items;
            }
            return tilesResult.copy(list);
        }

        @NotNull
        public final List<TileItemResponse> component1() {
            return this.items;
        }

        @NotNull
        public final TilesResult copy(@NotNull List<TileItemResponse> list) {
            Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
            return new TilesResult(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TilesResult) && Intrinsics.areEqual((Object) this.items, (Object) ((TilesResult) obj).items);
        }

        @NotNull
        public final List<TileItemResponse> getItems() {
            return this.items;
        }

        public int hashCode() {
            return this.items.hashCode();
        }

        @NotNull
        public String toString() {
            List<TileItemResponse> list = this.items;
            return "TilesResult(items=" + list + ")";
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003Jp\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006+"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper$TilesResult$TileItemResponse;", "", "id", "", "name", "", "imageUrl", "deeplink", "colorCode", "widthType", "isNew", "", "verticalIds", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getColorCode", "()Ljava/lang/String;", "getDeeplink", "getId", "()I", "getImageUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getVerticalIds", "()Ljava/util/List;", "setVerticalIds", "(Ljava/util/List;)V", "getWidthType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/talabat/fluid/homescreen/presentation/mapper/VerticalItemViewEntityMapper$TilesResult$TileItemResponse;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class TileItemResponse {
            @SerializedName("colorCode")
            @Nullable
            private final String colorCode;
            @SerializedName("deeplink")
            @Nullable
            private final String deeplink;
            @SerializedName("id")

            /* renamed from: id  reason: collision with root package name */
            private final int f59725id;
            @SerializedName("imageUrl")
            @Nullable
            private final String imageUrl;
            @SerializedName("isNew")
            @Nullable
            private final Boolean isNew;
            @SerializedName("name")
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f59726name;
            @SerializedName("verticalIds")
            @Nullable
            private List<Integer> verticalIds;
            @SerializedName("size")
            @Nullable
            private final String widthType;

            public TileItemResponse(int i11, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable List<Integer> list) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.f59725id = i11;
                this.f59726name = str;
                this.imageUrl = str2;
                this.deeplink = str3;
                this.colorCode = str4;
                this.widthType = str5;
                this.isNew = bool;
                this.verticalIds = list;
            }

            public static /* synthetic */ TileItemResponse copy$default(TileItemResponse tileItemResponse, int i11, String str, String str2, String str3, String str4, String str5, Boolean bool, List list, int i12, Object obj) {
                TileItemResponse tileItemResponse2 = tileItemResponse;
                int i13 = i12;
                return tileItemResponse.copy((i13 & 1) != 0 ? tileItemResponse2.f59725id : i11, (i13 & 2) != 0 ? tileItemResponse2.f59726name : str, (i13 & 4) != 0 ? tileItemResponse2.imageUrl : str2, (i13 & 8) != 0 ? tileItemResponse2.deeplink : str3, (i13 & 16) != 0 ? tileItemResponse2.colorCode : str4, (i13 & 32) != 0 ? tileItemResponse2.widthType : str5, (i13 & 64) != 0 ? tileItemResponse2.isNew : bool, (i13 & 128) != 0 ? tileItemResponse2.verticalIds : list);
            }

            public final int component1() {
                return this.f59725id;
            }

            @NotNull
            public final String component2() {
                return this.f59726name;
            }

            @Nullable
            public final String component3() {
                return this.imageUrl;
            }

            @Nullable
            public final String component4() {
                return this.deeplink;
            }

            @Nullable
            public final String component5() {
                return this.colorCode;
            }

            @Nullable
            public final String component6() {
                return this.widthType;
            }

            @Nullable
            public final Boolean component7() {
                return this.isNew;
            }

            @Nullable
            public final List<Integer> component8() {
                return this.verticalIds;
            }

            @NotNull
            public final TileItemResponse copy(int i11, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable List<Integer> list) {
                Intrinsics.checkNotNullParameter(str, "name");
                return new TileItemResponse(i11, str, str2, str3, str4, str5, bool, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TileItemResponse)) {
                    return false;
                }
                TileItemResponse tileItemResponse = (TileItemResponse) obj;
                return this.f59725id == tileItemResponse.f59725id && Intrinsics.areEqual((Object) this.f59726name, (Object) tileItemResponse.f59726name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) tileItemResponse.imageUrl) && Intrinsics.areEqual((Object) this.deeplink, (Object) tileItemResponse.deeplink) && Intrinsics.areEqual((Object) this.colorCode, (Object) tileItemResponse.colorCode) && Intrinsics.areEqual((Object) this.widthType, (Object) tileItemResponse.widthType) && Intrinsics.areEqual((Object) this.isNew, (Object) tileItemResponse.isNew) && Intrinsics.areEqual((Object) this.verticalIds, (Object) tileItemResponse.verticalIds);
            }

            @Nullable
            public final String getColorCode() {
                return this.colorCode;
            }

            @Nullable
            public final String getDeeplink() {
                return this.deeplink;
            }

            public final int getId() {
                return this.f59725id;
            }

            @Nullable
            public final String getImageUrl() {
                return this.imageUrl;
            }

            @NotNull
            public final String getName() {
                return this.f59726name;
            }

            @Nullable
            public final List<Integer> getVerticalIds() {
                return this.verticalIds;
            }

            @Nullable
            public final String getWidthType() {
                return this.widthType;
            }

            public int hashCode() {
                int hashCode = ((this.f59725id * 31) + this.f59726name.hashCode()) * 31;
                String str = this.imageUrl;
                int i11 = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.deeplink;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.colorCode;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.widthType;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Boolean bool = this.isNew;
                int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
                List<Integer> list = this.verticalIds;
                if (list != null) {
                    i11 = list.hashCode();
                }
                return hashCode6 + i11;
            }

            @Nullable
            public final Boolean isNew() {
                return this.isNew;
            }

            public final void setVerticalIds(@Nullable List<Integer> list) {
                this.verticalIds = list;
            }

            @NotNull
            public String toString() {
                int i11 = this.f59725id;
                String str = this.f59726name;
                String str2 = this.imageUrl;
                String str3 = this.deeplink;
                String str4 = this.colorCode;
                String str5 = this.widthType;
                Boolean bool = this.isNew;
                List<Integer> list = this.verticalIds;
                return "TileItemResponse(id=" + i11 + ", name=" + str + ", imageUrl=" + str2 + ", deeplink=" + str3 + ", colorCode=" + str4 + ", widthType=" + str5 + ", isNew=" + bool + ", verticalIds=" + list + ")";
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ TileItemResponse(int i11, String str, String str2, String str3, String str4, String str5, Boolean bool, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
                this(i11, str, str2, str3, str4, str5, bool, (i12 & 128) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            }
        }
    }
}
