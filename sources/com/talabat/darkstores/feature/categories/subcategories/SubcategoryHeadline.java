package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.darkstores.data.discovery.model.SortOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JH\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "headline", "", "headlineIndex", "", "positionOnList", "marginTop", "sortOptions", "", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "(Ljava/lang/String;IILjava/lang/Integer;Ljava/util/List;)V", "getHeadline", "()Ljava/lang/String;", "getHeadlineIndex", "()I", "id", "getId", "getMarginTop", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPositionOnList", "getSortOptions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;IILjava/lang/Integer;Ljava/util/List;)Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoryHeadline extends SubcategoryItem {
    @NotNull
    private final String headline;
    private final int headlineIndex;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56328id;
    @Nullable
    private final Integer marginTop;
    private final int positionOnList;
    @NotNull
    private final List<SortOption> sortOptions;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubcategoryHeadline(String str, int i11, int i12, Integer num, List list, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, i12, (i13 & 8) != 0 ? null : num, (i13 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public static /* synthetic */ SubcategoryHeadline copy$default(SubcategoryHeadline subcategoryHeadline, String str, int i11, int i12, Integer num, List<SortOption> list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = subcategoryHeadline.headline;
        }
        if ((i13 & 2) != 0) {
            i11 = subcategoryHeadline.getHeadlineIndex();
        }
        int i14 = i11;
        if ((i13 & 4) != 0) {
            i12 = subcategoryHeadline.positionOnList;
        }
        int i15 = i12;
        if ((i13 & 8) != 0) {
            num = subcategoryHeadline.marginTop;
        }
        Integer num2 = num;
        if ((i13 & 16) != 0) {
            list = subcategoryHeadline.sortOptions;
        }
        return subcategoryHeadline.copy(str, i14, i15, num2, list);
    }

    @NotNull
    public final String component1() {
        return this.headline;
    }

    public final int component2() {
        return getHeadlineIndex();
    }

    public final int component3() {
        return this.positionOnList;
    }

    @Nullable
    public final Integer component4() {
        return this.marginTop;
    }

    @NotNull
    public final List<SortOption> component5() {
        return this.sortOptions;
    }

    @NotNull
    public final SubcategoryHeadline copy(@NotNull String str, int i11, int i12, @Nullable Integer num, @NotNull List<SortOption> list) {
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "sortOptions");
        return new SubcategoryHeadline(str, i11, i12, num, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubcategoryHeadline)) {
            return false;
        }
        SubcategoryHeadline subcategoryHeadline = (SubcategoryHeadline) obj;
        return Intrinsics.areEqual((Object) this.headline, (Object) subcategoryHeadline.headline) && getHeadlineIndex() == subcategoryHeadline.getHeadlineIndex() && this.positionOnList == subcategoryHeadline.positionOnList && Intrinsics.areEqual((Object) this.marginTop, (Object) subcategoryHeadline.marginTop) && Intrinsics.areEqual((Object) this.sortOptions, (Object) subcategoryHeadline.sortOptions);
    }

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    public int getHeadlineIndex() {
        return this.headlineIndex;
    }

    @NotNull
    public String getId() {
        return this.f56328id;
    }

    @Nullable
    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final int getPositionOnList() {
        return this.positionOnList;
    }

    @NotNull
    public final List<SortOption> getSortOptions() {
        return this.sortOptions;
    }

    public int hashCode() {
        int hashCode = ((((this.headline.hashCode() * 31) + getHeadlineIndex()) * 31) + this.positionOnList) * 31;
        Integer num = this.marginTop;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.sortOptions.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.headline;
        int headlineIndex2 = getHeadlineIndex();
        int i11 = this.positionOnList;
        Integer num = this.marginTop;
        List<SortOption> list = this.sortOptions;
        return "SubcategoryHeadline(headline=" + str + ", headlineIndex=" + headlineIndex2 + ", positionOnList=" + i11 + ", marginTop=" + num + ", sortOptions=" + list + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoryHeadline(@NotNull String str, int i11, int i12, @Nullable Integer num, @NotNull List<SortOption> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "headline");
        Intrinsics.checkNotNullParameter(list, "sortOptions");
        this.headline = str;
        this.headlineIndex = i11;
        this.positionOnList = i12;
        this.marginTop = num;
        this.sortOptions = list;
        this.f56328id = str;
    }
}
