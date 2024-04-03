package com.checkout.frames.di.module;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.component.base.InputComponentState;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.view.InputFieldState;
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
public final class StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory implements Factory<Mapper<InputComponentStyle, InputComponentState>> {
    private final Provider<Mapper<InputFieldStyle, InputFieldState>> inputFieldStateMapperProvider;
    private final Provider<Mapper<TextLabelStyle, TextLabelState>> textLabelMapperProvider;

    public StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory(Provider<Mapper<TextLabelStyle, TextLabelState>> provider, Provider<Mapper<InputFieldStyle, InputFieldState>> provider2) {
        this.textLabelMapperProvider = provider;
        this.inputFieldStateMapperProvider = provider2;
    }

    public static StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory create(Provider<Mapper<TextLabelStyle, TextLabelState>> provider, Provider<Mapper<InputFieldStyle, InputFieldState>> provider2) {
        return new StylesModule_Companion_ProvideInputComponentStyleToStateMapperFactory(provider, provider2);
    }

    public static Mapper<InputComponentStyle, InputComponentState> provideInputComponentStyleToStateMapper(Mapper<TextLabelStyle, TextLabelState> mapper, Mapper<InputFieldStyle, InputFieldState> mapper2) {
        return (Mapper) Preconditions.checkNotNullFromProvides(StylesModule.Companion.provideInputComponentStyleToStateMapper(mapper, mapper2));
    }

    public Mapper<InputComponentStyle, InputComponentState> get() {
        return provideInputComponentStyleToStateMapper(this.textLabelMapperProvider.get(), this.inputFieldStateMapperProvider.get());
    }
}
