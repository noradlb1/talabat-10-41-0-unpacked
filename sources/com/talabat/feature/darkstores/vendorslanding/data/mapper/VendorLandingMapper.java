package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LayoutType;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ProductSwimlanes;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Tracking;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.TrackingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001BG\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/VendorLandingMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "categoryTreeMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "lifestyleMissionMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "swimlaneProductMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "(Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "mapToItem", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingMapper implements ModelMapper<VendorLandingResponse, VendorLanding> {
    @NotNull
    private final ModelMapper<CategoryTreeResponse, CategoryTree> categoryTreeMapper;
    @NotNull
    private final ModelMapper<LifestyleMissionResponse, LifestyleMission> lifestyleMissionMapper;
    @NotNull
    private final ModelMapper<SwimlaneProductResponse, SwimlaneProduct> swimlaneProductMapper;

    @Inject
    public VendorLandingMapper(@NotNull ModelMapper<CategoryTreeResponse, CategoryTree> modelMapper, @NotNull ModelMapper<LifestyleMissionResponse, LifestyleMission> modelMapper2, @NotNull ModelMapper<SwimlaneProductResponse, SwimlaneProduct> modelMapper3) {
        Intrinsics.checkNotNullParameter(modelMapper, "categoryTreeMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "lifestyleMissionMapper");
        Intrinsics.checkNotNullParameter(modelMapper3, "swimlaneProductMapper");
        this.categoryTreeMapper = modelMapper;
        this.lifestyleMissionMapper = modelMapper2;
        this.swimlaneProductMapper = modelMapper3;
    }

    private final Item mapToItem(ItemResponse itemResponse) {
        boolean z11;
        boolean z12;
        LayoutType layoutType;
        String trackingId;
        String id2 = itemResponse.getId();
        boolean z13 = false;
        if (id2 == null || StringsKt__StringsJVMKt.isBlank(id2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        Tracking tracking2 = null;
        if (z11) {
            return null;
        }
        Collection products = itemResponse.getProducts();
        if (products == null || products.isEmpty()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return null;
        }
        String name2 = itemResponse.getName();
        if (name2 == null || StringsKt__StringsJVMKt.isBlank(name2)) {
            z13 = true;
        }
        if (z13) {
            return null;
        }
        String id3 = itemResponse.getId();
        String name3 = itemResponse.getName();
        ArrayList arrayList = new ArrayList();
        for (SwimlaneProductResponse apply : itemResponse.getProducts()) {
            SwimlaneProduct apply2 = this.swimlaneProductMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        TrackingResponse tracking3 = itemResponse.getTracking();
        if (!(tracking3 == null || (trackingId = tracking3.getTrackingId()) == null)) {
            tracking2 = new Tracking(trackingId);
        }
        Tracking tracking4 = tracking2;
        String layoutType2 = itemResponse.getLayoutType();
        if (layoutType2 == null) {
            layoutType = LayoutType.FULL;
        } else if (Intrinsics.areEqual((Object) layoutType2, (Object) "small_no_info")) {
            layoutType = LayoutType.COMPACT;
        } else {
            layoutType = LayoutType.COMPACT_WITH_TEXT;
        }
        return new Item(id3, name3, arrayList, tracking4, layoutType);
    }

    @NotNull
    public VendorLanding apply(@NotNull VendorLandingResponse vendorLandingResponse) {
        String str;
        List list;
        List list2;
        List list3;
        List<ItemResponse> items;
        Intrinsics.checkNotNullParameter(vendorLandingResponse, "source");
        ProductSwimlanesResponse productSwimlanes = vendorLandingResponse.getProductSwimlanes();
        List<CategoryTreeResponse> categoryTree = vendorLandingResponse.getCategoryTree();
        List<ItemResponse> topSwimlanes = vendorLandingResponse.getTopSwimlanes();
        List<ItemResponse> highlightedSwimlanes = vendorLandingResponse.getHighlightedSwimlanes();
        VendorLandingMetadataResponse metadata = vendorLandingResponse.getMetadata();
        ArrayList arrayList = new ArrayList();
        for (CategoryTreeResponse apply : categoryTree) {
            CategoryTree apply2 = this.categoryTreeMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (!arrayList.isEmpty()) {
            String str2 = null;
            LifestyleMission apply3 = vendorLandingResponse.getLifestyleMission() != null ? this.lifestyleMissionMapper.apply(vendorLandingResponse.getLifestyleMission()) : null;
            if (productSwimlanes == null || (str = productSwimlanes.getRequestId()) == null) {
                str = "";
            }
            if (productSwimlanes == null || (items = productSwimlanes.getItems()) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                list = new ArrayList();
                for (ItemResponse mapToItem : items) {
                    Item mapToItem2 = mapToItem(mapToItem);
                    if (mapToItem2 != null) {
                        list.add(mapToItem2);
                    }
                }
            }
            if (topSwimlanes != null) {
                list2 = new ArrayList();
                for (ItemResponse mapToItem3 : topSwimlanes) {
                    Item mapToItem4 = mapToItem(mapToItem3);
                    if (mapToItem4 != null) {
                        list2.add(mapToItem4);
                    }
                }
            } else {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list4 = list2;
            if (highlightedSwimlanes != null) {
                list3 = new ArrayList();
                for (ItemResponse mapToItem5 : highlightedSwimlanes) {
                    Item mapToItem6 = mapToItem(mapToItem5);
                    if (mapToItem6 != null) {
                        list3.add(mapToItem6);
                    }
                }
            } else {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list5 = list3;
            ProductSwimlanes productSwimlanes2 = new ProductSwimlanes(list, str);
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            if (metadata != null) {
                str2 = metadata.getPrimaryMissionSwimlanesRequestId();
            }
            return new VendorLanding(arrayList, apply3, productSwimlanes2, list4, list5, emptyList, emptyList2, (Vendor) null, new com.talabat.feature.darkstores.vendorlanding.domain.model.Metadata(str2));
        }
        throw new IllegalArgumentException("CategoryTree can not be empty");
    }
}
