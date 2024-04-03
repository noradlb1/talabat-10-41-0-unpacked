package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "", "id", "", "name", "layoutType", "products", "", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "tracking", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/TrackingResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorslanding/data/model/TrackingResponse;)V", "getId", "()Ljava/lang/String;", "getLayoutType", "getName", "getProducts", "()Ljava/util/List;", "getTracking", "()Lcom/talabat/feature/darkstores/vendorslanding/data/model/TrackingResponse;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemResponse {
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f58437id;
    @Nullable
    private final String layoutType;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f58438name;
    @Nullable
    private final List<SwimlaneProductResponse> products;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final TrackingResponse f58439tracking;

    public ItemResponse() {
        this((String) null, (String) null, (String) null, (List) null, (TrackingResponse) null, 31, (DefaultConstructorMarker) null);
    }

    public ItemResponse(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "layout_type") String str3, @Nullable @Json(name = "products") List<SwimlaneProductResponse> list, @Nullable @Json(name = "tracking") TrackingResponse trackingResponse) {
        this.f58437id = str;
        this.f58438name = str2;
        this.layoutType = str3;
        this.products = list;
        this.f58439tracking = trackingResponse;
    }

    public static /* synthetic */ ItemResponse copy$default(ItemResponse itemResponse, String str, String str2, String str3, List<SwimlaneProductResponse> list, TrackingResponse trackingResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = itemResponse.f58437id;
        }
        if ((i11 & 2) != 0) {
            str2 = itemResponse.f58438name;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            str3 = itemResponse.layoutType;
        }
        String str5 = str3;
        if ((i11 & 8) != 0) {
            list = itemResponse.products;
        }
        List<SwimlaneProductResponse> list2 = list;
        if ((i11 & 16) != 0) {
            trackingResponse = itemResponse.f58439tracking;
        }
        return itemResponse.copy(str, str4, str5, list2, trackingResponse);
    }

    @Nullable
    public final String component1() {
        return this.f58437id;
    }

    @Nullable
    public final String component2() {
        return this.f58438name;
    }

    @Nullable
    public final String component3() {
        return this.layoutType;
    }

    @Nullable
    public final List<SwimlaneProductResponse> component4() {
        return this.products;
    }

    @Nullable
    public final TrackingResponse component5() {
        return this.f58439tracking;
    }

    @NotNull
    public final ItemResponse copy(@Nullable @Json(name = "id") String str, @Nullable @Json(name = "name") String str2, @Nullable @Json(name = "layout_type") String str3, @Nullable @Json(name = "products") List<SwimlaneProductResponse> list, @Nullable @Json(name = "tracking") TrackingResponse trackingResponse) {
        return new ItemResponse(str, str2, str3, list, trackingResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemResponse)) {
            return false;
        }
        ItemResponse itemResponse = (ItemResponse) obj;
        return Intrinsics.areEqual((Object) this.f58437id, (Object) itemResponse.f58437id) && Intrinsics.areEqual((Object) this.f58438name, (Object) itemResponse.f58438name) && Intrinsics.areEqual((Object) this.layoutType, (Object) itemResponse.layoutType) && Intrinsics.areEqual((Object) this.products, (Object) itemResponse.products) && Intrinsics.areEqual((Object) this.f58439tracking, (Object) itemResponse.f58439tracking);
    }

    @Nullable
    public final String getId() {
        return this.f58437id;
    }

    @Nullable
    public final String getLayoutType() {
        return this.layoutType;
    }

    @Nullable
    public final String getName() {
        return this.f58438name;
    }

    @Nullable
    public final List<SwimlaneProductResponse> getProducts() {
        return this.products;
    }

    @Nullable
    public final TrackingResponse getTracking() {
        return this.f58439tracking;
    }

    public int hashCode() {
        String str = this.f58437id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f58438name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.layoutType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<SwimlaneProductResponse> list = this.products;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        TrackingResponse trackingResponse = this.f58439tracking;
        if (trackingResponse != null) {
            i11 = trackingResponse.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f58437id;
        String str2 = this.f58438name;
        String str3 = this.layoutType;
        List<SwimlaneProductResponse> list = this.products;
        TrackingResponse trackingResponse = this.f58439tracking;
        return "ItemResponse(id=" + str + ", name=" + str2 + ", layoutType=" + str3 + ", products=" + list + ", tracking=" + trackingResponse + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ItemResponse(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.util.List r8, com.talabat.feature.darkstores.vendorslanding.data.model.TrackingResponse r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, com.talabat.feature.darkstores.vendorslanding.data.model.TrackingResponse, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
