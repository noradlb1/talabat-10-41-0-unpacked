package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.model.Category;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "", "categories", "", "Lcom/talabat/darkstores/model/Category;", "feedItems", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseExt;", "(Ljava/util/List;Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseExt;)V", "getCategories", "()Ljava/util/List;", "getFeedItems", "()Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponseExt;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiListFeedEndpointResponse {
    @Nullable
    private final List<Category> categories;
    @NotNull
    private final MultiListFeedEndpointResponseExt feedItems;

    public MultiListFeedEndpointResponse(@Nullable @Json(name = "category_tree") List<Category> list, @NotNull @Json(name = "feed") MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt) {
        Intrinsics.checkNotNullParameter(multiListFeedEndpointResponseExt, "feedItems");
        this.categories = list;
        this.feedItems = multiListFeedEndpointResponseExt;
    }

    public static /* synthetic */ MultiListFeedEndpointResponse copy$default(MultiListFeedEndpointResponse multiListFeedEndpointResponse, List<Category> list, MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = multiListFeedEndpointResponse.categories;
        }
        if ((i11 & 2) != 0) {
            multiListFeedEndpointResponseExt = multiListFeedEndpointResponse.feedItems;
        }
        return multiListFeedEndpointResponse.copy(list, multiListFeedEndpointResponseExt);
    }

    @Nullable
    public final List<Category> component1() {
        return this.categories;
    }

    @NotNull
    public final MultiListFeedEndpointResponseExt component2() {
        return this.feedItems;
    }

    @NotNull
    public final MultiListFeedEndpointResponse copy(@Nullable @Json(name = "category_tree") List<Category> list, @NotNull @Json(name = "feed") MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt) {
        Intrinsics.checkNotNullParameter(multiListFeedEndpointResponseExt, "feedItems");
        return new MultiListFeedEndpointResponse(list, multiListFeedEndpointResponseExt);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiListFeedEndpointResponse)) {
            return false;
        }
        MultiListFeedEndpointResponse multiListFeedEndpointResponse = (MultiListFeedEndpointResponse) obj;
        return Intrinsics.areEqual((Object) this.categories, (Object) multiListFeedEndpointResponse.categories) && Intrinsics.areEqual((Object) this.feedItems, (Object) multiListFeedEndpointResponse.feedItems);
    }

    @Nullable
    public final List<Category> getCategories() {
        return this.categories;
    }

    @NotNull
    public final MultiListFeedEndpointResponseExt getFeedItems() {
        return this.feedItems;
    }

    public int hashCode() {
        List<Category> list = this.categories;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.feedItems.hashCode();
    }

    @NotNull
    public String toString() {
        List<Category> list = this.categories;
        MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt = this.feedItems;
        return "MultiListFeedEndpointResponse(categories=" + list + ", feedItems=" + multiListFeedEndpointResponseExt + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiListFeedEndpointResponse(List list, MultiListFeedEndpointResponseExt multiListFeedEndpointResponseExt, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? new MultiListFeedEndpointResponseExt((List) null, 1, (DefaultConstructorMarker) null) : multiListFeedEndpointResponseExt);
    }
}
