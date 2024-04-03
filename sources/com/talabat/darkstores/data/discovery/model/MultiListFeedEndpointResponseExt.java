package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseExt;", "", "componentItems", "", "Lcom/talabat/darkstores/data/discovery/model/MultiListComponentItem;", "(Ljava/util/List;)V", "getComponentItems", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiListFeedEndpointResponseExt {
    @NotNull
    private final List<MultiListComponentItem> componentItems;

    public MultiListFeedEndpointResponseExt() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public MultiListFeedEndpointResponseExt(@NotNull @Json(name = "items") List<MultiListComponentItem> list) {
        Intrinsics.checkNotNullParameter(list, "componentItems");
        this.componentItems = list;
    }

    public static /* synthetic */ MultiListFeedEndpointResponseExt copy$default(MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt, List<MultiListComponentItem> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = multiListFeedEndpointResponseExt.componentItems;
        }
        return multiListFeedEndpointResponseExt.copy(list);
    }

    @NotNull
    public final List<MultiListComponentItem> component1() {
        return this.componentItems;
    }

    @NotNull
    public final MultiListFeedEndpointResponseExt copy(@NotNull @Json(name = "items") List<MultiListComponentItem> list) {
        Intrinsics.checkNotNullParameter(list, "componentItems");
        return new MultiListFeedEndpointResponseExt(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiListFeedEndpointResponseExt) && Intrinsics.areEqual((Object) this.componentItems, (Object) ((MultiListFeedEndpointResponseExt) obj).componentItems);
    }

    @NotNull
    public final List<MultiListComponentItem> getComponentItems() {
        return this.componentItems;
    }

    public int hashCode() {
        return this.componentItems.hashCode();
    }

    @NotNull
    public String toString() {
        List<MultiListComponentItem> list = this.componentItems;
        return "MultiListFeedEndpointResponseExt(componentItems=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiListFeedEndpointResponseExt(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
