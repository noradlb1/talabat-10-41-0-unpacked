package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003Je\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentData;", "", "topTwoCategories", "", "Lcom/talabat/darkstores/model/Category;", "categories", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "swimlanes", "Lcom/talabat/darkstores/model/Swimlane;", "topSwimlanes", "highlightSwimlanes", "(Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "getHighlightSwimlanes", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "getSwimlanes", "getTopSwimlanes", "getTopTwoCategories", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentData {
    @NotNull
    private final List<Category> categories;
    @NotNull
    private final List<Swimlane> highlightSwimlanes;
    @Nullable
    private final LifestyleMission lifestyleMission;
    @NotNull
    private final List<Swimlane> swimlanes;
    @NotNull
    private final List<Swimlane> topSwimlanes;
    @NotNull
    private final List<Category> topTwoCategories;

    public HomeFragmentData(@NotNull List<Category> list, @NotNull List<Category> list2, @Nullable LifestyleMission lifestyleMission2, @NotNull List<Swimlane> list3, @NotNull List<Swimlane> list4, @NotNull List<Swimlane> list5) {
        Intrinsics.checkNotNullParameter(list, "topTwoCategories");
        Intrinsics.checkNotNullParameter(list2, "categories");
        Intrinsics.checkNotNullParameter(list3, "swimlanes");
        Intrinsics.checkNotNullParameter(list4, "topSwimlanes");
        Intrinsics.checkNotNullParameter(list5, "highlightSwimlanes");
        this.topTwoCategories = list;
        this.categories = list2;
        this.lifestyleMission = lifestyleMission2;
        this.swimlanes = list3;
        this.topSwimlanes = list4;
        this.highlightSwimlanes = list5;
    }

    public static /* synthetic */ HomeFragmentData copy$default(HomeFragmentData homeFragmentData, List<Category> list, List<Category> list2, LifestyleMission lifestyleMission2, List<Swimlane> list3, List<Swimlane> list4, List<Swimlane> list5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = homeFragmentData.topTwoCategories;
        }
        if ((i11 & 2) != 0) {
            list2 = homeFragmentData.categories;
        }
        List<Category> list6 = list2;
        if ((i11 & 4) != 0) {
            lifestyleMission2 = homeFragmentData.lifestyleMission;
        }
        LifestyleMission lifestyleMission3 = lifestyleMission2;
        if ((i11 & 8) != 0) {
            list3 = homeFragmentData.swimlanes;
        }
        List<Swimlane> list7 = list3;
        if ((i11 & 16) != 0) {
            list4 = homeFragmentData.topSwimlanes;
        }
        List<Swimlane> list8 = list4;
        if ((i11 & 32) != 0) {
            list5 = homeFragmentData.highlightSwimlanes;
        }
        return homeFragmentData.copy(list, list6, lifestyleMission3, list7, list8, list5);
    }

    @NotNull
    public final List<Category> component1() {
        return this.topTwoCategories;
    }

    @NotNull
    public final List<Category> component2() {
        return this.categories;
    }

    @Nullable
    public final LifestyleMission component3() {
        return this.lifestyleMission;
    }

    @NotNull
    public final List<Swimlane> component4() {
        return this.swimlanes;
    }

    @NotNull
    public final List<Swimlane> component5() {
        return this.topSwimlanes;
    }

    @NotNull
    public final List<Swimlane> component6() {
        return this.highlightSwimlanes;
    }

    @NotNull
    public final HomeFragmentData copy(@NotNull List<Category> list, @NotNull List<Category> list2, @Nullable LifestyleMission lifestyleMission2, @NotNull List<Swimlane> list3, @NotNull List<Swimlane> list4, @NotNull List<Swimlane> list5) {
        Intrinsics.checkNotNullParameter(list, "topTwoCategories");
        Intrinsics.checkNotNullParameter(list2, "categories");
        Intrinsics.checkNotNullParameter(list3, "swimlanes");
        Intrinsics.checkNotNullParameter(list4, "topSwimlanes");
        Intrinsics.checkNotNullParameter(list5, "highlightSwimlanes");
        return new HomeFragmentData(list, list2, lifestyleMission2, list3, list4, list5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeFragmentData)) {
            return false;
        }
        HomeFragmentData homeFragmentData = (HomeFragmentData) obj;
        return Intrinsics.areEqual((Object) this.topTwoCategories, (Object) homeFragmentData.topTwoCategories) && Intrinsics.areEqual((Object) this.categories, (Object) homeFragmentData.categories) && Intrinsics.areEqual((Object) this.lifestyleMission, (Object) homeFragmentData.lifestyleMission) && Intrinsics.areEqual((Object) this.swimlanes, (Object) homeFragmentData.swimlanes) && Intrinsics.areEqual((Object) this.topSwimlanes, (Object) homeFragmentData.topSwimlanes) && Intrinsics.areEqual((Object) this.highlightSwimlanes, (Object) homeFragmentData.highlightSwimlanes);
    }

    @NotNull
    public final List<Category> getCategories() {
        return this.categories;
    }

    @NotNull
    public final List<Swimlane> getHighlightSwimlanes() {
        return this.highlightSwimlanes;
    }

    @Nullable
    public final LifestyleMission getLifestyleMission() {
        return this.lifestyleMission;
    }

    @NotNull
    public final List<Swimlane> getSwimlanes() {
        return this.swimlanes;
    }

    @NotNull
    public final List<Swimlane> getTopSwimlanes() {
        return this.topSwimlanes;
    }

    @NotNull
    public final List<Category> getTopTwoCategories() {
        return this.topTwoCategories;
    }

    public int hashCode() {
        int hashCode = ((this.topTwoCategories.hashCode() * 31) + this.categories.hashCode()) * 31;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        return ((((((hashCode + (lifestyleMission2 == null ? 0 : lifestyleMission2.hashCode())) * 31) + this.swimlanes.hashCode()) * 31) + this.topSwimlanes.hashCode()) * 31) + this.highlightSwimlanes.hashCode();
    }

    @NotNull
    public String toString() {
        List<Category> list = this.topTwoCategories;
        List<Category> list2 = this.categories;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        List<Swimlane> list3 = this.swimlanes;
        List<Swimlane> list4 = this.topSwimlanes;
        List<Swimlane> list5 = this.highlightSwimlanes;
        return "HomeFragmentData(topTwoCategories=" + list + ", categories=" + list2 + ", lifestyleMission=" + lifestyleMission2 + ", swimlanes=" + list3 + ", topSwimlanes=" + list4 + ", highlightSwimlanes=" + list5 + ")";
    }
}
