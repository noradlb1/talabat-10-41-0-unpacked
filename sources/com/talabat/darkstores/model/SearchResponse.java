package com.talabat.darkstores.model;

import com.talabat.darkstores.feature.tracking.SearchResultScreenType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/model/SearchResponse;", "", "trackingData", "Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "getTrackingData", "()Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "TrackingData", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SearchResponse {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/model/SearchResponse$TrackingData;", "", "isEmpty", "", "screenType", "Lcom/talabat/darkstores/feature/tracking/SearchResultScreenType;", "productsCount", "", "productsSkus", "", "", "(ZLcom/talabat/darkstores/feature/tracking/SearchResultScreenType;ILjava/util/List;)V", "()Z", "getProductsCount", "()I", "getProductsSkus", "()Ljava/util/List;", "getScreenType", "()Lcom/talabat/darkstores/feature/tracking/SearchResultScreenType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TrackingData {
        private final boolean isEmpty;
        private final int productsCount;
        @NotNull
        private final List<String> productsSkus;
        @NotNull
        private final SearchResultScreenType screenType;

        public TrackingData(boolean z11, @NotNull SearchResultScreenType searchResultScreenType, int i11, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(searchResultScreenType, "screenType");
            Intrinsics.checkNotNullParameter(list, "productsSkus");
            this.isEmpty = z11;
            this.screenType = searchResultScreenType;
            this.productsCount = i11;
            this.productsSkus = list;
        }

        public static /* synthetic */ TrackingData copy$default(TrackingData trackingData, boolean z11, SearchResultScreenType searchResultScreenType, int i11, List<String> list, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                z11 = trackingData.isEmpty;
            }
            if ((i12 & 2) != 0) {
                searchResultScreenType = trackingData.screenType;
            }
            if ((i12 & 4) != 0) {
                i11 = trackingData.productsCount;
            }
            if ((i12 & 8) != 0) {
                list = trackingData.productsSkus;
            }
            return trackingData.copy(z11, searchResultScreenType, i11, list);
        }

        public final boolean component1() {
            return this.isEmpty;
        }

        @NotNull
        public final SearchResultScreenType component2() {
            return this.screenType;
        }

        public final int component3() {
            return this.productsCount;
        }

        @NotNull
        public final List<String> component4() {
            return this.productsSkus;
        }

        @NotNull
        public final TrackingData copy(boolean z11, @NotNull SearchResultScreenType searchResultScreenType, int i11, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(searchResultScreenType, "screenType");
            Intrinsics.checkNotNullParameter(list, "productsSkus");
            return new TrackingData(z11, searchResultScreenType, i11, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TrackingData)) {
                return false;
            }
            TrackingData trackingData = (TrackingData) obj;
            return this.isEmpty == trackingData.isEmpty && this.screenType == trackingData.screenType && this.productsCount == trackingData.productsCount && Intrinsics.areEqual((Object) this.productsSkus, (Object) trackingData.productsSkus);
        }

        public final int getProductsCount() {
            return this.productsCount;
        }

        @NotNull
        public final List<String> getProductsSkus() {
            return this.productsSkus;
        }

        @NotNull
        public final SearchResultScreenType getScreenType() {
            return this.screenType;
        }

        public int hashCode() {
            boolean z11 = this.isEmpty;
            if (z11) {
                z11 = true;
            }
            return ((((((z11 ? 1 : 0) * true) + this.screenType.hashCode()) * 31) + this.productsCount) * 31) + this.productsSkus.hashCode();
        }

        public final boolean isEmpty() {
            return this.isEmpty;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.isEmpty;
            SearchResultScreenType searchResultScreenType = this.screenType;
            int i11 = this.productsCount;
            List<String> list = this.productsSkus;
            return "TrackingData(isEmpty=" + z11 + ", screenType=" + searchResultScreenType + ", productsCount=" + i11 + ", productsSkus=" + list + ")";
        }
    }

    @NotNull
    TrackingData getTrackingData();
}
