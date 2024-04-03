package com.talabat.feature.ridertips.presentation.di;

import com.talabat.feature.ridertips.presentation.IResourceProvider;
import com.talabat.feature.ridertips.presentation.mapper.IRiderTipDisplayModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipPresentationModule_ProvideRiderTipDisplayModelMapperFactory implements Factory<IRiderTipDisplayModelMapper> {
    private final Provider<String> currencySymbolProvider;
    private final Provider<String> decimalPatternProvider;
    private final Provider<Integer> numOfDecimalPlacesProvider;
    private final Provider<IResourceProvider> resourceProvider;

    public RiderTipPresentationModule_ProvideRiderTipDisplayModelMapperFactory(Provider<String> provider, Provider<Integer> provider2, Provider<String> provider3, Provider<IResourceProvider> provider4) {
        this.currencySymbolProvider = provider;
        this.numOfDecimalPlacesProvider = provider2;
        this.decimalPatternProvider = provider3;
        this.resourceProvider = provider4;
    }

    public static RiderTipPresentationModule_ProvideRiderTipDisplayModelMapperFactory create(Provider<String> provider, Provider<Integer> provider2, Provider<String> provider3, Provider<IResourceProvider> provider4) {
        return new RiderTipPresentationModule_ProvideRiderTipDisplayModelMapperFactory(provider, provider2, provider3, provider4);
    }

    public static IRiderTipDisplayModelMapper provideRiderTipDisplayModelMapper(String str, int i11, String str2, IResourceProvider iResourceProvider) {
        return (IRiderTipDisplayModelMapper) Preconditions.checkNotNullFromProvides(RiderTipPresentationModule.INSTANCE.provideRiderTipDisplayModelMapper(str, i11, str2, iResourceProvider));
    }

    public IRiderTipDisplayModelMapper get() {
        return provideRiderTipDisplayModelMapper(this.currencySymbolProvider.get(), this.numOfDecimalPlacesProvider.get().intValue(), this.decimalPatternProvider.get(), this.resourceProvider.get());
    }
}
