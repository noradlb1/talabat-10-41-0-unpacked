package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummaryComponentViewStyle;
import com.checkout.frames.style.view.addresssummary.AddressSummarySectionViewStyle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory implements Factory<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle>> {
    private final Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> buttonMapperProvider;
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle>> summarySectionMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelMapperProvider;

    public AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider2, Provider<Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4) {
        this.textLabelMapperProvider = provider;
        this.buttonMapperProvider = provider2;
        this.summarySectionMapperProvider = provider3;
        this.containerMapperProvider = provider4;
    }

    public static AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider2, Provider<Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4) {
        return new AddressSummaryModule_Companion_ProvideAddressSummaryComponentStyleMapperFactory(provider, provider2, provider3, provider4);
    }

    public static Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> provideAddressSummaryComponentStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<ButtonStyle, InternalButtonViewStyle> mapper2, Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> mapper3, Mapper<ContainerStyle, Modifier> mapper4) {
        return (Mapper) Preconditions.checkNotNullFromProvides(AddressSummaryModule.Companion.provideAddressSummaryComponentStyleMapper(mapper, mapper2, mapper3, mapper4));
    }

    public Mapper<AddressSummaryComponentStyle, AddressSummaryComponentViewStyle> get() {
        return provideAddressSummaryComponentStyleMapper(this.textLabelMapperProvider.get(), this.buttonMapperProvider.get(), this.summarySectionMapperProvider.get(), this.containerMapperProvider.get());
    }
}
