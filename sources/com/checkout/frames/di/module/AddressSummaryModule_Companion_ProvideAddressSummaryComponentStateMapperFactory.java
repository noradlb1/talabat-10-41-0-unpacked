package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.addresssummary.AddressSummaryComponentState;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InternalButtonState;
import com.checkout.frames.view.TextLabelState;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory implements Factory<Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState>> {
    private final Provider<Mapper<ButtonStyle, InternalButtonState>> internalButtonStateMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelStateMapperProvider;

    public AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelState>> provider, Provider<Mapper<ButtonStyle, InternalButtonState>> provider2) {
        this.textLabelStateMapperProvider = provider;
        this.internalButtonStateMapperProvider = provider2;
    }

    public static AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelState>> provider, Provider<Mapper<ButtonStyle, InternalButtonState>> provider2) {
        return new AddressSummaryModule_Companion_ProvideAddressSummaryComponentStateMapperFactory(provider, provider2);
    }

    public static Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> provideAddressSummaryComponentStateMapper(Mapper<TextLabelStyle, TextLabelState> mapper, Mapper<ButtonStyle, InternalButtonState> mapper2) {
        return (Mapper) Preconditions.checkNotNullFromProvides(AddressSummaryModule.Companion.provideAddressSummaryComponentStateMapper(mapper, mapper2));
    }

    public Mapper<AddressSummaryComponentStyle, AddressSummaryComponentState> get() {
        return provideAddressSummaryComponentStateMapper(this.textLabelStateMapperProvider.get(), this.internalButtonStateMapperProvider.get());
    }
}
