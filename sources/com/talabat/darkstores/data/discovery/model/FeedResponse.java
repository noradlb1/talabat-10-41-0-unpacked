package com.talabat.darkstores.data.discovery.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedResponse;", "", "count", "", "items", "", "Lcom/talabat/darkstores/data/discovery/model/ProductsComponentItem;", "(ILjava/util/List;)V", "getCount", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedResponse {
    private final int count;
    @NotNull
    private final List<ProductsComponentItem> items;

    public FeedResponse(int i11, @NotNull List<ProductsComponentItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.count = i11;
        this.items = list;
    }

    public static /* synthetic */ FeedResponse copy$default(FeedResponse feedResponse, int i11, List<ProductsComponentItem> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = feedResponse.count;
        }
        if ((i12 & 2) != 0) {
            list = feedResponse.items;
        }
        return feedResponse.copy(i11, list);
    }

    public final int component1() {
        return this.count;
    }

    @NotNull
    public final List<ProductsComponentItem> component2() {
        return this.items;
    }

    @NotNull
    public final FeedResponse copy(int i11, @NotNull List<ProductsComponentItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new FeedResponse(i11, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedResponse)) {
            return false;
        }
        FeedResponse feedResponse = (FeedResponse) obj;
        return this.count == feedResponse.count && Intrinsics.areEqual((Object) this.items, (Object) feedResponse.items);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<ProductsComponentItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        return (this.count * 31) + this.items.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.count;
        List<ProductsComponentItem> list = this.items;
        return "FeedResponse(count=" + i11 + ", items=" + list + ")";
    }
}
