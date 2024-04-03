package com.checkout.frames.di.module;

import androidx.compose.ui.Modifier;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.view.DividerViewStyle;
import com.checkout.frames.style.view.InternalButtonViewStyle;
import com.checkout.frames.style.view.TextLabelViewStyle;
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
public final class AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory implements Factory<Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle>> {
    private final Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> buttonMapperProvider;
    private final Provider<Mapper<ContainerStyle, Modifier>> containerMapperProvider;
    private final Provider<Mapper<DividerStyle, DividerViewStyle>> dividerMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> textLabelMapperProvider;

    public AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<DividerStyle, DividerViewStyle>> provider2, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4) {
        this.textLabelMapperProvider = provider;
        this.dividerMapperProvider = provider2;
        this.buttonMapperProvider = provider3;
        this.containerMapperProvider = provider4;
    }

    public static AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelViewStyle>> provider, Provider<Mapper<DividerStyle, DividerViewStyle>> provider2, Provider<Mapper<ButtonStyle, InternalButtonViewStyle>> provider3, Provider<Mapper<ContainerStyle, Modifier>> provider4) {
        return new AddressSummaryModule_Companion_ProvideAddressSummarySectionStyleMapperFactory(provider, provider2, provider3, provider4);
    }

    public static Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> provideAddressSummarySectionStyleMapper(Mapper<TextLabelStyle, TextLabelViewStyle> mapper, Mapper<DividerStyle, DividerViewStyle> mapper2, Mapper<ButtonStyle, InternalButtonViewStyle> mapper3, Mapper<ContainerStyle, Modifier> mapper4) {
        return (Mapper) Preconditions.checkNotNullFromProvides(AddressSummaryModule.Companion.provideAddressSummarySectionStyleMapper(mapper, mapper2, mapper3, mapper4));
    }

    public Mapper<AddressSummarySectionStyle, AddressSummarySectionViewStyle> get() {
        return provideAddressSummarySectionStyleMapper(this.textLabelMapperProvider.get(), this.dividerMapperProvider.get(), this.buttonMapperProvider.get(), this.containerMapperProvider.get());
    }
}
