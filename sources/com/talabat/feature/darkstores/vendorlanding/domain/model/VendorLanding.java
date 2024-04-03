package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bo\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "", "categoryTree", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "lifestyleMission", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "productSwimlanes", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductSwimlanes;", "topSwimlanes", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "highlightedSwimlanes", "heroBanners", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "banners", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "metadata", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Metadata;", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductSwimlanes;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Metadata;)V", "getBanners", "()Ljava/util/List;", "getCategoryTree", "getHeroBanners", "getHighlightedSwimlanes", "getLifestyleMission", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "getMetadata", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Metadata;", "getProductSwimlanes", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductSwimlanes;", "getTopSwimlanes", "getVendor", "()Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLanding {
    @NotNull
    private final List<Banner> banners;
    @NotNull
    private final List<CategoryTree> categoryTree;
    @NotNull
    private final List<Banner> heroBanners;
    @NotNull
    private final List<Item> highlightedSwimlanes;
    @Nullable
    private final LifestyleMission lifestyleMission;
    @NotNull
    private final Metadata metadata;
    @NotNull
    private final ProductSwimlanes productSwimlanes;
    @NotNull
    private final List<Item> topSwimlanes;
    @Nullable
    private final Vendor vendor;

    public VendorLanding(@NotNull List<CategoryTree> list, @Nullable LifestyleMission lifestyleMission2, @NotNull ProductSwimlanes productSwimlanes2, @NotNull List<Item> list2, @NotNull List<Item> list3, @NotNull List<Banner> list4, @NotNull List<Banner> list5, @Nullable Vendor vendor2, @NotNull Metadata metadata2) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        Intrinsics.checkNotNullParameter(productSwimlanes2, "productSwimlanes");
        Intrinsics.checkNotNullParameter(list2, "topSwimlanes");
        Intrinsics.checkNotNullParameter(list3, "highlightedSwimlanes");
        Intrinsics.checkNotNullParameter(list4, "heroBanners");
        Intrinsics.checkNotNullParameter(list5, "banners");
        Intrinsics.checkNotNullParameter(metadata2, TtmlNode.TAG_METADATA);
        this.categoryTree = list;
        this.lifestyleMission = lifestyleMission2;
        this.productSwimlanes = productSwimlanes2;
        this.topSwimlanes = list2;
        this.highlightedSwimlanes = list3;
        this.heroBanners = list4;
        this.banners = list5;
        this.vendor = vendor2;
        this.metadata = metadata2;
    }

    public static /* synthetic */ VendorLanding copy$default(VendorLanding vendorLanding, List list, LifestyleMission lifestyleMission2, ProductSwimlanes productSwimlanes2, List list2, List list3, List list4, List list5, Vendor vendor2, Metadata metadata2, int i11, Object obj) {
        VendorLanding vendorLanding2 = vendorLanding;
        int i12 = i11;
        return vendorLanding.copy((i12 & 1) != 0 ? vendorLanding2.categoryTree : list, (i12 & 2) != 0 ? vendorLanding2.lifestyleMission : lifestyleMission2, (i12 & 4) != 0 ? vendorLanding2.productSwimlanes : productSwimlanes2, (i12 & 8) != 0 ? vendorLanding2.topSwimlanes : list2, (i12 & 16) != 0 ? vendorLanding2.highlightedSwimlanes : list3, (i12 & 32) != 0 ? vendorLanding2.heroBanners : list4, (i12 & 64) != 0 ? vendorLanding2.banners : list5, (i12 & 128) != 0 ? vendorLanding2.vendor : vendor2, (i12 & 256) != 0 ? vendorLanding2.metadata : metadata2);
    }

    @NotNull
    public final List<CategoryTree> component1() {
        return this.categoryTree;
    }

    @Nullable
    public final LifestyleMission component2() {
        return this.lifestyleMission;
    }

    @NotNull
    public final ProductSwimlanes component3() {
        return this.productSwimlanes;
    }

    @NotNull
    public final List<Item> component4() {
        return this.topSwimlanes;
    }

    @NotNull
    public final List<Item> component5() {
        return this.highlightedSwimlanes;
    }

    @NotNull
    public final List<Banner> component6() {
        return this.heroBanners;
    }

    @NotNull
    public final List<Banner> component7() {
        return this.banners;
    }

    @Nullable
    public final Vendor component8() {
        return this.vendor;
    }

    @NotNull
    public final Metadata component9() {
        return this.metadata;
    }

    @NotNull
    public final VendorLanding copy(@NotNull List<CategoryTree> list, @Nullable LifestyleMission lifestyleMission2, @NotNull ProductSwimlanes productSwimlanes2, @NotNull List<Item> list2, @NotNull List<Item> list3, @NotNull List<Banner> list4, @NotNull List<Banner> list5, @Nullable Vendor vendor2, @NotNull Metadata metadata2) {
        Intrinsics.checkNotNullParameter(list, "categoryTree");
        Intrinsics.checkNotNullParameter(productSwimlanes2, "productSwimlanes");
        Intrinsics.checkNotNullParameter(list2, "topSwimlanes");
        List<Item> list6 = list3;
        Intrinsics.checkNotNullParameter(list6, "highlightedSwimlanes");
        List<Banner> list7 = list4;
        Intrinsics.checkNotNullParameter(list7, "heroBanners");
        List<Banner> list8 = list5;
        Intrinsics.checkNotNullParameter(list8, "banners");
        Metadata metadata3 = metadata2;
        Intrinsics.checkNotNullParameter(metadata3, TtmlNode.TAG_METADATA);
        return new VendorLanding(list, lifestyleMission2, productSwimlanes2, list2, list6, list7, list8, vendor2, metadata3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorLanding)) {
            return false;
        }
        VendorLanding vendorLanding = (VendorLanding) obj;
        return Intrinsics.areEqual((Object) this.categoryTree, (Object) vendorLanding.categoryTree) && Intrinsics.areEqual((Object) this.lifestyleMission, (Object) vendorLanding.lifestyleMission) && Intrinsics.areEqual((Object) this.productSwimlanes, (Object) vendorLanding.productSwimlanes) && Intrinsics.areEqual((Object) this.topSwimlanes, (Object) vendorLanding.topSwimlanes) && Intrinsics.areEqual((Object) this.highlightedSwimlanes, (Object) vendorLanding.highlightedSwimlanes) && Intrinsics.areEqual((Object) this.heroBanners, (Object) vendorLanding.heroBanners) && Intrinsics.areEqual((Object) this.banners, (Object) vendorLanding.banners) && Intrinsics.areEqual((Object) this.vendor, (Object) vendorLanding.vendor) && Intrinsics.areEqual((Object) this.metadata, (Object) vendorLanding.metadata);
    }

    @NotNull
    public final List<Banner> getBanners() {
        return this.banners;
    }

    @NotNull
    public final List<CategoryTree> getCategoryTree() {
        return this.categoryTree;
    }

    @NotNull
    public final List<Banner> getHeroBanners() {
        return this.heroBanners;
    }

    @NotNull
    public final List<Item> getHighlightedSwimlanes() {
        return this.highlightedSwimlanes;
    }

    @Nullable
    public final LifestyleMission getLifestyleMission() {
        return this.lifestyleMission;
    }

    @NotNull
    public final Metadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final ProductSwimlanes getProductSwimlanes() {
        return this.productSwimlanes;
    }

    @NotNull
    public final List<Item> getTopSwimlanes() {
        return this.topSwimlanes;
    }

    @Nullable
    public final Vendor getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        int hashCode = this.categoryTree.hashCode() * 31;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        int i11 = 0;
        int hashCode2 = (((((((((((hashCode + (lifestyleMission2 == null ? 0 : lifestyleMission2.hashCode())) * 31) + this.productSwimlanes.hashCode()) * 31) + this.topSwimlanes.hashCode()) * 31) + this.highlightedSwimlanes.hashCode()) * 31) + this.heroBanners.hashCode()) * 31) + this.banners.hashCode()) * 31;
        Vendor vendor2 = this.vendor;
        if (vendor2 != null) {
            i11 = vendor2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        List<CategoryTree> list = this.categoryTree;
        LifestyleMission lifestyleMission2 = this.lifestyleMission;
        ProductSwimlanes productSwimlanes2 = this.productSwimlanes;
        List<Item> list2 = this.topSwimlanes;
        List<Item> list3 = this.highlightedSwimlanes;
        List<Banner> list4 = this.heroBanners;
        List<Banner> list5 = this.banners;
        Vendor vendor2 = this.vendor;
        Metadata metadata2 = this.metadata;
        return "VendorLanding(categoryTree=" + list + ", lifestyleMission=" + lifestyleMission2 + ", productSwimlanes=" + productSwimlanes2 + ", topSwimlanes=" + list2 + ", highlightedSwimlanes=" + list3 + ", heroBanners=" + list4 + ", banners=" + list5 + ", vendor=" + vendor2 + ", metadata=" + metadata2 + ")";
    }
}
