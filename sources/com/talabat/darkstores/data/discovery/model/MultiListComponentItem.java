package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.model.Swimlane;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/MultiListComponentItem;", "", "headline", "", "swimlanes", "", "Lcom/talabat/darkstores/model/Swimlane;", "component", "sortOptions", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getComponent", "()Ljava/lang/String;", "getHeadline", "setHeadline", "(Ljava/lang/String;)V", "getSortOptions", "()Ljava/util/List;", "getSwimlanes", "setSwimlanes", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiListComponentItem {
    @Nullable
    private final String component;
    @Nullable
    private String headline;
    @Nullable
    private final List<NetworkSortOption> sortOptions;
    @NotNull
    private List<Swimlane> swimlanes;

    public MultiListComponentItem() {
        this((String) null, (List) null, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public MultiListComponentItem(@Nullable @Json(name = "headline") String str, @NotNull @Json(name = "items") List<Swimlane> list, @Nullable @Json(name = "component") String str2, @Nullable @Json(name = "sort_options") List<NetworkSortOption> list2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        this.headline = str;
        this.swimlanes = list;
        this.component = str2;
        this.sortOptions = list2;
    }

    public static /* synthetic */ MultiListComponentItem copy$default(MultiListComponentItem multiListComponentItem, String str, List<Swimlane> list, String str2, List<NetworkSortOption> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = multiListComponentItem.headline;
        }
        if ((i11 & 2) != 0) {
            list = multiListComponentItem.swimlanes;
        }
        if ((i11 & 4) != 0) {
            str2 = multiListComponentItem.component;
        }
        if ((i11 & 8) != 0) {
            list2 = multiListComponentItem.sortOptions;
        }
        return multiListComponentItem.copy(str, list, str2, list2);
    }

    @Nullable
    public final String component1() {
        return this.headline;
    }

    @NotNull
    public final List<Swimlane> component2() {
        return this.swimlanes;
    }

    @Nullable
    public final String component3() {
        return this.component;
    }

    @Nullable
    public final List<NetworkSortOption> component4() {
        return this.sortOptions;
    }

    @NotNull
    public final MultiListComponentItem copy(@Nullable @Json(name = "headline") String str, @NotNull @Json(name = "items") List<Swimlane> list, @Nullable @Json(name = "component") String str2, @Nullable @Json(name = "sort_options") List<NetworkSortOption> list2) {
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        return new MultiListComponentItem(str, list, str2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiListComponentItem)) {
            return false;
        }
        MultiListComponentItem multiListComponentItem = (MultiListComponentItem) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) multiListComponentItem.headline) && Intrinsics.areEqual((Object) this.swimlanes, (Object) multiListComponentItem.swimlanes) && Intrinsics.areEqual((Object) this.component, (Object) multiListComponentItem.component) && Intrinsics.areEqual((Object) this.sortOptions, (Object) multiListComponentItem.sortOptions);
    }

    @Nullable
    public final String getComponent() {
        return this.component;
    }

    @Nullable
    public final String getHeadline() {
        return this.headline;
    }

    @Nullable
    public final List<NetworkSortOption> getSortOptions() {
        return this.sortOptions;
    }

    @NotNull
    public final List<Swimlane> getSwimlanes() {
        return this.swimlanes;
    }

    public int hashCode() {
        String str = this.headline;
        int i11 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.swimlanes.hashCode()) * 31;
        String str2 = this.component;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<NetworkSortOption> list = this.sortOptions;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setHeadline(@Nullable String str) {
        this.headline = str;
    }

    public final void setSwimlanes(@NotNull List<Swimlane> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.swimlanes = list;
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        List<Swimlane> list = this.swimlanes;
        String str2 = this.component;
        List<NetworkSortOption> list2 = this.sortOptions;
        return "MultiListComponentItem(headline=" + str + ", swimlanes=" + list + ", component=" + str2 + ", sortOptions=" + list2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiListComponentItem(String str, List list, String str2, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : list2);
    }
}
