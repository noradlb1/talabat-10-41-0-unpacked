package com.talabat.feature.ridertips.presentation.mapper;

import com.talabat.feature.ridertips.presentation.IResourceProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipDisplayModelMapperImpl_Factory implements Factory<RiderTipDisplayModelMapperImpl> {
    private final Provider<String> currencySymbolProvider;
    private final Provider<String> decimalPatternProvider;
    private final Provider<Integer> numOfDecimalPlacesProvider;
    private final Provider<IResourceProvider> resourceProvider;

    public RiderTipDisplayModelMapperImpl_Factory(Provider<String> provider, Provider<Integer> provider2, Provider<String> provider3, Provider<IResourceProvider> provider4) {
        this.currencySymbolProvider = provider;
        this.numOfDecimalPlacesProvider = provider2;
        this.decimalPatternProvider = provider3;
        this.resourceProvider = provider4;
    }

    public static RiderTipDisplayModelMapperImpl_Factory create(Provider<String> provider, Provider<Integer> provider2, Provider<String> provider3, Provider<IResourceProvider> provider4) {
        return new RiderTipDisplayModelMapperImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static RiderTipDisplayModelMapperImpl newInstance(String str, int i11, String str2, IResourceProvider iResourceProvider) {
        return new RiderTipDisplayModelMapperImpl(str, i11, str2, iResourceProvider);
    }

    public RiderTipDisplayModelMapperImpl get() {
        return newInstance(this.currencySymbolProvider.get(), this.numOfDecimalPlacesProvider.get().intValue(), this.decimalPatternProvider.get(), this.resourceProvider.get());
    }
}
