package com.talabat.feature.darkstores.vendorslanding.data.di;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Banner;
import com.talabat.feature.darkstores.vendorlanding.domain.model.CategoryTree;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.Item;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMetadata;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMission;
import com.talabat.feature.darkstores.vendorlanding.domain.model.LifestyleMissionItem;
import com.talabat.feature.darkstores.vendorlanding.domain.model.MetadataError;
import com.talabat.feature.darkstores.vendorlanding.domain.model.PageInfo;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.BannerResponseMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.CategoryTreeMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.ImageUrlMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.ItemMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.LifestyleMissionItemMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.LifestyleMissionMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.MetadataErrorMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.MetadataMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.PageInfoMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.SwimlaneProductMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorInfoResponseMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapper;
import com.talabat.feature.darkstores.vendorslanding.data.mapper.VendorLandingMapperV2;
import com.talabat.feature.darkstores.vendorslanding.data.model.BannerResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.CategoryTreeResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ImageUrlResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionItemResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.LifestyleMissionResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataErrorResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.MetadataResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.PageInfoResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorInfoResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import com.talabat.feature.darkstores.vendorslanding.data.repository.VendorLandingRepositoryImpl;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00032\u0006\u0010\u0006\u001a\u00020\u0015H'J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00032\u0006\u0010\u0006\u001a\u00020\u0019H'J\u001e\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00032\u0006\u0010\u0006\u001a\u00020\u001dH'J\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u00032\u0006\u0010\u0006\u001a\u00020!H'J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010$0\u00032\u0006\u0010\u0006\u001a\u00020%H'J\u001e\u0010&\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010(0\u00032\u0006\u0010\u0006\u001a\u00020)H'J\u001e\u0010*\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00032\u0006\u0010\u0006\u001a\u00020-H'J\u001e\u0010.\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0006\u0012\u0004\u0018\u0001000\u00032\u0006\u00101\u001a\u000202H'J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002000\u00032\u0006\u00101\u001a\u000205H'J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H'J\u001c\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0\u00032\u0006\u0010\u0006\u001a\u00020=H'¨\u0006>"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/di/VendorLandingFeatureModule;", "", "bindBannerResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/BannerResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "impl", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/BannerResponseMapper;", "bindCategoryTreeMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CategoryTreeResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/CategoryTree;", "categoryTreeMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/CategoryTreeMapper;", "bindImageUrlsMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ImageUrlResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "imageUrlMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/ImageUrlMapper;", "bindItemMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Item;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/ItemMapper;", "bindLifestyleMissionItemMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionItemResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/LifestyleMissionItemMapper;", "bindLifestyleMissionMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/LifestyleMissionResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/LifestyleMissionMapper;", "bindMetadataErrorMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataErrorResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/MetadataError;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/MetadataErrorMapper;", "bindMetadataMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/MetadataResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/MetadataMapper;", "bindPageInfoMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/PageInfoResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/PageInfo;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/PageInfoMapper;", "bindSwimlandProductMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/SwimlaneProductMapper;", "bindVendorLandingMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "vendorLandingMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/VendorLandingMapper;", "bindVendorLandingMapperV2", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponseV2;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/VendorLandingMapperV2;", "bindVendorLandingRepository", "Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "repository", "Lcom/talabat/feature/darkstores/vendorslanding/data/repository/VendorLandingRepositoryImpl;", "bindVendorResponseMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorInfoResponse;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/VendorInfoResponseMapper;", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface VendorLandingFeatureModule {
    @Binds
    @NotNull
    @Reusable
    ModelMapper<BannerResponse, Banner> bindBannerResponseMapper(@NotNull BannerResponseMapper bannerResponseMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<CategoryTreeResponse, CategoryTree> bindCategoryTreeMapper(@NotNull CategoryTreeMapper categoryTreeMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<ImageUrlResponse, ImageUrl> bindImageUrlsMapper(@NotNull ImageUrlMapper imageUrlMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<ItemResponse, Item> bindItemMapper(@NotNull ItemMapper itemMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<LifestyleMissionItemResponse, LifestyleMissionItem> bindLifestyleMissionItemMapper(@NotNull LifestyleMissionItemMapper lifestyleMissionItemMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<LifestyleMissionResponse, LifestyleMission> bindLifestyleMissionMapper(@NotNull LifestyleMissionMapper lifestyleMissionMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<MetadataErrorResponse, MetadataError> bindMetadataErrorMapper(@NotNull MetadataErrorMapper metadataErrorMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<MetadataResponse, LifestyleMetadata> bindMetadataMapper(@NotNull MetadataMapper metadataMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<PageInfoResponse, PageInfo> bindPageInfoMapper(@NotNull PageInfoMapper pageInfoMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<SwimlaneProductResponse, SwimlaneProduct> bindSwimlandProductMapper(@NotNull SwimlaneProductMapper swimlaneProductMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<VendorLandingResponse, VendorLanding> bindVendorLandingMapper(@NotNull VendorLandingMapper vendorLandingMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<VendorLandingResponseV2, VendorLanding> bindVendorLandingMapperV2(@NotNull VendorLandingMapperV2 vendorLandingMapperV2);

    @NotNull
    @Binds
    @Reusable
    VendorLandingRepository bindVendorLandingRepository(@NotNull VendorLandingRepositoryImpl vendorLandingRepositoryImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<VendorInfoResponse, Vendor> bindVendorResponseMapper(@NotNull VendorInfoResponseMapper vendorInfoResponseMapper);
}
