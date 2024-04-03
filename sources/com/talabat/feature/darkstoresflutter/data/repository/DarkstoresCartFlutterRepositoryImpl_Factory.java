package com.talabat.feature.darkstoresflutter.data.repository;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresflutter.data.mapper.CampaignProgressToFlutterCampaignProgressMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterCartToMapMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.FlutterMapToProductMapper;
import com.talabat.feature.darkstoresflutter.data.mapper.ProductToFlutterCartItemMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresCartFlutterRepositoryImpl_Factory implements Factory<DarkstoresCartFlutterRepositoryImpl> {
    private final Provider<CampaignProgressToFlutterCampaignProgressMapper> campaignProgressToFlutterCampaignProgressMapperProvider;
    private final Provider<DarkstoresCartRepository> cartRepositoryProvider;
    private final Provider<FlutterCartToMapMapper> flutterCartToMapMapperProvider;
    private final Provider<FlutterMapToProductMapper> flutterMapToProductMapperProvider;
    private final Provider<ProductToFlutterCartItemMapper> productToFlutterCartItemMapperProvider;

    public DarkstoresCartFlutterRepositoryImpl_Factory(Provider<DarkstoresCartRepository> provider, Provider<ProductToFlutterCartItemMapper> provider2, Provider<FlutterMapToProductMapper> provider3, Provider<FlutterCartToMapMapper> provider4, Provider<CampaignProgressToFlutterCampaignProgressMapper> provider5) {
        this.cartRepositoryProvider = provider;
        this.productToFlutterCartItemMapperProvider = provider2;
        this.flutterMapToProductMapperProvider = provider3;
        this.flutterCartToMapMapperProvider = provider4;
        this.campaignProgressToFlutterCampaignProgressMapperProvider = provider5;
    }

    public static DarkstoresCartFlutterRepositoryImpl_Factory create(Provider<DarkstoresCartRepository> provider, Provider<ProductToFlutterCartItemMapper> provider2, Provider<FlutterMapToProductMapper> provider3, Provider<FlutterCartToMapMapper> provider4, Provider<CampaignProgressToFlutterCampaignProgressMapper> provider5) {
        return new DarkstoresCartFlutterRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DarkstoresCartFlutterRepositoryImpl newInstance(DarkstoresCartRepository darkstoresCartRepository, ProductToFlutterCartItemMapper productToFlutterCartItemMapper, FlutterMapToProductMapper flutterMapToProductMapper, FlutterCartToMapMapper flutterCartToMapMapper, CampaignProgressToFlutterCampaignProgressMapper campaignProgressToFlutterCampaignProgressMapper) {
        return new DarkstoresCartFlutterRepositoryImpl(darkstoresCartRepository, productToFlutterCartItemMapper, flutterMapToProductMapper, flutterCartToMapMapper, campaignProgressToFlutterCampaignProgressMapper);
    }

    public DarkstoresCartFlutterRepositoryImpl get() {
        return newInstance(this.cartRepositoryProvider.get(), this.productToFlutterCartItemMapperProvider.get(), this.flutterMapToProductMapperProvider.get(), this.flutterCartToMapMapperProvider.get(), this.campaignProgressToFlutterCampaignProgressMapperProvider.get());
    }
}
