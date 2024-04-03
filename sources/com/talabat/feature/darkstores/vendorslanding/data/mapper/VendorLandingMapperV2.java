package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ProductSwimlanes;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ProductSwimlanesResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingMetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Bq\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/VendorLandingMapperV2;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponseV2;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "categoryTreeMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "lifestyleMissionMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "bannerMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/BannerResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "vendorInfoMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorInfoResponse;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "itemMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "(Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLandingMapperV2 implements ModelMapper<VendorLandingResponseV2, VendorLanding> {
    @NotNull
    private final ModelMapper<BannerResponse, Banner> bannerMapper;
    @NotNull
    private final ModelMapper<CategoryTreeResponse, CategoryTree> categoryTreeMapper;
    @NotNull
    private final ModelMapper<ItemResponse, Item> itemMapper;
    @NotNull
    private final ModelMapper<LifestyleMissionResponse, LifestyleMission> lifestyleMissionMapper;
    @NotNull
    private final ModelMapper<VendorInfoResponse, Vendor> vendorInfoMapper;

    @Inject
    public VendorLandingMapperV2(@NotNull ModelMapper<CategoryTreeResponse, CategoryTree> modelMapper, @NotNull ModelMapper<LifestyleMissionResponse, LifestyleMission> modelMapper2, @NotNull ModelMapper<BannerResponse, Banner> modelMapper3, @NotNull ModelMapper<VendorInfoResponse, Vendor> modelMapper4, @NotNull ModelMapper<ItemResponse, Item> modelMapper5) {
        Intrinsics.checkNotNullParameter(modelMapper, "categoryTreeMapper");
        Intrinsics.checkNotNullParameter(modelMapper2, "lifestyleMissionMapper");
        Intrinsics.checkNotNullParameter(modelMapper3, "bannerMapper");
        Intrinsics.checkNotNullParameter(modelMapper4, "vendorInfoMapper");
        Intrinsics.checkNotNullParameter(modelMapper5, "itemMapper");
        this.categoryTreeMapper = modelMapper;
        this.lifestyleMissionMapper = modelMapper2;
        this.bannerMapper = modelMapper3;
        this.vendorInfoMapper = modelMapper4;
        this.itemMapper = modelMapper5;
    }

    @NotNull
    public VendorLanding apply(@NotNull VendorLandingResponseV2 vendorLandingResponseV2) {
        String str;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List<ItemResponse> items;
        Intrinsics.checkNotNullParameter(vendorLandingResponseV2, "source");
        ProductSwimlanesResponse productSwimlanes = vendorLandingResponseV2.getProductSwimlanes();
        List<CategoryTreeResponse> categoryTree = vendorLandingResponseV2.getCategoryTree();
        List<ItemResponse> topSwimlanes = vendorLandingResponseV2.getTopSwimlanes();
        List<ItemResponse> highlightedSwimlanes = vendorLandingResponseV2.getHighlightedSwimlanes();
        VendorInfoResponse vendorInfo = vendorLandingResponseV2.getVendorInfo();
        List<BannerResponse> heroBanners = vendorLandingResponseV2.getHeroBanners();
        List<BannerResponse> banners = vendorLandingResponseV2.getBanners();
        VendorLandingMetadataResponse metadata = vendorLandingResponseV2.getMetadata();
        ArrayList arrayList = new ArrayList();
        for (CategoryTreeResponse apply : categoryTree) {
            CategoryTree apply2 = this.categoryTreeMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (!arrayList.isEmpty()) {
            String str2 = null;
            LifestyleMission apply3 = vendorLandingResponseV2.getLifestyleMission() != null ? this.lifestyleMissionMapper.apply(vendorLandingResponseV2.getLifestyleMission()) : null;
            if (productSwimlanes == null || (str = productSwimlanes.getRequestId()) == null) {
                str = "";
            }
            if (productSwimlanes == null || (items = productSwimlanes.getItems()) == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                list = new ArrayList();
                for (ItemResponse apply4 : items) {
                    Item apply5 = this.itemMapper.apply(apply4);
                    if (apply5 != null) {
                        list.add(apply5);
                    }
                }
            }
            if (topSwimlanes != null) {
                list2 = new ArrayList();
                for (ItemResponse apply6 : topSwimlanes) {
                    Item apply7 = this.itemMapper.apply(apply6);
                    if (apply7 != null) {
                        list2.add(apply7);
                    }
                }
            } else {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list6 = list2;
            if (highlightedSwimlanes != null) {
                list3 = new ArrayList();
                for (ItemResponse apply8 : highlightedSwimlanes) {
                    Item apply9 = this.itemMapper.apply(apply8);
                    if (apply9 != null) {
                        list3.add(apply9);
                    }
                }
            } else {
                list3 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list7 = list3;
            if (banners != null) {
                list4 = new ArrayList();
                for (BannerResponse apply10 : banners) {
                    Banner apply11 = this.bannerMapper.apply(apply10);
                    if (apply11 != null) {
                        list4.add(apply11);
                    }
                }
            } else {
                list4 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list8 = list4;
            if (heroBanners != null) {
                list5 = new ArrayList();
                for (BannerResponse apply12 : heroBanners) {
                    Banner apply13 = this.bannerMapper.apply(apply12);
                    if (apply13 != null) {
                        list5.add(apply13);
                    }
                }
            } else {
                list5 = CollectionsKt__CollectionsKt.emptyList();
            }
            List list9 = list5;
            Vendor apply14 = this.vendorInfoMapper.apply(vendorInfo);
            ProductSwimlanes productSwimlanes2 = new ProductSwimlanes(list, str);
            if (metadata != null) {
                str2 = metadata.getPrimaryMissionSwimlanesRequestId();
            }
            return new VendorLanding(arrayList, apply3, productSwimlanes2, list6, list7, list9, list8, apply14, new com.talabat.feature.darkstores.vendorlanding.domain.model.Metadata(str2));
        }
        throw new IllegalArgumentException("CategoryTree can not be empty");
    }
}
