package com.talabat.darkstores.data.basket.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.visa.checkout.PurchaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB3\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "", "items", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "headline", "", "requestId", "tracking", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;)V", "getHeadline", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getRequestId", "getTracking", "()Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "TrackingInfo", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneResponse {
    @NotNull
    private final String headline;
    @NotNull
    private final List<Product> items;
    @NotNull
    private final String requestId;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final TrackingInfo f56185tracking;

    public SwimlaneResponse(@NotNull @Json(name = "items") List<Product> list, @NotNull @Json(name = "headline") String str, @NotNull @Json(name = "id") String str2, @NotNull @Json(name = "tracking") TrackingInfo trackingInfo) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(trackingInfo, "tracking");
        this.items = list;
        this.headline = str;
        this.requestId = str2;
        this.f56185tracking = trackingInfo;
    }

    public static /* synthetic */ SwimlaneResponse copy$default(SwimlaneResponse swimlaneResponse, List<Product> list, String str, String str2, TrackingInfo trackingInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = swimlaneResponse.items;
        }
        if ((i11 & 2) != 0) {
            str = swimlaneResponse.headline;
        }
        if ((i11 & 4) != 0) {
            str2 = swimlaneResponse.requestId;
        }
        if ((i11 & 8) != 0) {
            trackingInfo = swimlaneResponse.f56185tracking;
        }
        return swimlaneResponse.copy(list, str, str2, trackingInfo);
    }

    @NotNull
    public final List<Product> component1() {
        return this.items;
    }

    @NotNull
    public final String component2() {
        return this.headline;
    }

    @NotNull
    public final String component3() {
        return this.requestId;
    }

    @NotNull
    public final TrackingInfo component4() {
        return this.f56185tracking;
    }

    @NotNull
    public final SwimlaneResponse copy(@NotNull @Json(name = "items") List<Product> list, @NotNull @Json(name = "headline") String str, @NotNull @Json(name = "id") String str2, @NotNull @Json(name = "tracking") TrackingInfo trackingInfo) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(str2, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(trackingInfo, "tracking");
        return new SwimlaneResponse(list, str, str2, trackingInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneResponse)) {
            return false;
        }
        SwimlaneResponse swimlaneResponse = (SwimlaneResponse) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) swimlaneResponse.items) && Intrinsics.areEqual((Object) this.headline, (Object) swimlaneResponse.headline) && Intrinsics.areEqual((Object) this.requestId, (Object) swimlaneResponse.requestId) && Intrinsics.areEqual((Object) this.f56185tracking, (Object) swimlaneResponse.f56185tracking);
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final List<Product> getItems() {
        return this.items;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final TrackingInfo getTracking() {
        return this.f56185tracking;
    }

    public int hashCode() {
        return (((((this.items.hashCode() * 31) + this.headline.hashCode()) * 31) + this.requestId.hashCode()) * 31) + this.f56185tracking.hashCode();
    }

    @NotNull
    public String toString() {
        List<Product> list = this.items;
        String str = this.headline;
        String str2 = this.requestId;
        TrackingInfo trackingInfo = this.f56185tracking;
        return "SwimlaneResponse(items=" + list + ", headline=" + str + ", requestId=" + str2 + ", tracking=" + trackingInfo + ")";
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse$TrackingInfo;", "", "swimlaneId", "", "trackingId", "supportedTitleList", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getSupportedTitleList", "()Ljava/util/List;", "getSwimlaneId", "()Ljava/lang/String;", "getTrackingId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TrackingInfo {
        @NotNull
        private final List<String> supportedTitleList;
        @NotNull
        private final String swimlaneId;
        @NotNull
        private final String trackingId;

        public TrackingInfo() {
            this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
        }

        public TrackingInfo(@NotNull @Json(name = "swimlane_id") String str, @NotNull @Json(name = "tracking_id") String str2, @NotNull @Json(name = "swimlane_title_list") List<String> list) {
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "trackingId");
            Intrinsics.checkNotNullParameter(list, "supportedTitleList");
            this.swimlaneId = str;
            this.trackingId = str2;
            this.supportedTitleList = list;
        }

        public static /* synthetic */ TrackingInfo copy$default(TrackingInfo trackingInfo, String str, String str2, List<String> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = trackingInfo.swimlaneId;
            }
            if ((i11 & 2) != 0) {
                str2 = trackingInfo.trackingId;
            }
            if ((i11 & 4) != 0) {
                list = trackingInfo.supportedTitleList;
            }
            return trackingInfo.copy(str, str2, list);
        }

        @NotNull
        public final String component1() {
            return this.swimlaneId;
        }

        @NotNull
        public final String component2() {
            return this.trackingId;
        }

        @NotNull
        public final List<String> component3() {
            return this.supportedTitleList;
        }

        @NotNull
        public final TrackingInfo copy(@NotNull @Json(name = "swimlane_id") String str, @NotNull @Json(name = "tracking_id") String str2, @NotNull @Json(name = "swimlane_title_list") List<String> list) {
            Intrinsics.checkNotNullParameter(str, "swimlaneId");
            Intrinsics.checkNotNullParameter(str2, "trackingId");
            Intrinsics.checkNotNullParameter(list, "supportedTitleList");
            return new TrackingInfo(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TrackingInfo)) {
                return false;
            }
            TrackingInfo trackingInfo = (TrackingInfo) obj;
            return Intrinsics.areEqual((Object) this.swimlaneId, (Object) trackingInfo.swimlaneId) && Intrinsics.areEqual((Object) this.trackingId, (Object) trackingInfo.trackingId) && Intrinsics.areEqual((Object) this.supportedTitleList, (Object) trackingInfo.supportedTitleList);
        }

        @NotNull
        public final List<String> getSupportedTitleList() {
            return this.supportedTitleList;
        }

        @NotNull
        public final String getSwimlaneId() {
            return this.swimlaneId;
        }

        @NotNull
        public final String getTrackingId() {
            return this.trackingId;
        }

        public int hashCode() {
            return (((this.swimlaneId.hashCode() * 31) + this.trackingId.hashCode()) * 31) + this.supportedTitleList.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.swimlaneId;
            String str2 = this.trackingId;
            List<String> list = this.supportedTitleList;
            return "TrackingInfo(swimlaneId=" + str + ", trackingId=" + str2 + ", supportedTitleList=" + list + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TrackingInfo(String str, String str2, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
        }
    }
}
