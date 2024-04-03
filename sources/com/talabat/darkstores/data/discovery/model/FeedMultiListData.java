package com.talabat.darkstores.data.discovery.model;

import com.talabat.darkstores.domain.model.ProductsHolder;
import com.talabat.darkstores.model.Banner;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0013J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\bHÖ\u0001J\u0016\u00107\u001a\u00020\u00002\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H\u0016R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "Lcom/talabat/darkstores/domain/model/ProductsHolder;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "swimlaneRequestId", "", "swimlanes", "Lcom/talabat/darkstores/model/Swimlane;", "topSwimlanes", "highlightedSwimlanes", "heroBanners", "Lcom/talabat/darkstores/model/Banner;", "banners", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "primaryMissionSwimlanesRequestId", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;Ljava/lang/String;)V", "getBanners", "()Ljava/util/List;", "getCategories", "getHeroBanners", "getHighlightedSwimlanes", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "getPrimaryMissionSwimlanesRequestId", "()Ljava/lang/String;", "products", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProducts", "getSwimlaneRequestId", "getSwimlanes", "getTopSwimlanes", "getVendor", "()Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "withProducts", "newProducts", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedMultiListData implements ProductsHolder<FeedMultiListData> {
    @NotNull
    private final List<Banner> banners;
    @NotNull
    private final List<Category> categories;
    @NotNull
    private final List<Banner> heroBanners;
    @NotNull
    private final List<Swimlane> highlightedSwimlanes;
    @Nullable
    private final LifestyleMission lifestyleMission;
    @Nullable
    private final String primaryMissionSwimlanesRequestId;
    @NotNull
    private final String swimlaneRequestId;
    @NotNull
    private final List<Swimlane> swimlanes;
    @NotNull
    private final List<Swimlane> topSwimlanes;
    @Nullable
    private final Vendor vendor;

    public FeedMultiListData(@NotNull List<Category> list, @Nullable LifestyleMission lifestyleMission2, @NotNull String str, @NotNull List<Swimlane> list2, @NotNull List<Swimlane> list3, @NotNull List<Swimlane> list4, @NotNull List<Banner> list5, @NotNull List<Banner> list6, @Nullable Vendor vendor2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(str, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(list2, "swimlanes");
        Intrinsics.checkNotNullParameter(list3, "topSwimlanes");
        Intrinsics.checkNotNullParameter(list4, "highlightedSwimlanes");
        Intrinsics.checkNotNullParameter(list5, "heroBanners");
        Intrinsics.checkNotNullParameter(list6, "banners");
        this.categories = list;
        this.lifestyleMission = lifestyleMission2;
        this.swimlaneRequestId = str;
        this.swimlanes = list2;
        this.topSwimlanes = list3;
        this.highlightedSwimlanes = list4;
        this.heroBanners = list5;
        this.banners = list6;
        this.vendor = vendor2;
        this.primaryMissionSwimlanesRequestId = str2;
    }

    public static /* synthetic */ FeedMultiListData copy$default(FeedMultiListData feedMultiListData, List list, LifestyleMission lifestyleMission2, String str, List list2, List list3, List list4, List list5, List list6, Vendor vendor2, String str2, int i11, Object obj) {
        FeedMultiListData feedMultiListData2 = feedMultiListData;
        int i12 = i11;
        return feedMultiListData.copy((i12 & 1) != 0 ? feedMultiListData2.categories : list, (i12 & 2) != 0 ? feedMultiListData2.lifestyleMission : lifestyleMission2, (i12 & 4) != 0 ? feedMultiListData2.swimlaneRequestId : str, (i12 & 8) != 0 ? feedMultiListData2.swimlanes : list2, (i12 & 16) != 0 ? feedMultiListData2.topSwimlanes : list3, (i12 & 32) != 0 ? feedMultiListData2.highlightedSwimlanes : list4, (i12 & 64) != 0 ? feedMultiListData2.heroBanners : list5, (i12 & 128) != 0 ? feedMultiListData2.banners : list6, (i12 & 256) != 0 ? feedMultiListData2.vendor : vendor2, (i12 & 512) != 0 ? feedMultiListData2.primaryMissionSwimlanesRequestId : str2);
    }

    @NotNull
    public final List<Category> component1() {
        return this.categories;
    }

    @Nullable
    public final String component10() {
        return this.primaryMissionSwimlanesRequestId;
    }

    @Nullable
    public final LifestyleMission component2() {
        return this.lifestyleMission;
    }

    @NotNull
    public final String component3() {
        return this.swimlaneRequestId;
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
        return this.highlightedSwimlanes;
    }

    @NotNull
    public final List<Banner> component7() {
        return this.heroBanners;
    }

    @NotNull
    public final List<Banner> component8() {
        return this.banners;
    }

    @Nullable
    public final Vendor component9() {
        return this.vendor;
    }

    @NotNull
    public final FeedMultiListData copy(@NotNull List<Category> list, @Nullable LifestyleMission lifestyleMission2, @NotNull String str, @NotNull List<Swimlane> list2, @NotNull List<Swimlane> list3, @NotNull List<Swimlane> list4, @NotNull List<Banner> list5, @NotNull List<Banner> list6, @Nullable Vendor vendor2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "categories");
        Intrinsics.checkNotNullParameter(str, "swimlaneRequestId");
        List<Swimlane> list7 = list2;
        Intrinsics.checkNotNullParameter(list7, "swimlanes");
        List<Swimlane> list8 = list3;
        Intrinsics.checkNotNullParameter(list8, "topSwimlanes");
        List<Swimlane> list9 = list4;
        Intrinsics.checkNotNullParameter(list9, "highlightedSwimlanes");
        List<Banner> list10 = list5;
        Intrinsics.checkNotNullParameter(list10, "heroBanners");
        List<Banner> list11 = list6;
        Intrinsics.checkNotNullParameter(list11, "banners");
        return new FeedMultiListData(list, lifestyleMission2, str, list7, list8, list9, list10, list11, vendor2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedMultiListData)) {
            return false;
        }
        FeedMultiListData feedMultiListData = (FeedMultiListData) obj;
        return Intrinsics.areEqual((Object) this.categories, (Object) feedMultiListData.categories) && Intrinsics.areEqual((Object) this.lifestyleMission, (Object) feedMultiListData.lifestyleMission) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) feedMultiListData.swimlaneRequestId) && Intrinsics.areEqual((Object) this.swimlanes, (Object) feedMultiListData.swimlanes) && Intrinsics.areEqual((Object) this.topSwimlanes, (Object) feedMultiListData.topSwimlanes) && Intrinsics.areEqual((Object) this.highlightedSwimlanes, (Object) feedMultiListData.highlightedSwimlanes) && Intrinsics.areEqual((Object) this.heroBanners, (Object) feedMultiListData.heroBanners) && Intrinsics.areEqual((Object) this.banners, (Object) feedMultiListData.banners) && Intrinsics.areEqual((Object) this.vendor, (Object) feedMultiListData.vendor) && Intrinsics.areEqual((Object) this.primaryMissionSwimlanesRequestId, (Object) feedMultiListData.primaryMissionSwimlanesRequestId);
    }

    @NotNull
    public final List<Banner> getBanners() {
        return this.banners;
    }

    @NotNull
    public final List<Category> getCategories() {
        return this.categories;
    }

    @NotNull
    public final List<Banner> getHeroBanners() {
        return this.heroBanners;
    }

    @NotNull
    public final List<Swimlane> getHighlightedSwimlanes() {
        return this.highlightedSwimlanes;
    }

    @Nullable
    public final LifestyleMission getLifestyleMission() {
        return this.lifestyleMission;
    }

    @Nullable
    public final String getPrimaryMissionSwimlanesRequestId() {
        return this.primaryMissionSwimlanesRequestId;
    }

    @NotNull
    public List<Product> getProducts() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Swimlane products : this.swimlanes) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, products.getProducts());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Swimlane products2 : this.topSwimlanes) {
            boolean unused2 = CollectionsKt__MutableCollectionsKt.addAll(arrayList3, products2.getProducts());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Swimlane products3 : this.highlightedSwimlanes) {
            boolean unused3 = CollectionsKt__MutableCollectionsKt.addAll(arrayList4, products3.getProducts());
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        return arrayList;
    }

    @NotNull
    public final String getSwimlaneRequestId() {
        return this.swimlaneRequestId;
    }

    @NotNull
    public final List<Swimlane> getSwimlanes() {
        return this.swimlanes;
    }

    @NotNull
    public final List<Swimlane> getTopSwimlanes() {
        return this.topSwimlanes;
    }

    @Nullable
    public final Vendor getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        int hashCode = this.categories.hashCode() * 31;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        int i11 = 0;
        int hashCode2 = (((((((((((((hashCode + (lifestyleMission2 == null ? 0 : lifestyleMission2.hashCode())) * 31) + this.swimlaneRequestId.hashCode()) * 31) + this.swimlanes.hashCode()) * 31) + this.topSwimlanes.hashCode()) * 31) + this.highlightedSwimlanes.hashCode()) * 31) + this.heroBanners.hashCode()) * 31) + this.banners.hashCode()) * 31;
        Vendor vendor2 = this.vendor;
        int hashCode3 = (hashCode2 + (vendor2 == null ? 0 : vendor2.hashCode())) * 31;
        String str = this.primaryMissionSwimlanesRequestId;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        List<Category> list = this.categories;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        String str = this.swimlaneRequestId;
        List<Swimlane> list2 = this.swimlanes;
        List<Swimlane> list3 = this.topSwimlanes;
        List<Swimlane> list4 = this.highlightedSwimlanes;
        List<Banner> list5 = this.heroBanners;
        List<Banner> list6 = this.banners;
        Vendor vendor2 = this.vendor;
        String str2 = this.primaryMissionSwimlanesRequestId;
        return "FeedMultiListData(categories=" + list + ", lifestyleMission=" + lifestyleMission2 + ", swimlaneRequestId=" + str + ", swimlanes=" + list2 + ", topSwimlanes=" + list3 + ", highlightedSwimlanes=" + list4 + ", heroBanners=" + list5 + ", banners=" + list6 + ", vendor=" + vendor2 + ", primaryMissionSwimlanesRequestId=" + str2 + ")";
    }

    @NotNull
    public FeedMultiListData withProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "newProducts");
        Iterable iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(((Product) next).getId(), next);
        }
        FeedMultiListData$withProducts$updateProductsInSwimlane$1 feedMultiListData$withProducts$updateProductsInSwimlane$1 = new FeedMultiListData$withProducts$updateProductsInSwimlane$1(linkedHashMap);
        return new FeedMultiListData(this.categories, this.lifestyleMission, this.swimlaneRequestId, (List) feedMultiListData$withProducts$updateProductsInSwimlane$1.invoke(this.swimlanes), (List) feedMultiListData$withProducts$updateProductsInSwimlane$1.invoke(this.topSwimlanes), (List) feedMultiListData$withProducts$updateProductsInSwimlane$1.invoke(this.highlightedSwimlanes), this.heroBanners, this.banners, this.vendor, this.primaryMissionSwimlanesRequestId);
    }
}
